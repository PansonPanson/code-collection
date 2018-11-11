# 操作系统漫游记003之程序的机器级表示part2程序控制的底层实现

### 1.条件

除了整数寄存器 ，CPU还维护者一组单个位的条件码（condition code）寄存器，用于描述最近的算数或逻辑操作的属性。可以检测这些寄存器来执行条件分支指令。最常用的条件码有：

+ CF：进位标志
+ ZF：零标志
+ SF：符号标志
+ OF：溢出标志

条件码通常不会直接读取，常用的使用方法有3种：

+ 可以根据条件码的某种组合，将一个字节设置为0或1；

    + 这一整类指令称为SET指令

+ 可以条件跳转到程序的某个其他的部分；

    + `jmp`指令是无条件跳转，可以是间接跳转，即跳转目标是作为指令的一部分编码

        ```c
        jmp  *%rax
        ```

    + 也可以是间接跳转，即跳转目标是从寄存器或内存位置中读出来的。

        ```c
        jmp  *(%rax)
        ```

+ 可以有条件地传递数据。

### 2.循环

C语言提供了多种循环结构，即do-while、while 和 for，汇编中没有相对应的指令存在，可以用条件测试和跳转组合实现。

#### 2.1do-while

```c
// C代码
long fact_do(long n) 
{
    long result = 1;
    do {
        result *= n;
        n = n - 1;
    } while (n > 1);
    return result;
}
```

```c
// 等价的goto语句
long fact_do-goto(long n) 
{
    long result = 1;
 loop:
    result *= n;
    n = n - 1;
    if (n > 1)
        goto loop;
    return result;
}
```

```c
// 对应的汇编代码
long fact_do(long n)
n in %rdi
fact_do:
	mov1 $1, %eax			Set result = 1
.L2:						loop:
	imulq $rdi, %rax			Compute result *= n
	subq $1, %rdi				Decrement n
	cmpq $1, %rdi				Compare n:1
	jg .L2						If >, goto loop
	req; ret					Return
```



#### 2.2while的两种翻译方法

#### 2.3for循环

### 3.分支switch

跳转表是一个数组，表项i是一个代码段的地址，这个代码段实现当开关索引值等于i时程序应该采取的动作。和使用if-else语句相比，跳转表的优点是执行开关语句的时间与开关情况的数量无关。GCC根据开关情况的数量和开关情况值得稀疏程度来翻译开关语句，当开关情况数量比较多（例如4个以上），并且值的范围跨度比较小时，就会使用跳转表。

