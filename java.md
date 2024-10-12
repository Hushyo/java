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

Collection(接口)，表示一组被称为元素的对象
Collection\<E>接口，用于描述最具通用性的集合，也包含了最具通用性的集合操作方法
Collection接口均继承自Iterable接口，即所有集合类型均支持foreach循环语句

- <font color = blue>**集合里的元素必须是引用类型**</font>（封装基本类型用处这不就来了）
  集合操作的也是元素所引用的对象，因此一个对象可以同时存在多个集合中
  <font color=229453>**如 有一个学生对象，stu1 = new Student(); stu2 = stu1, 把 stu1 和 stu2放入同一个集合里**</font>
  <font color=229453>**操作stu1，修改学生名字为A，再打印stu2的名字，发现也是A，所以操作的是元素引用的对象**</font>
  <font color=229453>**同时也说明List集合允许包含重复元素**</font>
  
  null是所有引用类型的默认值
  集合类型允许包含地址为null的元素

- **\<E>** 泛型. (表示可以是任何类型)
  		创建集合时,必须将泛型具体化为一个  引用类型
    		有助于编译器编译时检测,减少运行时错误

> 那么为什么不声明为Object类?
> 所有类都是Object类的子类,那么声明Object跟没声明一样
> 集合不关心里面塞了什么,但是我们关心.我们声明类型后,这个集合只放这个

- 集合系列操作需要放在主函数里，在类里写是识别不了的

![QQ图片20240410220320](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/QQ%E5%9B%BE%E7%89%8720240410220320.png)

![QQ图片20240410220126](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/QQ%E5%9B%BE%E7%89%8720240410220126.png)

|    Return    |            Method            |        Operation         |
| :----------: | :--------------------------: | :----------------------: |
|   boolean    |           add(E e)           |        添加元素e         |
|   boolean    |   addAll(Colletion\<E> c)    | 把集合c的元素全部加进去  |
|   boolean    |          remove(e)           |        删除元素e         |
|   boolean    |  removeAll(Colletion\<E>c)   |        删除集合c         |
|     void     |           clear()            |           清空           |
|   boolean    |         contains(e)          |    判断是否包含元素e     |
|   boolean    | containsAll(Collection\<E>c) |    判断是否包含集合c     |
|   boolean    |          isEmpty()           |        判断是否空        |
|     int      |            size()            |         集合长度         |
|     T[]      |        toArray(T[] a)        | 将集合转化为指定类型数组 |
| Iterator\<E> |          iterator()          |        获取迭代器        |
|              |       removeIf(lambda)       | 表达式为真时，移除该元素 |

Collection 的 foreach方法运行时 不允许改变集合的长度

> 一个String集合 删除“sun”元素时，有些注意点，
> 集合中 删除元素后，后面的元素会自动向前移，补全空位。
> 所以不改变索引指针时，可能跳过一些符合条件的元素
>  1和2都是“sun“，删了1的”sun“后，2移到1，但是下一次搜索的i=2，所以注意删除后i--

### List

有序,允许包含重复元素的集合.
除了继承自Collection的方法,还提供了位置索引的操作方法

|         Method          |    Operation     |
| :---------------------: | :--------------: |
| void add(int index,E e) | 在索引处插入元素 |
|  E set(int index,E e)   | 根据索引替换元素 |
|    E get(int index)     | 根据索引取得元素 |
|   E remove(int index)   | 根据索引移除元素 |
|           ···           |       ···        |

List集合的基本实现类有 **ArrayList** 和 **LinkedList** 

- ArrayList 基于对象数组数据结构实现 
- LinkedList 基于双向链表数据结构实现

既然是类，那么必然有构造函数
我们利用构造函数创建集合对象

它们都有三种构造函数，以ArrayList为例

|         Constructor         |                    Operation                     |
| :-------------------------: | :----------------------------------------------: |
|         ArrayList()         |                    创建空集合                    |
|      ArrayList(int L)       | 创建长度为L的集合<br />可以随添加/删除元素变长短 |
| ArrayList(Collection\<E> c) | 用集合C的元素创建集合<br />是简单的集合类型转换  |



1. 创建集合对象
   <font color = blue>List\<元素类型> 集合名 = new ArrayList<>();</font>
   List\<Integer> list = new ArrayList<>();
   List\<Integer> list = new LinkedList<>();

   声明List集合类型变量list, <>中声明集合中元素的类型，集合中的元素必须为引用类型
   后面的尖括号<>可以不填写类型，java自动推导，只填前面的就行
   ArrayList或是LinkedList都可以，根据具体储存结构选择构造函数

2. 泛型约束向集合里传入的元素类型
   定义好泛型后，加入不符合泛型的元素，会报错。
   加入元素类型的父类也会报错--父类有子类的特性吗？

   ```java
   List<Integer> numbers = new ArrayList<>();
   numbers.add("string");报错
   ```

>  LinkedList基于双向链表数据结构实现，每个元素都有两个节点对象保留前后元素的地址
> ArrayList基于数组结构实现
> ArrayList 可以基于索引快速访问对象
> LinkedList 基于索引访问对象比较慢
> LinkedList 删除某索引前全部元素快得很，因为有前后指针
> ArrayList 删除某索引前全部元素比较慢



### Set

**Set**集合 不包含重复元素
特点就是不包含重复元素和不支持索引
**Set**集合只包含继承自Collection的方法，并且包含重复元素的校验

<font color = red>**基本实现类**</font>
**HashSet\<E>** 元素无序（基于HashMap确定元素是否重复）。
**LinkedHashSet\<E>** 元素有序
**TreeSet\<E>** 元素有序
无论使用有序还是无序的实现类，都没有基于索引的操作方法



### Iterators

迭代器，用于遍历集合，并且可以根据需求从中移除元素

Iterator\<E> iterator()方法，Collection接口的方法，获取集合对象的迭代器
<font color =blue>集合 .iterator()</font>

| Return  |  Method   |             Operation              |
| :-----: | :-------: | :--------------------------------: |
| boolean | hasNext() |     Iterator中是否有下一个元素     |
|    E    |  next()   | 向后移动游标同时返回游标指向的元素 |
|  void   | remove()  |       移除游标当前指向的元素       |



**removeIf**
集合里的方法，底层基于迭代器实现
集合.removeIf(lambda) 移除使表达式为真的元素



### 不可变集合

- 如果一个对象的状态在构造后不能改变，则该对象被认为是不可变的。
  不可变集合是线程安全
  不可变类型集合不允许包含 null

- 不可变集合的结构不变，构造速度更快，消耗内存空间更小
  不可变集合的结构不可变（长度也不可变），一旦创建，不可添加/移除元素
  如需改变结构必须创建新的结合（类似数组）
  不可变集合中的元素可以替换，元素对象属性值可以改变
  
- List.of(e,e,e,e) / Set.of(e,e,e,e) / Map.of (k,v) 基于元素创建并返回相应的集合对象
  如果参数为空如 List.of() 则返回空的集合对象

  ```java
  List<Integer> number= List.of(1,2,3,4);
         for(Integer num : number){
             System.out.println(num);
         }//1,2,3,4
  ```

### Map

<font color = blue>**Map不是集合**</font>

- Map用于存放键值对(key-value)。
  通过key值，保存和获取其对应的value值。
  key是唯一的，每个key只能对应一个value，但是一个value可以对应多个key，键值可以多对一。
  添加键值对时，如果key已经存在，则新值覆盖旧值。
- 支持 基本数据类型和任何类型的对象 作为key/value。
  Map允许声明null为 k / v ，空值也可以作为键值.
- java通过 key 的hash值判断key是否相同。
- Map没有基于index索引的操作。
- 支持嵌套： Map<String,Map<Integer,User> >

**基本实现类**

HashMap <k,v>
TreeMap <k,v>
HashTable <k,v>

