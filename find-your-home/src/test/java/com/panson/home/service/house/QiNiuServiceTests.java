package com.panson.home.service.house;
import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.panson.home.ApplicationTests;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
/**
 * Package: com.panson.home.service.house
 * Description：
 * Author: Panson
 * Date: Created in 7/15 15:55
 */
public class QiNiuServiceTests extends ApplicationTests {
    @Autowired
    private IQiNiuService qiNiuService;

    @Test
    public void testUploadFile() {
        String fileName = "/Users/bug/imooc/xunwu-project/tmp/xiaoqian.jpeg";
        File file = new File(fileName);

        Assert.assertTrue(file.exists());

        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        String key = "FvyNceBAaZF6TBh6OZpcEKlhuACG";
        try {
            Response response = qiNiuService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}

