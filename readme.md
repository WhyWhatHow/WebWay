##  what's it using ? 
> 记录自己在学完网课后的代码实践，其中不乏有一些相对较为简单的案例，本文档的作用类似于目录章节的作用，记录java web 的学习步骤。
- author : WhyWhatHow
- Finished：servletConfig 
- TODO: cookie && session
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
>   servletConfig 示例:： 
```java
   ServletConfig  config =getServletConfig(); // 获取servletConfig；
   config.getServletName();
   config.getInitParameter(String name) ;
   config.getInitParmaeterNames(); 
```

>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)



#### servletContext : usually 

> 周期： 同 servlet  
> web 工程共享一个servletContext，即对一个web工程，servletContext 唯一。
##### functions : 

   -  1. 获取全局参数

>   ServletContext context = getServletContext();
>   String address = context.getInitParamter("address");


   -  2. 获取工程里面的资源。 

>   context.getAttribute(name);
>   String path = context.getRealPath("TestServletContext.java");	

   -  3. 资源共享。  ServletContext 域对象  , 

>InputStream in = context.getResourceAsStream("file/readme.md");

- PS: servletContext对象所获取的 资源实现对于tomcat服务器而言的，因而，建议将web资源放于文件夹 WebContent下,其实也可以通过获取绝对路径后，通过io流操作. 


>   [示例:] (/WebWay/src/learn/servlet/test/TestServletContext.java)

--- ---



### HttpServletReqest 

>  [示例:] (/WebWay/src/learn/servlet/test/TestRequest.java)
#### functions : 
- 可以获取客户端请求头信息
```java
 Enumeration<String> parameterNames = request.getParameterNames();
```
- 中文乱码： 
     	
    - 修改配置文件:  tomcat 安装目录下 /config/server.xml：

     	 >  <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/> 

     	- post  :
     	> request.setCharacterEncoding("utf-8");
      
      - get :
      ```java  
       	String username = request.getParameter("username");
    		//先让文字回到ISO-8859-1对应的字节数组 ， 然后再按utf-8组拼字符串
    	   username = new String(username.getBytes("ISO-8859-1") , "UTF-8");
	```


### HttpServletResponse 
#### functions :

-   解決中文乱码问题：

> response.setContentType("text/html;charset=UTF-8");

- 文档下载：    [link](http://localhost:8080/WebWay/test/download.jsp)

```java
		// 1. 获取文件名
		String name = request.getParameter("fileName");
		// 2. 获取文件绝对路径
		String file = context.getRealPath("file/" + name); // webContent 文件夹下
		// 3. 解决浏览器乱码 （可省略）
		String clientName = request.getHeader("User-Agent");
		name = changeFileNameInBrower(clientName, name);
		// 4. 设置文件返回类型， 以附件返回
		response.setHeader("Content-Disposition", "attachment;filename=" + name); // 将文件以附件的形式 展示。
		// 5 写入 response 的过程：
		try {
			InputStream inputStream = new FileInputStream(file);
			byte[] buf = new byte[1024];
			OutputStream outputStream = response.getOutputStream();
			int len = 0;
			while ((len = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, len);
			}
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
```
- 请求转发与重定向 的区别： 
	
	请求转发只会发送一次http请求，而重定向则两次，这一点可以通过获取request携带params确定：
		请求转发 : 可以返回请求参数	eg:request.getRequestDispatcher("你是鸡要跳转的页面__").forward(request, response); --效率相對高
		重定向： 没有返回参数，因为是第二次http请求，对于第二次http请求而言，并没有携带信息的必要性。 -- 消耗资源，慢
- thinking : 
	request.getParamter(String name)与 request.getAttibute(String name) 的不同? 
	[ans](https://blog.csdn.net/qq_35449428/article/details/78151648);
	hint: 
		数据来源，应用场景，操作场景，数据类型

			  
>  [文档下载示例:servlet] (/WebWay/src/learn/servlet/test/DownloadDemo.java)
>  [重定向與請求轉發的區別案例:] (/WebWay/WebContent/test/Dispatcher&Rediction.html)

#### PS :
	- java web 的默认资源存放位置为 webContent 文档目录下
--- ---
### Cookie : 
 

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