|  Return   |               Method               |                          Operation                           |
| :-------: | :--------------------------------: | :----------------------------------------------------------: |
|     V     |        put(k key, v value)         |                    添加键值对且返回value                     |
|     V     |             get(k key)             | 基于key获取value<br />value不存在则返回null<br />不能用这个作为if的条件句 |
|     V     |           remove(k key)            |                   移除键值对并且返回value                    |
|  boolean  |         containsKey(k key)         |              是否包含key<br />可以用作if条件句               |
|  boolean  |       containsValue(v value)       |                        是否包含value                         |
|    int    |               size()               |                          键值对个数                          |
|  boolean  |             isEmpty()              |                           是否为空                           |
| default V | getOrDefault(k key,v defaultvalue) |                           **待定**                           |
|    ···    |                ···                 |                             ···                              |

- Map不是Collection的子类，没有继承Iterable的方法，不支持Iterable的foreach遍历。
  但是和集合一起支持另外一个foreach遍历
  这个forEach跟流操作非常相似，参数是函数，对每个元素都使用函数
  其他集合的函数接收一个参数，Map的函数接收两个参数，key和value

  ```
  List<User> list = 某集合 
  
  list.forEach(a-> System.out.println(a.getName()));
  Steve
  Peter
  David
  Jack
  Lily
  
  Map<Integer,Integer> map=某Map
  
  map.forEach((k,v)->System.out.println(k+" "+v));
  2018008 66
  2018006 56
  2018007 42
  ```

  















### **example**

**Q**:  提供以下可直接使用的User类，直接使用getter/setter方法。编写测试类主函数，模拟创建5个用户，分属3个不同城市创建Set集合，添加以上元素对象。思考，为什么使用Set集合？

1. 创建静态方法，传入封装User类型元素的Set集合，转为List集合返回 

   如何将Set转化为List>?

2. 创建静态方法，传入封装User类型元素的Set集合以及用户ID，基于迭代器在集合移除指定ID用户。 

   如何使用迭代器删除元素?

3. 创建静态方法，传入封装User类型元素的Set集合，将集合中元素以城市名称为键，相同城市用户集合为值分组 等同于 给定User类型，未知的Set集合数据。即不知道集合中有多少user对象，不知道用户居住在多少个城市。 实现以下方法，以城市名称为键，在此城市的所用用户为值，保存为Map

   如何根据键分组

4. 传入测试集合，调用测试

```java
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
	//省略getter和setter
}
```

1. 将Set转化为List 

   ```java
   public static List<User> convertSetToList(Set<User> set){
          return new ArrayList<>(set);
       }
   ```

   利用以集合为参数的构造函数可以轻松实现集合类型间的转换

2. 用迭代器删除元素

   ```java
   public static void removeUserById(Set<User> set,int id){
           Iterator<User> iterator=set.iterator();
           while(iterator.hasNext()){
               User user=iterator.next();
               if(user.getId() == id){
                   iterator.remove();
               }
           }
       }
   ```

   迭代器是直接定义的，再通过 集合.iterator() 方法获得迭代器对象

3. 以城市为键分组

   ```java
   public static Map<String,List<User>> groupByCity(Set<User> set){
       
           Map<String,List<User>> mapUserCity = new HashMap<>();
       	//创建待返回对象
           for(User user : set){//遍历集合
               String city=user.getCity();
               if(mapUserCity.containsKey(city)){
   			//这里不能用 map.get(key)判断是否存在key,因为null不是false
                   mapUserCity.get(city).add(user);
               }
               else{
                   mapUserCity.put(user.getCity(),new ArrayList<>());
   			  //添加新的键时添加一个空的集合
   			  //添加后不要忘了把这个键对应的元素添加到该集合里
                   mapUserCity.get(user.getCity()).add(user);
               }
           }
           return mapUserCity;
       }
   ```

   ​	

4. 输出

   ```java
   Map<String,List<User>> map=Method.toMap(set);
           for(String s : map.keySet()){
               for(User user : map.get(s)){
                   System.out.println(user.getId() +" " + user.getName() + " " + user.getCity());
               }
           }
   ```

   map是不支持forEach遍历的，所以不能直接遍历map，但是map中有方法 keySet()。
   keySet()会获取map中所有的键，并返回这些键的集合
   这个集合是Map的一个视图，对Map的修改，集合也会生效，反之亦然
   这个集合可以用任意类型的集合接收，也可以直接用











## 函数式编程

函数式编程，函数的输出应该且仅应该依赖函数的本身。
函数的执行不依赖于函数外部数据。 即 函数要用的数据 只有参数列表传进来的和函数内部的
不用外部的数据

函数式编程是应用程序设计思想，与面向对象程序编程完全不同

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
  - **传递，可以像引用变量类型一样声明，像对象一样传递**
    有些方法的参数是函数，这就用到了lambda表达式

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
  - 集合是存储元素对象的容器。
    集合流Stream并不是存储元素的数据结构，而是操作集合元素的管道
  - Stream操作的是集合中的元素，而非集合本身。
    因此，将创建新集合聚合Stream操作的结果，而不影响源集合结构
  - Stream仅会对流过的元素操作一次，因此必须生成一个新的Stream才可以继续操作
    Stream上的操作会被延迟处理，针对一个集合的多次操作会被优化后执行，提高效率
  - **Collection接口中stream()方法可以获取当前集合的Stream对象**

#### 操作

对集合中元素所执行的具体操作
操作执行后，将结果置于一个新的Stream，从而允许新的Stream实现后续操作，形成基于Stream的操作链

常用的几个

- Stream filter() : 基于参数选择stream中的元素，过滤
- Stream map() : 基于stream操作映射为新的类型，映射
- Stream sorted() ：排序stream中的元素，排序
- Stream forEach()：遍历，操作种类很多，具体什么操作取决于传入的函数

它们的参数都是函数，用Lambda表达式实现
该函数会被应用到每个元素上

- **Stream\<T> filter()**
  过滤stream中的元素，
  函数表达式返回值必须为boolean值，如果元素应用函数后返回值为真，则置于新stream，为假则过滤掉。

  ```java
  private static void getStreamMap(Apple.Color c){    
  Stream<Apple> appleStream = APPLES.stream();
  //流变量可以像集合一样直接定义
  //集合.stream()返回值为由该集合元素组成的流   
      
  Stream<Apple> colorStream = appleStream.filter(a -> c==a.getColor());
  //filter()方法返回值仍然是流，用同类型的流变量接收
  // a->c==a.getColor()  对每个元素都执行条件判断 元素.getColor()==c? 为真则放入新stream中 
      
  List<Apple> apples = colorStream.collect(Collectors.toList());
  //转化为对应的集合对象
      
  }
  
  //使用方法链可以简单许多
  List<Apple> apples = APPLES
  					.stream()
      				.filter(a - > c == a.getColor())
  					.collect(Collector.toList());
  //基于stream的方法链
  //java17后，.collect(Collector.toList()) 可以写 toList()。等效的			
  ```

  

- **Stream\<T> map()**
  映射Stream中元素，基于条件将元素映射为新类型元素

  ```java
  APPLES.stream()
  	  .map( a -> a.getWeight()) //a代表传入的元素，a转换为 a.getWeight()
  	  //把每一个 元素 都变成 元素.getWeight() 
  	  .collect(Collectors.toList())
  	  .forEach(i -> System.out.println(i));
  	  //对每个传入的元素进行打印操作
  APPLES.stream()
  	  .map(Apple::getWeight) //如果对传入的元素使用元素本身就能用的东西，可以这样写 类::方法名 
  	  //要是传入与Apple类型不符的元素怎么办？报错呗。
  	  .collect(Collectors.toList())
  	  .forEach(i -> System.out.println(i));//对每个传入的元素进行打印操作
  ```

  

- **Stream\<T> sorted()**
  对Stream中元素排序，参数为 Comparator.comparing(lambda)
  comparing() 基于指定值排序(由小到大)
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


- **Collection collect()** ：
  聚合流中元素，返回一个集合
  参数是 Collectors.方法
  Collector拥有 toList() / toSet() / toMap() 将stream结果转化为它们,to什么,返回值就是什么
   还有groupingBy()/mapping() 分组映射

