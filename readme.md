
##  what's it using ? 
> 记录自己在学完网课后的代码实践，其中不乏有一些相对较为简单的案例，本文档的作用类似于目录章节的作用，记录java web 的学习步骤。
- author : WhyWhatHow
- Finished：Cookie 
- TODO: MVC addStudentServlet 可以优化
- Mind Map: [link](http://naotu.baidu.com/file/19f3ff42c9d50661fdb96be77836a071?token=5d54b9a7269664f4)
- notice : the thing i wrote may wrong, if wrong, just feed back!
--- ---
## java web
--- ---
### TODO:
#### Q_1: -c3p0 读文件的形式连接数据库是否会导致过多的io操作，进而影响程序的运行速度？c3p0的配置文件的相关参数的正确用法？

#### T_1: jstl 正确用法，知识面太过低下

#### T_2: jquery 的代码量 

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

### servletConfig ：sometimes
#### functions : 
>   servletConfig 示例:： 
```java
   ServletConfig  config =getServletConfig(); // 获取servletConfig；
   config.getServletName();
   config.getInitParameter(String name) ;
   config.getInitParmaeterNames(); 
```

>  [示例:] (/WebWay/src/learn/servlet/test/TestServletConfig.java)



### servletContext : usually 

> 周期： 同 servlet  
> web 工程共享一个servletContext，即对一个web工程，servletContext 唯一。
#### functions : 

   -  1. 获取全局参数++

>   ServletContext context = getServletContext();
>   String address = context.getInitParamter("address");


   -  2. 获取工程里面的资源。 

>   context.getAttribute(name);
>   String path = context.getRealPath("TestServletContext.java");	

   -  3. 资源共享。  ServletContext 域对象  , 

> InputStream in = context.getResourceAsStream("file/readme.md");

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
 
#### 显示上一次登陆的时间： 
 
		 	 * 1. 获取请求数据， usename,password 
			 * 2. 判断是否有cookie，含有上一次登陆时间，若有，获取上次登录时间，，修改对应的cookie值，response 返回，
			 * 3.否则的话，生成新的cookie，加入response 

>  [示例:] (/WebWay/src/learn/demo/LatestLogin/LoginLatestServlet.java)
> [link](http://localhost:8080/WebWay/test/recentLogin.jsp)
#### 浏览记录： 

- Test: http://localhost:8080/WebWay/test/GoodsList.jsp 

> 在tomcat服务器中挂载上WebWay后在访问网址

- 业务逻辑； 

> view: /test/GoodsList.jsp, /test/GoodsDetail.jsp
> controller: HistoryServlet，ClearServlet 
> location :/WebWay/src/learn/demo/HistoryVisited/*.java
> model : no DB

- 教训： 
 
> 一个一个界面的写，一个功能一个功能的完善。 

=================================================================

### Session: 
#### functions : 
#### shoppingCar:

- Test: http://localhost:8080/WebWay/test/PhoneList.jsp
- 业务逻辑： 

```
	PhoneList.jsp(商品列表页面) 
	 --> PhoneChoseServlet.java (处理list发来的请求，与数据库进行交互，结果在detail.jsp 页面显示出来) (未实现)
	 --> PoneDetail.jsp(将 detail.jsp 获取到的数据库数据进行显示)
	 --> PhoneBuyServlet.java (处理，将需要添加入购物车的商品加入购物车，如果之前已经存在，商品数量加一，其他不变)
```
	 


### JSP : java server page
#### 学生管理系统
##### user用户登录查看学生信息： 
	login.jsp -- > loginServlet.java --> stu_list.jsp
##### 对学生信息实现增加，删除，修改，查找

##### 实现查询结果分页
- 	Page - currentPage, totalPage, totalSize, pageSize(存在问题，自己并不能修改这个pageSize 的大小),List<T>,
- 业务逻辑：
	1. 获取currentPage，默认为1; 获取 pageSize(StudentDao, 无法修改，问题- pageBean 设置，然后修改 StudentDao.PAGE_SIZE(貌似是常量，不可以修改))   
	2. 查找所含用户数量，当前查找的List<student>结果集,求取totalPage, 封装成Page返回， 利用改返回值设置 session属性。
	3. jsp 前端页面设计， 实现view 界面

#### problems:
##### 数值型参数 带空格问题：
-ans:	String.trim() 方法了解下
##### 数据库连接过程过慢：
- 根本原因是自己的c3p0-config.xml 文件中一起的错误，鉴于自己当前知识有限，以及自己对于项目的理解能力不到位，在不追究，先给出参考答案（单纯的考虑数据库连接池方面的配置）
> ans:

```
<c3p0-config>
	<default-config>
		<property name="initialPoolSize">3</property>
		<property name="maxIdleTime">60</property>
		<property name="maxPoolSize">15</property>
		<property name="minPoolSize">3</property>
		<property name="maxStatements">15</property>
	</default-config>

	<!-- This app is massive! -->
	<named-config name="mysql">
		<property name="driverClass">com.mysql.cj.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost/stumanager</property>
		<property name="user">root</property>
		<property name="password">aa12321.</property>
		<property name="initialPoolSize">10</property>
		<property name="maxIdleTime">30</property>
		<property name="maxPoolSize">100</property>
		<property name="minPoolSize">10</property>
		<property name="maxStatements">200</property>
	</named-config>
</c3p0-config>

```
##### jstl面对的问题：

```
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<c:if test="${stu.gender=='female'}">checked</c:if>>female
	
	<input type="checkbox" name="hobby" value="sports"
	<c:if test="${fn:contains(stu.hobby,'sports')}">checked </c:if>>sports
```

- reflect: 没有阅读过官方文档，对这个知识了解的太少，太过皮毛，看api文档写代码的速度简直令人发指， 凸显出问题：知识面匮乏，

#### request 太多的 parameters:
- ans : commons-beanutils.jar , commons-logging-1.1.1.jar 
- MyDateConverter.java :  /WebWay/src/Util/MyDateConverter.java
```

	ConvertUtils.register(new MyDateConverter(), Date.class); // 注册java.util.date 类
	Map map = request.getParameterMap();
	Student stu = new Student();
	BeanUtils.populate(stu, map); // 赋值
			
```


#### 补充：

> web工程 读取文件用两种方式，

> 一种servletContext 的方式：
	String path = context.getRealPath("TestServletContext.java");
	InputStream in = context.getResourceAsStream("file/readme.md");
> 另一种是 类加载器的方式读取： 	
InputStream in = DButil.class.getClassLoader().getResourceAsStream("jdbc.properties"); 
		
			
>  [link:http://localhost:8080/WebWay/StuManager/Login.jsp] (http://localhost:8080/WebWay/StuManager/Login.jsp)


### 装饰者模式：
> 优点：实现了面向接口编程
> 缺点： 程序无用函数过多， 引出动态代理 方法 实现
> 子我理解就是用自己生成的类对象直接继承需要修改的接口，对自己想添加功能的方法进行DIY设计，然后调用接口时调用继承类实现。

```
	//interface A -- class A(对需要的接口方法加以修改，使之成为自己的方法)
	userDao userDao = new UserImpl(); // userDao  interface特点  实现面向接口编程 
```
### JDBC： 
- Code Location : 
> /WebWay/src/Util/DButil.java

### MyDataBaseSoure：  
- 自定义的数据库连接池，使用装饰者模式生成类ConnectionWrap 实现 面向接口编程
- codeLocation: 
> /WebWay/src/Util/MyDataSourse.java|ConnectionWrap.java
- Test :
> /WebWay/src/test/MyDataSourseTest.java

#### DBCP:
-codeLocation： 
> /WebWay/src/test/DBCPTest.java

#### C3P0: 
查官方文档，是王道，
引申 ：druid
-codeLocation： 
> /WebWay/src/test/DBCPTest.java
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




