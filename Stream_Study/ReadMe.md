---

---

### 2.Lambda表达式

#### 2.1概述

Lambda是JDK8中一个语法糖。他可以对某当匿名内部类的写法进行简化。它是函数式编程思想的一个重要体现。让我们不用关注是什么对象。而是更关注我们对数据进行了什么操作。

#### 

#### 2.2核心原则

可推导可省略

#### 2.3基本格式

```java
(参数列表)->{代码}
```

例一
我们在创建线程并启动时可以使用匿名内部类的写法：

```java
public static void main(String[] args) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("run方法执行");
        }
    }).start();
}
```

首先new Runnable()接口是一个匿名内部类，并且当中只有一个抽象方法需要重写，就可以转换成lambda表达式。

#### 2.4省略规则

* 参数类型可以省略
* 方法体只有一句代码时大括号return和唯一一句代码的分号可以省略
* 方法只有一个参数时小活号可以省略
* 以上这些规则都记不住也可以省略不记

### 3.Stream流

#### 3.1概述

Java8的Stream使用的是函数式编程模式，如同它的名字一样，它可以被用来对集合或数组进行链状流式的操作。可以更方便的让我们对集合或数组操作。

#### 3.4常用操作

##### 3.4.1创建流

单列集合：集合对象.stream()

```java
List<Author>authors getAuthors();
Stream<Author>stream authors.stream();
```

数组:Arrays.stream(数组)或者使用Stream.of来创建

```java
Integer[]arr = {1,2,3,4,5};
Stream<Integer>stream = Arrays.stream(arr);
Stream<Integer>stream2 = stream.of (arr);
```

双列集合：转换成单列集合后再创建

```java
Map<string,Integer>map = new HashMap<();
map.put("蜡笔小新"，19)；
map.put("黑子"，17)；
map.put("日向用阳"，16)：
Stream<Map.Entry<string,Integer>>stream = map.entrySet().stream();
```

#### 3.4.2中间操作

##### filter

可以对流中的元素进行条件过滤，符合过滤条件的才能继续留在流中。
例如：
打印所有姓名长度大于1的作家的姓名

```java
List<Author>authors = getAuthors();
authors.stream()
.filter (author ->author.getName().length()>1)
.forEach (author ->System.out.println(author.getName()))
```

##### distinct

可以去除流中的重复元素。
例如：
打印所有作家的姓名，并且要求其中不能有重复元素。
I
注意：distinct,方法是依赖object的equals方法来判断是否是相同对象的。所以需要注意重写equals方法。

##### sorted

可以对流中的元素进行排序。
例如：
对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。

注意：如果调用空参的sorted()方法，需要流中的元素是实现了Comparable。

```java
 List<Author> authors= getAuthors();
        authors.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge()).
                forEach(author -> System.out.println(author.getAge()));
```

注意：如果调用空参的sorted()方法，需要流中的元素是实现了Comparable。

##### limit

可以设置流的最大长度，超出的部分将被抛弃。
例如：
对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家的姓名。

```java
private static void extracted3() {
    List<Author> authors = getAuthors();
    authors.stream()
            .distinct()
            .sorted()
            .limit(2)
            .forEach(author -> System.out.println(author.getName()));
}
```