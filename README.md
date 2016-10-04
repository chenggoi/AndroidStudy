# AndroidStudy

## 第一部分：基础知识

### 注：学习笔记源于《第一行代码》，感谢作者

### 2016年7月11日
#### Activity
- **setContentView(R.layout.xxx)**:为当前活动加载一个布局
- **requestWindowFeature(Window.FEATURE_NO_TITLE)**:隐藏标题栏，需要在setContentView之前运行，否则会报错
- **findViewById()**:通过传入布局元素的id来获取该元素，该方法返回的是一个View对象，需要对其进行向下转型转换成需要的元素对象类型
- **setOnClickListener()**:为按钮添加点击事件，点击按钮时会触发 **onClick()** 方法
- **Toast.makeText().show()**:显示一条Toast消息，makeText中需要的三个参数为 **Context,消息内容，消息显示时长**
- **onCreateOptionsMenu()**:在活动中创建一个菜单，通过 **getMenuInflater().inflate(R.menu.main, menu)** 将菜单布局文件绑定到Menu对象上
- **onOptionsItemSelected()**:执行Menu中item的点击事件，通过 **item.getItemId()** 来判断点击的按钮
- **finish()**:销毁当前活动


#### Layout

- **android:id="@+id/xx"**:设置当前元素id，可通过R.id.xx调用
- **android:layout_width="match_parent"**:设置当前元素宽度与父元素一样宽
- **android:layout_height="wrap_content"**:设置当前元素高度为刚好包含元素内容的高度
- **android:text="xxx"**:设置元素中显示的文字内容

#### AndroidManifest

- 在 **\<application\>\</application\>** 标签中注册当前活动

