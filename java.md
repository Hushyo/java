## 规范

### 命名:
所有 **包/类/接口/方法/参数/变量** 的命名必须使用 
有意义且无歧义的 英文单词或其缩写
禁止中文,拼音以及中英混合

---

#### 类 命名: 

<font color=blue>驼峰式命名</font>,每个单词仅首字母大写,其余小写
一般是单数,工具类可以用复数

---

#### 包 命名:

使用<font color=blue>全部小写</font>的英文单数名词
package 声明包的路径名称
必须放在源文件的顶部,源文件的位置必须与包声明的路径相同

---

#### 变量 命名:

<font color=blue>小 驼峰</font>(先小写,再驼峰)
首个单词的首字母小写,其余单词首字母大写

> string userName = "Petter"

---

#### 合法的标识符:

首字符仅支持26个字母和符号 $ , _ 不支持数字以及其他符号
后续字符可以是字母,数字以及 _ 不支持其他字符
但是为了规范: 不用 \$ 与 _ 开头

> \$count _count count\$ count_\$ 合法但是不要用

---

#### 数字字面量:
支持用下划线 _ 分隔,提高代码可读性
编译时会把 _ 忽略

> creditCardNumber = 1234_567_89

---

#### 常量 :
所有字母大写且用 _ 分隔单词 
final

> final int NUM_GEAR = 6

---

### long,double,float

#### long

长整型 long 的数值要以 L 结尾 

> long creditCardNumber = 12344456L
> long num = 123L
>
> 不用 L 结尾也不会报错,但是要规范,得加上

---

#### float

float 以 f/F 结尾,必须以 f/F 结尾
浮点型判断大小 只能用 >= 或 <= 不要用 ==

>  float num=1.23F

---

#### double

double 以 d/D 结尾,也可以不要
默认的double  类型允许不声明后缀

> double num = 1.23
> dounle num = 1.23D

---

## Base

### 未分类

1. 8+1都是值传递,而不是引用传递(地址不共享).
   对象是引用传递
2. 用判断符判断 8 时 返回值为 Boolean 

### 短路性

条件运算符 && 与 || 存在短路
第二个及以后表达式仅在需要时执行
如果前面的表达式已经决定结果,后面的表达式就不执行

如 a>b && b>c
 	a>b 为 false 时,这个表达式结果已经被决定是 false,则 b>c 这个表达式不执行
	 a>b 为 true  时,表达式还没结果, b>c 再执行

短路遇上了 ++

v1=10 , v2=11
if(v1>5 && v2>v1++) 执行后 v1=11
if(v1<5 && v2>v1++) 执行后 v1=10
区别就在于 后面的语句是否执行


### 自加

i++ 和 ++i
单独写一行时没有区别
但是在表达式内部可不一样
i++ i 先不变,表达式结束后再加一 先用后加
++i i 先加一 再参加表达式的运算 先加后用



## 函数

### switch

匹配到case中表达式时,执行代码 且顺次执行之后的所有case的代码块直到遇到break
也就是 没有break 它会一直进行下去

```
switch(num){
case 1:
	代码1
case 2:
	代码2
case 3:
	代码3
	break;
case 4:
	代码4
}
```

给num传入一个值,case 1: ->如果 num == 1 则执行该case的代码块
由于该case没有break,程序会接着执行case 2 和 case 3 直到case 3的break switch才结束

## 访问级别修饰符

决定其修饰的 类型/变量/方法 的作用范围 (可访问范围||可见范围)
可见即可访问,不可见即不可访问

### 顶级

类/接口/枚举/注解/record 支持创建为顶级的独立源文件
必须先创建以上类型 才能在以上文件里写 方法变量常量等

- public 所有其它类可访问
- package-private 仅包内可访问(就算是子包也不可以用)

package级允许文件名与类名不同但是禁止使用,有歧义
必须定义在类型内的,称呼为 Method方法
可以脱离类型独立定义的 称呼为Function函数

### 成员级

声明在类型内部.可以是 类/接口/变量/常量/方法等

- public 全局可访问
- package-private 包内可访问
- private 类型内可访问
- protected 包和任意位置的子包类可以用

### 方法

#### 构成

由 修饰符, 方法返回类型, 方法参数列表, 方法体 构成

- 修饰符 public/private/static/final...
- 方法返回类型 返回值的类型,没有返回值写void
- 方法参数列表 ( type name) 没有参数时写 ()
- 方法体 函数体

