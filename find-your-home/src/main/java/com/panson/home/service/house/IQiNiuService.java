package com.panson.home.service.house;

import java.io.File;
import java.io.InputStream;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

/**
 * Package: com.panson.home.service.house
 * Description：
 * Author: Panson
 * Date: Created in 2018/7/15 9:56
 */

public interface IQiNiuService {
    Response uploadFile(File file) throws QiniuException;

    Response uploadFile(InputStream inputStream) throws QiniuException;

    Response delete(String key) throws QiniuException;
}