```
<activity
    android:name=".MainActivity"
    android:label="This is MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

- **android:name**:具体注册的活动名称
- **android:label**:程序的快捷方式名称
- **\<action android:name="android.intent.action.MAIN" /\>**:声明该活动为主活动，打开app的第一页面
- **\<category android:name="android.intent.category.LAUNCHER" /\>**:该程序会显示在程序列表中，即创建图标
- **\<data android:scheme="http"/\>**:定义该活动能够相拥的数据协议，http是网络协议，geo是地理位置，tel是电话

#### Intent

- **Intent intent = new Intent(MainActivity.this, SecondActivity.class)**:显式Intent的创建，构造函数的两个参数为 **Context,目标活动**
- **startActivity(intent)**:通过该方法执行intent，打开第二个活动，按back建即可返回
- **startActivityForResult(intent, 1)**:启动活动，并在活动销毁时返回一个结果给上一个活动
- **Intent intent = new Intent("com.chenggoi.androidstudy.ACTION_START")**:隐式Intent的创建，通过**<action>标签**来确定开启的活动，只有在活动包含的action标签吻合时，才会启动
- **intent.addCategory()**:添加一个 **category** ，只有在category也对应上时才能打开该活动。一个活动只能有 **一个** action，但是可以有 **多个** category
- **Intent.ACTION_VIEW**:系统内置的action，用于启动浏览器
- **Intent.ACTION_DIAL**:系统内置的action，用于启动拨号界面
- **intent.setData(Uri.parse("http://chenggoi.com"))**:将网址的uri信息绑定到intent上传递给要打开的应用
- **intent.putExtra("extera_data",data)**:通过intent传递信息，两个参数分别为 **信息标签，信息内容**
- **getIntent()**:获取用于启动Activity的Intent
- **intent.getStringExtra()**:获取intent中包含的指定类型指定标签的数据
- **setResult(RESULT_OK,intent)**:将intent返回给上一个活动，只有在该活动被销毁时才会调用，并触发上一个活动的onActivityResult()方法
- **onActivityResult()**:通过重写该方法处理活动销毁时返回的信息，该方法的三个参数为 **启动第二活动时传入的请求码，返回数据时传入的处理结果，携带着返回数据的intent** ，可以根据三个参数，判断数据来源，处理结果是否成功，并将intent中的数据取出

### 2016年7月12日

#### AndroidManifest

- **android:theme**:用于给当前活动指定主题
- **android:launchMode**:用于给当前活动设置启动模式，启动模式包括 **satndard、singleTop、singleTask、singleInstance**
- **standard**:活动启动的默认模式，系统不会判断这个活动是否在返回栈中存在，每次启动都会创建该活动的一个新的实例
- **singleTop**:当活动已经在栈顶时，再次启动该活动不会创建一个新的实例，而是直接使用栈顶的该活动。当该活动不在栈顶时，再次启动会创建一个新的实例
- **singleTask**:系统会检测栈中是否含有该活动，如果有则将该活动之后的所有活动统统出栈，如果没有则会创建一个新的活动
- **singleInstance**:该活动会单独启用一个新的返回栈来管理这个活动，不论哪个应用访问该活动，该活动都会共用同一个返回栈，解决了共享活动实例的问题


#### Layout

- **\<TextView\>**：显示一段文本信息
- **android:gravity**:指定文字的对齐方式，可选值有 **top、bottom、left、right、center** 等，可以用|来同时指定多个值
- **android:textColor**:设置文字的颜色
- **android:textSize**：设置文字的大小
- **\<Button\>**:用于与用户进行交互的按钮
- **\<EditText\>**:允许用户进行输入的输入框
- **android:hint**:指定输入框内的提示性文本，输入文字后会消失
- **android:maxLines**:指定输入的最大行数，输入内容超过行数限制时会向上滚动
- **\<ImageView\>**:在界面上插入一个图片
- **android:src**:设置元素中显示的内容
- **\<ProgressBar\>**:进度条元素
- **android:max**:设置进度条的最大值
- **android:visibility**:设置元素的可见性，可选值有**visible(可见)、invisible(透明)、gone(不可见)**

#### Activity

- **生命周期**：onCreate、onStart、onResume、onPause、onStop、onDestory、onRestart
- ![Activity生命周期](https://developer.android.com/images/training/basics/basic-lifecycle.png)
- **Bundle类型**:提供了一系列方法用于保存数据，如 **putString()** 方法保存字符串。每个保存方法需传入两个参数，一个是一个参数是键，用于从Bundle中取值，另一个是要保存的内容
- **onSaveInstanceState()**:用于在活动被系统回收前保存活动中的数据，将数据存于Bundle类型的变量中，等到活动再次调用onCerate时作为参数传入，并携带有之前保存的全部数据
- **getClass().getSimpleName()**:获取当前实例的类名
- **editText.getText()**:获取EditText输入的内容
- **imageView.setImageResource()**:设置ImageView中显示的图片
- **getVisibility()**:获取元素的可见性
- **setVisibility()**:设置元素的可见性，可选值为 **View.VISIBLE、View.INVISIBLE、View.GONE**
- **AlertDialog.Builder**:创建一个AlertDialog实例
- **dialog.setTitle()**:设置dialog标题
- **dialog.setMessage()**:设置dialog的内容
- **dialog.setCancelable()**:是否可以点击dialog以外区域取消
- **dialog.setPositiveButton()**:为确定按钮设置点击事件
- **dialog.setNegativeButton()**:为取消按钮设置点击事件
- **dialog.show()**:显示dialog
- **ProgressDialog**:创建一个带进度条的dialog
- **dialog.dismiss()**:关闭dialog

### 2016年7月13日

#### Layout

- **LinearLayout**:线性布局，将所包含的控件在线性方向上依次排列
- **android:orientation**:指定布局的排列方向， **vertical** 为垂直排列， **horizontal** 为水平排列，默认值为水平排列
- **android:layout_gravity**:控件在布局中的对齐方式。当布局为 **horizontal** 时，只有垂直方向的对齐方式会生效，反之亦然
- **android:layout_weight**:设定控件所占的屏幕比例。系统会将所有控件的weight值相加，然后根据每个控件的值算出所占比例
- **RelativeLayout**:线性布局，通过相对定位的方式让控件出现在布局的任何位置
- **android:layout_alignParentLeft**:与父布局左边对齐
- **android:layout_alignParentRight**:与父布局右边对齐
- **android:layout_alignParentTop**:与父布局顶端对齐
- **android:layout_alignParentBottom**:与父布局底端对齐
- **android:layout_centerInParent**:与父布局中间对齐
- **android:layout_above**:在某个控件的上面
- **android:layout_toLeftOf**:在某个控件的左面
- **android:layout_toRightOf**:在某个控件的右面
- **android:layout_below**:在某个控件的下面
- **android:layout_alignLeft**:一个控件的左边缘与另一个控件的左边缘对齐
- **android:layout_alignRight**:一个控件的右边缘与另一个控件的右边缘对齐
- **android:layout_alignTop**:一个控件的上边缘与另一个控件的上边缘对齐
- **android:layout_alignBottom**:一个控件的下边缘与另一个控件的下边缘对齐
- **FrameLayout**:没有任何定位方式的布局，所有控件都会摆放在布局的左上角，后添加的控件会覆盖在之前添加的控件上
- **TableLayout**:使用表格的方式来排列控件
- **android:stretchColumns**:指定第n-1列拉抻至填满屏幕
- **TableRow**:表示在表各中添加一行，在TableRow中每加入一个控件，就添加了一列。TableRow中的控件不能指定宽度
- **android:inputType**:设置EditText的输入格式
- **android:layout_span**:合并单元格

### 2016年7月15日

#### Layout

- **android:background**:为控件或布局指定一个背景，可以使用颜色或者图片来填充
- **android:layout_margin**:指定控件在上下左右方向上的偏移距离，也可以使用 **marginTop** 等来指定特定方向的偏移距离

#### 自定义控件

- **TitleLayout继承自LinearLayout**，重写其构造函数，当布局被调用时会调用该构造函数，并执行其中对于控件的操作
- **LayoutInflater.from(context).inflate(R.layout.title, this)**:通过LayoutInflater的from()方法，构建一个LayoutInflater对象，然后调用inflate()方法动态加载一个布局文件。两个参数为 **要加载的布局文件id，加载好的布局文件的父布局**
- 通过指定 **完整包名** 在其他布局中添加该自定义控件

```
    <com.chenggoi.androidstudy.TitleLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </com.chenggoi.androidstudy.TitleLayout>
