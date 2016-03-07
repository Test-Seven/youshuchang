**youshuchang**
### 2016年03月06日 第3节课作业 ###

1.反编译任意apk，并截图

2.aapt命令查询权限，并且截图

3.编写3中不同切入点的Andriod monkey的命令，并成功运行，同时说明切入点是什么。

4.请找出motion和touch对应的源码里的方法，并找出monkey工具实现点击的最基础的方法是什么

5.找到任意一个apk or ipa，然后去寻找里面的db，并打开db

6.mac IOS github上去找monkey.js,去instruments运行，给instruments运行的结果图

7.安装下idevicestaller，获取下IOS日志


----------------------------------------分割线---------------------------------------------

### 2016年02月28日 第2节课作业 ###

**1、给出ios开发者设置中的网络模拟的详情数据**

- 100% Loss

<img src="http://i.imgur.com/VVKMrLh.png" alt="100% Loss" width="250px" height=""/>

- 3G

<img src="http://i.imgur.com/8cwX40h.png" alt="3G" width="250px" height=""/>

- DSL

<img src="http://i.imgur.com/jPUGPt6.png" alt="DSL" width="250px" height=""/>

- Edge

<img src="http://i.imgur.com/S7W8uDQ.png" alt="Edge" width="250px" height=""/>

- High Latency DNS

<img src="http://i.imgur.com/wwnT7Vm.png" alt="High Latency DNS" width="250px" height=""/>

- Very Bad Network

<img src="http://i.imgur.com/4RhFSOA.png" alt="Very Bad Network" width="250px" height=""/>

- Wifi

<img src="http://i.imgur.com/bZutIwO.png" alt="Wifi" width="250px" height=""/>

**2、使用任意的抓包工具对任意的app进行抓包，并给出抓包的截图**

Fiddler 抓包截图：
![Fiddler 抓包截图](http://i.imgur.com/TvVEJEW.png)

**3、获取proxy tools默认的ssl证书，并且在Android or IOS 上面进行安装，并给出安装的截图。**

**<font color="#DC143C" >ssl证书在Android手机上未安装成功，但是却成功抓到了https的请求</font>**

- 操作步骤如下：

> 配置Fiddler

Tools>Fiddler Options>HTTPS,勾选相应选项，安装证书

> Fiddler配置

![配置Fiddler](http://i.imgur.com/V6ewZYj.png)

> Fiddler证书

![Fiddler证书](http://i.imgur.com/MduYWzN.png)

> 抓包成功

![抓包成功](http://i.imgur.com/5YDWoYZ.png)

**此时手机并未安装任何证书，为什么抓包成功了呢？**

我将证书导出为.cer格式，QQ发送到手机上，发现无法安装。是我的安装步骤不对么？怎样才可以在Android手机上安装证书？

> 无法安装截图

<img src="http://i.imgur.com/HwqbYNi.png" alt="无法安装截图" width="250px" height=""/>

-----------------------------------------分割线------------------------------------------------

证书终于安装成功了！！！

- Fiddler证书安装截图

<img src="http://i.imgur.com/0wmQu98.png" alt="Fiddler证书安装截图" width="250px" height=""/>

- 网站证书安装截图

<img src="http://i.imgur.com/dKqFPzk.png" alt="网站证书安装截图" width="250px" height=""/>


**4、if 有mac的话，请去编译打包出任意一个 ios 的 debug 的app，并给出 debug app 的路径，else 编译打包出任意一个 Android 的 debug 的 app，并给出 Android 的 keystore 的目录所在**

debug的apk包请见“002-20160228”文件夹

Android默认的debug.keystore路径是C:\Users\Book\\.android
![dubug.keystore](http://i.imgur.com/rxa7N7L.png)
