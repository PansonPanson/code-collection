在Linux中，一切都是文件，对于内核的操作也是如此的。

为了区别不同文件的类型，利用 `type` 来进行区别：

+ 普通文件：包含任意数据，一般来说分为文本文件和二进制文件

    + 文本文件只包含 ASCII 或 Unicode 字符。文本文件就是一系列的文本行，每行以 `\n` 结尾，新的一行是 `0xa`，和 ASCII 码中的 line feed 字符(LF) 一样。不同系统用用判断一行结束的符号不同(End of line, EOL)。
    + 除此之外的都是二进制文件(对象文件, JPEG 图片, 等等)

+ 目录：相关一组文件的索引。目录包含一个链接(link)数组，并且每个目录至少包含两条记录：

    + `.`(dot) 当前目录
    + `..`(dot dot) 上一层目录

    用来操作目录的命令主要有 `mkdir`, `ls`, `rmdir`。目录是以树状结构组织的，根目录是 `/`(slash)。

+ 套接字 Socket：和另一台机器上的进程通信的类型

两种 I/O 方法：Unix I/O 是最底层的，通过系统调用来进行文件操作，在这之上是 C 的标准 I/O 库，对应的函数为：

+ Unix I/O: `open`, `read`, `write`, `lseek`, `stat`, `close`
+ Standard C I/O: `fopen`, `fdopen`, `fread`, `fwrite`, `fscanf`, `fprintf`, `sscanf`, `sprintf`, `fgets`, `fputs`, `fflush`, `fseek`, `fclose`