```

### 2016年7月19日

#### Layout

- **\<ListView\>**:列表控件
- **px**:以像素为单位
- **pt**:以磅为单位，以上两种单位会存在因屏幕分辨率不同而产生的适配问题，因此多用于文字
- **dp**:密度无关像素，也称作 **dip** ，在不同密度(屏幕每英寸所包含的像素数，通常以dpi为单位)的屏幕中的显示比例保持一直。根据Android规定，在160dpi的屏幕上，1dp=1px，在320dpi的屏幕上，1dp=2px。
- **sp**:可伸缩像素，采用与dp相同的设计理念来解决文字大小的适配问题


#### Activity

- **ArrayAdapter\<\>**:通过泛型来指定适配器的类型，并在构造函数中将适配的数据传入即可
- **listView.setAdapter()**:将构建好的适配器对象传递进去，建立ListView与数据之间的关联
- **listView.setOnItemClickListener()**:为ListView上的Item注册一个监听器，对item的点击事件进行监听。在**onItemClick()**方法中，可以根据position来判断用户点击的是哪一个item子项。
- **getResources().getDisplayMetrics().xdpi**:获取x轴方向上的屏幕密度
- **getResources().getDisplayMetrics().ydpi**:获取y轴方向上的屏幕密度

#### Adapter

- **getView()**:重写Adapter的该方法，该方法在每个子项被滚动到的时候会被调用，并返回每个子项的布局。其参数中的**convertView**用于将之前加载好的布局进行缓存，以便日后进行重用，提高效率
- **getItem()**:通过该方法可以得到当前子项的实例
- **LayoutInflater.from()**:该方法用于为该子项加载传入的布局
- **imageView.setImageResource**:设置显示的图片
- **textView.setText**:设置显示的文字
- **提高ListView加载效率**:对控件实例进行缓存。创建一个ViewHolder类，将全部控件实例放于其中，然后调用View的setTag()方法，将ViewHolder对象储存在View中。当convertView不为空时调用View的getTag()方法将ViewHolder重新取出，省去每次都要findViewById().

### 2016年7月22日

#### Layout

- **\<fragment\>**:碎片布局
- **android:name**:显式指明需要添加的碎片类名
- **限定符**:通过对layout进行限定，来根据设备屏幕大小动态加载布局，如**layout-large**,**layout-ldpi**, **layout-land** 分别对应屏幕大小、屏幕分辨率、屏幕横竖屏
- **android:padding**:给控件的周围加上补白，使文本不会紧靠在边缘上
- **android:singleLine**:设置为true时表示文字单行显示
- **android:ellipsize**:设定当文本超出控件宽度时的缩略方式，可选值有 **start(省略号在开头)、end(省略号在结尾)、middle(省略号在中间)、marquee(获取焦点时，以跑马灯的形式滚动显示)**

#### Fragment

- **onCreateView()**:与Activity的onCreate()方法作用相同,为碎片加载布局时调用
- **getActivity()**:获取与当前碎片关联的活动实例，从而调用活动中的方法。而且当fragment中需要context对象时，也可以使用该方法
- **onAttach()**:当碎片和活动建立关联的时候调用
- **onActivityCreated()**:确保与碎片相关联的活动已经创建完毕的时候调用
- **onDestoryView()**:当与碎片关联的视图被移除的时候调用
- **onDetach()**:当碎片和活动解除关联的时候调用
- ![Fragment生命周期](https://developer.android.com/images/fragment_lifecycle.png)

#### Activity

- **getFragmentManager()**:获取FragmentManager实例
- **fragmentManager.beginTransaction()**:开启一个fragment事物，用于对fragment进行添加,移除,替换,以及执行其他动作
- **transaction.replace()**:向容器内添加碎片，两个参数为 **传入容器的id，待添加的碎片实例**
- **transaction.commit()**:提交执行事务
- **transaction.addToBackStack()**:接收一个名字用于描述返回栈的状态，当按下back键时，不会直接退出fragment页面，而是返回上一个fragment页面
- **fragmentManager.findFragmentById()**:通过布局ID来获取Fragment实例，从而调用Fragment中的方法

### 2016年7月26日

#### Broadcast

- **标准广播(Normal broadcasts)**:完全异步执行的广播，在广播发出后，所有的广播接收器几乎都会在同一时间接收到这条广播信息。效率比较高但是无法被截断
- **有序广播(Ordered broadcasts)**:同步执行广播，在广播发出后，同一时刻只会有一个广播接收器能够收到这条消息，当这个广播接收器中的逻辑执行完毕后，广播才会继续传递。此时广播有优先级顺序，优先级高的接收器可以对广播进行截断
- **BroadcastReceiver**:广播接收者，当接收到广播时，会执行onRecive()方法，在onReceive()方法中，尽量不要执行过多操作，否则长时间没有结束会报错
- **intentFilter.addAction("")**:添加要监听的广播的action
- **registerReceiver()**:对Receiver进行动态注册，将Receiver实例和IntentFilter实例都传进去
- **unregisterReceiver()**:动态注册的广播必须在onDestory()方法中调用该方法取消注册
- **getSystemService()**:获取系统服务的实例
- **connectivityManager.getActiveNetworkInfo()**:得到NetworkInfo实例
- **networkInfo.isAvailable()**:判断当前是否有网络
- **sendBroadcast()**:发送一条标准广播，参数为 **指定了action的Intent实例**
- **sendOrderedBroadcast()**:发送一条有序广播，参数为 **Intent,与权限相关的字符串**
- **abortBroadcast()**:将该条广播截断，后面的广播接收器无法再收到该条广播
- **LocalBroadcastManager.getInstance()**:获取一个LocalBroadcastManager的实例，用于管理本地广播。本地广播只能在同一个程序内被接收，并且无法通过静态注册的方式来接收
- **localBroadcastManager.sendBroadcast()**:发送本地广播
- **localBroadcastManager.registerReceiver()**:注册本地广播
- **localBroadcastManager.unregisterReceiver()**:销毁本地广播

#### AndroidManifest

- **\<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /\>**:添加查询系统网络状态的权限
- **\<receiver\>**:静态注册广播接收器，通过 **android:name** 指定具体注册哪一个广播接收器， **\<intent-filter\>** 标签内加入想要接收的广播
- **\<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /\>**:添加监听系统开机广播的权限
- **android:priority**:为广播接收器设置优先级，有序广播会按照优先级顺序进行接收

### 2016年7月29日

#### 数据持久化存储

- Android系统中三种简单实现持久化存储的方式：**文件存储、SharedPreference存储、数据库存储**
- **文件存储**:Android中最基本的数据存储方式，不对存储内容进行任何的格式化处理，所有数据原封不动的保存在文件当中
- **openFileOutput()**:用于将数据存储到指定文件中，两个参数为 **文件名，存储模式** ，存储模式分别为 **"MOVE_PRIVATE"同文件名覆盖、"MOVE_APPEND"同文件名追加** ，默认会保存到 **/data/data/\<package name\>/files** 目录下
- **openFileInput()**:用于读取指定文件的数据，参数为 **文件名** ，返回一个FileInputStream对象
- **editText.setSelection()**:将EditText的光标移动到指定的位置
- **TextUtils.isEmpty()**:判断字符串是否为空，自带两种空值判断
- **SharedPreference存储**:使用键值对的方式来存储数据，支持多种不同数据类型存储
- **getSharedPreferences()**:两个参数为 **文件的名称，操作模式** ，获取SharedPerferences对象
- **SharedPerferences.edit()**:获取一个SharedPerferences.Editor对象，然后通过 **editor.putString()** 等方法往其中添加数据
- **editor.commit()**:提交添加的数据，数据存储在 **/data/data/\<package name\>/shared_prefs/** 目录下
- **sharedPreferences.getString()**:根据键值获取SharedPerferences中保存的数据

### 2016年8月1日

#### SQLiteOpenHelper

- **SQLiteOpenHelper**:用于管理数据库的一个抽象类，继承该类并实现其抽象方法，用于对数据库进行创建和升级操作
- **getReadableDatabase()**:创建或打开一个数据库，并返回一个可对数据库进行读写操作的对象。当数据库不可写入的时候，返回对象以只读方式打开数据库
- **getWritableDatabase()**:创建或打开一个数据库，并返回一个可对数据库进行读写操作的对象。当数据库不可写入的时候，将抛出异常
- **数据库建表语句**: **integer** 整型、 **text** 文本类型、 **real** 浮点型、 **primary key** 主键、 **autoincrement** id自增长
- **db.execSQL()**:执行除了查询以外的SQL语句
- **onUpgrade()**:当构造函数中传入的版本号比当前数据库的版本号高时，会执行升级方法
- **db.insert()**:向数据表中插入数据，三个参数为 **表名，为指定添加数值列的默认赋值，携带添加数据的ContentValues对象**
- **values.put()**:向ContentValues中添加数据，两个参数为 **相应表的列名，待添加的数据**
- **db.update()**:对数据库中的数据进行更新，四个参数分别为 **表名，携带更新数据的ContentValues对象，SQL的where语句，指定where语句的条件**
- **db.delete()**:删除数据库中的数据，三个参数为 **表名，SQL的where语句，指定where语句的条件**
- **db.query()**:查询数据库中的数据，七个参数为 **表名，查询哪列，查询哪行，查询哪行，指定需要区group by的列，group by之后进行过滤，查询结果排序方式** ，查询结果以Cursor对象返回
- **cursor.moveToFirst()**:移动到第一行
- **cursor.moveToNext()**:移动到下一行
- **cursor.getColumnIndex()**:获取某一列在表中对应位置的索引
- **cursor.getString()**:根据位置索引获取数据
- **cursor.close()**:关闭Cursor
- **db.rawQuery()**:使用SQL语句查询数据库时使用该方法

### 2016年8月2日

#### SQLiteOpenHelper

- **db.beginTransaction()**:开启一个事务，在返回事务成功之前操作中断的话，会还原旧数据
- **db.setTransactionSuccessful()**:表示事务执行成功
- **db.endTransaction()**:结束事务

#### Content Provider

- **内容Uri**:内容Uri通常由 **conten://权限/路径** 组成，用于确定想要访问哪张表里的数据
- **Uri.parse()**:将内容Uri字符串解析成 **Uri对象**
- **getContentResolver()**:获取ContentResolver实例，用于对提供ContentProvider的Uri进行 **insert(),delete(),update(),query()** 操作
- **onCreate()**:初始化内容提供器，通常会在这里完成数据库的创建和升级等操作。只有在ContentResolver尝试访问程序中的数据时才会进行初始化操作
- **uriMatcher.addURI()**:用于匹配内容Uri，三个参数为 **权限，路径，一个自定义代码** ，可以传入通配符
- **uriMatcher.match()**:通过Uri对象匹配所对应的自定义代码，从而判断出调用方期盼访问的数据
- **getType()**:用于获取Uri对应的MIME字符串，该字符串主要由三个部分组成：1.必须以 **vnd.**开头；2如果内容URI以路径结尾，则后接**android.cursor.dir/** ,如果以id结尾，则后接 **android.cursor.item/** ；3.最后接上 **vnd.\<authority\>\<path\>**
- **uri.getPathSegments()**:将uri以“/”符号进行分割，并把分割后的结果存入一个字符串列表中，第0个位置存的路径，第1个位置存的id


#### AndroidManifest

- **\<uses-permission android:name="android.permission.READ_CONTACTS" /\>**:获取电话本的读取权限

### 2016年8月3日

#### Notification

- **获取NotificationManager实例**:通过调用Context的getSystemService()方法，接收Context.NOTIFICATION_SERVICE获取
- **NotificationCompat.Builder**:通过实例化该对象，为通知添加图标和文字内容等
- **builder.build()**:返回一个包含具体规范的Notification对象
- **notificationManager.notify()**:将Notification传递给系统，从而使之生效，两个参数为 **Notification的专有id，Notification对象**
- **PendingIntent**:延迟执行的Intent，可根据需求选择使用 **getActivity(),getBroadcast(),getService()**方法。四个参数为**Context对象，0，Intent对象，确定PendingIntent的行为**
- **builder.setContentIntent()**:设置Notification点击时响应的PendingIntent
- **notificationManager.cancel()**:根据id关闭相应的Notification
- **builder.setSound()**:显示通知时播放一段音频提示，参数为 **音频的uri**
- **Uri.fromFile()**:将文件的路径转化为Uri
- **startForeground(1, builder.build())**:调用该方法会让服务变成前台服务，在系统状态栏显示出来，两个参数为 **id，notification对象**

### 2016年8月4日

#### SMS

- **SmsMessage.createFromPdu()**:将pdu字节数组转换为SmsMessage对象
- **smsMessages[0].getOriginatingAddress()**:用于获取到短信发送方的电话号码
- **message.getMessageBody()**:用于获取短信的内容
- **receiverFilter.setPriority()**:设置receiver的优先级
- **SmsManager.getDefault()**:用于获取SmsManager实例
- **smsManager.sendTextMessage()**:发送短信，五个参数为**接收人手机号码，service center address，短信内容，发送之后回执，接收之后回执**
- **PendingIntent.getBroadcast()**:通过广播获取到一个PendingIntent对象
- **getResultCode()**:获取广播返回的状态

#### AndroidManifest

- **\<uses-permission android:name="android.permission.RECEIVE_SMS" /\>**:声明接收短信的权限
- **\<uses-permission android:name="android.permission.SEND_SMS" /\>**:声明短信发送的权限

### 2016年8月8日

#### Picture

- **Environment.getExternalStorageDirectory()**:获取手机sd卡根目录
- **android.media.action.IMAGE_CAPTURE**:启动相机的隐式action
- **intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)**:设置照片的存储路径
- **com.android.camera.action.CROP**:启动照片裁剪功能action
- **BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri))**:将照片解析成bitmap对象
- **picture.setImageBitmap(bitmap)**:将照片显示到ImageView控件上
- **android.intent.action.GET_CONTENT**:启动文件管理器的action，通过 **intent.setType("image/*")** 限制获取的文件格式

#### Media

- **mediaPlayer.setDataSource(file.getPath())**:设置播放的音频文件的位置
- **mediaPlayer.prepare()**:在开始播放之前调用该方法完成准备工作
- **mediaPlayer.isPlaying()**:判断当前的media player是否正在播放音频
- **mediaPlayer.start()**:开始或继续播放音频
- **mediaPlayer.pause()**:暂停播放音频
- **mediaPlayer.reset()**:将media player重置到初始状态
- **mediaPlayer.stop()**:停止播放音频，调用该方法后，media player无法再播放音频
- **mediaPlayer.release()**:释放掉与media player有关的资源

#### Video

- **videoView.isPlaying()**:判断是否正在播放视频
- **videoView.start()**:开始或继续播放视频
- **videoView.pause()**:暂停播放视频
- **videoView.resume()**:将视频重头开始播放
- **videoView.setVideoPath(file.getPath())**:设置将要播放视频的文件位置
- **videoView.suspend()**:释放videoView所占用的资源

### 2016年8月9日

#### Thread

```
class MyThread extends Thread {

