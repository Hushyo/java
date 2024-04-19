## 规范CC

<font color=0327ff> 规范色</font>

### 命名:
所有 **包/类/接口/方法/参数/变量** 的命名必须使用 
有意义且无歧义的 英文单词或其缩写
<font color = red>禁止中文,拼音以及中英混合</font>

|   Name   |             CC              |                             Tips                             |
| :------: | :-------------------------: | :----------------------------------------------------------: |
|  **类**  |         **驼峰式**          |              **一般单数<br />工具类可以用复数**              |
| **变量** |        **小驼峰式**         |                                                              |
| **方法** |        **小驼峰式**         |                                                              |
|  **包**  |          **小写**           | **必须放在源文件的顶部<br />源文件的位置必须与包声明的路径相同** |
| **常量** | **大写<br />用 _ 分隔单词** |                   **用关键字 final 修饰**                    |

#### 合法的标识符:

首字符仅支持 26个字母 和 符号 $ , _  不支持 数字以及其他符号
后续字符可以是字母,数字以及 _ 不支持其他字符
但是为了规范: 不用 \$ 与 _ 开头

> \$count _count count\$ count_\$ 合法但是不要用

#### 数字字面量:
支持用下划线 _ 分隔,提高代码可读性
编译时会把 _ 忽略

> creditCardNumber = 1234_567_89



### 数字

|  Name  |                      CC                      |                 example                  |
| :----: | :------------------------------------------: | :--------------------------------------: |
|  long  | 以 L 结尾,也可以不要<br />不报错，但是不规范 |             long num = 123L              |
| float  |       以 f/F 结尾<br />必须以 f/F 结尾       |             float num=1.23F              |
| double |            以 d/D 结尾,也可以不要            | double num = 1.23<br/>dounle num = 1.23D |



### 封装

对外隐藏功能实现的具体细节，并且隐藏对象中的数据信息，通过暴露方法/接口对外提供服务. 


- public修饰的成员变量为公有成员变量,全局可访问
- private修饰的成员变量,私有成员变量,仅能在类中访问

Bicycle类中声明了三个 int 类型的 公共非静态变量

```java
public class Bicycle{
	public int cadence = 0;
	public int speed = 0;
	public int gear = 0;
}
```

当我们创建对象后，可以直接访问对象的属性

```java
Bicycle bicycle = new Bicycle();
System.out.println(<font color = red>bicycle.cadence</font>) ;
```

**规范:**
不要暴露对象的属性
对象的属性必须用private封装起来
不能让外界直接访问 

```java
public class Bicycle{
	private int cadence = 0;
	private int speed = 0;
	private int gear = 0;
}
```

对外设置访问器(**getter/setter**),允许外界通过访问器访问成员的属性

```java
public class Bicycle{
	private int cadence;
	private int speed;
	private int gear;
    
	public int getGear(){
	return gear;
    } //外界通过这个获得Bicycle对象的gear信息
    public void setGear(int gear){
        this.gear = gear;
    }//外界通过这个修改Bicycle对象的gear信息
}
```

对象每一个属性都需要设置对应的 getter 和 setter;

> this. 表示当前对象的引用,上文setter 参数名字 与 变量名字相同,用this区分它俩,this.gear就是对象中的属性gear.

### 点子

垃圾收集器不会回收没有引用的常量和静态变量
所以失去引用的对象不是立即被回收的
回收是自动的，不必手动清除

JVM是编译java源码的环境，不是工具

重写toString实现对象的详细输出，不是toClass

java无法动态修改数组的长度

return 可以声明在没有返回值的方法中，所以 return必须声明在有返回值的方法中 说法错误

this 在类的内部代表当前的对象，不是类本身

## 修饰符,方法,包

修饰符决定其修饰的 类型/变量/方法 的作用范围 (可访问范围||可见范围)

### 修饰符

#### 顶级

类/接口/枚举/注解/record 支持创建为顶级的独立源文件
必须先创建源文件 才能在文件里编译

- public 所有其它类可访问
- package-private 仅包内可访问(就算是子包也不可以用)

package级允许文件名与类名不同但是禁止使用,有歧义

必须定义在类型内的,称呼为 Method方法
可以脱离类型独立定义的 称呼为Function函数

#### 成员级

声明在类型内部.可以是 类/接口/变量/常量/方法等

- public 全局可访问
- package-private 包内可访问
- private 类型内可访问
- protected 包和任意位置的子包类可以用

### 方法

#### 构成

由 修饰符, 返回类型, 方法名，参数列表, 方法体 构成

<font color=0327ff>方法小驼峰，必须以动词开始，接形容词或者名词</font>

#### 方法签名

方法签名是一个方法区别于另一个方法的特征
不同方法之间靠方法签名区分

方法签名由**方法名称 参数列表的参数类型**决定，与**修饰符 返回值类型 参数名称**无关

```
public double calculate(double a, double b, int point)
方法签名: calculate(double,double,int)
public int calculate(double c, double d, int point)
方法签名: calculate(double,double,int)
它俩方法签名一样,无法编译
```

方法参数名称
在作用范围内必须唯一
无论参数类型是否相同，参数名称不能相同。
方法内的局部变量不能与方法参数名称相。

```java
void setName(string num, int num){
int num;
}
//禁止
```

---



### 包的导入

想要使用其他包中的public类型,必须通过以下方式之一:

- 全限定性名称
- 简单名称
- 导入整个包

#### 全限定名称

把要用的类的地址完完整整写出来
如 在calzz包里有个 Bicycle类，想用它，怎么用？补全它的地址
com.example.clazz.Bicycle

```java
public class Student{
	private com.example.clazz.Bicycle bicycle;
}
```

类的全限定名称 其实就是类的目录地址

#### 简单名称

在package之后 类型定义语句之前 
通过 import 关键词导入，导入要用的类的全限定名称，之后就可以仅用类的名称使用类

```java
package com.example.packagex;
import com.example.clazz.Bicycle;
public class Student{
	private Bicycle bicycle;
}
```



#### 整个包

用 * 号导入包中的所有类型

```java
import com.example.clazz.*;
public class Student{
	private Bicycle bicycle;
}
```

然后用类型名使用类

>  当包的路径不同但是名称相同时,只有一个可以 简单名称使用类,其他的必须使用 全限定名称.
> com.example.clazz.Bicycle 作用等于 Bicycle







## 类与静态

### 类

- 一个源文件可以有多个类
- 一个类中可以声明多个类
- 源文件可以供多个程序使用

#### 构造函数

- 类的构造函数**没有返回类型.** 
- 构造函数方法名称 与 类 的名称一致;
- 无参构造函数并不是必须的，类中并不必须包含无参构造函数
- 类可以声明多个构造函数,但是构造函数的方法签名不能相同.

可以通过 new 操作符 利用构造函数 创建一个类的对象

```java
Bicycle bicycle = new Bicycle();
```

new的是什么?new的是Bicycle这个类吗?不是.类是不能new的
它new的是构造函数 public Bicycle(){} 

- 当类显式声明了有参构造函数时,编译器将不再自动创建无参构造函数
  没有显式声明有参构造函数时,编译器自动创建无参构造函数。这也是不写无参构造函数时,new Bicycle()可以使用的原因

