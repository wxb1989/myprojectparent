#集合类
Java 集合类详解
集合类说明及区别
Collection ├List │├LinkedList │├ArrayList │└Vector │　
└Stack └Set 
Map ├Hashtable ├HashMap └WeakHashMap


Collection 接口
Collection 是最基本的集合接口，一个 Collection 代表一组 Object，即 Collection 的元素（Elements）。
一些 Collection 允许相同的元素而另一些不行。一些能排序而另一些不行。Java SDK 不提供直接继承自 
Collection 的类，Java SDK 提供的类都是继承自 Collection的“子接口”如 List 和 Set。 　　
 所有实现 Collection 接口的类都必须提供两个标准的构造函数：无参数的构造函数用于创建一个空的
  Collection，有一个 Collection 参数的构造函数用于创建一个新的 Collection，这个新的 
  Collection 与传入的 Collection 有相同的元素。后 一个构造函数允许用户复制一个Collection。 
  　　 如何遍历 Collection 中的每一个元素？不论 Collection 的实际类型如何，
  它都支持一个iterator()的方法，该方法返回一个迭代子，使用该迭代子即可逐一访问 
  Collection 中每一个元素。典型的用法如下：
`Iterator it = collection.iterator(); // 获得一个迭代子
　　　　while(it.hasNext()) {
　　　　　　Object obj = it.next(); // 得到下一个元素
　　　　}`
由 Collection 接口派生的两个接口是 List 和 Set。


List 接口
　　 List 是有序的 Collection，使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引（元素在 List 中的位置，类似于数组下标）来访问 List 中的元素，这类似于 Java 的数组。

和下面要提到的 Set 不同，List 允许有相同的元素。 　　 除了具有 Collection 接口必备的 iterator()方法外，List 还提供一个 listIterator()方法，返回一个 ListIterator 接口，和标准的 Iterator 接口相比，ListIterator 多了一些 add()之类的方法，允许添加，删除，设定元素， 还能向前或向后遍历。 　　 实现 List 接口的常用类有 LinkedList，ArrayList，Vector 和 Stack。

LinkedList 类
　　 LinkedList 实现了 List 接口，允许 null 元素。此外 LinkedList 提供额外的 get，remove，insert 方法在 LinkedList 的首部或尾部。这些操作使 LinkedList 可被用作堆栈（stack），队列（queue）或双向队列（deque）。 　　 注意 LinkedList 没有同步方法。如果多个线程同时访问一个 List，则必须自己实现访问同步。一种解决方法是在创建 List 时构造一个同步的 List： 　　　　

`List list = Collections.synchronizedList(new LinkedList(...));`

ArrayList 类
　　 ArrayList 实现了可变大小的数组。它允许所有元素，包括 null。ArrayList 没有同步。
 size，isEmpty，get，set 方法运行时间为常数。但是 add 方法开销为分摊的常数，添加 n 个元素需要 O(n)的时间。其他的方法运行时间为线性。 　
 每个 ArrayList 实例都有一个容量（Capacity），即用于存储元素的数组的大小。这个容量可随着不断添加新元素而自动增加，但是增长算法 并没有定义。
 当需要插入大量元素时，在插入前可以调用 ensureCapacity 方法来增加 ArrayList 的容量以提高插入效率。
 和 LinkedList 一样，ArrayList 也是非同步的（unsynchronized）。
