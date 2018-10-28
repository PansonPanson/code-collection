# 操作系统漫游记002之信息的位与表示part2

#### 一些值得注意的地方

+ C和C++都支持有符号（默认）和无符号数，Java只支持有符号数。
+ C语言标准并没有要求用补码形式来表示有符号整数，但是几乎所有的机器都是这么做的。
+ 关于整数数据类型的取值范围和表示，Java标准是非常明确的。它采用补码表示，这保证了Java程序的跨平台运行。
+ 无符号数编码与补码都具有唯一性，但反码和原码都不具有唯一性（对0有两种不同的编码方式）

#### 4种编码

1.无符号数的编码
$$
B2U_w(\vec{x}) a\overset{.}{=}\sum_{i=0}^{w-1}x_i2^i
$$
2.补码编码
$$
B2T_w(\vec{x}) a\overset{.}{=}-x_{w-1}2^{w-1} + \sum_{i=0}^{w-2}x_i2^{i}
$$
3.反码编码：与补码相比只有最高位的权值不一样
$$
B2O_w(\vec{x}) a\overset{.}{=}-x_{w-1}(2^{w-1}-1)+\sum_{i=0}^{w-2}x_i2^i
$$
4.原码编码：


