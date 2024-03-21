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