- forEach() ： 迭代stream的每个元素
  **例 toList()**

  ```
  APPLES.stream()
  	  .map(Apple::getColor)//将传入的元素变成元素执行getColor后的结果，返回这个结果流
  	  .collect(Collectors.toList())//把流转化成List 这一句可以简化为toList()
  	  .forEach(System.out::println);//对每一个元素使用println
  ```

  **toMap()**

  ```
  Map<Integer,Apple> map = APPLES
  		.stream()
  		.collect(Collectors.toMap(a->a.getId(),a->a))//基于给定键值来分组
  //		.collect(Collectors.toMap(APPLES::getId,a->a))等价
  ```

  **groupBy()**
  基于给定数据 以 Map<K，List\<T> >分组结合

  ```
  - Map<Apple.Color,List<Apple> > map = APPLES
    		.stream()
    		.collect(Collectors.groupBy(a -> a.getColor()));
  //按照Map中定义的Key分组,groupBy里面的东西需要匹配Key
  //返回分组后的map
  
  
  ```
  
  **forEach()**
  是个Stream的方法，参数是 函数，应该传入函数对象
  
  ```java
   for(Apple a : APPLES){
     System.out.println(a.getWeight());
    }//Iterable接口的foreach语句
    list.stream()
        .forEach( a -> {System.out.println(a.getWeight());});
    //Stream的forEach语句
  
    //a -> {System.out.println(a.getWeight());}是一个函数
    //↑这里只能有一个参数a，因为这个foreach方法只要一个参数
    //而不是因为lambda只能一个参数，lambda可以有多个参数
  ```

| Return | Method  |      Operation       |
| :----: | :-----: | :------------------: |
|  Long  | count() | 获取stream中元素个数 |
|        |         |                      |
|        |         |                      |





## Optional

java.util.Optional\<T>

为了解决空引用异常引入的容器，用于封装单值元素（只能放一个元素）
我们可以通过Optional提供的方法，操作其中可能为空值的元素

我们有许多变量，它们可能为空值，当操作这些变量且它们恰巧为空值时，抛出很多异常，我们还要时刻注意它们是不是空值。现在我们用Optional装这些可能为空的元素，操作Optional容器就不用担心因为空值产生的异常

- **创建容器**
   <font color = red>Optional. **ofNullable (T value) / of(T value)/empty()** </font>
   Optional类的两个静态方法，用于创建Optional对象
  使用方法为 Optional 点 ofNullable()/of()
  可以装入任何类型的元素

  

  `Optional.of(T value)`用于传入非空元素，返回一个包含value的Optional对象，如果传入的值为null,则抛出异常
  
  ```java
   Optional<String> emailOptional = Optional.of("Hushsama@gmail.com");
  ```

  `Optional.ofNullable(T value)`用于传入可能为空的元素。返回包含value的Optional对象，如果传入的值为null,则返回空的Optional对象
  
  ```java
   Optional<String> emailOptional = Optional.ofNullable(null);
  ```

  
   `empty()`
   Optional的静态方法，无参，返回不含任何值的Optional对象
  
- **执行操作**
  **<font color = red>ifPresent() / ifPresentOrElse()</font>**
  
  `ifPresent()`
  如果对象中的值存在则执行函数,不存在就什么也不干
  返回boolean值，有值true无值false

  ```java
  Optional<String> optional = Optional.of("Hello");
  optional.ifPresent(a->System.out.println(a));  // 输出 "Hello"
  ```

  `ifPresentOrElse()`
  参数为逗号分开的两个函数，如果对象中的值存在，则执行前者，否则执行后者
  无返回值 两者的参数为没有返回值的函数
  
  ```java
  Optional<String> optional = Optional.empty();
  optional.ifPresentOrElse(
      s -> System.out.println(s),
      () -> System.out.println("Value is empty")  // 输出 "Value is empty"
  );
  ```
  
- **取值获取操作**
  <font color = red>**orElse() / orElseGet() / get()**</font>
  `orElse(T other)`
  
  参数是类型为T的值other（T不用声明出来）
  如果Optioal容器中有值，则返回该值，否则返回other
  该方法的返回值不是Optional容器，而是容器中的元素或者参数other
  
  ```java
  Optional<String> optional = Optional.ofNullable(null);
  String value = optional.orElse("Default Value");
  System.out.println(value)//Default Value
  
  Optional<String> optional = Optional.ofNullable("hello");
  String value = optional.orElse("Default Value");
  System.out.println(value)//hello
  ```
  
  `orElseGet`(函数)
  如果值存在则返回值，不执行函数
  如果不存在则调用有返回值的函数，这个结果必须是容器中同类型的对象
  
  函数用无参的lambda表达式
  因为对象中不存在值时，调用函数也获得不了参数.
  
  ```java
  Optional<String> optional = Optional.ofNullable(null);
  String value = optional.orElseGet(() -> "Default Value");  // 返回 "Default Value"
  ```
  
  `get()`
  无参。
  如果值存在，则返回值；
  值不存在，抛出异常
  
- **空否**
  <font color = red>**isEmpty( ) / isPresent()**</font>
  都用来检查Optional对象是否有值

  `isPresent()` 方法：如果值存在返回 `true`，否则返回 `false`。

  `isEmpty()` 方法：如果值不存在返回 `true`，否则返回 `false`
  
- **<font color = red>filter() / map() / or()</font>**
  `Optional<T> filter(函数)`
  过滤容器中元素，如果Optional对象的值使函数为真，则返回包含该值的Optional对象;
  否则返回空的Optional对象

  ```java
  Optional<Integer> optional = Optional.of(10);
  optional = optional.filter(i -> i > 5);
  System.out.println(optional.get());  // 输出：10
  ```

  `Optional<T> map(函数)`
  如果Optional对象有值，那么返回一个新的Optional对象，新对象的值是旧对象的值执行函数后得到的值；
  如果Optional对象是空的，则返回空的Optional对象

  ```java
  Optional<Integer> optional = Optional.of(10);
  optional = optional.map(i -> i * 2);
  System.out.println(optional.get());  // 输出：20
  ```

  `or(供应函数)`
  如果Optional对象有值，则返回该对象；
  如果没值，则执行函数且必须同样类型的容器，可以为空

  ```java
  Optional<Integer> optional = Optional.empty();//获得一个空的optional对象
  optional = optional.or(() -> Optional.of(20));//由于该对象是空的，获得返回的供应器对象
  //供应器：()->Optional对象创建函数 这样的lambda
  System.out.println(optional.get());  // 输出：20
  ```

  Optional容器对象无法被序列化，不应作为属性，非特殊情况不作为方法的返回类型和参数

  一般用于执行与空引用有关的操作





## 异常

### 介绍

异常 指发生在程序执行过程中的，扰乱了程序正常流程的一个事件

当方法执行中发生错误时，方法创建一个对象并且将其传递给  **运行时系统**，该对想法称为 异常对象
创建一个异常对象并且将其交给运行时系统，称为 **抛出异常**
异常对象中封装了错误的信息，错误类型，出错时的状态等等

方法抛出异常后，运行时系统会尝试找到一个“方法”处理该异常
这些“方法”在一个列表中，开始于主函数main，终止于错误方法。这个方法列表称为调用栈
异常会沿着调用栈逆向往回找能处理它的“方法”，如果找到了适当的异常处理程序，系统将异常对象传递给处理程序，选择合适的异常处理程序，也叫捕获异常
如果找到main了还处理不了，程序终止

### 两种异常

**Checked Exceptions  受检异常**
一般是程序与程序控制之外的外部资源互交时产生的错误
<font color=red>即受检异常是 运行中完全可能出现，但是出现后程序无法解决的问题</font>
如方法A需要连接网络，但是网络不通。抛出异常，捕获后也解决不了。这就是受检异常
程序会因为无法解决的问题无法继续执行
必须为可能出现的受检异常提供处理程序使得程序可以继续进行而非崩溃
因此！Java要求受检异常必须在调用栈中，显式捕获/处理受检异常，否则无法编译

**Unchecked Exceptions  非受检异常**

由程序中的错误逻辑/代码产生
或受检异常转换为非受检异常
比如空指针，数组集合越界，类型转换失败，0作被除数···
<font color=red>即非受检异常是 运行中不应该出现的但是出现的问题</font>
它们一般因为代码错误或不严谨产生，不应该捕获异常处理，而是修改代码解决错误
因此！Java不要求显式捕获处理非受检异常

