# 单例模式总结

## 定义
 单例（Singleton）模式的定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式

## 特点
1. 单例类只有一个实例对象；
2. 该单例对象必须由单例类自行创建；
3. 单例类对外提供一个访问该单例的全局访问点；

##代码实现

- 饿汉模式
   
(```)

  	
	public class HungrySingleton {

    private  static final HungrySingleton  hungrySingleton = new HungrySingleton();;

    private static boolean flag = true;
    private  HungrySingleton(){

        if(flag){
            flag = !flag;
        }else{
            throw new RuntimeException("不能创建多个实例");
        }


    }

    public  static  HungrySingleton getHungrySingleton(){
        return hungrySingleton;
    }
	}

(```)

它是在类加载的时候就立即初始化，并且创建单例对象

优点:绝对的线程安全,没有加任何的锁、执行效率比较高，在用户体验上来说，比懒汉式更好

缺点:类加载的时候就初始化，不管你用还是不用，都占着空间浪费了内存

- 懒汉模式


	1. 双检懒汉模式
	

(```)

 	public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
		//减少同步锁的使用，当lazy不为空时不执行下面方法
        if(lazy == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazy == null){ //防止多个线程同时满足第一个不为null判断 lazy 实例多次（对象创建多次，最后一次覆盖前面引用），浪费内存，
                    lazy = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象
                    //2.初始化对象
                    //3.设置lazy指向刚分配的内存地址
                    //4.初次访问对象
                }
            }
        }
        return lazy;
    }
}

  
(```)

懒汉模式 优点：使用时创建，节省资源但是存在多线程安全问题，缺点：synchronized关键字保证线程安全问题但是影响性能，所以使用两次检查减少粒度

	2. 内部类懒汉模式

(```)

	
	public class InnerLazySingleton {
	

    private   InnerLazySingleton(){

        //防止反射实例对象
        if(LazyHolder.LAZY_SINGLETON != null){
            throw new RuntimeException("不允许创建多个实例");
        }

    }
    //默认使用LazyInnerClassGeneral的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的


    //每一个关键字都不是多余的
    //static 是为了使单例的空间共享
    //final保证这个方法不会被重写，重载
    public  static  final  InnerLazySingleton getInstance(){

        return LazyHolder.LAZY_SINGLETON;
    }


    //默认不加载
    private  static  class  LazyHolder{


        private  static  final InnerLazySingleton  LAZY_SINGLETON  =  new InnerLazySingleton();
    }

	}

(```)

//性能最优的写法。无需synchronized同步线程安全，也是被调时才创建

-	注册容器单例模式

	
	1. 枚举类单例模式

(```)

	public enum  EnumSingleton {

    INSTANCE;


    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
	}

(```)

推荐写法，优点：安全，防止反射，反序列化破坏单例模式，线程安全
通过jad 反编译，可以看出枚举单例跟饿汉模式一样类加载时实例化保证线程安全

(```)

	    public static EnumSingleton getInstance()
    {
        return INSTANCE;
    }

    public static final EnumSingleton INSTANCE;
    private Object data;
    private static final EnumSingleton $VALUES[];

    static 
    {
        INSTANCE = new EnumSingleton("INSTANCE", 0);
        $VALUES = (new EnumSingleton[] {
            INSTANCE
        });
    }

(```)

 JDK 默认不能通过反射    创建对象

(```)

	     if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
        ConstructorAccessor ca = constructorAccessor;   // read volatile

(```)

 反序列化会直接从缓冲中取

(```)

 		if (cl != null) {
            try {
                @SuppressWarnings("unchecked")
                Enum<?> en = Enum.valueOf((Class)cl, name);
                result = en;
            } catch (IllegalArgumentException ex) {
                throw (IOException) new InvalidObjectException(
                    "enum constant " + name + " does not exist in " +
                    cl).initCause(ex);
            }

(```)



	
	2. ConcurrentHashMap实现

Spring中的做法，就是用这种注册式单例,方便管理实例，缺点：多线程不安全，无法抵御反射 反序列化攻击


- THreadLocal单例模式

 注册性容器单例，线程为key，对象为value, 伪线程安全，同线程相同实例，不同线程实例不同，多数据源实现模式


- 破坏单例模式方法

    1. 反射

同过反射获取构造器实例对象


(```)

 		public class reflectionTest {

    	public static void main(String[] args) {

        try {
            //Class<?> clazz = HungrySingleton.class;
            Class<?> clazz = HungrySingleton.class;

            //clazz.newInstance();  构造器私有化，无法直接new

            //通过反射拿到私有的构造方
            Constructor c = clazz.getDeclaredConstructor(null);

            //强制访问，访问私有类
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();

            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，
            Object o2 = c.newInstance();

            System.out.println(o1 == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}

(```)


可以通过一个静态的变量来判断构造器实例化多少次，大于一次则返回一个runException

(```)

 		private static boolean flag = true;

    private SingletonLazy(){


        if(flag){
            flag = !flag;
        }else{
            throw new RuntimeException("不能创建多个实例");
        }
    }

(```)



	2. 反序列化

反序列化通过重写readObject（）的 readResolve（）方法返回实例保证安全（限饿汉、懒汉）
(```)

  	 ObjectInputStream:

                case TC_ENUM:
                    return checkResolve(readEnum(unshared));
				//反序列OBJect 对象
                case TC_OBJECT:
                    return checkResolve(readOrdinaryObject(unshared));


	readOrdinaryObject(unshared)：  
   	//如果有readResolve() 则覆盖之前创建的OBj
	if (obj != null &&
            handles.lookupException(passHandle) == null &&
            desc.hasReadResolveMethod())
        {
            Object rep = desc.invokeReadResolve(obj);
            if (unshared && rep.getClass().isArray()) {
                rep = cloneArray(rep);
            }
            if (rep != obj) {
                // Filter the replacement object
                if (rep != null) {
                    if (rep.getClass().isArray()) {
                        filterCheck(rep.getClass(), Array.getLength(rep));
                    } else {
                        filterCheck(rep.getClass(), -1);
                    }
                }
                handles.setObject(passHandle, obj = rep);
            }

(```)


(```)

    // 重写readResolve(),覆盖反序列化出来的的对象，，还是创建了两次对象， 但是发生在jvm层较安全，之前的对象会被GC回收
    private  Object readResolve(){
        return  INSTANCE;
    }

(```)