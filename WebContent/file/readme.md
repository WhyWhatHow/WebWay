##  what's it using ? 
> 记录自己在学完网课后的代码实践，其中不乏有一些相对较为简单的案例，本文档的作用类似于目录章节的作用，记录java web 的学习步骤。
>@author : WhyWhatHow
>Finished：servletConfig 

--- ---
## java web
--- ---
### servlet 
#### servlet life-time：
##### functions : 
>- init方法
  在创建该servlet的实例时，就执行该方法。
	一个servlet只会初始化一次， init方法只会执行一次
	默认情况下是 ： 初次访问该servlet，才会创建实例。 
>- service方法
		 	 该方法可以被执行很多次。 一次请求，对应一次service方法的调用
>- destroy方法
  servlet销毁的时候，就会执行该方法
	 *  移除项目
	 *  关闭Tomcat
>- 修改默认启动顺序：值越小，启动越早
	<load-on-startup>2</load-on-startup>
>  [示例] (/WebWay/src/learn/servlet/test/TestServletStart.java)

#### servletConfig ：sometimes
##### functions : 
> *  servletConfig 示例:： 
> *  获取servletConfig；ServletConfig  config =getServletConfig();
> *  config.getServletName();
> *  config.getInitParameter(String name) ;
> *  config.getInitParmaeterNames(); 

>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

#### servletContext : usually
> web 工程共享一个servletContext，即对一个web工程，servletContext 唯一。
##### functions : 
>	1. 获取全局参数

>	2. 获取工程里面的资源。

>	3. 资源共享。  ServletContext 域对象

>   [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

--- --- 

=================================================================

### HttpServletReqest 
>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)
#### functions : 

=================================================================

### HttpServletResponse 
#### functions : 
>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

=================================================================

### Cookie : 
#### functions : 
>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

=================================================================

### Session: 
#### functions : 
>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

=================================================================

### JSP : java server page
#### functions : 

>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

=================================================================

### EL:
#### functions : 

>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

=================================================================
### JSTL: java server page standered lib
#### functions : 

>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)

=================================================================
### 事务： 
#### functions : 

=================================================================
### JDBC： 
#### functions : 

=================================================================
### databaseSourse： 
#### functions : 

=================================================================
#### DBCP:
##### functions : 

=================================================================
#### C3P0: 
##### functions : 

=================================================================
### DButils: 
#### functions : 

=================================================================
### Project(MVC_01) ： student management system:
#### functions : 

=================================================================
### AJAXS:
#### functions : 

=================================================================
### JQuery: 
#### functions : 

=================================================================
### Listener : 
#### functions : 

=================================================================
### Filter: 
#### functions : 

=================================================================




