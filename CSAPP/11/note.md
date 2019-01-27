根据网络的应用范围和架构层级，可以分成三个部分：

+ Ethernet Segment
+ Bridged Ethernet Segment
+ internets

关于网络协议需要做的事情：

+ 提供 naming scheme
    + 定义 host address 格式
    + 每个主机和路由器都至少有一个独立的 internet 地址
+ 提供 delivery mechanism
    + 定义了标准的传输单元 - packet
    + Packet 包含 header 和 payload
        + header 包括 packet size, source 和 destination address
        + payload 包括需要传输的数据

IP地址底层：

```c
struct in_addr {
    uint32_t s_addr;    // network byte order (big-endian)
}
```

DNS: IP地址 --> 域名

