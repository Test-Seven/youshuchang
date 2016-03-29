**youshuchang**

### 2016年03月37日 第5节课作业 ###
**1.写一个.fearture，上传.feature文件；#calabash-android run MyProjectDemo.apk 运行的截图。**

----------------------------------------分割线---------------------------------------------
### 2016年03月19日 第5节课作业 ###

**1.基于Appium，编写testerhome.apk的自动化用例脚本；用例应包含课程讲到过的定位方式，以及uiautomator scrollable的使用；用例覆盖3~4个场景；**

----------------------------------------分割线---------------------------------------------
### 2016年03月13日 第4节课作业 ###

**1.制作一个app，有两个界面，可以通过点击按钮的方式进行跳转**

页面跳转代码在文件夹“/004-20160313/Book”下面

[页面跳转代码](https://github.com/Test-Seven/youshuchang/tree/master/004-20160313/Book)

**2.修改sppinner或者notpad的默认case，并执行通过。直接贴修改的代码**


**3.看robotium源码**

----------------------------------------分割线---------------------------------------------
### 2016年03月06日 第3节课作业 ###

**1.反编译任意apk，并截图**

反编译截图如下：
![反编译截图](http://i.imgur.com/IhxLFJP.png)

**2.aapt命令查询权限，并且截图**

aapt命令查询权限截图如下：
![aapt查询apk权限](http://i.imgur.com/0uHrNZZ.png)

3.编写3中不同切入点的Andriod monkey的命令，并成功运行，同时说明切入点是什么。

- 多点击
    
  ``` adb -s 192.168.56.101:5555 shell monkey -p com.xxx.xxx  -pct-touch 80 -pct-motion 15 -pct-nav 5  --pct-motion-trackball 0 --ignore-timeouts --ignore-crashes --throttle 500 -s 88 -v -v -v 1000 ```

- 多应用切换

 ```adb -s 192.168.56.101:5555 shell monkey -p com.xxx.xxx -p com.xxx.xxx -p com.xxx.xxx  -pct-touch 80 -pct-motion 15 -pct-nav 5  --pct-motion-trackball 0 --ignore-timeouts --ignore-crashes --throttle 500 -s 88 -v -v -v 1000```

- 手机硬件按钮对于应用的效果

 ```adb -s 192.168.56.101:5555 shell monkey -p com.xxx.xxx -p com.xxx.xxx -p com.xxx.xxx -pct-touch 10 -pct-motion 10 -pct-nav 50 -pct-majornav 30  --pct-motion-trackball 0 --ignore-timeouts --ignore-crashes --throttle 500 -s 88 -v -v -v 1000```

**4.请找出motion和touch对应的源码里的方法，并找出monkey工具实现点击的最基础的方法是什么**


- motion源码的方法：
   
 ```public int injectEvent(IWindowManager paramIWindowManager, IActivityManager paramIActivityManager, int paramInt)
  {
    paramIWindowManager = getEvent();
    if (((paramInt > 0) && (!this.mIntermediateNote)) || (paramInt > 1))
    {
      paramIActivityManager = new StringBuilder(":Sending ");
      paramIActivityManager.append(getTypeLabel()).append(" (");
      switch (paramIWindowManager.getActionMasked())
      {
      case 4: 
      default: 
        paramIActivityManager.append(paramIWindowManager.getAction());
      }
      for (;;)
      {
        paramIActivityManager.append("):");
        int i = paramIWindowManager.getPointerCount();
        paramInt = 0;
        while (paramInt < i)
        {
          paramIActivityManager.append(" ").append(paramIWindowManager.getPointerId(paramInt));
          paramIActivityManager.append(":(").append(paramIWindowManager.getX(paramInt)).append(",").append(paramIWindowManager.getY(paramInt)).append(")");
          paramInt += 1;
        }
        paramIActivityManager.append("ACTION_DOWN");
        continue;
        paramIActivityManager.append("ACTION_MOVE");
        continue;
        paramIActivityManager.append("ACTION_UP");
        continue;
        paramIActivityManager.append("ACTION_CANCEL");
        continue;
        paramIActivityManager.append("ACTION_POINTER_DOWN ").append(paramIWindowManager.getPointerId(paramIWindowManager.getActionIndex()));
        continue;
        paramIActivityManager.append("ACTION_POINTER_UP ").append(paramIWindowManager.getPointerId(paramIWindowManager.getActionIndex()));
      }
      System.out.println(paramIActivityManager.toString());
    }
    try
    {
      boolean bool = InputManager.getInstance().injectInputEvent(paramIWindowManager, 1);
      if (!bool) {
        return 0;
      }
      return 1;
    }
    finally
    {
      paramIWindowManager.recycle();
    }
  } ```

- touch源码的方法：

 ```public MonkeyTouchEvent(int paramInt)
  {
    super(1, 4098, paramInt);
  } ```

- monkey工具实现点击的最基础的方法

 ```public abstract int injectEvent(IWindowManager paramIWindowManager, IActivityManager paramIActivityManager, int paramInt);```

**5.找到任意一个apk or ipa，然后去寻找里面的db，并打开db**

- db文件见文件夹"003-20160306"

- 查看数据库数据截图如下：

![db文件截图](http://i.imgur.com/Kgh6kKF.png)


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