方法必须以 动词 开始 驼峰式首字母小写,接形容词或者名词

#### 方法签名

方法签名是类中一个方法区别于另一个方法的特征
由 方法名称 方法参数列表的参数类型决定
与 修饰符 返回值类型 参数名称无关

```
public double calculate(double a, double b, int point)
方法签名: calculate(double,double,int)
public int calculate(double c, double d, int point)
方法签名: calculate(double,double,int)
它俩方法签名一样,无法编译
```

方法参数名称
在作用范围内必须唯一,无论参数类型是否相同,参数名称不能相同.
方法内的局部变量不能与方法参数名称相同
(就是不能写函数,变量不能重名)

```
void setName(string num, int num){
int num;
}两个禁忌
```

#### 方法重载

允许具有相同名称但是不同参数列表的方法存在
即 只要方法签名不同,方法的名字是可以相同的

```
public void list(int groupId){}
public void list(int groupId,int type){}
public void list(int groupId,string name){}
都可以的
```

#### 值传递

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
```

```
结果
java 10
V++ 5
java 10
```

 name和index 是 java 和 10
传入getPrint后打印结果java,10
在getPrint中修改值为c++,5
结束方法后打印还是java和10
说明 8+1类型是值传递

**对象是引用传递**

### 封装

类中可以生命成员变量

- public修饰的成员变量为公有成员变量,全局可访问
- private修饰的成员变量,私有成员变量,仅能在类中访问

```java
public class Bicycle{
	public int cadence = 0;
	public int speed = 0;
	public int gear = 0;
}
```

Bicycle中声明了三个 int 类型的public 公共成员变量
成员变量必须通过对象操作访问 
Bicycle bicycle = new Bicycle();
System.out.println(<font color = red>bicycle.cadence</font>) ;
这是直接访问了对象中的属性数据.

规范: 不要通过public暴露对象中的数据
实体对象的属性必须用private封装起来,不能让外界直接访问 正确如下

```java
public class Bicycle{
	private int cadence = 0;
	private int speed = 0;
	private int gear = 0;
}
```

封装 对外隐藏功能实现的具体细节,并且隐藏对象中的数据信息.
		 通过暴露方法/接口对外提供服务.
那么外界如何获取信息?
对成员变量的操作必须通过访问器**(getter/setter)**实现

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

> this. 表示当前对象中的东西,上文setter 参数名字 与 变量名字相同,用this区分它俩,this.gear就是对象中的属性gear.

### 构造函数

#### 什么是构造函数

类的构造函数,像一个方法,但是没有返回类型. 方法名称 与 类 的名称一致;

```
public class Bicycle{
	public Bicycle(){}
}
```

可以通过 new 操作符 利用构造函数 创建一个类的对象

```
Bicycle bicycle = new Bicycle();
```

new的是什么?new的是Bicycle这个类吗?不是.类是不能new的
它new的是构造函数 public Bicycle(){} 

这里是无参构造函数,仅创建了对象,但是没有初始化对象属性.
可以通过有参构造函数 创建并初始化对象属性.

当类显式声明了有参构造函数时,编译器将不再自动创建无参构造函数
没有显式声明有参构造函数时,编译器自动创建无参构造函数. ->不写无参构造函数时,new Bicycle()可以使用的原因

类可以声明多个构造函数,但是构造函数的方法签名不能相同.

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
```

就当第二个构造函数不存在,创建Bicycle对象的操作就变成了:

```java
Bicycle bicycle = new Bicycle(5);
//这个 5 就是 bicycle 对象 gear的初始属性
Bicycle bicycle = new Bicycle();
//但是这样就不对了,因为无参构造函数不再自动创建了,真想用?自己声明;
```

#### 对象创建的过程

- 声明
- 实例化
- 初始化

声明:声明一个可以引用指定类型对象的变量
Bicycle bicycle;//bicycle 可以接受Bicycle类型的对象
**声明并不会创建一个对象**,必须为其分配一个地址
实例化: new操作符为对象分配内存,并返回对象的内存地址给变量
Bicycle bicycle = new 
初始化: 利用构造函数完成对象的初始化
Bicycle bicycle = new Bicycle(5)

![](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/creat.png)

创建一个对象,就是创建一个 类的实例 ,即 实例化一个类

#### 对象引用传递

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

### 包的导入

想要使用其他包中的public类型,必须通过以下方式之一:

- 全限定性名称
- 简单名称
- 导入整个包

#### 全限定名称

public class Student{
	private **com.example.clazz.Bicycle** bicycle;
}

