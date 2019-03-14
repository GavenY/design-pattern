#原型模式

原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象

##应用场景

- 对象之间相同或相似，即只是个别的几个属性不同的时候。
- 对象的创建过程比较麻烦，但复制比较简单的时候，创建过程中要大量赋值，VO转DTO等。（BeanUtil、Gson）

##原型模式的结构与实现
1. 模式的结构
   1. 抽象原型类：规定了具体原型对象必须实现的接口。
   2. 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
   3. 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
  
2. 模式实现
   可以利用java对象提供的clone（）方法，实现Cloneable接口就可实现对象的浅克隆，原型模式的克隆分为浅克隆和深克隆。



 - 浅克隆
 
（```）
  

    //简单克隆只能克隆属性值，跟对象引用
    private String name;

    private List<String> list;
    
    RealPrototype()
    {
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException
    {
        System.out.println("克隆原型复制成功！");
        return (RealPrototype)super.clone();
    }


（```）


 （```）
  

   			RealPrototype realPrototype = new RealPrototype();
            realPrototype.setName("NO");
            List<String> list = new ArrayList<>();
            list.add("gaven");
            realPrototype.setList(list);
            RealPrototype clonePrototype = (RealPrototype)realPrototype.clone();

            System.out.println(realPrototype == clonePrototype);//false
            System.out.println(realPrototype.getName() == clonePrototype.getName());//true
            System.out.println(realPrototype.getList() == clonePrototype.getList()); // true

            clonePrototype.setName("YES");
            System.out.println( clonePrototype.getName());//YES
            System.out.println( realPrototype.getName());//NO

            List<String> cloneList = clonePrototype.getList();
            cloneList.add("YJW");

            //随意一个对象修改了这个引用对象都会导致原型模式下的所有对象一起改变
            System.out.println(realPrototype.getList().size());// 2 具体原型对象被修改了


（```）

- 深克隆

（```）
  

   			//重写克隆方法，变成深克隆
    public     DeepRealPrototype clone() throws CloneNotSupportedException
    {
        System.out.println("克隆原型复制成功！");
        DeepRealPrototype obj = (DeepRealPrototype)super.clone();

        List<String> cloneList = new ArrayList<>();

        cloneList.addAll(this.list);

        obj.setList(cloneList);
        return obj;
    }


	//Test
   	List<String> cloneList = clonePrototype.getList();
            cloneList.add("YJW");

            System.out.println(realPrototype.getList().size());// 1 具体原型对象没有被修改了
            System.out.println(clonePrototype.getList().size());//clone Prototype 的list 修改，但不影响原型对象

（```）


##原型模式管理器
创建一个原型对象的容器，后续用get（Key）方法获取目标对象原型

（```)

 	public class PrototypeManager {

    private HashMap<String, Shape>ht=new HashMap<String,Shape>();

    public PrototypeManager()
    {
        ht.put("Circle",new Circle());
        ht.put("Square",new Square());
    }
    public void addshape(String key,Shape obj)
    {
        ht.put(key,obj);
    }
    public Shape getShape(String key)
    {
        Shape temp=ht.get(key);
        return (Shape) temp.clone();
    }


}
	
 (```)
