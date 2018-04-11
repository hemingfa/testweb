package com.hemf.testweb.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * 图片服务
 */
public interface IPictureService {
    /**
     * 上传图片
     *
     * @param uploadFile
     * @return
     */
    Map uploadPicture(MultipartFile uploadFile);
}