把类的地址全写上,来使用类

#### 简单名称

在package之后 类型定义语句之前 通过 import 关键词引入类型后,直接通过类型名使用类

package com.example.packagex;
import **com.example.clazz.Bicycle;**
public class Student{
	private **Bicycle** bicycle;
}

#### 导入整个包

用 * 号导入包中的所有类型

import **com.example.clazz.*;**
public class Student{
	private **Bicycle** bicycle;
}
然后用类型名使用类

>  当包的路径不同但是名称相同时,只有一个可以 简单名称使用类,其他的必须使用 全限定名称.
> com.example.clazz.Bicycle 作用等于 Bicycle







## 静态static

### static method

 **class** 是 method 的载体,一个 class 可以装两种 method
 一种是 静态method,另一种是非静态method
简单来说, static method 是整个 class 共享的 method
而 non-static method 是具体某个实例的 method
method 前写了 static ,这个方法是静态method,不写就是非静态 method

- 调用 非静态method,需要创建一个对象,然后 对象.method 才能使用
  因此也叫 实例方法 instance method
- 调用 静态method 任何时候都可以 classname.method 来使用
  也就是ppt上所说的静态不与任何对象关联.(记住上面的不用管这个)

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

---



### static variable

也分为 static variable 和 instance variable
static variable 是 整个 class 共享的变量
不管是直接 类调用它 还是 对象调用它,大家都是共享的
instance variable 是 具体实例的变量,只存在于某个具体对象内.

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

但是 类的私有静态变量,只有类的对象可以调用,不能通过类调用它.
规范:私有静态变量依然禁止对外直接暴露,必须对外提供访问的公有静态方法
类中 实例方法 单项访问 方法静态成员
		 静态方法 无法访问 实例级成员

