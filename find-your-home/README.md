### 项目简介：

中国一、二线城市的房价对于许多人来说难以承受，租房成为许多年轻人的唯一选择。本项目基于开源分布式搜索引擎Elasticsearch，实现一个租房房源搜索系统，帮助房源持有者便捷地出租房屋，也为租房客户提供平台，搜索到符合需求的房源。

### 技术选型：

+ MySQL ：基础数据存储
+ Elasticsearch ：站内搜索
+ Kafaka : 分布式消息中间件
+ Nginx :  负载均衡及安全加固
+ Redis : 缓存
+ ELK( Elasticsearch + Logstash + kibana ) ：数据分析
+ SpringBoot + Spring Data JPA : 基础核心框架
+ Thymeleaf、Jquery、Bootstrap、webUpLoad ：前端
+ Spring Security ：权限控制
+ Maven :  构建工具 

### 项目分层：

![find-your-home](https://github.com/PansonPanson/blogPictures/blob/master/github002/find-your-home.png?raw=true)

### Task List 

- [x] 数据库设计
- [x] 后端框架搭建
- [x] 集成单元测试
- [x] 前端框架集成
- [x] API结构设计
- [ ] 后台登录功能实现
- [ ] 权限控制
- [ ] 验证失败逻辑处理
- [ ] 基于第三方图床——七牛云实现图片上传
- [ ] 新增房源信息功能实现
- [ ] 房源浏览功能实现
- [ ] 编辑功能实现

- [ ] 默认排序功能实现
- [ ] 其他维度排序功能实现
- [ ] 索引结构设计与构建
- [ ] 集成Elasticsearch
- [ ] 小区房源统计功能实现
- [ ] 基于Elasticsearch的地图点聚合
- [ ] 地图鼠标事件应用
- [ ] 基于地址获取经纬度的开发实现
- [ ] 基于Elasticsearch的地图查询功能
- [ ] 基于Elasticsearch的的视野数据源绑定
- [ ] 基于百度LBS的云麻点
- [ ] 免注册登录
- [ ] 会员中心
- [ ] 用户预约功能
- [ ] 经纪人完成预约功能
- [ ] API权限拦截器
- [ ] 基于美洽的客服系统
- [ ] 基于Nginx实现负载均衡
- [ ] 安全控制
- [ ] 基于SpringSchedule的监控任务
- [ ] 基于SpringMail的报警系统
- [ ] 集成Logstash
- [ ] 数据可视化分析

...



### 参考资料：

+ [Java定时任务调度工具详解之Timer篇](http://www.imooc.com/learn/841)
+ [Java定时任务调度工具详解之Quartz篇](https://www.imooc.com/qa/846/t/1)
+ 