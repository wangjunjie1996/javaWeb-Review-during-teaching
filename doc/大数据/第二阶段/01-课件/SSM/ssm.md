1.原生的jdbc操作数据库的过程
	1.1 加载驱动
	1.2 获取链接 connection
	1.3 获取statement
	1.4 设置sql
	1.5 给占位符 set值
	1.6 执行sql，获取结果集
	1.7 对结果集进行解析、封装
	1.8 释放资源

	原生的jdbc操作数据库的缺点：
		缺点一：频繁的进行获取链接、关闭链接，资源浪费。    数据库连接池
		缺点二：sql语句属于硬编码，维护不方便。并且需求变得可能性大，要经常的修改sql
		缺点三：占位符设置参数也属于硬编码，维护不方便
		缺点四：结果集解析过程也是硬编码，希望是能够自动的封装成我们自己开发的pojo对象中去

2.mybatis框架
 mybatis是 apache旗下的 开源的 gitHub
 mybatis 是一个持久层框架 ORM,他可以对jdbc的操作过程进行封装，使开发者只需关注sql本身，而无需去处理 注册驱动、获取链接、获取statement、结果集解析、资源释放 等工作
 
 ORM :Object Ralational Mapping 对象关系映射
 简单的说，是通过描述 对象和关系数据库之间的元数据的映射关系 ，将java中的对象 持久化到 关系数据库中
 hibernate、mybatis
 
 3.mybatis架构
  画图：
  
 4.mybatis的入门程序
  4.1 新建java项目，导入jar
  4.2 log4j日志文件
  4.3 mapper.xml(学习重点)
  		id：用于标识 映射文件中的sql，其实是statement的id
		parameterType: 参数类型，支持基本类型、map、pojo对象。当前的是int
		resultType: 输出结果类型，支持基本类型、map、pojo对象。是单条记录的类型
		#{}:占位符.能够防止sql注入 
			  如果参数类型为简单类型，那么#{} 可以通过 #{value}来获取值获取其他任意#{任意名字}
		
		${}: 字符串拼接,不能防止sql注入的。 应该更多的使用#{}
			${} 如果通过 简单类型传参，只能使用 ${value}
  	查询
  	新增		返回新增记录的 id：keyProperty="id" useGeneratedKeys="true"   传参的对象里 user.id
  	修改
  	删除
  	
  5.全局配置文件 的一些知识点
  
  	5.1 <!-- 加载外部的资源文件 -->
	<properties resource="db.properties"></properties>
	
	5.2
	<!-- 起别名 ： 作用，简化全限定类名 -->
	<typeAliases>
		<!-- type: 给哪个类起别名    alise：别名是什么 -->
		<!-- <typeAlias type="cn.pojo.User" alias="user"/> -->
		<!-- 批量起别名，name是配置的包   ，起的别名就是类名 的 全名，首字母大写或者小写都可以 -->
		 <!-- cn.pojo.User - -> User/user -->
		<package name="cn.pojo"/> 
	</typeAliases>
	
 6.SqlSessionFactory和SqlSession
 
 SqlSessionFactory： 它是通过全局配置文件获取的，SqlSessionFactoryBuilder创建的，
 	一旦SqlSessionFactory创建，它会在程序的执行期一直存在，只需要一个实例，
 	换句话说，我们希望SqlSessionFactory做成单例的
 	作用： 创建sqlSession
 SqlSession： 作用：操作数据库的，是线程不安全的，希望是每个线程都有自己的sqlSessin的实例
 
 7.传统的dao开发方式
 	7.1 声明一个dao接口
 	7.2声明dao接口的实现类
 	7.3 mapper.xml
 	
 8.mapper动态代理的实现方式
 	开发者只需声明mapper接口，(就是dao接口)，无需声明接口的实现类，而由mybatis框架通过 创建接口的代理对象， 就和实现类类似。
 	需要按照一定的规范来开发接口和映射文件
 	1 映射文件mapper.xml的名称 要和接口的名称一致
 	2 映射文件的 namespace 是 接口的全路径
 	3 映射文件的 sql statement的id  是  接口的方法名称
 	4 映射文件的输入参数类型 和 接口方法的参数类型一致
 	5 映射文件的输出结果类型 和接口方法的返回类型一致
 	
 9.mapper.xml 的详解
 9.1 参数类型 parameterType  支持的类型：java简单类型、hashmap、自定义的pojo
 	hashmap: map的取值方式  #{map的key} 取出的值就是  map的value
 	多参数的：@Param 相当于把当前的注解对象封装到了map进行传值
 			#{0} 取下标为0的，即第一个参数
 
 
 
 
 
	
 
 