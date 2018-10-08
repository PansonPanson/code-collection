

## 死锁 - 必要条件

+ 互斥条件
+ 请求和保持条件
+ 不剥夺条件
+ 环路等待条件

## 多线程并发最佳实践

+ 使用本地变量
+ 使用不可变类
+ 最小化锁的作用域范围：S=1/(1-a+a/n)
+ 使用线程池的Executor, 而不是直接使用new Thread执行
+ 宁可使用线程的同步也不要使用线程的wait和notify
+ 使用BlockingQueue实现生产-消费模式
+ 使用并发集合而不是加了锁的的同步集合
+ 使用Semaphore创建有界的访问
+ 宁可使用同步代码块，也不使用同步的方法
+ 避免使用静态变量

## Spring与线程安全

+ Spring bean：singleton、prototype
+ 交由Spring管理的大多数对象是无状态对象

## HashMap和ConcurrentHashMap

