#代理模式

代理模式（proxy）定义：由于某些原因需要给某对象提供一个代理来控制对该对象的访问

优点：

- 代理对象可以扩展目标对象功能（AOP，数据源动态切换）

- 代理对象在客户端与目标对象之间起到中介作用保护目标对象的作用

- 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度；

缺点：

- 在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢
- 增加系统复杂度

##静态代理

 模式结构

- 抽象主题（Subject）：通过接口或者抽象类声明真实主题和代理对象的业务方法

- 真实主题（RealSubject）：实现抽象主题的具体内容，是代理对象所代表的真实对象，是最终要引用的对象。 

- 代理（Proxy）类：提供与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或者扩展真实主题。


(```)

	package proxy;
	public class ProxyTest
	{
    public static void main(String[] args)
    {
        Proxy proxy=new Proxy();
        proxy.Request();
    }
		}
	//抽象主题
	interface Subject
	{
    void Request();
	}
	//真实主题
	class RealSubject implements Subject
	{
    public void Request()
    {
        System.out.println("访问真实主题方法...");
    }
	}
	//代理
	class Proxy implements Subject
	{
    private RealSubject realSubject;
    public void Request()
    {
        if (realSubject==null)
        {
            realSubject=new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest()
    {
        System.out.println("访问真实主题之后的后续处理。");
    }
	}

(```) 

静态代理缺点：扩展麻烦，如果对象需要增加静态代理，需要为对象独自生成一个代理类


##动态代理

可以不需要真实主题的情况下创建代理，易扩展通过反射动态生成目标对象的代理类；

模式结构：

- 动态代理（DynamicProxy）类，需要实现InvocationHandler接口的invoke方法。

- 被代理类，需要被代理类调用的方法都要在实现的接口中声明。

(```)

	public class JDKMeipo implements InvocationHandler {

    private Object target;
    public Object getInstance(Object person) throws Exception{
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
       return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after(){
        System.out.println("OK的话，准备办事");
    }
	}

(```)

实现原理：


1.  `return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);` 生成一个代理类。
  1. 同过客户端传送一个目标对象实例 ，通过`getClass()、getInterfaces()`获取类信息
 
  2. 然后通过这些类信息拼接生成一个$Proxy${num}.java代理类文件($proxy0)， 这个代理类是实现目标对象的所有接口方法，每个方法都是最终调用的是InvocationHandle的invoke()方法
  3. 通过jdk包中的tools.jar 中complie方法编译成.class文件，保存在每个项目target\calss 目录文件下
  4. 然后通过ClassLoad加载器，利用字节流将这个目录下的.class，转换成字节码 然后加载到JVM中
  5. 然后通过`getConstructor(InvocationHandler.class)`获取一个代理类构造器，然后`newInstance()`生成一个实例对象
  6. 然后`Person obj = (Person) new GPMeipo().getInstance(new Girl());`向上转型调用（动态代理类都是实现目标对象的接口的）
  
  (```) 
  
    //生成的$proxy 文件
	public int findLove() {
	try{
	Method m = com.gaven.pattern.ProxyTest.dynamicproxy.Person.class.getMethod("findLove",new Class[]{});
	return ((java.lang.Integer)this.h.invoke(this,m,new Object[]{})).intValue();
	}catch(Error _ex) { }catch(Throwable e){
	throw new UndeclaredThrowableException(e);
	}return 0;} 

(```)

   
 当客户端调用findLove的时候，其实就是调用生成$proxy的findLove方法，this.h.invoke(..),就是调用我实现InvocationHandler的类里面的invoke， 所有我们可以轻易添加before（），after（）方法，扩展目标类实现


## Proxy接口数不能超过65535

每个类加载到JVM时，会将类信息保存到常量池里，魔数、副版本号、主版本常量池的数据区域等，其中常量池数据区域就是类信息，类名，方法名、变量名之类的，	常量池数据区域由两部分组成，前端的两个字节占有的位置叫做常量池计数器(constant_pool_count)，它记录着常量池的组成元素  常量池项(cp_info)的个数，cp_info就是具体内容，例如下面例子的`const #7 = class        #29; `


可以看出Girl在记录了37个类信息在常量池数据区中，常量池计数器是从1开始的，所以常量池数据区最多存放 2Byte = 16bit = 65536-1 个类信息，如果一个类的接口数量就大于等于65535了，直接将数据区占满了，其他信息就无法放入常量池



(```)

	 //Proxy.java	
	 private static Class<?> getProxyClass0(ClassLoader loader,
                                           Class<?>... interfaces) {
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        // If the proxy class defined by the given loader implementing
        // the given interfaces exists, this will simply return the cached copy;
        // otherwise, it will create the proxy class via the ProxyClassFactory
        return proxyClassCache.get(loader, interfaces);
    }


	//查看编译文件
	oxy>javap -verbose Girl
	Compiled from "Girl.java"
	public class com.gaven.pattern.ProxyTest.dynamicproxy.jdkproxy.Girl extends java.lang.Object implements com.gaven.pattern.ProxyTest.dynamicproxy.Person
	  SourceFile: "Girl.java"
	  minor version: 0
	  major version: 51
	  Constant pool:
	const #1 = Method       #8.#21; //  java/lang/Object."<init>":()V
	const #2 = Field        #22.#23;        //  java/lang/System.out:Ljava/io/PrintStream;
	const #3 = String       #24;    //  高富帅
	const #4 = Method       #25.#26;        //  java/io/PrintStream.println:(Ljava/lang/String;)V
	const #5 = String       #27;    //  身高180cm
	const #6 = String       #28;    //  有6块腹肌
	const #7 = class        #29;    //  com/gaven/pattern/ProxyTest/dynamicproxy/jdkproxy/Girl
	const #8 = class        #30;    //  java/lang/Object
	const #9 = class        #31;    //  com/gaven/pattern/ProxyTest/dynamicproxy/Person
	const #10 = Asciz       <init>;
	const #11 = Asciz       ()V;
	const #12 = Asciz       Code;
	const #13 = Asciz       LineNumberTable;
	const #14 = Asciz       LocalVariableTable;
	const #15 = Asciz       this;
	const #16 = Asciz       Lcom/gaven/pattern/ProxyTest/dynamicproxy/jdkproxy/Girl;;
	const #17 = Asciz       findLove;
	const #18 = Asciz       ()I;
	const #19 = Asciz       SourceFile;
	const #20 = Asciz       Girl.java;
	const #21 = NameAndType #10:#11;//  "<init>":()V
	const #22 = class       #32;    //  java/lang/System
	const #23 = NameAndType #33:#34;//  out:Ljava/io/PrintStream;
	const #24 = Asciz       高富帅;
	const #25 = class       #35;    //  java/io/PrintStream
	const #26 = NameAndType #36:#37;//  println:(Ljava/lang/String;)V
	const #27 = Asciz       身高180cm;
	const #28 = Asciz       有6块腹肌;
	const #29 = Asciz       com/gaven/pattern/ProxyTest/dynamicproxy/jdkproxy/Girl;
	const #30 = Asciz       java/lang/Object;
	const #31 = Asciz       com/gaven/pattern/ProxyTest/dynamicproxy/Person;
	const #32 = Asciz       java/lang/System;
	const #33 = Asciz       out;
	const #34 = Asciz       Ljava/io/PrintStream;;
	const #35 = Asciz       java/io/PrintStream;
	const #36 = Asciz       println;
	const #37 = Asciz       (Ljava/lang/String;)V;

(```)
