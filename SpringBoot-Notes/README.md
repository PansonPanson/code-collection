## 梳理一遍SpringBoot的使用
### 001之Hello World

使用Maven：

+ 引入spring-boot-start-parent，可以提供dependency management,也就是说依赖管理，引入以后在申明其它dependency的时候就不需要version了

  ```XML
  <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>1.5.7.RELEASE</version>
  </parent>
  ```

+ 指定编码格式和JDK版本

  ```xml
  <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <maven.compiler.source>1.8</maven.compiler.source>
      <maven.compiler.target>1.8</maven.compiler.target>
   </properties>
  ```

+ spring-boot-starter-web包含了spring webmvc和tomcat等web开发的特性

  ```xml
  <dependency>  
      <groupId>org.springframework.boot</groupId>  
      <artifactId>spring-boot-starter-web</artifactId>  
  </dependency>  
  
  ```

+ 如果我们要直接Main启动spring，那么以下plugin必须要添加，否则是无法启动的。如果使用maven 的spring-boot:run的话是不需要此配置的。 

  ```xml
  <build>  
        <plugins>  
              <plugin>  
                  <groupId>org.springframework.boot</groupId>  
                 <artifactId>spring-boot-maven-plugin </artifactId>  
            </plugin>  
         </plugins>  
  </build>  
  ```

+ 其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan

  @RestController返回json字符串的数据，直接可以编写RESTFul的接口；

  ```java
  @RestController
  @SpringBootApplication
  public class SpringbootApplication {
  
  	@RequestMapping("/")
  	public String hello(){
  		return "Hello World!";
  	}
  	public static void main(String[] args) {
  		SpringApplication.run(SpringbootApplication.class, args);
  	}
  }
  ```



使用Gradle:

+ ```xml
  plugins {
  	id 'org.springframework.boot' version '2.0.3.RELEASE'
  	id 'java'
  }
  
  
  jar {
  	baseName = 'myproject'
  	version =  '0.0.1-SNAPSHOT'
  }
  
  repositories {
  	jcenter()
  }
  
  dependencies {
  	compile("org.springframework.boot:spring-boot-starter-web")
  	testCompile("org.springframework.boot:spring-boot-starter-test")
  }
  ```



### 002之热部署

+ spring为开发者提供了一个名为spring-boot-devtools的模块来使Spring Boot应用支持热部署，提高开发者的开发效率，无需手动重启Spring Boot应用。 
+ 深层原理是使用了两个ClassLoader，一个Classloader加载那些不会改变的类（第三方Jar包），另一个ClassLoader加载会更改的类，称为restart ClassLoader,这样在有代码更改的时候，原来的restart ClassLoader 被丢弃，重新创建一个restart ClassLoader，由于需要加载的类相比较少，所以实现了较快的重启时间。 

