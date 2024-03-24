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

使用全部小写的英文单数名词
package 声明包的路径名称
必须放在源文件的顶部,源文件的位置必须与包声明的路径相同

---

#### 变量 命名:

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







## 静态

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







## 枚举
