# 新海内部工具类
## Log打印
## LogUtils
![image](https://github.com/Dougbutyl/neoceansoftLogTool/blob/master/screenhot/device-2019-06-06-154514.png)
## Dependency
Add it in your root build.gradle at the end of repositories:
``` Java
 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 and then add dependency
``` Java
 	dependencies {
	        implementation 'com.github.Dougbutyl:neoceansoftLogTool:1.0'
	}

 ```
 ```
  	LogUtils.i("i 打印内容显示");
        LogUtils.il("il 带标签打印内容显示");
        LogUtils.e("e 打印内容显示");
        LogUtils.el("el 带标签打印内容显示");
        LogUtils.a("a 打印内容显示");
        LogUtils.al("al 带标签打印内容显示");
        LogUtils.d("d 打印内容显示");
        LogUtils.dl("dl 带标签打印内容显示");
        LogUtils.v("v 打印内容显示");
        LogUtils.vl("vl 带标签打印内容显示");
        LogUtils.w("w 打印内容显示");
        LogUtils.wl("wl 带标签打印内容显示");
```