### 捕获异常

---

**java.lang.Throwable类**
所有错误/异常的超类，仅它和它的子类可以被catch语句捕获
java提供了三种主要异常类型的实现(还有很多，这里不写了)

**异常参数类型声明了其可以处理的异常类型，类型必须是Throwable或者其子类**
1.`java.lang.Error`继承自Throwable，非受检异常
2.`java.lang.Exception` 继承自Throwable，受检异常
3.`java.lang.RuntimeExcepiton` 继承自Exception 运行时异常，它是**非受检异常**

以及两种方法
`String getMessage()` 返回异常信息字符串
`void printStackTrace()  `打印异常栈信息

---



对于可能抛出异常的方法，必须显式处理异常，否则无法编译
1.方法内通过 `try catch`语句捕获处理异常
2.方法通过`throws`语句声明抛出异常，由调用者处理异常

**try-catch** block
<font color = red>**构建异常处理程序**</font>
将可能引发异常的代码置于try代码块中 也就是code

```
try{
	code 
}catch(ExceptionType name){

}
```

一个try块可以由多个catch块，将异常处理与try块相关联

```
try{
	code 
}catch(ExceptionType name){

}catch(ExceptionType name){

}
```

**在try和catch块之间禁止定义其他代码，会无法编译**

example

- 为引发异常的代码单独设置异常处理程序

```java
try{
	Files.readString(Path.of("A:/aa.aa"));
	//显然没有A盘，而且是与外界交互(读取磁盘)，抛出受检异常，类型为IOException
}catch(IOException e){//捕获该异常
    System.err.println("捕获IOException异常");//这就是异常处理
}
try{
    Thread.sleep(1000);
}catch(InterruptedException e){//捕获InterruptedException类型异常
    System.err.println("捕获InterruptedException异常");//这样处理该异常
}
```

- 或者放一起，将多个处理程序与其关联

```java
try{
	Files.readString(Path.of("A:/aa.aa"));
    Thread.sleep(1000);
}catch(IOException e){
    System.err.println("捕获IOException异常");
}catch(InterruptedException e){
    System.err.println("捕获InterruptedException异常");
}//这个代码块中的异常会自己找能处理自己的处理程序
```

- 另一种放一起的写法，处理程序修改一下

```java
try{
	Files.readString(Path.of("A:/aa.aa"));
    Thread.sleep(1000);
}catch(IOException | InterruptedException e){//用一个 | 代表或，两个||是 or 
    System.err.println("捕获IOException异常");
}

```



- 块变量作用范围仅在块内，try块的变量在try外都不能用，包括catch。
  但是在try块前的变量，try和catch都可以用
- 如果方法有返回值，那么return的位置应该注意一下
  如果把return放在try块里，要是在return前抛出了异常，那么return就不会再执行了
  所以要注意一点，有时候方法红了就是因为这个，会没有返回值

<font color = red>**按照级别顺序精确捕获处理异常**</font>
多个异常处理程序与try块关联
异常会依次寻找可以处理该异常的程序
由于异常类型之间存在继承关系，所以可能出现下面的情况

```java
       try{
           System.out.println("try内异常前");
           Files.readString(Path.of("E:\\Gitfile\\java\\a.txt"));
           System.out.println("try内异常后");
       }catch(InterruptedIOException e){//InterruptedIOException可以接收IO异常没问题
           System.out.println("InterruptedIOException");
       }catch(IOException e){//等待接收InterruptedIOException处理不了的异常
           System.out.println("IOException");
       }
	 //但是把这两个异常处理程序交换一下位置就会报错
       try{
           System.out.println("try内异常前");
           Files.readString(Path.of("E:\\Gitfile\\java\\a.txt"));
           System.out.println("try内异常后");
       }catch(IOException e){
           //IOException是InterruptedIOException的超类
           //所以IOException可以处理InterruptedIOException类型的异常
           System.out.println("IOException");
       }catch(InterruptedIOException e){
           //所以这个catch永远都不可能执行了，没有意义，标红报错
           System.out.println("InterruptedIOException");
       }
		   //因此异常处理程序的顺序应该精确,不能让某个处理程序没有用武之地
```



### 执行顺序

try内未引发异常时，正常执行完try代码块，catch块不执行。
异常处理程序外继续执行

```java
public static void main(String[] args){
       try{
           System.out.println("try内异常前");
           Files.readString(Path.of("E:\\Gitfile\\java\\1.txt"));
           System.out.println("try内异常后");
       }catch(IOException e){
           System.out.println("catch块");
       }
       System.out.println("try/catch外");
   }

try内异常前
try异常后
try/catch外
```

try内引发异常，try异常处后面的代码不再执行，程序跳转到catch块执行
如果异常被捕获处理，则执行catch代码块，异常处理程序外继续执行
如果异常没有被捕获处理，则程序直接结束，报错，catch不执行

```java
public static void main(String[] args){
       try{
           System.out.println("try内异常前");
           Files.readString(Path.of("E:\\Gitfile\\java\\a.txt"));
           System.out.println("try内异常后");
       }catch(IOException e){//如果这里是Error类型异常，它不能处理IO异常程序会直接报错结束
           System.out.println("catch块");
       }
       System.out.println("try/catch外");
   }
try内异常前
catch块
try/catch外
```

**Finally块**
连接try块或者catch块

- 无异常时执行完try块后执行finally代码块
- 有异常且捕获处理后 从try跳到catch catch执行完 执行finally代码块

- <font color = red>**无论是否引发异常，是否执行到return语句，finally代码块总会被执行**</font>
  如果try代码块最后有一个return，且没有引发异常，正常执行try代码。
  但是在执行return之前，会跳到finally代码块执行完后再执行return
  因此 无论有没有异常，应该在finally块中清理释放必要的资源空间
- Finally仅用于释放资源，禁止含有方法本体如return语句。
  用了return会怎么样？影响是什么？暂不讨论

### 抛出异常

- 有时代码可以捕获可能发生的异常，但也可能需要方法栈上的其他方法处理异常
  <font color = grey>即代码里有try-catch，代码可以捕获异常。但有时不写这个，就需要其他方法捕获异常</font>

- 可能引发异常的方法被有不同需求的方法调用，
  而不同的调用方法对异常的处理方法可能不同，
  可引发异常的方法在声明定义时是无法预测的。
  在这种情况下不要捕获异常，由调用方法的人处理异常。谁调用，谁处理

- 当方法不捕获可能发生的受检异常时，方法必须声明 **抛出受检异常**
  在方法声明添加 throws 子句，实现方法抛出异常.
  throws在参数列表后，方法体前，可以抛出多个异常，用逗号隔开
  <font color = grey>抛出异常不影响方法签名</font>

```java
public static void main(String[] args) throws IOException{//上抛一个
       try {
           getThorws1();
       }catch (InterruptedIOException e){//处理一个
           e.printStackTrace();
       }
   }

private static void getThorws1() throws IOException,InterruptedIOException{
       Files.readString(Path.of("A:\\a"));//可能抛出IO异常
       Thread.sleep(1000);//可能抛出Thread异常
   }//方法声明抛出两种异常，调用者要显式处理这些异常，处理不了的继续往上抛
```

在选择需要抛出的异常类型时，可以选择java提供的异常类/第三方异常类型/自定义的异常类
可以通过继承相关异常类，实现自定义异常类型

```java
public class MyException extends RuntimeException{
	public MyException(String message){
	super(message);
	}
	//继承RuntimeException异常类实现自定义非受检异常
}
```

**构造函数/静态/实例方法/方法内的代码块/Lambda表达式**等都可以抛异常
通过throw语句，声明抛出一个Throwable或其子类的对象
抛出去的异常如果没有被捕获，程序中断，不再进行
抛出的自定义非受检异常无需显式捕获处理

```
自定义异常
```

接口，抽象类中的方法
子类在重写时
方法原本没有声明抛异常，那么重写时不能声明抛受检异常
可以抛非受检异常(子类可以编写有误) 
这一句实质上就是 方法原本没声明，那么重写时不能声明抛异常

