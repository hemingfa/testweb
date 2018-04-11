package com.hemf.testweb.service.impl;

import com.hemf.testweb.service.IPictureService;
import com.hemf.testweb.util.FtpUtil;
import com.hemf.testweb.util.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hemf
 * @Date: 2018/4/12 04:14
 * @Description:
 */
@Service
public class PictureServiceImpl implements IPictureService {

    @Value(value = "${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value(value = "${FTP_PORT}")
    private Integer FTP_PORT;
    @Value(value = "${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value(value = "${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value(value = "${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;

    @Value(value = "${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    /**
     * 图片上传的服务
     *
     * @param uploadFile
     * @return
     */
    @Override
    public Map uploadPicture(MultipartFile uploadFile) {

        Map<String, String> resultMap = new HashMap();

        InputStream inputStream = null;
        boolean result = false;
        String uploadFileUrl = "";
        try {
            inputStream = uploadFile.getInputStream();
            String filepath = new DateTime().toString("/yyyy/MM/dd");

            String oldName = uploadFile.getOriginalFilename();
            String newName = IDUtils.genImageName() + oldName.substring(oldName.lastIndexOf("."));

            result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filepath, newName, inputStream);
            uploadFileUrl = IMAGE_BASE_URL + IMAGE_BASE_URL + "/" + newName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (result) {
            resultMap.put("error", "0");
            resultMap.put("url", uploadFileUrl);
        } else {
            resultMap.put("error", "1");
            resultMap.put("message", "文件上传失败！");
        }

        return resultMap;
    }
}
