package com.yby.minio.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.yby.minio.common.Result;
import com.yby.minio.common.ResultUtil;
import com.yby.minio.config.MinioConfig;
import com.yby.minio.entity.MinioFile;
import com.yby.minio.service.MinioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author yby
 * @Date 2020/9/17 17:39
 **/
@RequestMapping("/minio")
@RestController
public class MinioController {

    @Autowired
    private MinioService minioService;

    @Autowired
    private MinioConfig minioConfig;

    /**
     * 上传文件
     *
     * @param minioFile
     * @return
     */
    @PostMapping(value = "/uploadFile")
    public Result uploadFile(MinioFile minioFile) {
        try {
            minioFile.setBucketName(StringUtils.isNotBlank(minioFile.getBucketName()) ? minioFile.getBucketName() : minioConfig.getBucketName());
            if (!minioService.bucketExists(minioFile.getBucketName())) {
                minioService.makeBucket(minioFile.getBucketName());
            }
            String fileName = minioFile.getFile().getOriginalFilename();
            String objectName = DateUtil.now() + IdUtil.simpleUUID() + fileName.substring(fileName.lastIndexOf("."));
            minioService.putObject(minioFile.getBucketName(), minioFile.getFile(), objectName);
            return ResultUtil.success(minioService.getObjectUrl(minioFile.getBucketName(), objectName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.sendErrorMessage("上传失败");
        }
    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param path
     * @return
     */
    @DeleteMapping(value = "/deleteFile")
    public Result uploadFile(String bucketName, String path) {
        return ResultUtil.success(minioService.removeObject(bucketName, path));
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param fileName
     * @param response
     */
    @GetMapping(value = "/downloadFile")
    public void downloadFile(@RequestParam String bucketName, @RequestParam String fileName, HttpServletResponse response) {
        minioService.downloadFile(bucketName, fileName, response);
    }
}
