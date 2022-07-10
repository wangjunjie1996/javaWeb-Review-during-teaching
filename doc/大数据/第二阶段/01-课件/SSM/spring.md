1 spring的概念
 spring是一个轻量级的控制反转（ioc）和面向切面编程（aop）的容器框架。
 	轻量级: spring的大小和开销都是轻量的
 	非入侵：一般在程序开发中，不需要引入spring的包。
 	控制反转：ioc 把对象的创建的权利交给容器
 	面向切面编程：aop  基于代理的  可以将核心业务 和 系统服务 分开，
 	
2. spring的入门
	2.1 认识一下spring的jar
	
	
spring的核心的配置或者类
applicationContext.xml  核心配置文件，作用：用于配置所有的类，这些类可以称为springbean
BeanFactory:	容器的工厂类（接口），作用：用于创建或者获取springbean，即spring管理的对象
ApplicationContext(接口)	：它是BeanFactory的子类： 作用：用于创建或者获取springbean，
			功能比BeanFactory更强大。（常用）
			
		BeanFactory和ApplicationContext的区别：
		BeanFactory：懒加载
		ApplicationContext：非懒加载

3 spring IOC
	控制反转 Inversion of Control: 把对象的创建、销毁 的权利交给 容器框架，由容器来管理对象的生命周期。
	ioc不是一个新的技术，只是一种思想或者理念，可以实现 松耦合
	ioc包括依赖注入（DI,核心）和依赖查找
	DI： 依赖注入  就是在sprng实例化对象的时候，由容器来设置这些对象的属性的值。
	
	spring的注入：
	属性的注入：
	**构造器注入：
	注入其他类：
	
	
4. Bean的装配方式
 4.1 基于XML文件的装配
 	注意以下两点：
 		一：Bean的需要注入的属性 要有对应的setter方法
 		二：配置到spring中的bean 必须有默认的无参构造。
 	
 4.2 基于注解的装配
	
1 spring AOP的基本概念
	AOP：面向切面编程，采用的是横向抽取机制，把分散在各个方法中的 相同的代码抽取取来，然后在编译期或者是运行时，再把这些代码应用到需要执行的地方。
	
	通知 Advice：AOP在切点上执行的增强处理。
		通俗的讲，就是在什么时间点上去做增强工作，在对象的方法执行之前？之后？成功放回后？抛出异常后？
	切点 PointCut：带有通知的连接点。
		通俗的讲，就是对哪些类、哪些方法 做增强
	切面 Aspect：通常上就是一个类，里面定义了通知和切点
	
	AOP=通知+切点
	
	
2.通知的类型
前通知 MethodBeforeAdvice      方法执行前
后通知 AfterAdvice      方法执行后
环绕通知 MethodInterceptor  方法执行的前和后
返回后通知 AfterReturningAdvice   成功返回后
异常通知   ThrowsAdvice 抛出异常后

3.切点的类型
	基于正则表达式 	了解     JdkRegexpMethodPointcut
	基于AspectJ的表达式   掌握   AspectJExpressionPointcut
	
2018/09/14上午
切点表达式：
1.第一个*代表着返回类型 *代表任意类型
2.cn.aop代表着包路径 Person代表着对象，*代表着方法
3./。 ..代表着参数  .. 代表任意多个 0~n个
execution(* cn.aop.Person.*(..))
execution(int  cn.*.login(..))  返回值是int,cn包下的，不包含cn的子包下的。方法名为login,参数是任意多个
execution(* cn..*.run(..))  这个指的是cn包下的和cn子包下的所有对象	
5、AspectJ开发
5.1 XML方式
<aop:config>
		<!-- 切点 ，需要配置切点表达式-->
		<aop:pointcut expression="execution(* cn.aspectj.bean.*.*(..))" id="cut1"/>
		<!-- 通知器 -->
		<!-- <aop:advisor advice-ref=""/> -->
		<!-- 切面 -->
		<aop:aspect ref="myAspect">
			<!-- 前通知   method：前通知对应的方法   pointcut-ref：对应的切点-->
			<aop:before method="doBefore" pointcut-ref="cut1"/>	
			<!-- 后通知。 无论怎样都会执行-->
			<aop:after method="doAfter" pointcut-ref="cut1"/>	
			<!-- 返回后通知  。只有正常返回后 才执行-->
			<aop:after-returning method="doAfterReturning" pointcut-ref="cut1"/>
			<!-- 异常通知 . 当有异常抛出时才会执行-->
			<aop:after-throwing method="doThrow" pointcut-ref="cut1"/>
			<!-- 环绕通知 -->
			<aop:around method="doAround" pointcut-ref="cut1"/>
		</aop:aspect>
	</aop:config>	


JoinPoint 连接点.  表示的被增强的对象。 可以在 前、后、返回后、异常通知中使用

环绕通知 = 前通知+返回后通知   我们在项目开发时，使用二者其一即可


//环绕通知 1必须传递连接点  2必须调用jp.proceed(); 3返回为Object 4 抛异常
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		System.err.println("环绕通知前.....");
		Object obj = jp.proceed();
		System.err.println("环绕通知后.....");
		return obj;
	}
	
5.2 注解方式

6.spring+mybatis整合
6.1.spring+mybatis整合
	mybatis：dao层，操作数据库，需要单例的SqlSessionFactory会话工厂
	spring：容器，管理对象， 把SqlSessionFactory交给spring来管理。事务、数据库连接池都由spring管理。 mapper接口，动态代理的。
	
6.2.认识一下整合的jar   mybatis-spring.1.**.jar

	2.1spring的配置文件
7.spring的事务管理
	