```java
public class Bicycle{
	private int cadence;
	private int speed;
	private int gear;
    
	public Bicycle(int gear){
        this.gear = gear;
    }
    public Bicycle(int speed){
        this.speed = speed;
    }//无法编译,因为两个构造函数方法签名相同
}
Bicycle bicycle = new Bicycle(5);
//这个 5 就是 bicycle 对象 gear的初始属性
Bicycle bicycle = new Bicycle();
//但是这样就不对了,因为无参构造函数不再自动创建了,真想用?自己声明;
```

**多个构造函数**
类有多种构造函数，调用构造函数创建对象时
java根据我们传入的参数类型，自动调用符合参数列表的构造函数

```java
public class Test{
    int var;
    Test(double var){
        this.var = (int)var;
    }
    Test(int var){
        this("hello");
    }
    Test(String s){
        this();
        System.out.println(s);
    }
    Test(){
        System.out.println("goodbye");
    }
    public static void main(String[] args){
    Test t = new Test(5);
    }
}/*
多个构造函数，输入5时，它会调用哪个？
调用符合条件的，输入 int 那么就调用 int
调用  Test(int var),而它里面又调用了 Test(String s).
此时传入的5去哪了？没了，没有赋值给var的语句
调用Test(String s),传入了"hello",这个函数调用了Test()
所以结果是 goodbye
		 hello
```

```java
public class A {
   private String name;
    public A() {
       System.out.println("1");
    }
    public A(String name) {
        this.name = name;
        System.out.println("2");
    }
}
public class B extends A{
    private A a;
    public B() {
        System.out.println("3");
    }
    public B(String name) {
        System.out.println("4");
       a = new A("5");
    }
}
new B("6");/*结果是？
要调用B了，先加载B，而B继承自A，先加载类A，A里面没有什么静态代码，无事发生
再加载B，B声明了a，不会加载A，仅声明不会加载类
newB类对象时，会优先调用超类A的构造函数，调用哪个呢？
B中没有显式调用A的构造函数，所以默认调用A的无参构造函数 输出1
之后调用B的有参构造函数，输出4
之后创建A类对象，调用A的有参构造函数，输出2 
结果 1 4 2
```



#### 对象创建

- 声明 
  声明并不会创建一个对象，也不会加载声明类
  声明类仅创建一个变量，这个变量可以引用 声明类型的对象
  Bicycle bicycle;
- 实例化
  创建对象就是实例化，创建对象是new操作符要做的事情
  有几个new，就有几个对象
  Bicycle bicycle = new
- 初始化
  利用构造函数对对象完成初始化
  Bicycle bicycle = new Bicycle(5)

![](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/creat.png)

#### 传递类型

##### 对象引用传递

```java
public class Test {
    public static void main(String[] args){
        Bicycle bicycle = new Bicycle();
        bicycle.setGear(5);//初始化bicycle的gear为 5
        test(bicycle); 
        System.out.println("离开方法后："+bicycle.getGear()); //如果是值传递,bicycle对象的gear仍是5
    }
    private static void test(Bicycle bicycle){
        System.out.println("方法修改前："+bicycle.getGear());
        bicycle.setGear(2);
        System.out.println("方法修改后:"+bicycle.getGear());
    }
}
/*结果:
方法修改前：5
方法修改后:2
离开方法后：2
说明 对象 是引用传递*/
```

##### 值传递

8+1数据类型为值传递

```java
public static void main(String[] args){
    String name = "java";
    int index = 10;
    getPrint(name,index);
    System.out.println(name);
    System.out.println(index);
    return;
}
private static void getPrint(String name,int index){
    System.out.println(name);
    System.out.println(index);
    name = "C++"
    index = 5;
    System.out.println(name);
    System.out.println(index);
    return;
}
/*
结果
java 10  name和index 是 java 和 10 传入getPrint后打印结果java,10
C++ 5 在getPrint中 改java为c++,改index为5
java 10 结束方法后打印还是java和10 
说明 8+1类型是值传递
*/ 
```

### Static

- **static关键字不会改变方法或者变量的访问范围**
- java中static不能用于修饰局部变量
- static可以不需要实例化对象就可以访问类中的属性和方法

#### 方法

方法分为两种：静态方法和非静态方法

- 静态方法可以直接 点 出来，直接使用

- 非静态方法，需要创建一个对象，然后通过 对象.方法 使用
  因此也叫 实例方法

- <font color = blue>静态方法属于类本身，不能被子类继承</font>
- 静态方法内不允许使用 this 和 super 关键字

```java
public class Test {
    static void staticprint(){
        System.out.println("静态方法");
    }
    void nonstaticprint(){
        System.out.println("动态方法");
    }
}
public class Main {
    public static void main(String[] args){
        Test.staticprint();// 静态方法直接调用
        //Test.nonstaticprint 是不可以调用的,编译器会建议把			  nonstaticprint前加static,改成静态方法
        Test test = new Test();//非静态方法需要先创建对象
        test.nonstaticprint();//然后借助对象调用
        test.staticprint();//对象当然可以调用静态方法
    }
}
```



#### 变量

- 静态变量被所有的对象共享，在内存中只有一个地址，当且仅当类在初次加载时被初始化
  非静态变量时对象所拥有的，每个对象的非静态变量地址不一样

- 静态变量也是可以直接点出来
  非静态变量只能通过对象点出来
- 对于静态方法，不管是类调用它 还是对象调用它，调用的都是同一个地址
- 类的私有静态变量，只有类的对象可以调用，不能通过类调用它。
- 实例方法 单项访问 方法静态成员
  静态方法 无法访问 实例级成员

```java
public class Dish {
    double salt;
    static int count = 0;//静态变量
    static double sumSalt = 0;//静态变量
    Dish(double salt){
        this.salt = salt;
        count++;
        sumSalt += salt;
/*每次调用这个函数,这个Dish类的 count 就会加1,类的sumSalt就会加上Salt,使用类的 count 时,会接着上次的count用,
d1用完count后是1,d2调用时count还是1,不会再初始化一次.
具体实例也可以使用静态变量,正如 静态变量 是整个类共享的
静态代码块仅初始化一次,仅运行一次*/.
    }
}
public class Test {
    public static void main(String[] args) {
        Dish d1 = new Dish(0.1);
        Dish d2 = new Dish(0.4);
        Dish d3 = new Dish(0.5);
        System.out.println("一共做了"+Dish.count +"盘菜");
        System.out.println("一共用了"+Dish.sumSalt+"g盐");
		System.out.println("一共用了"+d3.sumSal+"g盐");
    }
}
```


**规范:**
私有静态变量依然禁止对外直接暴露,必须对外提供访问的公有静态方法

![staticvariable](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/staticvariable.png)

> 静态方法任何时刻都能用,而实例成员必须定义才会存在
> 因此静态方法无法访问可能不存在的成员 
> 即 静态方法无法访问实例成员





#### 静态内部类

在 类 里面再定义一个 静态类
虽然是定义在 类 的里面,但是规则上跟外部类一样,是完全独立的,只是代码层面是嵌套的.静态的内部类仍然无法调用外部类的实例级对象







#### 初始化顺序

