# 小程序

## 目录结构

### 主目录结构

+ app.js : 外部全局主js,可以当做一个父类
+ app.json : 全局配置文件，不可以注释
+ app.wxss : 全局主样式，公用



### 页面目录结构

![001](https://github.com/PansonPanson/blogPictures/blob/master/github002/%E5%B0%8F%E7%A8%8B%E5%BA%8F001.png?raw=true)

+ button.js : 私有的js,相当于子类
+ button.json : 以json对象形式存在的配置
+ button.wxml : 元素所渲染的页面
+ button.wxss : 私有样式



### 小程序生命周期

`App()` 函数用来注册一个小程序。接受一个 object 参数，其指定小程序的生命周期函数等。 

**object参数说明：**

| 属性           | 类型     | 描述                           | 触发时机                                                     |
| -------------- | -------- | ------------------------------ | ------------------------------------------------------------ |
| onLaunch       | Function | 生命周期函数--监听小程序初始化 | 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）      |
| onShow         | Function | 生命周期函数--监听小程序显示   | 当小程序启动，或从后台进入前台显示，会触发 onShow            |
| onHide         | Function | 生命周期函数--监听小程序隐藏   | 当小程序从前台进入后台，会触发 onHide                        |
| onError        | Function | 错误监听函数                   | 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息 |
| onPageNotFound | Function | 页面不存在监听函数             | 当小程序出现要打开的页面不存在的情况，会带上页面信息回调该函数，详见下文 |
| 其他           | Any      |                                | 开发者可以添加任意的函数或数据到 Object 参数中，用 `this` 可以访问 |

### 参考资料：

+ [小程序官方文档j简易教程](https://developers.weixin.qq.com/miniprogram/dev/)
+ [小程序框架](https://developers.weixin.qq.com/miniprogram/dev/framework/MINA.html)
+ [小程序组件](https://developers.weixin.qq.com/miniprogram/dev/component/)
+ [小程序API](https://developers.weixin.qq.com/miniprogram/dev/api/)
+ [小程序工具](https://developers.weixin.qq.com/miniprogram/dev/devtools/devtools.html)