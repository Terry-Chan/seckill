# Java高并发秒杀项目源码

## 项目介绍
此秒杀项目前端使用了Bootstrap、jQuery, 后端主要使用了Spring、SpringMVC、Mybatis，
数据库使用了MySQL, 缓存使用了Redis。同时使用了RESTful的风格，整个项目自底向上开发，
由DAO层到Service层，再到Web层，最后再回去分析秒杀的瓶颈所在，并完成了优化。

## 开发环境
| 软件 | 版本 |
| :------: | :------: |
| IntelliJ IDEA | 14.0.3 |
| MySQL | 5.6 |
| Redis | 3.2.100 |

## 系统环境
Windows 7

## 项目依赖
| groupId | artifactId | version |
| :------: | :------: | :------: |
| junit | junit | 4.11 |
| org.slf4j | slf4j-api | 1.7.21 |
| ch.qos.logback | logback-core | 1.1.1 |
| ch.qos.logback | logback-classic | 1.1.1 |
| mysql | mysql-connector-java | 5.1.35 |
| c3p0 | c3p0 | 0.9.1.2 |
| org.mybatis | mybatis | 3.3.0 |
| org.mybatis | mybatis-spring | 1.2.3 |
| taglibs | standard | 1.1.2 |
| jstl | jstl | 1.2 |
| com.fasterxml.jackson.core | jackson-databind | 2.5.4 |
| javax.servlet | javax.servlet-api | 3.1.0 |
| org.springframework | spring-core | 4.1.7.RELEASE |
| org.springframework | spring-beans | 4.1.7.RELEASE |
| org.springframework | spring-context | 4.1.7.RELEASE |
| org.springframework | spring-jdbc | 4.1.7.RELEASE |
| org.springframework | spring-tx | 4.1.7.RELEASE |
| org.springframework | spring-web | 4.1.7.RELEASE |
| org.springframework | spring-webmvc | 4.1.7.RELEASE |
| org.springframework | spring-test | 4.1.7.RELEASE |
| redis.clients | jedis | 2.9.0 |
| com.dyuproject.protostuff | protostuff-core | 1.0.10 |
| com.dyuproject.protostuff | protostuff-runtime | 1.0.10 |
| commons-collections | commons-collections | 3.2.1 |