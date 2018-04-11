package com.hemf.testweb;

import com.hemf.testweb.util.FtpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestwebApplicationTests {
    @Value(value = "${FTP_ADDRESS}")
    private String host;

    @Value("${FTP_PORT}")
    private Integer port;

    @Value("${FTP_USERNAME}")
    private String username;

    @Value("${FTP_PASSWORD}")
    private String password;

    @Value("${FTP_BASE_PATH}")
    private String basePath;

    @Test
    public void contextLoads() throws FileNotFoundException {
        File file = new File("C:\\Users\\hemf\\Pictures\\LifeFrame\\2.jpg");
        InputStream inputStream = new FileInputStream(file);
        String filePath = "";
        String fileName = file.getName();
        boolean b = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, fileName, inputStream);
        System.out.println(b);
    }

}