```java
public class A {
    private static String S = create();
    private static String create(){
        System.out.println("A static method create()");
        return "";
    }
    public static String getS(){
        System.out.println("A static method getS");
        return S;
    }
}
public class Test{
    public static void main(String[] args){
        A.getS();
        A.getS();
    }
}
//A static method create()
//A static method getS
//A static method getS
```

- 第一次使用类A时,先加载一遍A的静态代码. 
  Aの静态代码: private static String S = create(); 调用了create()	输出了 A static method create()
  加载完静态代码后,	A.getS() 	输出	A static method getS
  而第二次使用类 A.getS() 不用跑一遍静态代码了,所以只有A static method getS
- 静态代码块的调用顺序 就是编译顺序.

- static变量是在类加载时完成的初始化,与是否调用 getS() 无关.
  加载类时便初始化static变量.

```java
public class A {
    public A(){
        System.out.println("构造函数");
    }
    private static String S = create();
    private static String create(){
        System.out.println("A static method create()");
        return "";
    }
    public static String getS(){
        System.out.println("A static method getS");
        return S;
    }
}
public static void main(String[] args){
        new A();
    }
//A static method create()
//构造函数
//要调用A,先加载一遍A里的静态变量 S,所以 method create() 先出来
//之后 new A() 调用A的构造函数, 才出来了 "构造函数"
```

- 仅声明变量 不会加载类

```
A a; 不会加载类A
```

- B提供属性a的有参构造函数
  后传入一个类型A的引用,哪个优先级高? 变量a的两个引用,谁覆盖谁?

```java

public class A {
    public A(){
        System.out.println("A的构造函数");
    }
    static{
        System.out.println("A的静态代码块");
    }
    private static String S = create();
    private static String create(){
        System.out.println("A static method create()");
        return "";
    }
    public static String getS(){
        System.out.println("A static method getS");
        return S;
    }
}
public class B {
    private A a = new A();
    public B(A a){
        this.a = a;
        System.out.println("B构造函数");
    }
    static {
        System.out.println("B的静态函数块");
    }
}
new B(new A());
/*
B的静态函数块	from B的静态代码
A的静态代码块 from A的静态代码
A static method create() from A的静态代码
A的构造函数 from private A a = new A()
A的构造函数 from newB( new A()) 的 new A()
B构造函数 from public B
*/
new B(new(A)) 先加载类B,加载一遍静态代码块. 然后要调用B的构造函数.但是调用构造函数之前,先执行类B的属性的初始化.B中属性是 A a = new A() 先执行这,要执行这个就要加载一遍A的静态代码. 
加载完后才执行 A a = new A()
最后才是B的构造函数,B的构造函数传入了一个新的 A类型变量,A的构造函数又执行一边,最后才输出B构造函数的最后语句.
```



## 枚举enum

特殊的数据类型,定义一组预定义的**枚举**常量列表.限制用户输入

enum 是一个类型, 可以定义变量
定义的 enum 类型变量 只能接受 enum常量列表 里的值，其他的值无法输入，也就无法编译.

- 顶级类型
  允许创建独立源文件
- 内容都是常量（全部大写）
- 每一个常量都有隐式修饰符 public static final 确保 枚举中的常量具有公共，静态，不可改变的特性.
- 逗号隔开，不要分号结尾.

比如 四季

> java 给了月份枚举 Month.······

```java
public enum Seaon{
 SPRING,SUMMER,AUTUMN,WINTER
}
//使用:Season.SPRING
private static String getEnumSession(Season season){
    String msg = "";
    switch(season){//season只能传入上面预设的值,这便是用法.
        case SPRING:
            msg = "春天";
            break;
        case SUMMER:
            msg = "夏天";
            break;
        case AUTUMN:
            msg = "秋天";
            break;
        case WINTER:
            msg = "冬天";
            break;
    }
    return msg;
}
//再举一个 学生的性别
public class Student{  
    Gender gender;
   	String name;
    public Student(String name,Gender gender){
        this.name = name;
        this.gender = gender;
    }
	punlic enum Gender{
    	MALE,FEMALE//那么Gender类型的变量只能接受 MALE 或者 FEMALE，其他的值接受不了
	}
}
```

































## 抽象类,接口,继承

### 接口

接口是互交的协议，也是定制的规范，A产的电脑能插B生产的U盘，就是因为它们遵循同一套规范

接口声明抽象方法（仅声明方法，不实现方法）
public int addNum(int a, int b);   这便是仅声明了方法,没有实现,所以它是抽象的方法

- 接口 由 **修饰符, interface 名称 ,(继承接口列表) 主体** 组成
  支持 public/package-private修饰

  ```java
  public interface GroupInterface extends Interface1, Interface2, Interface3{int addNum(int a, int b);}
  //修饰符				名称				继承列表									主体
  ```

- 接口也是顶级的,可以单独创建源文件，也可以声明在类中

- 接口可以继承接口一个接口可以继承任意数量的接口，接口设计出来就是为了被继承的

- 接口内可以包含 **抽象方法，默认方法， 静态方法 和常量**
  
  接口中所有方法都有隐式public修饰，
  抽象方法具有隐式public abstract修饰
  常量有隐式public static final修饰
  
  隐式修饰，代表这些 public 可写可不写，写了不错，不写编译器自动补全。
  
- 规范: 接口中的方法/常量，省略多余的修饰符。（不写）
- 接口命名 名词或者名词短语,形容能力的以形容词命名；形容服务的声明服务类型后缀 UserService,InitService...
  

**接口中的方法不需要手动写 public ，因为有隐式 public**



java8之前,接口中只能有抽象方法。

java8及之后,接口里也可以有具体实现的方法了。通过 default 关键词在接口中声明方法的具体实现 (可以放心添加新method) 
默认方法干什么的？可以把它当作接口的非静态方法。

```java
public interface Learnable{
	void read();
	default void study(){
	 System.out.println("study");//这个 study 就是 default 声明实现的方法,所有实现了该接口的类都可以直接调用study
	}
}
```


java8之后 允许在接口中定义 静态方法.
定义静态方法无需添加 default 关键词 

所有静态方法都可以  类型.方法 使用
接口的静态现在也可以 接口.方法 使用啦,无需任何实现类

```java
public interface Learnable{
	int STUDY_TIME=8;
	void read();
	int test();
	static int getLeftTime(int hours){
	return hours - STUDY_TIME;
	}
}
```





#### 实现类

> 既然声明了方法,总得有人实现这些方法.

定义一个类，通过 implements 关键词继承接口，这个类就是实现类

- 实现类 implements 多个接口时，用逗号分隔接口列表
- 实现接口，就必须实现接口中的所有抽象方法，少一个都不行
- 实现方法是重写，用@override声明重写。
- 实现类本质上还是一个类，也可以当正常类一样声明自己的属性，创建自己的对象···
- 如果在接口里添加新method，该接口的所有实现类都要对该method进行实现。

```java
public interface Playable{
	void sing(String songName);
}//接口1
public interface Learnable{
    void read(String bookName);
    int test(String courseName);
}//接口2
public class Undergraduate implements Learnable,Playable{//继承两个接口
    private String name;//可以正常声明自己的属性
    public Undergraduate(String name){
        this.name = name;
    }
    @override
    public void read(String bookName){
        System.out.println(bookName);
    }
    @override
    public int test(String courseName){
        System.out.println(courseName);
        return 0;
    }
    @override
    public void song(String songName){
        System.out.println(songName);
    }
}
```





