package com.yby.minio.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author yby
 * @Date 2020/9/17 19:39
 **/
@Data
public class MinioFile{

    private String bucketName;

    private MultipartFile file;
}
