package com.yby.minio.service.impl;

import com.yby.minio.service.MinioService;
import com.yby.minio.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author yby
 * @Date 2020/9/17 17:44
 **/
@Service
public class MinioServiceImpl implements MinioService {

    @Autowired
    private MinioUtil minioUtil;

    /**
     * 判断 bucket是否存在
     *
     * @param bucketName
     * @return
     */
    @Override
    public boolean bucketExists(String bucketName) {
        return minioUtil.bucketExists(bucketName);
    }

    /**
     * 创建 bucket
     *
     * @param bucketName
     */
    @Override
    public void makeBucket(String bucketName) {
        minioUtil.makeBucket(bucketName);
    }


    /**
     * 文件上传
     *
     * @param bucketName
     * @param multipartFile
     * @param filename
     */
    @Override
    public void putObject(String bucketName, MultipartFile multipartFile, String filename) {
        minioUtil.putObject(bucketName, multipartFile, filename);
    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param objectName
     */
    @Override
    public boolean removeObject(String bucketName, String objectName) {
        return minioUtil.removeObject(bucketName, objectName);
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param fileName
     * @param response
     */
    @Override
    public void downloadFile(String bucketName, String fileName, HttpServletResponse response) {
        minioUtil.downloadFile(bucketName, fileName, response);
    }

    /**
     * 获取文件路径
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    @Override
    public String getObjectUrl(String bucketName, String objectName) {
        return minioUtil.getObjectUrl(bucketName, objectName);
    }

}