#### 使用

定义了一个接口,就是定义了一个可以引用的类型.
像类一样,可以在任何需要的地方作为类型使用
接口无法实例化，创建对象的方法有点特殊：
		首先要new一个接口实现类的对象，
		然后接口声明一个引用变量对该对象引用

```java
Learnable learnable = new new什么?
new Learnable()
//无法编译,Learnable里面根本没有具体的方法,无法实例化
Learnable learnable = new Playable();
//接口创建对象,new的是接口的实现类.这样才能使用接口里的方法.
//同时这个对象也可以拥有实现类里面的属性.
//注意是对象可以拥有其他属性，而变量learnable只能用声明类型里的东西
```



### 抽象类

抽象类可以声明抽象的方法(跟接口一样)，也可以声明普通的方法。
普通方法可以被子类继承使用

> 注意抽象类里面没有隐式 public abstract 
> 需要手动添加声明这是抽象方法

- **抽象类无法被实例化**，但是可以被继承使用。
  可以声明属性，并且可以提供构造函数给子类用。
- 继承了抽象类的非抽象子类，必须实现抽象类中所有的抽象方法。
  即 如果子类也是抽象类，那么不必实现超类的方法

- 抽象类不必实现接口中的所有方法。
  未实现的抽象方法交给子类实现
  子类可以中介调用超类中的方法。
- 子类无法继承超类private成员,但是可以通过 getter/setter 方法访问超类的属性(如果提供)

- 抽象类可以继承非抽象类的普通类

- 抽象类中的抽象方法不能用static修饰

  > 抽象方法是用来给子类继承的，使用static后，这个方法就属于类了，不能被子类继承，所以抽象方法不能使用static修饰

```java
public abstract class Organism{
	private String name;//声明子类共有的属性
	public Organism(String name){
		this.name = name;
	}//提供构造函数
	public void sleep(){
	sout("sleeping");
	}//可以声明普通方法
	public abstract void move();//声明抽象方法
}
Organism org = new Organism("asd")//出错
```



抽象类可以被多个类继承，但是只能继承一个抽象类
类就是人，一个儿子只能有一个父亲

### 匿名内部类

接口可以有多个实现类，不同的实现类可以提供不同的实现方法。
那么如何让同一个实现类的不同对象提供不同的实现?

**匿名类/匿名内部类**
匿名内部类能够同时 声明和创建 一个实现类和对象。
它是动态创建的,没有名字。
适合于声明使用一次的不会被复用的类。
匿名类也是一个类,也可以拥有自己的属性和方法。

#### 接口使用

```java
public interface Learnabe{
	void read();
}
public class Student{
	private String name;
    private Learnable learnable;
    public Student(String name){
        this.name = name;
    }
    public void setLearnable(Learnable learnable){
        this.learnable = learnable;
    }// learnable 的 getter和setter
    public Learnable getLearnable(){
        return learnable;
    }
}
//如何实现不同学生有相同能力但是有不同的实现方法?每创建一个学生对象,单独针对此学生写一个实现类
public class test {
 public static void main(String[] args){
       Student s1 = new Student("s1");
       s1.setLearnable(new Learnable(){//s1.setLearnable(new Learnable的一个实现类) new的不是Learnable()接口.
           @Override
           public void read(){
               System.out.println("read by s1");
           }
       });//这里还是一行语句,不要忘记加分号
       Student s2 = new Student("s2");
       s2.setLearnable(new Learnable() {
           @Override
           public void read() {
               System.out.println("read by s2");
           }
       });
               s1.getLearnable().read(); // read by s1
               s2.getLearnable().read(); // read by s2
   }
}
```

匿名内部类其实就是    类的子类   匿名类在A内部写,那这个匿名类就是A的子类
如果 类有构造函数,那么子类必须给构造函数传值

#### 抽象类使用

用匿名内部类在抽象类中的使用

```java
public abstract class Organism{
	private String name;
	public Organism(String name){
		this.name = name;
	}
	public abstract void move();
}
Organism org = new Organism("kidney");//报错,抽象类不能实例化
//借由匿名内部类
Organism org = new Organism("kidney"){
           @Override
           public void move(){
               System.out.println("move");
           }
       };//这也是一个语句,记得带分号
       org.move(); // move 
}
```

普通类也可以直接创建一个匿名内类子类以及对象

匿名类: 创建一个继承 A 的子类
new 匿名类 实例化这个子类对象
A a = new 匿名类 把实例化的子类对象上转型给 a



### 继承Inheritance

#### 须知

- **Subclass** 子类(派生类,扩展类)
- **Superclass** 超类(基类) 
  子类的 直接超类 习惯上称为 父类
- 每个类 能且只能 直接继承自一个父类(单继承)
- 没有显示声明继承时,每个类都隐式继承自 Object 类
  A显式继承自B,B显式继承自C C没有显式继承, 那么C隐式继承自 Object
  so java中所有类都是 Object 的子类
- **final修饰的类无法被继承**

**继承的意义**:想创建一个新类,当前存在一个包含需要代码的类时,可以直接从现有的类中派生出一个新的类,重用现有类的成员,无需重新编写.
许多语言有更为灵活的 Mix-in 即保持了代码的重用性,又降低了耦合性. 但是java没有.别想了

