package com.gaven.pattern.SingletonTest.RegistSingleton;

public enum  EnumSingleton {

    INSTANCE;


    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }



 /*
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

     饿汉式，天生线程安全，类加载时创建，反序列化时jvm是根据类名，枚举名 获取实例有缓存，

     反射 ：java.lang.IllegalArgumentException: Cannot reflectively create enum objects

     JDK 默认不能通过反射    创建对象
        if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
        ConstructorAccessor ca = constructorAccessor;   // read volatile
    */
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
