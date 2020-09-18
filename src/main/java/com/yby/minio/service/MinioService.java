package com.yby.minio.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author yby
 * @Date 2020/9/17 17:40
 **/
public interface MinioService {

    /**
     * 判断 bucket是否存在
     *
     * @param bucketName
     * @return
     */
    boolean bucketExists(String bucketName);

    /**
     * 创建 bucket
     *
     * @param bucketName
     */
    void makeBucket(String bucketName);

    /**
     * 文件上传
     *
     * @param bucketName
     * @param multipartFile
     * @param filename
     */
    void putObject(String bucketName, MultipartFile multipartFile, String filename);

    /**
     * 删除文件
     * @param bucketName
     * @param objectName
     */
    boolean removeObject(String bucketName,String objectName);

    /**
     * 下载文件
     *
     * @param bucketName
     * @param fileName
     * @param response
     */
    void downloadFile(String bucketName, String fileName, HttpServletResponse response);

    /**
     * 获取文件路径
     * @param bucketName
     * @param objectName
     * @return
     */
    String getObjectUrl(String bucketName,String objectName);
}