方法原本声明抛异常，子类可以不声明
因为子类重写后可以抛出小于等于父类异常的异常(或者不抛)

> 方法内抛throw
> 方法上抛throws



## 线程

线程（Threads）是进程中的一个运行实体。是可以被系统独立调度分派的基本单位，是程序执行流的最小单元。线程是调度的抽象
系统创建程序进程后，启动执行该进程的主执行线程。当程序中的所有线程终止（而非仅主线程终止），进程随之终止
如果说进程是公司，那么线程就是干活的员工
8核16线程cpu 就是16个干活的（物理层面）但是由于干的太快了，感觉到同时干的事情不止16件，因为它这个干一会儿那个干一会儿

### 构造

**Runnable接口**  定义预执行的任务
接口中仅定义了唯一抽象方法run()
Runnable实现类实现该方法，这个方法的实现就是线程执行的任务
通过将`Runnable对象`传递给`Thread线程构造函数`实现创建线程，创建线程后用线程内的start方法启动线程

```java
public class HelloRunnable implements Runnable{
@override
    public void run(){//实现类重写run方法，这个就是线程start要执行的任务(这里只是模拟线程)
        System.out.println("hello");
    }
}
public class Test{
    public static void main(String[] args){
        Thread t = new Thread(new HelloRunnable);
        t.start();//线程.start执行的就是实现类中重写的run方法
        //hello
    }
}
```

**Thread类**  定义预执行的线程
Thread类实现了Runnable接口，但是实现的方法run（）方法为空；
定义实现类继承Thread类，重写run()方法实现任务
执行start()方法启动线程

```java
public class Hello extends Thread{
    @override
    public void run(){
        System.out.println("hello");
    }
}
public class Test{
    public static void main(String[] args){
        new Hello().start();//new创建线程启动对象，用start启动线程
        //hello
    }
}
```

以上两种方法均需要调用Thread的start方法启动新线程
run（）方法执行完毕后，自动停止线程
Thread的构造函数可以是Runnable对象，可以是继承自Thread的子类，也可以是无参lambda表达式，表达式的body就是run的内容，lambda在中断那儿

### 挂起

**Thread.sleep() throws InterruptedException方法**
挂起当前线程，使线程进入非可执行状态（睡眠），cpu不会分配给线程执行的时间片，导致当前线程停止一段指定的时间
sleep时间并不能保证准确，假如我设置5s后回来执行，但不可能刚好五秒（底层逻辑），指挥大于五秒后回来，说成大于等于五秒
sleep周期可以通过中断（Interrupt）来终止

sleep  放大问题的发生性
有些并发问题，需要放大才能看到。

```java
System.out.println("main thread running");
new Thread(new Runnable(){//匿名内部类
    @override
    public void run(){
        int amount=5;
        for (int i=0;i<amount;i++){
            System.out.println("i");
            try{
                Thread.sleep(1000);//每次执行后sleep1000ms
            }catch(InterruptedException e)
        }
    }
}).start();
System.out.println("main thread ending");
main thread running
main thread ending
0 1 2 3 4
为什么是这个顺序？主线程执行静态方法中创建子线程，主线程继续执行，子线程继续执行。
但是线程的执行/启动顺序默认无法确定
```



**Interrupts**
中断（Interrupts），表示线程应停止正在执行的操作，并执行其他操作
中断不是终止，也做不到终止线程。中断之后干什么取决于线程，线程决定下一步做什么
中断如何实现？
一个线程调用interrupt()方法，在线程中抛出一个异常，抛出异常后要处理异常
异常处理后干什么由catch中语句决定，如果是return，那就是不干了，如果是print，那打印完接着干

```java
Thread t = new Thread(()->{
    for(int i = 0;i<5;i++){
        System.out.println(i);
        try{
            Thread.sleep(1000);
        }catch(InterrunptedException e){
          System.out.println("Interrupt");   
        }
    }
});
t.start();
Thread.sleep(2000);//主线程sleep，确保子线程开始执行
t.interrupt();//线程对象调用interrupt方法中断
0 1 interrupt 2 3 4
通过lambda表达式构造线程，线程执行是循环打印，中断后抛出异常，解决后只打印interrupt,打印完接着执行线程内容
```

**join（）方法**
线程强制执行，插队
使当前线程暂停执行，直到插队线程终止
与`sleep()`相同，通过`InterruptedException异常`响应中断

B.join()就是B线程插队执行

```java
System.out.println("main thread running");
Thread t = new Thread(()->{
    for(int i = 0;i<5;i++){
        System.out.println(i);
        try{
            Thread.sleep(1000);
        }catch(InterrunptedException e){
        }
    }
});
t.start();
t.join();//在A线程中，A的子线程B执行join()方法，则B线程插队执行，A线程挂起，B执行完A再执行
System.out.println("main thread ending");
main thread running
0 1 2 3 4
main thread ending
```

### 通信

线程间主要通过访问共享数据实现通信
非常有效，但是可能会产生两种错误：线程冲突与内存一致性错误
一个语句 num++ 分为三部，取出当前的num值，将取出的值加一，将加完后的值储存到num
那么多个线程同时进行时，操作可能会交替，比如线程1取值，还没加的时候线程2也取值，就导致结果错误
多个线程同时访问一个数据产生的错误
java.util.concurrent.CountDownLatch类
允许多个线程等待的同步工具
通过调用CountDownLatch(int num)构造函数构造计数器对象

countDown()方法
减少锁计数器的1计数，计数达到0时，释放所有等待的线程
await() throws InterruptedException方法
任何执行此方法的线程开始等待。直到锁计数器递减到0。除非执行中断
在哪个线程里执行await，哪个线程开始等待

```java
public class Counter(){
    private Random r = new Random();
    public int c;
    public void increment(){
        try{
            Thread.sleep(r.nextInt);//使每个线程调用该方法时均可能产生不同的执行时间
            c++;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
Counter counter = new counter();
int count = 800;
CounterDownLatch latch = new CounterDownLatch(count);//创建一个800的锁计数器
for(int i = 0; i<count;i++){//创建800个线程，都开始执行，但是由于每个线程sleep的时间不一样，导致两个线程可能取得是同一个值
    new Thread(()->{//为线程对象定义任务，1：调用increment方法；2：使计数器减一
        counter.increment();
        latch.countDown();
    }).start();
}
latch.await();//主线程正在等待，直到800个线程执行完
System.out.println(counter.c);//798,不是800，代表线程冲突喽
```

### 同步

线程同步：多个线程操作同一个资源
并发：一个对象被多个线程操作（五一抢票，两个银行一起取钱）

**队列**
处理多线程问题时，多个线程访问同一个对象，并且某些线程还想修改这个对象。
这个时候我们就需要线程同步。
线程同步其实是一种等待机制，多个需要同时访问此对象的线程进入这个对象的等待池形成队列，一个一个来
**锁**
假如一群人上厕所，要排队，队列已经排好了，但是一群人挤进去了也不安全，所以厕所门有锁，锁上就保证安全
线程只有队列时还不够安全，还要加上锁（程序来源于生活）
每个对象都有一把锁，也只有一把锁，就是用于线程同步的。
当一个线程获得对象的排它锁后独占资源，其他线程必须等待。使用后释放锁
两个线程调用一个对象中两个不同的同步方法，因为先调用的线程已经独占对象了，后调用的线程得等着



java提供了两种基本的同步方式：
同步方法和同步语句（代码块）

**方法同步**
使用synchronized关键字声明在方法返回类型前面
声明了同步后的方法，必须获得当前对象的锁才能执行，否则线程会阻塞
方法一旦执行就独占该锁，直到该方法返回才释放此锁

```java
public synchronized void increment(){//同时只能由一个线程调用
    try{
        Thread.sleep(r.nextInt);
        c++;
    }catch(InterruptedException e){
        e.printStackTrace;
    }
}
Counter counter = new Counter();
int count = 800;
CountDownLatch latch = new CountDownLatch(count);
for(int i=0;i<count;i++){
    new Thread(()->{
        counter.increment();
        latch.countDown();
    }).start();
}
latch.await();
System.out.println(c);//800
```

