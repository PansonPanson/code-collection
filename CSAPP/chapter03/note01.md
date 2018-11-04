# 操作系统漫游记003之程序的机器级表示part1程序编码

### 1.程序编码

假设有一个C程序hello.c,在Linux系统上，翻译成可执行的目标文件hello，分为4个阶段进行。

![](https://github.com/PansonPanson/code-collection/blob/master/image-hosting/csapp/%E7%BC%96%E8%AF%91%E7%B3%BB%E7%BB%9F.png?raw=true0)

+ 预处理阶段。预处理器（cpp）根据以字符#开头的命令，修改原始的c程序。比如hello.c中第1行的`#include <stdio.h>`命令告诉预处理器读取系统头文件stdio.h的内容，并把它直接插入到程序文本中。结果就得到了另一个C程序，通常是以.i作为文件扩展名。
+ 编译阶段。编译器（ccl）将文本文件hello.i翻译成文本文件hello.s，它包含一个汇编语言程序。
+ 汇编阶段。汇编器（as）将hello.s翻译成机器语言指令，把这些指令打包成一种叫做“可重定位目标程序”的格式，并将结果保存在目标文件hello.o中。hello.o文件是一个二进制文件。
+ 链接阶段。hello程序调用了printf函数，该函数存在于一个名为printf.o的单独的预编译好了的目标文件中，而这个文件必须以某种方式合并到hello.o程序中。链接器就负责这种合并，并得到hello文件。hello文件是一个可执行目标文件，可以被加载到内存中，由系统执行。

命令：产生hello.s

> gcc -Og -S hello.c

命令：产生hello.o

> gcc -Og -c hello.c

命令：产生可执行目标文件hello

> gcc -Og -o p hello.c

反汇编命令：

> objdump -d hello.o

### 2.数据格式

Inter用术语“字（word）”表示16位数据类型，32位数为“双字（double words）”，64位数为“四字（quad words）”。

大多数GCC生成的汇编代码指令都有一个字符的后缀，表名操作数的大小。数据传送指令有4个变种：movb(传送字节)、movw(传送字)、movl(传送双字)和movq(传送四字)。后缀“l”用来表示双字是因为32位数被看成是"长字（long words）"。

### 3.访问信息

