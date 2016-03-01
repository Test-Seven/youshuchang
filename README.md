# youshuchang #

## 2016.02.28 第2节课作业 ##

**1、给出ios开发者设置中的网络模拟的详情数据**


- 100% Loss

![100% Loss](http://i.imgur.com/VVKMrLh.png)

- 3G

![3G](http://i.imgur.com/8cwX40h.png)

- DSL

![DSL](http://i.imgur.com/jPUGPt6.png)

- Edge

![Edge](http://i.imgur.com/S7W8uDQ.png)

- High Latency DNS

![High Latency DNS](http://i.imgur.com/wwnT7Vm.png)

- Very Bad Network

![Very Bad Network](http://i.imgur.com/4RhFSOA.png)

- Wifi

![Wifi](http://i.imgur.com/bZutIwO.png)


**2、使用任意的抓包工具对任意的app进行抓包，并给出抓包的截图**

Fiddler 抓包截图：
![Fiddler 抓包截图](http://i.imgur.com/TvVEJEW.png)

**3、获取proxy tools默认的ssl证书，并且在Android or IOS 上面进行安装，并给出安装的截图。**

**<font color=#DC143C >ssl证书在Android手机上未安装成功，但是却成功抓到了https的请求</font>**

- 操作步骤如下：
-
- 配置Fiddler


Tools>Fiddler Options>HTTPS,勾选相应选项，安装证书

> Fiddler配置

![配置Fiddler](http://i.imgur.com/V6ewZYj.png)

> Fiddler证书

![Fiddler证书](http://i.imgur.com/MduYWzN.png)

- 抓包成功

![抓包成功](http://i.imgur.com/5YDWoYZ.png)

**此时手机并未安装任何证书，为什么抓包成功了呢？**

我将证书导出为.cer格式，QQ发送到手机上，发现无法安装。是我的安装步骤不对么？怎样才可以在Android手机上安装证书？

> 无法安装截图

![手机上无法安装](http://i.imgur.com/HwqbYNi.png)


**4、if 有mac的话，请去编译打包出任意一个 ios 的 debug 的app，并给出 debug app 的路径，else 编译打包出任意一个 Android 的 debug 的 app，并给出 Android 的 keystore 的目录所在**

debug的apk包请见“002-20160228”文件夹

Android默认的debug.keystore路径是C:\Users\Book\\.android
![dubug.keystore](http://i.imgur.com/rxa7N7L.png)