声明同步就是使用方法同步锁，同一时间只能有一个线程执行此方法

```java
public class Account{
    public int a;
    public int b;
    public synchronized void addA(){//A同步方法
        try{
            Thread.sleep(1000);
            a++;
           }catch//省略
    }
    public void addB(){//B非同步方法
        try{
            Thread.sleep(1000);
            b++;
        }catch
    }
}

int c =1800;
CountDownLatch latch = new CountDownLatch(c);
Account a = new Account();
for(int i=0;i<c/2;i++){
    new Thread(()->{
        a.addA();
        latch.countDown();
    }).start();
}//这900个线程调用同步方法addA时有条有序，不争不抢
for(int i=0;i<c/2;i++){
    new Thread(()->{
        a.addB();
        latch.countDown();
    }).start();
}//这900个线程调用非同步方法addB时争抢数据，没加上
latch.await();
System.out.println(a.a);//900
System.out.println(a.b);//825
```

一个方法总不能全部声明成同步的，锁的太多浪费资源，比如方法内只读方法不用锁，锁上修改方法就可以了


**synchronized语句（代码块）**
假如多个用户在一个银行账户里取钱，用户里声明同步取钱方法get，如果取钱数大于剩余数100，那么就不给去
A用户执行get50，B用户紧接着执行get100，此时两个用户各自被锁住，假如B用户在A用户取完钱并更新剩余数之前获取到了剩余数100，那么B用户也执行
最后剩余数是-50
我们注意到，取钱方法get锁错对象了，应该锁住他们的账户的。得出👇

​		**使用synchronized方法默认锁的是this,也就是当前对象**。

synchronized(Obj){ 代码块 } 可以自定义锁任何对象
Obj称之为同步监视器
Obj可以是任何对象，但是推荐使用要共享的资源作为同步监视器
同步方法中无需指定同步监视器，因为同步方法的监视器就是this

同步监视器的执行过程
第一个线程访问，锁定同步监视器，执行其中代码
第二个线程访问，同步监视器锁定，无法访问
第一个线程访问完毕，解锁同步监视器
第二个线程访问，同步监视器解锁，锁定后访问

如果把get方法改用同步代码块，就可以避免这些问题 synchronized(账户){get方法} 再执行get方法时就正常了

```
public void run(){
	synchronized(account){
	public int get()....
	}
}
```

抽象的东西不能声明同步。同步是对实现了的东西的约束，而不是对未实现的东西使用的
但是抽象方法在重写时可以声明同步，因为重写就是实现抽象方法嘛。
构造函数不能同步。两个线程不可能创建同一个对象，因此构造函数声明同步无意义，所以不允许声明同步



### 原子操作

原子性操作：要么完全执行，要么不执行
对于引用变量和大多数基本变量来说，读取和写入均为原子性操作（i++不是原子性操作，它分为三步，拿出来，加一，放回去，这三步各自是原子性操作）

线程从主内存复制变量副本，并保存在本地缓存（CPU高级数据缓存）
线程基于变量完成操作，操作完成后将结果写回主内存
java的内存模型无法保证CPU高速缓存中的变量何时写回主内存，内存不一致性
即线程二拿到的可能是线程一还没来得及写回主内存的变量，A经过线程I后本要变成B，但是线程II太快了，直接就拿到了A，没能拿到B

利用`volatile`关键字（仅用于修饰变量）
可以保证变量的可见性，即各线程不在本地缓存volatile变量的副本，每次使用即时从主内存加载变量

volatile虽然可以保证变量的可见性，但是无法保证并发执行操作的原子性；没有使用锁，可以保证并发的执行性能
Synchronization可以保证并发操作的原子性和变量可见性，但是基于锁的同步，会严重不限制系统并发处理性能

使用同步锁定，会严重降低系统的并发处理性能，如须使用同步，尽可能使用锁定对象的同步语句；
因为锁定实例方法会影实例的其他同步方法，降低性能



### Lock

同步代码基于简单的锁实现。这种锁容易使用，但是有更多的限制
`java.util.concurrent.locks.Lock`接口

Lock是用于空值多线程访问共享资源的工具，提供对共享资源的独占访问权限：
一次只有一个线程可以获取该锁，并且对共享资源的访问优先获取该锁

Lock提供比同步操作更广泛/更灵活的锁定操作
`ReentrantLock`实现类，重入锁。
支持对共享资源重复枷锁
`ReadLock/WriteLock`实现类

定义: Lock lock = new ReentrantLock();
		   类型 名字         new一个实现类的构造函数

```java
public class Counter{
    private static int c = 0;
    private static final Random r = new Random();
    private static final Lock lock = new ReentrantLock();
    public static void increment(){
        try{
            Thread.sleep(r.renxInt(50));
            lock.lock();//调用锁方法
            c++;
        }catch(InterruptedException ignored){
            
        }finally{
            lock.unlock();//解锁
        }
    }
}
int count = 8000;
CountDownLatch latch = new CountDownLatch(count);
for(int i=0;i<count;i++){
    new Thread(()->{
        Counter.increment;
        latch.countDown();
    }).start();
}
latch.await();
Sout(Counter.value())
基于Lock的实现，无需锁定方法或者对象，可锁定任意代码区域
在操作结束后的finally块内解放锁
```

在旧版本的多线程处理中，由Runnable对象定义的需要线程完成的任务，与线程对象本身之前存在紧密联系
这只适用于小型应用程序，在大型应用程序中，将线程的创建/管理从应用程序中分离解耦是有意义的
多线程频繁创建在高并发及大数据量时，是非常消耗资源的。
因此在新的并发API中提供了封装这些功能的对象以及线程池机制实现


## IO流

IO流，可以表示不同类型的输入源与输出目标
输入源和输出目标可以是保存，生成或使用数据的 磁盘文件/外部设备/远程网络等等···

<font color = blue>IO流，支持不同类型的数据：简单字节/原始数据类型/本地化字符/对象等等</font>
IO流将不同的输入/输出，以相同的方式操作
创建的不同类型的流有不同的实现方式，不同类型的流又各有各的操作方式
但是 所有IO流呈现出的都是相同的简单的模式：程序中流入或流出的一系列数据
**Sum: IO流是数据源/数据目标，输入/输出的抽象表示**

<font color = blue>数据文件基于 byte 保存以及传输，而不是 bit （1 byte = 8 bit，一个字节等于八个二进制位）</font>

8个二进制位（bit）可以用十进制整数0-255表示，因此
1个字节可以用0-255内的十进制整数表示

### 输入输出

**Input Stream 输入流，用于从数据源读取数据**

**Java.io.InputStream抽象类**
输入流操作的超类，支持子类以基本字节的方式操作二进制数据


<font color = red>**int read(byte[] b) throws IOException, 抽象方法**，</font>由具体子类实现

1. 省略`byte[] b` 参数，一次读取一个字节，返回值为字节的ASCII码值
   如果到达流末没有可读字节。返回`-1`

2. 写出`byte[] b `参数，尝试读取和数组长度一样多的字节数据，读取的数据存在数组中
   返回的是实际读取的字节的数量。如果已经到达流的末尾，那么这个方法将返回 `-1`。

   

**Output Stream 输出流，用于将数据写入输出目标**

**Java.io.OutputStream抽象类**


<font color = red>**void write(int b) throws IOException, 抽象方法**</font>
<font color = blue>将十进制数b 按字节写入输出流（十进制数按ASCII码转成字符写入输出流）</font>


<font color = red>**void write(byte[] b,int off,int len)**</font>
<font color = blue>从字节数组b，off位置开始读取，读取len个字节</font>



> 基于单字节的read()/write()方法，实际开发不会使用，仅用于演示 

![IO](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/IO.png)

**write()是否指定off与len**