参考：[SpringBoot配置devtools实现热部署](https://www.cnblogs.com/lspz/p/6832358.html)



### 003之全局异常捕捉

@ControllerAdvice 与@ExceptionHandler 一起使用

参考：[全局异常捕捉](http://412887952-qq-com.iteye.com/blog/2291524)



### 004之整合MySQL

+ 在application.properties文件中配置数据库：

  ```properties
  ########################################################  
  ###datasource  
  ########################################################  
  spring.datasource.url = jdbc:mysql://localhost:3306/test  
  spring.datasource.username = root  
  spring.datasource.password = root  
  spring.datasource.driverClassName = com.mysql.jdbc.Driver  
  spring.datasource.max-active=20  
  spring.datasource.max-idle=8  
  spring.datasource.min-idle=8    
  spring.datasource.initial-size=10   
  ```

+ pom.xml配置： 

  ```xml
  <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
  </dependency>
  ```



### 005之JPA-Hibernate

+ pom.xml配置：

  ```xml
  <dependency>  
         <groupId>org.springframework.boot</groupId>  
         <artifactId>spring-boot-starter-data-jpa</artifactId>  
  </dependency> 
  ```

+ application.properties:

  ```properties
  ########################################################  
  ### Java Persistence Api  
  ########################################################  
  # Specify the DBMS  
  spring.jpa.database = MYSQL  
  # Show or not log for each sql query  
  spring.jpa.show-sql = true  
  # Hibernate ddl auto (create, create-drop, update)  
  spring.jpa.hibernate.ddl-auto = validate 
  # Naming strategy  
  spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy  
  # stripped before adding them to the entity manager)  
  spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect  
  ```

+ spring.jpa.hibernate.ddl-auto的选项：
  + create ：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
  + create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
  + update ：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。
  + validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。
+ 使用@Entity注解，相应的对象就会进行持久化。

参考：[hibernate.hbm2ddl.auto配置详解](https://www.cnblogs.com/talo/articles/1662244.html)



### 006之修改默认端口号

+ 只需要修改applicatoin.properties文件，在配置文件中加入： 

  ```properties
  server.port=你想使用的端口号
  ```

  

### 007之修改ContextPath

+ Spring boot默认是/ ，这样直接通过http://ip:port/就可以访问到index页面，如果要修改为http://ip:port/path/ 访问的话，那么需要在Application.properties文件中加入server.context-path = /你的path,比如：spring-boot,那么访问地址就是http://ip:port/spring-boot 路径。

  ```properties
  server.context-path=/spring-boot
  ```



### 008之修改SpringBoot编译时的JDK版本

+ 修改pom.xml文件的<build> -- <plugins>加入一个plugin 

  ```java
  <plugin>
     <artifactId>maven-compiler-plugin</artifactId>
     <configuration>
        <source>1.8</source>
        <target>1.8</target>
     </configuration>
  </plugin>
  ```



### 009之整合Thymeleaf

+ pom.xml:

  ```xml
  <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  ```

+ Thymeleaf缓存:

  ```properties
  spring.thymeleaf.cache=false
  ```

学习更多关于Thymeleaf的知识： [Thymeleaf Tutorial](https://github.com/waylau/thymeleaf-tutorial)



### 010之集成Redis实现缓存机制

参考：[Spring Boot集成Redis实现缓存机制【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2294942)



### 011之多文件上传

参考：[Spring boot 文件上传（多文件上传）【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2293385)



### 012之使用Redis保存Session状态

参考：[Spring Boot分布式Session状态保存Redis【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2295146)



### 013之集成Shiro

Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。 
既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则和访问权限。

参考：

+ [SpringBoot集成Shiro001](http://412887952-qq-com.iteye.com/blog/2299732)
+ [SpringBoot集成Shiro002](http://412887952-qq-com.iteye.com/blog/2299777)
+ [SpringBoot集成Shiro003](http://412887952-qq-com.iteye.com/blog/2299780)
+ [SpringBoot集成Shiro004](http://412887952-qq-com.iteye.com/blog/2299784)
+ [Shiro安全框架入门](https://www.imooc.com/view/977) 
+ [Apache Shiro 1.2.x 参考手册](https://github.com/waylau/apache-shiro-1.2.x-reference)



### 014之注解合集

+ @Qualifier 
+ @Autowired 
+ @Resource 
+ @component 
+ @controller  
+ @service  
+ @repository 
+ @Order 

+ ...

参考：

+ [springBoot注解大全](https://www.cnblogs.com/tanwei81/p/6814022.html) 
+ [SpringBoot注解](http://www.iteye.com/topic/1144685)



### 015之多数据源

单数据源的配置 ：在application.properties进行基本的连接配置，在pom.xml引入基本的依赖即可。

多数据源的配置 ：读取配置文件，根据配置文件中的配置的数据源数量，动态创建dataSource并注册到Spring中 。

参考：

+ [Spring Boot 使用Java代码创建Bean并注册到Spring中【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2301642)

+ [Spring Boot多数据源【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2302997)

+ [Spring Boot动态数据源（多数据源自动切换）【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2303075)




### 016之日志记录

+ [SLF4J](http://412887952-qq-com.iteye.com/blog/2303102)
+ [Spring Boot中使用AOP统一处理Web请求日志](http://www.iteye.com/blogs/tag/Spring%20Boot%E4%B8%AD%E4%BD%BF%E7%94%A8AOP%E7%BB%9F%E4%B8%80%E5%A4%84%E7%90%86Web%E8%AF%B7%E6%B1%82%E6%97%A5%E5%BF%97) 
+ [spring boot日志升级篇—理论【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2306441)
+ [Spring Boot日志升级篇—log4j【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2306974)
+ [spring boot日志升级篇—log4j多环境不同日志级别的控制【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2307194)
+ [spring boot日志升级篇—logback【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2307244)



### 017之整合MyBatis

+ [整合MyBatis](http://412887952-qq-com.iteye.com/blog/2303121)



### 018之使用AOP统一处理Web请求日志

+ [使用AOP统一处理Web请求日志](http://412887952-qq-com.iteye.com/blog/2305333)

 

### 019之发送邮件

+ [Spring Boot发送邮件【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2305992)



### 020之服务配置和部署

+ [spring boot 服务配置和部署【从零开始学Spring Boot】](http://412887952-qq-com.iteye.com/blog/2307389)



### 参考资料
+ [从零开始学SpringBoot博客专栏](http://412887952-qq-com.iteye.com/category/356333)
+ [SpringBoot系列](https://www.cnblogs.com/ityouknow/p/5662753.html)
+ [SpringBoot官方Doc](https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/)
+ [Spring Boot 揭秘与实战 系列](http://blog.720ui.com/columns/springboot_all/)
+ [SpringBoot配置devtools实现热部署](https://www.cnblogs.com/lspz/p/6832358.html)
+ [Spring For All](http://www.spring4all.com/)
+ [Thymeleaf Tutorial](https://github.com/waylau/thymeleaf-tutorial)
+ [Thymeleaf官方文档](https://www.thymeleaf.org/documentation.html)
+ [Shiro官方文档](https://shiro.apache.org/reference.html)
+ [Spring Boot Tutorial](https://waylau.gitbooks.io/spring-boot-tutorial/)
+ [Spring Security Tutorial](https://waylau.gitbooks.io/spring-security-tutorial/)
+ [初识 Spring Security](http://wiki.jikexueyuan.com/project/spring-security/)