    @Override
    public void run() {
        // 处理具体逻辑
    }
}
```

- **new MyThread().start()**:继承Thread方式来定义一个线程并执行线程中的run()方法

```
class MyThread implements Runnable {

    @Override
    public void run() {
        //处理具体逻辑
    }
}
```

- **new Thread(new MyThread()).start()**:实现Runnable接口的方式来定义一个线程

```
new Thread(new Runnable() {

    @Override
    public void run() {
        //处理具体逻辑
    }
}).start();
```

- 使用匿名类的方式定义一个线程
- **Android中的UI是线程不安全的**:更新UI元素的操作必须在主线程中完成

```
private Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case xxx:
                //更新UI
                break;
            default:
                break;
            }
        }
    };
```

- **handler.sendMessage(message)**:向Handler发送一条Message，在 **handleMessage()** 中进行接收并对UI更新

#### AsyncTask

- **AsyncTask是一个抽象类**:需要创建一个子类继承他，在继承时可以为AsyncTask指定三个泛型参数，分别为**Params,Progress,Result**，并且根据需要，重写内部方法
- **Params**:在执行AsnycTask时需要传入的参数，可用于在后台任务中使用
- **Progress**:后台任务执行时，如果需要在界面上显示当前任务的进度，则使用这里指定的泛型作为进度单位
- **Result**:当任务执行完毕后，如果需要对结果进行返回，则使用这里指定的泛型作为返回值类型
- **onPreExecute()**:任务开始之前调用，用于进行界面上的一些初始化操作，比如显示进度条
- **doInBackground(Params...)**:在子线程中执行该方法，任务完成后可通过return语句来返回任务执行结果，类型与Results相同。如需要在该方法中更新UI，可调用 **publishProgress(Progress...)** 方法来完成
- **onProgressUpdate(Progress...)**:调用了publishProgress(Progress...)方法之后，会很快调用该方法，在该方法中可以对UI进行操作
- **onPostExecute(Result)**:当后台任务return返回之后，会调用该方法。返回的数据会传到该方法中，可以利用这些数据对UI进行操作。

### 2016年8月10日

#### Service

- ![Service生命周期](https://developer.android.com/images/service_lifecycle.png)
- **onCreate()**:该方法会在服务创建的时候调用
- **onStartCommand()**:该方法会在每次启动服务时调用
- **onDestroy()**:该方法会在服务销毁的时候调用
- **startService(intent)**:启动服务
- **stopService(intent)**:停止服务
- **stopSelf()**:在服务中调用，使自身停止
- **Binder**:通过Binder对象，实现活动与服务之间的交互。服务在整个应用程序范围内是通用的，可以和任何一个activity进行绑定
- **ServiceConnection类**:用于活动与服务的绑定和解绑，包含两个方法 **onServiceConnected()和onServiceDisconnected()**
- **onServiceConnected()**:在活动与服务成功绑定后调用
- **onServiceDisconnected()**:在活动和服务成功解绑后调用
- **bindService(bindIntent, connection, BIND_AUTO_CREATE)**:将活动与服务进行绑定，三个参数为 **携带有Service的Intent对象，ServiceConnection实例，标志位** ，调用该方法会回调 **onBind()**方法
- **unbindService(connection)**:解除绑定
- **IntentService**:继承该类的service会在子线程中运行的service，无需担心ANR问题，并且在服务运行完之后会自动关闭，调用 **onDestroy()** 方法
- **onHandleIntent()**:该方法在子线程中运行，用以实现IntentService的逻辑

#### AndroidManifest

- **\<service\>**:注册该服务使之生效

### 2016年8月11日

#### WebView

- **webView.getSettings()**:设置浏览器的一些属性
- **webView.getSettings().setJavaScriptEnabled(true)**:让webview支持JS脚本
- **webView.ysetWebViewClient()**:用于使用webview接收各种通知和请求
- **webView.loadUrl()**:参数为需要打开的网址，调用该方法让webview打开相应的网站

#### Http

##### HttpURLConnection

- **(HttpURLConnection) url.openConnection()**:通过URL对象的openConnection()方法，获取HttpURLConnection实例
- **connection.setRequestMethod("GET")**:设置HTTP请求所是用的方法
- **connection.setConnectTimeout(8000)**:设置连接超时
- **connection.setReadTimeout(8000)**:设置读取超时
- **connection.getInputStream()**:获取服务器返回的输入流
- **connection.disconnect()**:关闭HTTP连接

##### HttpClient

- **SDK23 已经废弃该方法**
- **new DefaultHttpClient()**:获取HttpClient实例
- **new HttpGet()**:创建一个HttpGet对象，发起GET请求
- **httpClient.execute(httpGet)**:访问该网站
- **new HttpPost()**:创建一个HttpPost对象，发起POST请求
- **List\<NameValuePair\>**:创建一个NameValuePair集合，用来存放待POST的参数，并将这个参数集合传入到一个UrlEncodedFormEntity中
- **httpPost.setEntity(entity)**:将构建好的UrlEncodedFormEntity传入httpPost对象中
- **httpResponse.getStatusLine().getStatusCode()**:获取服务器返回的状态码

#### XML

##### XmlPullParser

- **XmlPullParserFactory.newInstance()**:获取一个XmlPullParserFactory实例
- **factory.newPullParser()**:创建一个XmlPullParser对象
- **xmlPullParser.setInput(new StringReader(xmlData))**:将服务器返回的XML数据设置到XmlPullParser对象中
- **xmlPullParser.getEventType()**:获取当前的解析事件
- **XmlPullParser.END_DOCUMENT**:解析事件为该值时，证明解析完成
- **XmlPullParser.START_TAG**:XML一个解析事件开始的标签
- **XmlPullParser.END_TAG**:XML一个解析事件结束的标签
- **xmlPullParser.getName()**:获取当前结点的名字
- **xmlPullParser.nextText()**:获取当前结点的内容
- **xmlPullParser.next()**:获取下一个解析事件

##### SAXParse

- **DefaultHandler类**:继承该类并重写父类的五个方法
- **startDocument()**:在开始解析XML时调用
- **startElement()**:在开始解析某个结点时调用，参数中localName为当前结点名称
- **characters()**:在获取节点中内容的时候调用，需要注意一些换行符的解析也会调用该方法，应做好控制
- **endElement()**:在完成解析某个结点的时候调用
- **endDocument()**:在完成整个XML解析的时候调用
- **SAXParserFactory.newInstance()**:获取SAXParserFactory对象
- **factory.newSAXParser().getXMLReader()**:获取XMLReader对象
- **xmlReader.setContentHandler(handler)**:将DefaultHandler实例设置到XMLReader中
- **xmlReader.parse(new InputSource(new StringReader(xmlData)))**:开始对XML数据进行解析

#### JSON

##### JSONObject

- **new JSONArray(jsonData)**:将网络发回的数据传入到JSONArray对象中
- **jsonArray.getJSONObject(i)**:取出每一个jsonObject对象
- **jsonObject.getString("id")**:根据标签名从jsonObject对象中取出对应数据

##### GSON

- **GSON可以自动将一段JSON格式的字符串映射成一个对象**：创建一个自定义类，并且声明与JSON字段名同名的变量，即可通过GSON自动将JSON解析成该类对象
- **gson.fromJson(jsonData, new TypeToken<List<App>>() {}.getType())**:通过该方法即可将JSON数组解析成需求类型的对象


#### Layout

- **\<WebView\>**:用于显示网页的webview控件
- **\<ScrollView\>**:允许以滚动形式查看屏幕外的那部分内容

#### AndroidManifest

- **\<uses-permission android:name="android.permission.INTERNET" /\>**:获取手机联网的权限

### 2016年8月12日

#### LBS

- **getSystemService(Context.LOCATION_SERVICE)**:获取LocationManager实例
- **locationManager.getProviders(true)**:获取可以使用的位置提供器，三种位置提供器分别为**NETWORK_PROVIDER、GPS_PROVIDER、PASSIVE_PROVIDER**
- **locationManager.getLastKnownLocation(provider)**:将位置提供器传入到该方法，得到一个Location对象
- **location.getLatitude()**:获取纬度信息
- **location.getLongitude()**:获取经度信息
- **locationManager.requestLocationUpdates(provider, 5000, 100, locationListener)**:随时更新位置信息，四个参数为**位置提供器，刷新时间间隔，刷新距离间隔，LocationListener实例**

#### AndroidManifest

- **\<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" /\>**:获取设备当前的位置信息的权限

### 2016年8月17日

#### 实战酷欧天气

### 2016年8月23日

#### 《第一行代码》 Over

---

## 第二部分：进阶篇

### TODO

- RecyclerView
- Cardview
- Paint
- Canvas
- Matrix
- Material Design
- SwipeRefreshLayout
- DrawerLayout
- TabLayout
- Fresco
- MVC
- MVP
- Retrofit
- OkHttp
- RxJava
- RxAndroid
- Volley
- Butter Knife
- WeChat
- QQ
- Weibo
- Otto
- Piccaso
- Glide
- Android-common
- Dagger
- Gson
- Flowlayout
- EventBus
- Timber
- Android-lite-orm
- ijkplayer