![staticvariable](https://cdn.jsdelivr.net/gh/Hushyo/img@main/img/staticvariable.png)

> 静态方法任何时刻都能用,而实例成员必须定义才会存在,因此静态方法无法访问可能不存在的成员 即 静态方法无法访问实例成员

---



### 静态内部类

在 类 里面再定义一个 静态类
虽然是定义在 类 的里面,但是规则上跟外部类一样,是完全独立的,只是代码层面是嵌套的.静态的内部类仍然无法调用外部类的实例级对象







## 枚举enum

特殊的数据类型,定义一组预定义的**枚举**常量列表.限制用户输入
是顶级类型,允许创建独立源文件
比如 四级

```java
public enum Seaon{
 SPRING,SUMMER,AUTUMN,WINTER
}
//使用:Season.SPRING
//enum是一个类型,所以可以定义变量
//定义的enum类型变量只能接受预设值的枚举值,输入其他的无法编译  由此
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
    	MALE,FEMALE
	}
}
```

> 都是常量,所以大写
> 逗号分开,不要分号结尾

java 给了月份枚举 Month.······

## 接口interface

### 解释

接口是互交的协议,也是定制的规范

> A产的电脑能插B生产的U盘,就是因为它们遵循同一套规范

接口中声明 抽象的方法
为什么说是抽象的方法?因为它们只声明了方法.没有说怎么实现
因此定义接口时只需要定义方法,不需要具体实现

> public int addNum(int a, int b);这便是仅声明了方法,没有实现,所以它是抽象的方法

接口也是顶级的,可以单独创建源文件.



- 抽象出相同的状态(属性),设计为实现类
- 抽象出相同的行为(方法),设计为接口

- 接口以行为能力分类

### 定义

接口 由 **修饰符,关键字 interface 接口名称 ,(继承接口列表) 接口主体** 组成
支持 public/package-private修饰
一个接口可以继承任意数量的接口

```java
public interface GroupInterface extends Interface1, Interface2, Interface3
//修饰符		关键字		接口名称				继承列表
```

接口内可以包含抽象方法,默认方法和静态方法
			抽象方法 仅声明.不实现,参数列表括号后直接分号.

- 接口中所有抽象/默认/静态方法 都是隐式 public 所以 public 可以省略
- 接口 抽象方法隐式有 public abstract 修饰
- 接口中可以声明常量,常量有隐式 public static final 修饰
- 规范:接口中的方法/常量,均省略多余的修饰符.
-  接口命名 名词或者名词短语,形容能力的以形容词命名;形容服务的声明服务类型后缀

> UserService,InitService...

### 实现类

> 既然声明了方法,总得有人实现这些方法.

定义一个类, 通过 implements 关键词声明 实现类
用来实现声明中的方法,

- 实现类 implements 多个接口时,用逗号分隔接口列表

- 实现接口,就必须实现接口中的所有抽象方法,少一个都不行
- 记得在方法上方写一行@override 表明这个方法不是类里自带的.而是接口里的抽象方法

```java
public interface Playable{
	void sing(String songName);
}
public interface Learnable{
    void read(String bookName);
    int test(String courseName);
}
public class Undergraduate implements Learnable,Playable{
    private String name;
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

> 实现类本质上还是一个类,也可以当正常类一样声明自己的属性并使用.



如果在接口里添加新method,该接口的所有实现类都要对该method进行实现.
虽然它们可以用同一个实现方法,但是实现类很多时,挨个添加挺麻烦的.

java8之前,接口中只能有抽象方法,不能具体实现.
java8及之后,接口里也可以有具体实现的方法了.
允许通过 default 关键词在接口中声明方法的具体实现(可以放心添加新method啦)

```java
public interface Learnable{
	void read();
	default void study(){
	//这个 study 就是 default 声明实现的方法,所有实现了该接口的类都可以直接调用study
	}
}
```



java8之后 允许在接口中定义 静态方法.
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

> 定义静态方法无需添加 default 关键词 

### 使用

定义了一个接口,就是定义了一个可以引用的类型.像类一样,可以在任何需要的地方作为类型使用
但是接口创建对象的方法有点特殊

```java
Learnable learnable = new new什么?
new Learnable()//吗?显然不行,Learnable里面根本没有具体的方法,new出来也用不了.
Learnable learnable = new Playable();
//接口创建对象,new的是接口的实现类.这样才能使用接口里的方法.
//同时这个对象也可以拥有实现类里面的属性. //后面的学习证明这是错的 对象learnable只能访问接口里的东西
//后面再具体解释
```

## 继承Inheritance

### 须知

- **Subclass** 子类(派生类,扩展类)
- **Superclass** 超类(基类) 
  子类的 直接超类 习惯上称为 父类
- 每个类 能且只能 直接继承自一个父类(单继承)
- 没有显示声明继承时,每个类都隐式继承自 Object 类
  A显式继承自B,B显式继承自C C没有显式继承, 那么C隐式继承自 Object
  so java中所有类都是 Object 的子类

**继承的意义**:想创建一个新类,当前存在一个包含需要代码的类时,可以直接从现有的类中派生出一个新的类,重用现有类的成员,无需重新编写.
许多语言有更为灵活的 Mix-in 即保持了代码的重用性,又降低了耦合性. 但是java没有.别想了

---

子类继承超类所有的public / protected成员/变量/方法
子类可以声明子类自有的新属性和新方法

### Keyword

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



### 子类实例化

子类必须满足超类的特性.子类的构造函数必须把超类也构造上

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

在构造函数中,通过super调用超类的构造函数语句 必须位于构造函数的第一行
先把超类构造出来 才能在超类的基础上添加子类属性构造出来子类.
调用super是为了完成本类继承自超类的属性的初始化,并不会创建超类对象

### 重写override

支持在子类中声明一个与超类中方法签名相同的新的实例方法.override覆写超类方法.
override的方法签名必须与被覆写的一模一样.(不然就不能叫做覆写了)

```
超类 有 move(){sout("move fast")}
子类 覆写: @override
		 public void move(){
		 sout("move low")
		 }
那么子类的对象使用move,输出的是 move low
```

覆写仅要求方法签名一样,说明什么?说明可以改变返回类型.
新的返回类型 ''小于等于'(子类的意思--目前理解)' 超类要求的类型

```
超类方法返回类型是 Movable 超类要求方法必须范围具有Movable能力的对象
子类覆写方法返回类型可以为 Bird 重写改变类型,支持重写为任何实现了 Movable 能力的类型
```

超类方法为基本数据类型时,禁止改变

重写方法的访问范围,必须大于等于超类声明范围

```
超类是protected,子类必须大于等于这个
可以是public,可以是protected,不能是private或其他比超类声明的访问范围小的
```



### 类型转换

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

### 另外

接口无法实例化.
声明的接口类型变量,是其实际引用对象的类型.
它永远都不能是它声明的接口类型.只能是接口中其中一个实现类的类型.

Animal 实现 接口 Movable .
Movable movable = new Animal();

变量 movable 实际类型是 Animal,但是由于声明限制,movable 只能表现出Movable类型的能力.

