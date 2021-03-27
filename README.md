**项目说明** 
- 复旦大学计算机科学技术学院20级专硕2班志愿项目后台模块
- 项目本体来自人人开源：https://gitee.com/renrenio/renren-fast
- 项目中使用的各项技术及代码，均来自开源项目，且本项目作公益用途
- 若有侵权，烦请联系 wangg20@fudan.edu.cn

<br>

**项目结构** 
```
renren-fast
├─db  项目SQL语句
│
├─common 公共模块
│  ├─aspect 系统日志
│  ├─exception 异常处理
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息
│ 
├─modules 功能模块
│  ├─app API接口模块(APP调用)
│  ├─job 定时任务模块
│  ├─oss 文件服务模块
│  └─sys 权限模块
│ 
├─RenrenApplication 项目启动类
│  
├──resources 
│  ├─mapper SQL对应的XML文件
│  └─static 静态资源

```

<br> 


**技术选型：** 
- 核心框架：Spring Boot 2.1
- 安全框架：Apache Shiro 1.4
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.0
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x 
<br> 


 **后端部署**
- 通过git下载源码
- idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
- 创建数据库renren_fast，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据
- 修改application-dev.yml，更新MySQL账号和密码
- Eclipse、IDEA运行RenrenApplication.java，则可启动项目

<br> 

 **前端部署**
 - 本项目是前后端分离的，还需要部署前端，才能运行起来
 - 前端下载地址：
 - 前端部署完毕，就可以访问项目了，账号：，密码：
 
 <br>

 **项目演示**
- 演示地址：
- 账号密码：admin/admin
<br> 

**接口文档效果图：**

<br> <br> <br> 


**效果图：**

<br>
