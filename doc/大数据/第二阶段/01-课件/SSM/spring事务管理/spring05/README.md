1.spring的声明式事务管理

1.1基于XML的声明式事务
	<!-- spring事务管理   事务管理器 -->
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<!-- 注入DataSource -->
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	
	<!-- 配置事务的通知   :  需要指定事务管理器-->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<!-- 对哪些方法进行事务管理
				传播行为 ：默认值为  propagation="REQUIRED" ：当前方法必须运行在事务中，如果当前没有事务，则会开启一个新的事务；如果有事务，那么使用当前的事务 
						propagation="SUPPORTS": 当前方法不需要事务，如果当前没有事务，则不使用事务；如果有事务，则使用当前的事务
						propagation="REQUIRED_NEW"：   当前方法必须运行在一个新的事务中。
				no-rollback-for： 不会滚的异常
					-->
			<tx:method name="tran*" propagation="REQUIRED" no-rollback-for="java.lang.ArithmeticException"/>
			<tx:method name="add*" propagation="REQUIRED"/>
			<tx:method name="del*" propagation="REQUIRED"/>
			<tx:method name="update*" propagation="REQUIRED"/>
			<tx:method name="select*" propagation="SUPPORTS"/>
		</tx:attributes>
	</tx:advice>
	
	<!-- 配置aop事务 -->
	<aop:config>
		<aop:pointcut expression="execution(* com.hpe.service..*.*(..))" id="cut1"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="cut1"/>
	</aop:config>

1.2 基于注解的声明式事务








