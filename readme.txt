一、单例设计模式
文件目录：/singleton
	1、简单单例类 Singleton.java
	2、延迟加载单例类 LazySingleton.java
	3、内部类创建实例对象的单例类 StaticSingleton.java
	4、串行化单例类 SerSingleton.java
	5、单例的性能测试 SingletonTest.java

二、代理模式
文件目录：/proxy
	1、静态代理 /proxy/proxy_static
	2、动态代理 /proxy/proxy_dynamic   CGLIB+Javassist+JDK
	
		<!-- Javassist 的动态代理 -->
		<dependency>
			<groupId>javassist</groupId>
			<artifactId>javassist</artifactId>
			<version>3.12.1.GA</version>
		</dependency>	
		
	3、性能测试 Main.java
	
三、享元模式简单案例
文件目录：/flyweight

四、装饰者模式
文件目录：/decorator
	1、简单案例
	2、OutputStream源码  DecoratorTest.java、BufferedOutputStream.java
	方法write(byte b[], int off, int len)

五、观察者模式
文件目录：/observer
	1、简单小demo /observer/first
	2、在JDK中，观察者模式也得到了普遍的应用。一个最典型的应用便是Swing框架的JButton。  /observer/swing
	方法fireActionPerformed()	

六、Value Object模式,简单案例
文件目录：/valueObject
	1、新知识点 RMI（Remote Method Invocation）远程方法调用

七、Future模式
目录文件：/future
	1、Future模式 入门 /future/hello
	2、JDK内置实现 /future/jdk

八、Master-Worker模式
文件目录：/master_worker
	1、案例：1~100的立方和
	
九、Guarded Suspension模式
文件目录：/GuardedSuspension

十、



