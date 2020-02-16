# XcEdu
在线教育项目

该项目借鉴了MOOC（大型开放式网络课程，即MOOC（massive open online courses））的设计思想，是一 个提供IT职业课程在线学习的平台
## 技术栈
所有微服务基于Spring Boot、Spring Cloud构建
1) 控制层： Spring MVC、Spring Security Oauth2 、Swagger 
2） 业务层： 事务控制：Spring 任务处理：Spring Task 
            数据缓存：Spring Data Redis 
            消息队列：Spring RabbitTemplate 
            搜索： Elasticsearch 
3)  持久层： 
        操作MySQL：MyBatis、com.alibaba.druid（采用druid-spring-boot-starter）
        Spring Data Jpa 操作MongoDB：Spring Data Mongodb 
4)  数据层，采用MySQL和MongoDB存储数据，MySQL存储用户、课程等系统核心信息，MongoDB存储 cms、配置信息

## 主要功能
1. 登入，注册
2. 搜索 
3. 视频点播
4. 我的课程
5. 媒资管理
6. 课程管理
7. 选择标签
8. cms
9. 分类管理
 等
