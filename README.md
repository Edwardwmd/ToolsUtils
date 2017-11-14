# ToolsUtils usage method

API
---
一、SharePreference缓存数据————》SharePreferenceUtils  
+ putSharePreference:保存数据的方法<br>
+ getSharePreference:获取数据的方法<br>
+ removKey:移除某个对应的那个数据
+ removeAllKey：移除所有数据
+ contains：查询某个key是否已经存在
+ putImg：保存图片
+ getImg：获取图片

二、缓存工具类 —————》AppCacheUtils
+ put             : 保存String数据到缓存中
+ getAsString     : 读取String数据
+ getAsJSONObject : 读取JSONObject数据
+ getAsJSONArray  : 读取JSONArray数据
+ getAsBinary     : 获取byte数据
+ getAsObject     : 读取Serializable数据
+ getAsBitmap     : 读取bitmap数据
+ getAsDrawable   : 读取Drawable数据
+ file            : 获取缓存文件
+ remove          : 除某个key
+ clear           : 清除所有数据

三、线程工具类——————》ThreadToolsUtils
+ isInMainThread：判断是当前线程是否在主线程

四、网络管理工具类——————》AppNetworkUtils
+ getNetworkState          : 获取当前手机连接的网络类型
+ isNetworkConnected       : 判断网络是否连接
+ openNetSetting           : 打开网络设置界面
+ is3gConnected            : 检测3G是否连接
+ getNetworkTypeName       : 获取网络类型名称
+ getCurrentNetworkState   : 获取当前网络的状态
+ getCurrentNetworkSubtype : 获取当前网络的具体类型
+ isConnectedByState       : 判断当前网络是否已经连接
+ isConnectingByState      : 判断当前网络是否正在连接
+ isDisconnectedByState    : 判断当前网络是否已经断开
+ isDisconnectingByState   : 判断当前网络是否正在断开
+ isSuspendedByState       : 判断当前网络是否已经暂停
+ isUnknownByState         : 判断当前网络是否处于未知状态中
+ isBluetoothByType        : 判断当前网络的类型是否是蓝牙
+ isDummyByType            : 判断当前网络的类型是否是虚拟网络
+ isEthernetByType         : 判断当前网络的类型是否是ETHERNET
+ isMobileByType           : 判断当前网络的类型是否是移动网络
+ isMobileDunByType        : 判断当前网络的类型是否是MobileDun
+ isMobileHipriByType      : 判断当前网络的类型是否是MobileHipri
+ isMobileMmsByType        : 判断当前网络的类型是否是MobileMms
+ isMobileSuplByType       : 判断当前网络的类型是否是MobileSupl
+ isWifiByType             : 判断当前网络的类型是否是Wifi
+ isWimaxByType            : 判断当前网络的类型是否是Wimax
+ is1XRTTBySubtype         : 判断当前网络的具体类型是否是1XRTT
+ isCDMABySubtype          : 判断当前网络的具体类型是否是CDMA（Either IS95A or IS95B）
+ isEDGEBySubtype          : 判断当前网络的具体类型是否是EDGE
+ isEHRPDBySubtype         :  判断当前网络的具体类型是否是EHRPD
+ isEVDO_0BySubtype        : 判断当前网络的具体类型是否是EVDO_0
+ isEVDO_ABySubtype        : 判断当前网络的具体类型是否是EVDO_A
+ isEVDO_BBySubtype        : 判断当前网络的具体类型是否是EDGE
+ isGPRSBySubtype          : 判断当前网络的具体类型是否是GPRS
+ isHSDPABySubtype         : 判断当前网络的具体类型是否是HSDPA
+ isHSPABySubtype          : 判断当前网络的具体类型是否是HSPA
+ isHSPAPBySubtype         : 判断当前网络的具体类型是否是HSPAP
+ isHSUPABySubtype         : 判断当前网络的具体类型是否是HSUPA
+ isIDENBySubtype          : 判断当前网络的具体类型是否是IDEN
+ isLTEBySubtype           : 判断当前网络的具体类型是否是LTEisUMTSBySubtype          : 判断当前网络的具体类型是否是UMTS
+ isUNKNOWNBySubtype       : 判断当前网络的具体类型是否是UNKNOWN
+ isChinaMobile2G          : 判断当前网络是否是中国移动2G网络
+ isChinaUnicom2G          : 判断当前网络是否是中国联通2G网络
+ isChinaUnicom3G          : 判断当前网络是否是中国联通3G网络
+ isChinaTelecom2G         : 判断当前网络是否是中国电信2G网络
+ isChinaTelecom3G         : 判断当前网络是否是中国电信3G网络
+ getWifiState             : 获取Wifi的状态，需要ACCESS_WIFI_STATE权限
+ isWifiOpen               : 判断Wifi是否打开，需要ACCESS_WIFI_STATE权限
+ setWifi                  : 设置Wifi，需要CHANGE_WIFI_STATE权限
+ isMobileNetworkOpen      : 判断移动网络是否打开，需要ACCESS_NETWORK_STATE权限
+ getIpAddress             : 获取本机IP地址
+ setDataEnabled           : 设置数据流量状态
+ getWifiScanResults       : 获取wifi列表
+ getScanResultsByBSSID    : 过滤扫描结果
+ getWifiConnectionInfo    : 获取wifi连接信息
+ getProxy                 : 获得Proxy地址

五、Activity 出入栈管理工具——————》ActivityCollector（单一实例）
+ addActivity              :Activity入栈
+ finishAppointActivity    :移除指定的Activity/移除指定类名的Activity
+ finishCurrentActivity    :移除当前activity
+ finishAllActivity        :结束所有Activity
+ AppExit                  :退出应用程序

六、String 使用工具——————》StringUtils
+ isEmpty：String/CharSequence/EditText判空
+ parseArrayInt:是否解析ArrayInt
+ parseArrayString:是否解析ArrayString
+ isEqual:判断两个String是否相同
+ trimEnd：去除字符串尾部空格
+ convert：将字符串中所有的非标准字符（双字节字符）替换成两个标准字符（**，或其他的也可以）
+ getUTF8Dom：获取UTF8Dom
+ copyString：复制String
+ getUrlName：换取url名称
+ getTime：获取时间
+ parseDouble：String转换成Double
+ parseInt：String转换成int
+ parseLong：转换成long
+ subString：截取某段字符串

----------------------------后续会添加其他工具-------------------------------------