- 子类继承超类所有的public/protected成员（变量，方法）
  并且可以直接调用超类中的public/protected静态成员(变量，方法）
  子类不能访问超类的private成员

- 子类可以声明子类自有的新属性和新方法

- **this** 指向当前对象的引用

- **super** 代表当前类的超类.
  - 可以通过 **super** 调用超类的 **public / protected** 成员  超累的 private 用不了,private仅类内可用
  - 可以通过 **super** 调用超类构造函数
  - 不能理解为指向超类的引用,虽然实例化会调用超类构造函数,但是不会创建超类对象


```java
//Bird是Animal的子类
//Animal有方法move
public class Bird extends Animal {
 move();
 super.move();
 //两者等价
}
```

> 在子类,超类的方法没有名称冲突时,可以直接使用超类中的方法,无无需声明 super.

#### 子类实例化

子类必须满足超类的特性。子类的构造函数必须把超类也构造上

创建子类对象时，会首先调用超类的构造函数。

```java
public class User{
	public user(){
	System.out.println("User");
	}
}
public class Teacher extends User{
	public Teacher(){
	System.out.println("Teacher");
	}
}
Teacher t = new Teacher();
//结果 
//User
//Teacher
```

为什么会这样?User哪来的?
构造子类对象时,会先调用超类的构造函数,之后再调用自己的构造函数.

子类就是在超类的地基上盖楼
想要盖楼时，要先把地基打上，才能接着往上面盖

```java
public class Animal implements Movable{
    private String name;
    public Animal (String name){
        this.name = name;
    }
}
public class Bird extends Animal implements Flyable {
   private String color;
   public Bird(String name,String color){
//两个参数的构造函数,一个参数为超类属性,且超类提供了构造函数,因此可以通过超类封装一个属性,再自己初始化一个属性
        super(name);//由于超类没有无参构造函数,必须调用超类的有参构造函数
        this.color = color;
   }
}
```

在构造函数中，通过super调用超类的构造函数语句必须位于构造函数的第一行
先把超类构造出来 才能在超类的基础上添加子类属性构造出来子类.
调用super是为了完成本类继承自超类的属性的初始化,并不会创建超类对象

#### 类型转换

相关的不同类型间的转换,是多态的表现形式
Bird继承自Animal以及Object,因此Bird是Animal类型,也是Object类型.但是反过来不能确定

- 允许将一种类型转换为其继承/实现的另一种类型,称为**上转型** (隐式转换,上转型是可以自动发生的)

```
Bird bird = new bird(xxx);
Animal animal = bird;
Object obj = bird;
bird,animal,obj的类型都是Bird.
```

> Animal animal = bird;
> 等号左边变量的类型取决于等号右边,跟声明无关.
> 等号左边的声明限制对象可以表现出什么特性/行为(能使用什么方法)

> bird可以使用方法fly.
> animal的类型虽然也是Bird,但是不能使用方法fly
> 因为Animal里面没有fly 所以 animal不能使用fly. Animal就是限制了bird中方法的使用

变量的实际类型由等号右边决定.
变量能使用的方法由左边声明决定.

- 下转型 需要显式声明强制类型转换

```java
Bird bird = new bird(xxx);
Animal animal = bird;
Object obj = bird;  可以

Bird bird2 = (Bird)obj;//obj的声明类型是Object,下转型需要显式声明
bird2.fly() //没问题---obj引用对象类型是Bird,所以可以给Bird类型的bird2,且可以使用fly
```

```java
Animal animal = new Animal(xxx); 
Bird bird2 = (Bird)animal; //animal的类型是 Animal,下转型需要显式声明
编译出错--------bird2引用的对象类型是Animal,不具有Bird的一些属性,所以不能编译
    如果子类没有新的属性,那么编译可以通过.
```

>  写的时候编译器不会报错,只有在运行的时候才会报错.

- 隐式的上转型. 子类一定有超类的特性,自动类型转换
- 显式的下转型. 超类不一定有子类的特性,运行时才知道对错

声明的变量类型仅约束行为(限制方法的使用),不影响方法的实现.

```
Animal 和 Bird 都有 method move,在Bird中覆写method move.
Bird bird = new Bird(xxx);
Animal animal = bird;
bird.move() -> bird move 而不是 animal move
方法的实现还是Bird中的方法,而不是animal中的方法,因为bird是Bird类型的对象.
```

#### 声明与限制

接口无法实例化.
声明的接口类型变量,是其实际引用对象的类型.
它永远都不能是它声明的接口类型.只能是接口中其中一个实现类的类型.

Animal 实现 接口 Movable .
Movable movable = new Animal();

变量 movable 实际类型是 Animal
但是由于声明限制，movable 只能表现出Movable类型的能力。



### Override Overload

#### 重写override

支持在子类中声明一个与超类中方法签名相同的新的实例方法.

- **声明**
  @override 覆写超类方法.(隐藏超类方法)
  隐藏静态方法时，无需@override注解修饰 

- **要求**
  **方法签名一样**。

  没有限制参数列表的参数名称，所以改变参数名称也叫重写

  **返回类型**

  1.  void ，不能增加返回类型
  2.  基本类型 ，不能改变
  3.  其他类型 ， 允许返回类型改成子类

- **访问范围**
  重写方法的访问权限不能比父类中被重写方法的访问权限更低。
  超类是protected,子类访问范围必须大于等于protected
  可以是public,可以是protected,不能是private或其他比超类声明的访问范围小的

**final修饰的方法无法被重写**



#### 重载**overload**

- 重载发生在一个类中，同名的方法具有不同的参数列表。
- 有不同的参数列表才能算作重载方法。
- 重载方法可以改变返回类型、访问修饰符。
  但是仅改变这俩不算重载方法

```java
public void list(int groupId){}
public int list(int groupId,int type){}
public void list(int groupId,string name){}
```



## 封装&String

### 说明

基本数据类型不是对象,在一些需要使用对象或者引用传递的地方,不可以使用.
java为每一种基本数据类型提供了一个包装类,这些类可以将基本数据类型包装成对象,而在以上场景下使用

装箱: 	将基本数据类型转换为对象
拆箱: 	将基本数据类型对象转换为基本数据类型

| 基本数据类型 |  包装类   |
| :----------: | :-------: |
|   boolean    |  Boolean  |
|     byte     |   Byte    |
|     char     | Character |
|    float     |   Float   |
|     int      |  Integer  |
|     long     |   Long    |
|    short     |   Short   |
|    double    |  Double   |

![QQ图片20240405140654](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/QQ%E5%9B%BE%E7%89%8720240405140654.png)	
num是基本数据类型,点不出方法

![QQ图片20240405140757](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/QQ%E5%9B%BE%E7%89%8720240405140757.png)
而Integer是int的包装类,可以点出方法.

- 基本数据类型的封装类(也叫引用类型),也用于声明禁止默认值的属性数据

  比如一个学生类的属性年龄  定义为 基本数据类型 int age; 时基本数据类型默认值为0,那么不给学生对象初始化的话,就表明这个学生0岁,这是不可以的.这时 我们可以定义年龄为 引用类型, Integer age; 引用类型默认是null,意义不一样.

### 方法

所有数字类型具有相同的方法,因此仅以 Integer举例.

#### valueOf() 

**将基本数据类型转为对应封装类的对象**

封装类名.valueOf(基本数据类型).返回值类型为封装类名.

```java
Integer num = Integer.valueOf(102);//Integer.valueOf(int)把int转化成Integer类型的对象
Integer num2 = Integer.valueOf("102");//Integer.valueOf(string)string转化成Integer类型的对象
```

java5后,编译器自动完成拆装箱.

Integer num = 102; 不用使用 Integer.valueOf(102);
	编译器自动补全 Integer num = Integer.valueOf(102); 

int i = num; 不用使用 num.intValue();
	编译器自动补全 int i = num.intValue();

```java
Integer num = 102;
int i = num;
编译器实现过程:↓
Integer num = Integer.valueOf(102);
int i = num.intValue();
```

但是没必要用封装类的地方还是不要用,比如直接相加,直接加比拆装箱再加快多了.
能直接用基本类型完成的事情,就不要拆装箱了

#### parseInt() 

**将string 转化为 int 基本类型**

```java
int num3 = Integer.parseInt("102");
```

#### max,min(a,b)

比大小,返回大的/小的值

#### xxxValue()

**将对象转化为基本数字类型xxx**

```java
Integer num = Integer.valueOf(102);
double d = num.doubleValue();//转为double
double n = num.intValue();//转回int
System.out.println(d);//102.0 
```

### Math类

|        Method        |    retrun    |
| :------------------: | :----------: |
|       sqrt(x)        | 开方(开根号) |
|       pow(x,y)       |     x^y^     |
| sin(x),cos(x),tan(x) |   三角函数   |
|        abs(x)        |    绝对值    |
|     max/min(x,y)     |   max/min    |
|       ceil(x)        |   向上取整   |
|       floor(x)       |   向下取整   |
|       round(x)       |   四舍五入   |
|        log(x)        |    ln(x)     |
|        exp(x)        |     e^x^     |
|         ···          |     ···      |

都是Math类下的方法,使用时应该是 **Math.xxx**

### Random类

Random r = new Random();
System.out.println(r.nextInt(10)); 取1-9之间的随机整数

### BigDecimal

根据 **IEEE** 指定的二进制计算机浮动存储标准,浮点型小数部分按bit计算存储会导致精度丢失

只因 小数的存储和计算 有问题
存储: 小数进行存储时,先转化为二进制

```
0.3转换为二进制
0.3*2 = 0.6 =>.0(.6) 取0余0.6
0.6*2 = 1.2 =>.01(.2)取1余0.2
0.2*2 = 0.4 =>.010(.4)取0余0.4
0.4*2 = 0.8 =>.0100(.8)取0余0.8
0.8*2 = 1.6 =>.01001(.6)取1余0.6  循环 0.010011001100110011001100...
再转换为十进制拿出来计算时,转换成了 0.3000000000004
```

**BigDecimal用于精度计算.**

- 将浮点数由字符串描述,封装在 BigDecimal对象 ,再通过 BigDecimal对象 完成操作.
  提供 add(),subtract(),multiply(),divide() 等方法
- 拥有封装类中的 
  xxxValue() (封装类转化为xxx基本类型)
  toXxx() (基本类型转化为封装类)

```java
     float f1 = 0.2F;
     float f2 = 0.1F;
     System.out.println(f1+f2);
     BigDecimal b1 = new BigDecimal("0.2");//浮点数用字符串描述
     BigDecimal b2 = new BigDecimal("0.1");
     float f3 = b1.add(b2).floatValue();
     System.out.println(f3);
```

###  String

#### 对象地址

String h1 = "hello world";
实际上创建了一个字节数组对象,并且把该数组的引用传给了 h1

- 字符串类型不可被继承
- String是不可变类型,一旦创建了字符串,就不能改变它的值
  许多方法看似修改了字符串的内容和长度,实际上是创建并且返回了一个新字符串
- 双引号" "声明的字符串常量,类编译时按常量直接置于字节码的常量池.
  简: 字面量直接置于常量池
- new操作符在 堆空间 创建字符串对象

```java
String str1 = new String("hello");
String str2 = "hello";
String str3 = str1.intern();
System.out.println(str1 == str2); //false
System.out.println(str1 == str3); //false
System.out.println(str2 == str3); //true
```

>str1引用的对象由new操作符在堆上创建,地址在堆上
>str2引用的对象在常量池,地址在常量池
>str3=str1.intern(),方法intern()将str1对象置于常量池,str3与str2所引用对象地址相同.

> == 在基本数据类型中判断对象是 值
>      在引用类型,对象中判断的是对象的地址

> 编译时字面量直接放入类常量池,类加载时放入运行时常量池.
> 常量池已有一个A的情况下,后面再创建一个新的A放入常量池时,不会再利用新地址放新A,而是引用旧A.
> 所以str1用方法放入常量池,但是常量池已经有了"hello",那么这个语句可以当没发生. 
> str3引用的是str2就存入的"hello",所以str2与str3引用对象的地址相同,是同一个"hello"

- equals(str1,str2)用来比较字符串的字面量(值)是否相同

- 字面量:不需要计算的量,编译时直接写出来的量
  String s1 = "11";常量池
  String s2 = "22";常量池
  String s3 = "11"+"22";常量池
  String s4 = s1 + s2;即使知道s1和s2都是字面量,但是还按照变量来看,所以s4引用对象地址不在常量池
  但是s4.intern()手动放入常量池后,s4和s3的引用相同.

#### 常用方法

|            Class.Method            |                            result                            |
| :--------------------------------: | :----------------------------------------------------------: |
|      (string)   toUpperCase()      |                           转为大写                           |
|      (string)   toLowerCase()      |                           转为小写                           |
|  (string)   substring(first,last)  |    获取[first,last)的字符串<br />last不写,默认获取到最后     |
|       int   indexOf(string)        | 从前检索指定字符串string<br />找到第一个后停止并返回索引值(找不到-1) |
|     int   lastInderOf(string)      | 从后检索指定字符串string<br />找到第一个后停止并返回索引值(找不到-1) |
| string   replace(oldchar,newchar)  |                         替换单个字符                         |
| string   replaceAll(oldstr,newstr) |                      替换所有匹配字符串                      |

> 索引: abcdefg d的索引是3, 3即是d的下标减一,又是d前面的字符个数,索引加一就是d的序数.

#### StringBuilder

StringBuilder对象跟String对象相似,但是StringBuilder可以被修改(不是返回一个新的对象)

- 构造函数

```java
StringBuilder( )
StringBuilder(CharSequence cs)
StringBuilder(int initCapacity)
StringBuilder(String s)
```

- append()方法
  StringBuilder append(float f)
  StringBuilder append(int t)
  StringBuilder append(long lng)
  StringBuilder append(String s)

  将参数转为字符串,并追加至builder

- toString() 将builder中的字符序列转为字符串



String 直接相加的效率没有StringBuilder相加的效率高

#### 输出

##### println

int n1 = 10;
System.out.println("Total:"+n1+n1);Total:1010
System.out.println("Total:"+(n1+n1));Total:20

println()输出类型按参数中第一个输出的算,先输出"Total",,则把后面的类型全部化作String输出.不想转换就用括号!

##### 代码块

java15以后,可以输出代码块了,关键词 """ """ 三个双引号括起来代码块,可以原样输出,而不用一个一个转义字符\.



##### 占位符

字符串中也可以用%s,%d···等占位符占位
使用方法 String.formatted(填充参数)将指定参数填入占位符


> 如何输出百分号%?  用百分号转义百分号 , \ 不能用来转义百分号



## 集合

将许多元素组合后曾一个单一单元的容器对象，可用于存储/检索/操作/传输/聚合数据

Collection(接口)，表示一组被称为元素的对象
Collection\<E>接口，用于描述最具通用性的集合，也包含了最具通用性的集合操作方法

Collection接口均继承自Iterable接口，即所有集合类型均支持foreach循环语句

- <font color = blue>**集合里的元素必须是引用类型**</font>（封装基本类型用处这不就来了）
  集合操作的也是元素所引用的对象，
  如 有一个学生对象，stu1 = new Student(); stu2 = stu1, 把 stu1 和 stu2放入同一个集合里
  操作stu1，修改学生名字为A，再打印stu2的名字，发现也是A，所以操作的是元素引用的对象
  同时也说明List集合允许包含重复元素



- **\<E>** 泛型. (表示可以是任何类型)
  		创建集合时,必须将泛型具体化为一个  引用类型
    		有助于编译器编译时检测,减少运行时错误

> 那么为什么不声明为Object类?
> 所有类都是Object类的子类,那么声明Object跟没声明一样
> 集合不关心里面塞了什么,但是我们关心.我们声明类型后,这个集合只放这个



- 集合系列操作需要放在主函数里，在类里写是识别不了的

![QQ图片20240410220320](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/QQ%E5%9B%BE%E7%89%8720240410220320.png)

![QQ图片20240410220126](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/QQ%E5%9B%BE%E7%89%8720240410220126.png)

### 方法

|                 Method                 |        Operation         |
| :------------------------------------: | :----------------------: |
|           boolean   add(E,e)           |        添加元素e         |
|    boolean   addAll(Colletion\<E>c)    |        添加集合c         |
|          boolean   remove(e)           |        删除元素e         |
|  boolean   removeAll(Colletion\<E>c)   |        删除集合c         |
|              void clear()              |           清空           |
|         boolean    contains(e)         |    判断是否包含元素e     |
| boolean   containsAll(Collection\<E>c) |    判断是否包含集合c     |
|          boolean   isEmpty()           |        判断是否空        |
|              int   size()              |         集合长度         |
|          T[]  toArray(T[] a)           | 将集合转化为指定类型数组 |
|        Iterator\<E> iterator()         |        获取迭代器        |

Collection 的 foreach方法运行时 不允许改变集合的长度

> 一个String集合 删除“sun”元素时，有些注意点，
> 集合中 删除元素后，后面的元素会自动向前移，补全空位。
> 所以不改变索引指针时，可能跳过一些符合条件的元素
>  1和2都是“sun“，删了1的”sun“后，2移到1，但是下一次搜索的i=2，所以注意删除后i--

### List\<E>

- 有序,允许包含重复元素的集合.
  除了继承自Collection的方法,还提供了位置索引的操作方法

|         Method          | Operation |
| :---------------------: | :-------: |
| void add(int index,E e) |   插入    |
|  E set(int index,E e)   |   替换    |
|    E get(int index)     |   获取    |
|   E remove(int index)   |   移除    |
|           ···           |    ···    |

**ArrayList LinkedList**

List集合的基本实现类有 ArrayList 和 LinkedList 

- ArrayList 基于对象数组数据结构实现 
- LinkedList 基于双向链表数据结构实现

> 创建List的时候 new 它俩
>
> List<Integer> list = new ArrayList<>();
> List<Integer> list = new LinkedList<>();

#### 声明创建

```javascript
List<type> list = new ArrayList<>();
//声明List集合类型变量list, <>中声明集合中元素的类型，必须为引用类型
//后面的尖括号<>可以不填写类型，java自动推导，只填前面的就行
//ArrayList或是LinkedList都可以，根据具体储存结构选择两种不同的实现类
List<String> strings;
List<Integer> numbers;
//定义好泛型后，加入不符合泛型的元素，会报错，加入元素类型的父类也会报错--父类有子类的特性吗？
//泛型约束向集合里传入的元素类型
List<Integer> numbers = new ArrayList<>();
numbers.add("string");报错
```

#### ArrayList构造函数

- **ArrayList**() 
  创建空List集合。默认创建0个元素的对象数组
- **ArrayList(int length)**
  创建 length 长度的List集合，长度仅限初始化时使用，后期添加/移除元素时自动更改长度
- ArrayList(Collection\<E> c) 
  基于 集合c 创建 List集合

LinkedList的构造函数同理

#### **ArrayList LinkedList**

- LinkedList基于双向链表数据结构实现，每个元素都有两个节点对象保留前后元素的地址

  ArrayList基于数组结构实现

- ArrayList 可以基于索引快速访问对象
  LinkedList 基于索引访问对象比较慢
  
- LinkedList 删除某索引前全部元素快得很，因为有前后指针
  ArrayList 删除某索引前全部元素比较慢



### Map

- <font color = blue>**Map不是集合**</font>

- Map用于存放键值对(key-value)。
  通过key值，保存和获取其对应的value值。
- key是唯一的，每个key只能对应一个value，但是一个value可以对应多个key，键值可以多对一。

- 添加键值对时，如果key已经存在，则新值覆盖旧值。
- java通过 key 的hash值判断key是否相同。
- 支持基本数据类型和任何类型的对象作为key/value。
- Map没有基于index索引的操作。
- Map不是Collection的子类，没有继承Iterable的操作，不支持foreach遍历。
- 支持嵌套： Map<String,Map<Integer,User> >
- 基本实现类为
  HashMap<k,v>
  TreeMap<k,v>
  HashTable<k,v>

#### Method

|  Return   |               Method               |                  Operation                  |
| :-------: | :--------------------------------: | :-----------------------------------------: |
|     V     |        put(k key, v value)         |            添加键值对且返回value            |
|     V     |             get(k key)             | 基于key获取value<br />value不存在则返回null |
|     V     |           remove(k key)            |           移除键值对并且返回value           |
|  boolean  |         containsKey(k key)         |                 是否包含key                 |
|  boolean  |       containsValue(v value)       |                是否包含value                |
|    int    |               size()               |                 键值对个数                  |
|  boolean  |             isEmpty()              |                  是否为空                   |
| default V | getOrDefault(k key,v defaultvalue) |                  **待定**                   |
|    ···    |                ···                 |                     ···                     |

### Set

- **Set**集合 不包含重复元素（数学中集合的抽象）
  因此不支持index索引
- **Set**集合只包含继承自Collection的方法，并且包含重复元素的校验
- 基本实现类
  HashSet\<E> 元素无序（基于HashMap确定元素是否重复）。
  LinkedHashSet\<E> 元素有序
  TreeSet\<E> 元素有序
  无论使用有序还是无序的实现类，都没有基于索引的操作方法
- **Set**集合适合描述逻辑上不能重复的对象：扑克牌，人···

**Tips:**
还记得List的第三种构造函数么？基于集合创建List ArrayList(Collection\<E> c) 
List/Set集合均提供参数为Collection的构造函数，可以将两种集合互相转化

```java
Set<User> uSet= new HashSet<>();//创建set
List<User> uList= new ArrayList<>(uSet);//set转list

List<User> uList = new ArrayList<>();//创建list
Set<User> uSet= new HashSet<>(uList);//list转set

//list转set自动去重
```

### Iterators

- Iterator接口，迭代器，允许遍历集合，并且根据需求从中移除元素
- Iterator\<E> iterator()方法，Collection接口的方法，获取集合对象的迭代器

#### Method

| Return  |  Method   |             Operation              |
| :-----: | :-------: | :--------------------------------: |
| boolean | hasNext() |     Iterator中是否有下一个元素     |
|    E    |  next()   | 向后移动游标同时返回游标指向的元素 |
|  void   | remove()  |       移除游标当前指向的元素       |

#### removeIf

移除符合函数表达式的元素，底层基于iterator迭代器实现

```java
users.removeIf(u -> "SUN".equals(u.getName()));
//这个 u 可以随意命名，它就跟平常定义函数的形参时给形参起的名字一样
```



### 不可变集合

- 如果一个对象的状态在构造后不能改变，则该对象被认为是不可变的。

- 不可变集合是线程安全

- 不可变集合的结构不变，构造速度更快，消耗内存空间更小
  不可变集合的结构不可变（长度也不可变），一旦创建，不可添加/移除元素
  如需改变结构必须创建新的结合（类似数组）
  不可变集合中的元素可以替换，元素对象属性值可以改变
  
- List.of() / Set.of() / Map.of (),返回空集合对象
  List.of(e,e,e,e) / Set.of(e,e,e,e) / Map.of (k,v) 基于元素创建并返回相应的集合对象

  ```java
  List<Integer> number= List.of(1,2,3,4);
         for(Integer num : number){
             System.out.println(num);
         }//1,2,3,4
  ```

### Tips

- null是所有引用类型的默认值
- 集合类型允许包含地址为null的元素
- Map允许声明null为 k / v
- 不可变类型集合不允许包含 null

## 函数式编程

函数式编程，函数的输出应该且仅应该依赖函数的本身。
函数的执行不依赖于函数外部数据。 即 函数要用的数据 只有参数列表传进来的和函数内部的
不用外部的数据

```java
//方法执行的结果，不仅依赖于方法本身而且依赖外部的属性
//面向对象的设计↓
int x;
public int multiply(){
return x*x;
}
//方法的执行结果仅依赖于方法本身
//函数式设计↓
public int multiply(int x){
return x*x;                                                                                                                                                                                                            
}
```

### Lambda

又 匿名函数表达式

- 有自己的参数列表，函数体和返回值

  - 闭包，独立于类
  - 匿名，无需声明修饰符，返回类型，函数名
  - 传递，可以像引用变量类型一样声明，像对象一样传递

- **语法**
  <font color = blue>(参数列表) -> {body} </font>
  函数体body很小，只有一行时，{ }可以省略
  参数为空时，需要声明空括号；只有一个参数时，可以省略括号
  参数列表的参数类型可以省略，编译器自动完成推导

  ```java
  (int num1,int num2) -> 
  (num1,num2) -> 
  //等效
  num1 ->//一个参数 省略括号
  () -> //无参数 声明空括号
  ```

  

### Stream

- **流操作**
  - 集合是存储元素对象的容器，而集合流Stream并不是存储元素的数据结构，
    而是操作集合元素的管道
  - Stream操作的是集合中的元素，而非集合本身。
    因此，将创建新集合聚合Stream操作的结果，而不影响源集合结构
  - Stream仅会对流过的元素操作一次，因此必须生成一个新的Stream才可以继续操作
    Stream上的操作会被延迟处理，针对一个集合的多次操作会被优化后执行，提高效率
  - **Collection接口中stream()方法可以获取当前集合的Stream对象**

#### 终止操作

终止stream操作处理，消费stream操作产生的结果

- collect() ：聚合在 stream 中间操作的结果
- forEach() ： 迭代stream的每个元素
- ······

#### **Collectors类**

用于操作聚合结果的工具类

- groupingBy()/mapping() 分组映射
- toList() / toSet() / toMap() 将stream结果转化为集合
- ·····
  **例 toList()**

  ```java
  APPLES.stream()
  	  .map(Apple::getColor)//将传入的元素变成元素执行getColor后的结果，返回这个结果流
  	  .collect(Collectors.toList())//把流转化成List 这一句可以简化为toList()
  	  .forEach(System.out::println);//对每一个元素使用println
  ```

  **例 groupBy()**
  基于给定数据 以 Map<K，List\<T> >分组结合

  ```java
  Map<Apple.Color,List<Apple> > map = APPLES
  		.stream()
  		.collect(Collectors.groupBy(a -> a.getColor()));//按照Map中定义的Key分组,groupBy里面的东西需要匹配Key
  ```

  **toMap()**

  ```java
  Map<Integer,Apple> map = APPLES
  		.stream()
  		.collect(Collectors.toMap(a->a.getId(),a->a))//基于给定键值来分组
  //		.collect(Collectors.toMap(APPLES::getId,a->a))等价
  ```

  

#### forEach()

是个Stream的方法，参数是 函数，应该传入函数对象

```java
for(Apple a : APPLES){
 System.out.println(a.getWeight());
}//原foreach语句
APPLES.forEach( a -> {System.out.println(a.getWeight());});
//基于forEach方法以及Lambda表达式
//a -> {System.out.println(a.getWeight());}是一个函数
//↑这里只能有一个参数a，因为这个foreach方法只要一个参数
//而不是因为lambda只能一个参数，lambda可以有多个参数
```

#### 中间操作

对集合中元素所执行的具体操作

- Stream filter() : 基于参数选择stream中的元素，过滤
- Stream map() : 基于stream操作映射为新的类型，映射
- Stream sorted() ：排序stream中的元素，排序
- Long count() ：获取stream中元素个数，技术
- ······

中间操作执行后，将结果置于一个新的Stream，从而允许新的Stream实现后续操作，形成基于Stream的操作链



- **Stream\<T> filter()**
  过滤stream中的元素，表达式结果必须为boolean值，为真则置于新stream，为假则过滤掉

  - 苹果s过滤颜色

    ```java
    private static void getStreamMap(Apple.Color c){    
    Stream<Apple> appleStream = APPLES.stream();
    //基于集合创建流 APPLES是 Apple类型元素对象的集合
    //collection类中有方法 stream()获得集合对应的对象
    //APPLES.stream()获得APPLES的Stream对象
        
    Stream<Apple> colorStream = appleStream.filter(a -> c==a.getColor());
    //中间操作 filter() 括号里的参数是函数，lambda恰好符合这个
    // a -> c==a.getColor() a只是随意命名的lambda形参名字而已
        
    List<Apple> apples = colorStream.collect(Collectors.toList());
    //stream有方法 collect() 括号内参数是 Collector.toList()/toSet()/toMap().
    //转化为对应的集合对象
        
    }
    List<Apple> apples = APPLES
    					.stream()
        				.filter(a - > c == a.getColor())
    					.collect(Collector.toList());
    //基于stream的方法链
    //java17后，.collect(Collector.toList()) 可以写 toList()。等效的			
    ```

  - **过滤重量和颜色**

    ```java
    List<Apple> apples = APPLES.stream()
    					.filter( a -> a.getColer == c && a.getWeight() >=weight)
    					.collect(Collectors.toList());
    ```

- **Stream\<T> map()**
  映射Stream中元素，基于条件将元素映射为新类型元素

  ```java
  APPLES.stream()
  	  .map( a -> a.getWeight()) //a代表传入的元素，a转换为 a.getWeight()
  	  .collect(Collectors.toList())
  	  .forEach(i -> System.out.println(i));//对每个传入的元素进行打印操作
  APPLES.stream()
  	  .map(Apple::getWeight) //如果对传入的元素使用元素本身就能用的东西，可以这样写 类::方法名 
  	  //要是传入与Apple类型不符的元素怎么办？报错呗。
  	  .collect(Collectors.toList())
  	  .forEach(i -> System.out.println(i));//对每个传入的元素进行打印操作
  ```

  

- **Stream\<T> sorted()**
  对Stream中元素排序

  Comparator类提供方法
  comparing() 基于指定值排序
  reversed() 倒序

  ```java
  APPLES.stream() //按重量排序
  	  .sorted(Comparator.comparing(Apple::getWeight))
  	  .collect(Collectors.toList())
  	  .forEach( a -> System.out.println(a.getId()));
  APPLES.stream() //按Id倒序
  	  .sorted(Comparator.comparing(Apple::getId).reversed())
  	  .collect(Collectors.toList())
  	  .forEach( a -> System.out.println(a.getId()));
  ```

  

- 其他方法