```java
 public static void getBytetoChar3() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
            byte[] buffer=new byte[4];
            int len=0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer,0,len);
            }
        }
    }
in : abcdefg
out: abcdefg
定义byte buffer 缓冲区4个字节
首先读取四个字节 abcd  此时buffer=abcd，len=返回值4
write 从buffer的起始位置0开始读取len 4个字节写入 out=abcd

再继续读 由于buffer字节数组没有清空，新读取的字节会覆盖旧字节
此时 buffer=efgd，但len=返回值3，read返回值是成功读取的字节个数而不是buffer数组的长度
write 从buffer 起始位置0开始读取len 3个字符写入 out=abcdefg
```

```java
public static void getBytetoChar3() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
            byte[] buffer=new byte[4];
            int len=0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer);
            }
        }
    }
in : abcdefg
out: abcdefgd
    定义byte buffer 缓冲区4个字节
首先读取四个字节 abcd  此时buffer=abcd，len=返回值4
write没有指定起始位置和写入长度，则将字节数组buffer全面写入，out=abcd

再继续读 由于buffer字节数组没有清空，新读取的字节会覆盖旧字节
此时 buffer=efgd，但len=返回值2
write 再次将buffer数组全部写入 out=abcdefgd
```

即使有字节数组作为缓冲区，仍需考虑其长度/读取/写入/偏移（起始位置）等操作

InputStream中方法
<font color = red> **long transferTo(oput) throws IOException方法**</font>
<font color = blue>**支持直接将输入流转移至一个输出流并返回总字节长度(java9)**</font>

```java
public static void getBytetoChar4() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt"))         {
            in.transferTo(out);//直接将输入流数据转移到输出流中
        }
    }
```

java提供了字符流操作，支持直接读写文本文件内容，无需手动完成字节到字符的转换

InputStream类中方法
<font color = red> **byte[] readAllBytes() throws IOException**</font>
<font color = blue>**直接将流中所有字节读出到字节数组（一次性读取，没有缓存区。不应用于大量数据的输入流）**</font>

```java
 public static void getBytetoChar5() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
          byte[] bytes=in.readAllBytes();//输入流中的字节直接读入bytes数组
            System.out.println(new String(bytes));
            //String类有字节数组的构造函数,记得new
        }
    }
```



### 声明与关闭

```java
public class IO {
    private static void getByteStreams() throws IOException{
        FileInputStream in = new FileInputStream(("E:\\Gitfile\\test.txt"));
        FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt");
        int c;
        while((c=in.read())!=-1){
            //FileInputStream的方法read 返回值是字符的ASCII码值
            System.out.println("该字节的十进制数："+c);
            out.write(c);
            //FileOutputStream的方法write 把整数按ASCII码值转字符后写入输出流

        }
        //输入输出流的资源一定要关闭
        in.close();
        out.close();
    }
    
    public static void main(String[] args){
        try{
            IO.getByteStreams();//该方法可能抛出的受检异常要显式处理
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
```


IO流不会像其他对象因为失去引用而自动释放占用的内存空间
因此所有IO流必须被正确关闭，否则可能内存溢出

1. 在finally块中关闭资源

2. 在try语句中直接声明使用的资源（在try语句的（）内，而非try语句的 { } 内声明）
   可以保证无论try是否发生异常，资源在try后均会自动关闭
   <font color = blue>try（）内声明的**各个变量之间用分号分开哦**</font>
   try( in; out )

任何实现了java.lang.AutoClosable接口的类型均支持自动关闭，资源的自动关闭与异常处理无关



在try语句中声明使用的资源后，执行有两种情况:

1. IO流无异常，try执行后自动关闭资源，再之后是finally
2. IO流引发异常，自动关闭资源，catch，finally--------异常时先关闭资源后catch和finally

```java
public static void getBytetoChar() throws IOException {
  try (FileInputStream in =new FileInputStream("E:\\Gitfile\\test.txt");
       FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
       int c;
       while ((c = in.read()) != -1) {
           System.out.println("字节十进制:" + c);
           System.out.println("十进制转为字符:" + (char) c);
           out.write(c);
            }
        }
    }
//这个方法抛出IO异常，调用时记得处理该异常哟
```

Java9 允许在 try（）外创建IO流，只需在（）内声明创建的IO流变量名字即可

```java
    public static void getBytetoChar2() throws IOException {
        FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
        FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt");
        try (in; out) {//用分号哦
            int c;
            while ((c = in.read()) != -1) {
                System.out.print("字节十进制:" + c+"  ");//print不换行
                System.out.println("十进制转为字符:" + (char) c);//println自动换行
                out.write(c);
            }
        }
    }
字节十进制:97  十进制转为字符:a
字节十进制:98  十进制转为字符:b
字节十进制:99  十进制转为字符:c
字节十进制:100  十进制转为字符:d
字节十进制:101  十进制转为字符:e
字节十进制:102  十进制转为字符:f
字节十进制:103  十进制转为字符:g
```



## Files

### Path

文件系统在某种形式的介质上存储和组织文件，以便于检索
目前文件系统均以树型（或分层）结构存储文件
但是不同系统描述路径的方式不同
Linux：
/home/sally/statusReport

Windows ：
C：\home\sally\statusReport

CC：linux/unix/网络请求路径等 均用 正斜杠 / 描述且windows也兼容正斜杠路径
		 因此 windows系统下路径也应用正斜杠描述（反斜杠也不错）

- 绝对路径
  从根写到该文件 如 G:\Steam\Steamapps\common\ELDEN RING\game\eldenring.exe
- 相对路径
  如 eldenring.exe 没有更多信息，就找不到该文件，启动不了艾尔登法环
  相对路径最终必须转为绝对路径
  相对路径不能以斜杠开始，那是绝对路径
  /example/a.txt 绝对路径
  example/a.txt 相对路径

---

- **java.io.File类**
  包含耦合了文件路径以及文件操作方法的类,但全部是同步阻塞的（不学了）
- **java.nio.File类** （nio=new io）
  将文件路径与文件操作分离，且支持异步非阻塞（学这个）
  java.nio.file.Path接口，系统文件/目录的路径
  java.nio.file.Files工具类，包含处理文件操作的方法，如文件的 创建，删除，复制，移动等

---

**Interface Path**
Path接口可以表示一个绝对的/相对的文件或目录的路径，Path代表一个不依赖于系统的文件路径
运行在不同操作系统中，Path会把文件路径处理成该操作系统可以识别的路径
因此开发者使用路径时无需关心操作系统的差异
Path仅用于描述路径，不包含对路径的操作方法

**创建Path对象：**
<font color = red> Path Path.of(String path)</font>
<font color = blue>基于Path接口中的静态方法of利用路径字符串创建Path对象并返回</font>
`Path path=Path.of("E:/Steam/Steamapps/common/ELDENRING/game/launch.exe");`

<font color = red> Path getFileName()</font>
<font color = blue>返回文件名或者名曾元素序列的最后一个元素</font>
即 路径的最后一个的名字，用在上面就是返回包含 launch.exe的Path对象
<font color = red> Path  getParent() </font>
<font color = blue>返回父目录的路径</font>
（谁的父？getFileName的父，最后一个元素的父）
<font color = red> Path getRoot()</font>
<font color = blue>返回根目录的路径</font>

```java
public class Test {
    public static void main(String[] args){
        Path path=Path.of("E:/Gitfile/test.txt");
        System.out.println(path);				//E:\Gitfile\test.txt
        System.out.println(path.getFileName()); //test.txt
        System.out.println(path.getParent());	//E:\Gitfile
        System.out.println(path.getRoot());		//E:\
    }
}//Path路径自动转换为当前系统默认的斜杠，如我这是Windows，转化成了反斜杠👆
```

它们返回值不是Path吗？为什么直接print不报错呢？
Path重写了toString()方法,因此可以直接打印，但它们的返回值并不是String

**路径拼接**
Path resolve(Path other) 
将路径拼接为一个新的路径并返回
Path Path.of(多个路径字符串)
基于参数数组拼接成路径

```java
        Path dir=Path.of("E:/test");
        Path file=Path.of("input.txt");
        Path p1=dir.resolve(file);
        System.out.println(p1);//E:/test/input.txt
	  //路径拼接自动添加斜杠，不是简单的字符串相加。
        Path p2=Path.of("E:","test","input.txt");
	  //基于数组拼接路径也不需要加斜杠，加了也不错，加多了它也会给你改成一个
        System.out.println(p2);

        System.out.println(p1.equals(p2));//true 重写了equals方法
```

