# 初始化一个Spring Boot项目

## 1. 使用start.spring.io创建

![](https://github.com/PansonPanson/blogPictures/blob/master/weather-SpringCloud/init-start.png?raw=true)

下载下来解压缩之后的目录：

![](https://github.com/PansonPanson/blogPictures/blob/master/weather-SpringCloud/%E9%A1%B9%E7%9B%AE%E5%88%9D%E5%A7%8B%E5%8C%96%E7%9B%AE%E5%BD%95.png?raw=true)

在项目根目录下打开终端，输入以下命令进行编译（windows下推荐使用命令行工具[Cmder](http://cmder.net/)）：

> gradle build



## 2. 编写HelloController类，并进行单元测试

HelloController.java:

```java
package com.panson.springcloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.panson.springcloud.weather.controller
 * Description：
 * Author: Panson
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}

```

HelloControllerTest.java

```java
package com.panson.springcloud.weather.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;

/**
 * Package: com.panson.springcloud.weather.controller
 * Description：
 * Author: Panson
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("Hello World!")));
    }

}
```

## 3. 运行Spring Boot应用的三种运行方式

+ java -jar xxx.jar（执行gradle build 之后会生成一个jar包，停止执行时，使用Ctrl + c）
+ gradle bootRun 
+ IDE里面右键项目