### Files

下面都是Files类里的静态方法👇

boolean exists(Path path)
boolean notexists(Path path)
检查路径是否存在

boolean isDirectory(Path path)
path是否为目录

```java
        Path p1 = BASE.resolve("123");
        System.out.println(p1);//E:\Gitfile\123
        System.out.println(Files.exists(p1));//false 这个路径根本就不对，最后的文件没有后缀
        System.out.println("目录"+Files.isDirectory(p1));//目录false

        Path p2=BASE.resolve("test.txt");
        System.out.println(p2);//E:\Gitfile\test.txt
        System.out.println(Files.exists(p2));//true
        System.out.println("目录"+Files.isDirectory(p2));//目录false

        System.out.println(BASE);//E:\Gitfile
        System.out.println(Files.exists(BASE));//true
        System.out.println("目录"+Files.isDirectory(BASE));//目录true
```

**创建目录**

Files类的静态方法

Path createDirectory(Path dir) throws IOException
创建dir目录，如果目录已存在，异常；如过目录是多级目录，异常
Path createDirectories(Path dir) throws IOException
自动创建多级目录，如果目录已存在，那么不管，无异常；目录不存在则创建一个目录
Path dir = Path.of("D:/test/a/b/c");
Files.createDirectories(dir); 如果👆目录已存在，则没事；如果不存在，则创建所有不存在目录。比如a,b,c都不存在，那么都创建

**创建文件**
Path createFile(Path) throws IOException
基于指定路径创建文件，如果文件已存在则异常

```
Path dir = Files.createDirectories(BATH.resolve("a"));
Files.createFile(dir.resolve("a.txt"));
在D：/test下创建a目录后创建a.txt文件
```

**复制文件**

Path copy(Path source,Path target,CopyOption option) throws IOException
默认将文件复制到目标文件，如果文件已存在，则异常，用合适的复制选项可避免异常
如果source为目录，则不会复制里面的文件，仅创建一个空目录

三个参数，一个是源文件路径，一个是目标路径，一个是复制选项

java.nio.file.StandardCopyOption 枚举实现CopyOption接口，提供三种复制选项

1. ATOMIC_MOVE 将文件作为原子文件系统操作移动
2. COPY_ATTRIBUTES 将属性复制到新文件
3. REPLACE_EXISTING 如果存在，替换现有文件
4. ATOMIC_MOVE 将文件作为原子文件系统操作移动
5. COPY_ATTRIBUTES 将属性复制到新文件
   1. REPLACE_EXISTING 如果存在，替换现有文件


```
Path source=BASE.resolve("input.txt");
Path target=BASE.resolve("output.txt");
Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);这样用哦
```

**移动**

Path move(Path source,Path target,CopyOption options) throws IOException
默认如果目标文件存在则异常，可通过options参数声明移动选项
如果在同一个目录下移动，相当于文件改名

```
Path source=BASE.resolve("input.txt");
Path target=BASE.resolve("output.txt");
Files.move(source,target);两者目录是一样的，相当于把input.txt 改成了output.txt

Path target=Path.of("D:/test2");
Files.move(BASE,target);BASE和target目录都是D:,相当于把BASE改名为target
```

**删除**

void delete(Path path) throws IOException
删除指定路径，如果路径不存在则异常
boolean deleteIfExists(Path path) throws IOException
路径不存在则不删除，返回值是是否删除成功

如果路径是个目录，且目录里面有文件，则两种删除均异常

Stream\<Path> walk(Path path,int depth) throws IOException
遍历，如果depth不写的话，基于path深度遍历path路径中的所有文件 

```java
Path dir=Path.of("E:/Doc/a");
Files.walk(dir).forEach(System.out::println);
Files.walk(dir,1).forEach(System.out::println);
Files.walk(dir,2).forEach(System.out::println);
调用这些方法时记得捕获异常，为了美观没有捕获
E:\Doc\a
E:\Doc\a\a.txt
E:\Doc\a\b
E:\Doc\a\b\b.txt
E:\Doc\a\b\c
E:\Doc\a\b\c\c.txt
-------------------------
深度1
E:\Doc\a
E:\Doc\a\a.txt
E:\Doc\a\b
-------------------------
深度2
E:\Doc\a
E:\Doc\a\a.txt
E:\Doc\a\b
E:\Doc\a\b\b.txt
E:\Doc\a\b\c
```

 那么如何删除BASE目录里面的所有文件呢？

```java
删除指定名称的文件
Path file = Path.of("a.txt");
Files.walk(BASE)
    .filter(p->p.getFileName().equals(file))
    .forEach(p->{
        try{
            Files.delete(p);
        }catch(IOException e){
            e.printStackTrace();
        }
    });
删除包含目录的整个文件夹，进入目录后逆向排序然后一个一个删除
Files.walk(BASE)
    .sorted(Comparator.reverseOrder())
    .forEach(p->{
        System.out.println(p);
        try{
            Files.delete(p);
        }catch(IOException e){
            e.printStackTree();
        }
    });
```

String Files.readString(Path path,charset) throws IOException
 基于指定路径读取文本文件即字符集

##  未分类

Java仅支持单返回类型

垃圾收集器不会回收没有引用的常量和静态变量
所以失去引用的对象不是立即被回收的
回收是自动的，不必手动清除

JVM是编译java源码的环境，不是工具

重写toString实现对象的详细输出，不是toClass

java无法动态修改数组的长度

return 可以声明在没有返回值的方法中，所以 return必须声明在有返回值的方法中 说法错误

this 在类的内部代表当前的对象，不是类本身

**toString()**

toString()是object类的方法，用于将一个对象转化为字符串并返回
由于每个类都是object的子类，所以每个类都可以调用 toString方法
但是toString方法默认返回值是 类的名称＋对象的地址

```
for(User user:list){
            System.out.println(user.toString());
        }
TemporaryTest.User@c818063
TemporaryTest.User@5ba23b66
TemporaryTest.User@3f0ee7cb
TemporaryTest.User@75bd9247
TemporaryTest.User@2ff4f00f
```

但是可以重写，在类里面重写过后可以返回自己想要的

```
public class User {
    private int id;
    private String name;
    private String city;
    
    @Override
    public String toString(){
        return id+" "+name+" "+city;//注意返回值是string
    }
}
for(User user:list){
            System.out.println(user.toString());
        }
3 Steve Shanghai
1 Peter Harbin
4 David Shanghai
5 Jack Sichuan
2 Lily Harbin
```

这就是重写toString()



##  工厂模式

方法先设置接口

```
public interface TeacherService {
    public List<Teacher> listTeachers(String type);

    public Teacher getTeacherById(String type,int id);
}
```

然后创建实现类

```
public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<Teacher> listTeachers(String type) {
        String sql="select * from "+type;
        List<Teacher> teachers=new ArrayList<>();
        try(Connection connection= DataSourceUtils.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()) {

            while(rs.next()){
                Teacher teacher = new Teacher(rs.getInt("tid"),
                        rs.getString("tname"),
                        rs.getString("tintroduction"),
                        rs.getString("timg"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  teachers;
    }

    @Override
    public Teacher getTeacherById(String type, int id) {

        String sql="select * from "+type+" where tid=?";
        Teacher teacher=null;

        try(Connection connection= DataSourceUtils.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,id);
            try (ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    teacher = new Teacher(rs.getInt("tid"),
                            rs.getString("tname"),
                            rs.getString("tintroduction"),
                            rs.getString("timg"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  teacher;
    }
}
```

在方法工厂里写上

```
public class ServiceFactory {
private static final TeacherService teacherService= teacherCreate();
 
 private static TeacherService teacherCreate(){return new TeacherServiceImpl();}
 }
```

回顾一下知识吧，首先接口是不能实例化的，变量 teacherService  的类型不是接口，而是接口的实现类，前面的接口只起到限制作用
限制后面的对象只能使用接口中的方法。
工厂类在第一次加载时，由于这里给变量teacherService进行了初始化，而初始化的内容是调用了函数，这个函数返回接口实现类对象
