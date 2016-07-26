# AndroidStudy

##注：学习笔记源于《第一行代码》，感谢作者

##2016年7月11日
###Activity
- **setContentView(R.layout.xxx)**:为当前活动加载一个布局
- **requestWindowFeature(Window.FEATURE_NO_TITLE)**:隐藏标题栏，需要在setContentView之前运行，否则会报错
- **findViewById()**:通过传入布局元素的id来获取该元素，该方法返回的是一个View对象，需要对其进行向下转型转换成需要的元素对象类型
- **setOnClickListener()**:为按钮添加点击事件，点击按钮时会触发**onClick()**方法
- **Toast.makeText().show()**:显示一条Toast消息，makeText中需要的三个参数为**Context,消息内容，消息显示时长**
- **onCreateOptionsMenu()**:在活动中创建一个菜单，通过**getMenuInflater().inflate(R.menu.main, menu)**将菜单布局文件绑定到Menu对象上
- **onOptionsItemSelected()**:执行Menu中item的点击事件，通过**item.getItemId()**来判断点击的按钮
- **finish()**:销毁当前活动


###Layout

- **android:id="@+id/xx"**:设置当前元素id，可通过R.id.xx调用
- **android:layout_width="match_parent"**:设置当前元素宽度与父元素一样宽
- **android:layout_height="wrap_content"**:设置当前元素高度为刚好包含元素内容的高度
- **android:text="xxx"**:设置元素中显示的文字内容

###AndroidManifest

- 在**\<application\>\</application\>**标签中注册当前活动

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

###Intent

- **Intent intent = new Intent(MainActivity.this, SecondActivity.class)**:显式Intent的创建，构造函数的两个参数为**Context,目标活动**
- **startActivity(intent)**:通过该方法执行intent，打开第二个活动，按back建即可返回
- **startActivityForResult(intent, 1)**:启动活动，并在活动销毁时返回一个结果给上一个活动
- **Intent intent = new Intent("com.chenggoi.androidstudy.ACTION_START")**:隐式Intent的创建，通过**<action>标签**来确定开启的活动，只有在活动包含的action标签吻合时，才会启动
- **intent.addCategory()**:添加一个**category**，只有在category也对应上时才能打开该活动。一个活动只能有**一个**action，但是可以有**多个**category
- **Intent.ACTION_VIEW**:系统内置的action，用于启动浏览器
- **Intent.ACTION_DIAL**:系统内置的action，用于启动拨号界面
- **intent.setData(Uri.parse("http://chenggoi.com"))**:将网址的uri信息绑定到intent上传递给要打开的应用
- **intent.putExtra("extera_data",data)**:通过intent传递信息，两个参数分别为**信息标签，信息内容**
- **getIntent()**:获取用于启动Activity的Intent
- **intent.getStringExtra()**:获取intent中包含的指定类型指定标签的数据
- **setResult(RESULT_OK,intent)**:将intent返回给上一个活动，只有在该活动被销毁时才会调用，并触发上一个活动的onActivityResult()方法
- **onActivityResult()**:通过重写该方法处理活动销毁时返回的信息，该方法的三个参数为**启动第二活动时传入的请求码，返回数据时传入的处理结果，携带着返回数据的intent**，可以根据三个参数，判断数据来源，处理结果是否成功，并将intent中的数据取出

##2016年7月12日

###AndroidManifest

- **android:theme**:用于给当前活动指定主题
- **android:launchMode**:用于给当前活动设置启动模式，启动模式包括**satndard、singleTop、singleTask、singleInstance**
- **standard**:活动启动的默认模式，系统不会判断这个活动是否在返回栈中存在，每次启动都会创建该活动的一个新的实例
- **singleTop**:当活动已经在栈顶时，再次启动该活动不会创建一个新的实例，而是直接使用栈顶的该活动。当该活动不在栈顶时，再次启动会创建一个新的实例
- **singleTask**:系统会检测栈中是否含有该活动，如果有则将该活动之后的所有活动统统出栈，如果没有则会创建一个新的活动
- **singleInstance**:该活动会单独启用一个新的返回栈来管理这个活动，不论哪个应用访问该活动，该活动都会共用同一个返回栈，解决了共享活动实例的问题


###Layout

- **\<TextView\>**：显示一段文本信息
- **android:gravity**:指定文字的对齐方式，可选值有**top、bottom、left、right、center**等，可以用|来同时指定多个值
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

###Activity

- **生命周期**：onCreate、onStart、onResume、onPause、onStop、onDestory、onRestart

![Activity生命周期][https://developer.android.com/images/training/basics/basic-lifecycle.png]

- **Bundle类型**:提供了一系列方法用于保存数据，如**putString()**方法保存字符串。每个保存方法需传入两个参数，一个是一个参数是键，用于从Bundle中取值，另一个是要保存的内容
- **onSaveInstanceState()**:用于在活动被系统回收前保存活动中的数据，将数据存于Bundle类型的变量中，等到活动再次调用onCerate时作为参数传入，并携带有之前保存的全部数据
- **getClass().getSimpleName()**:获取当前实例的类名
- **editText.getText()**:获取EditText输入的内容
- **imageView.setImageResource()**:设置ImageView中显示的图片
- **getVisibility()**:获取元素的可见性
- **setVisibility()**:设置元素的可见性，可选值为**View.VISIBLE、View.INVISIBLE、View.GONE**
- **AlertDialog.Builder**:创建一个AlertDialog实例
- **dialog.setTitle()**:设置dialog标题
- **dialog.setMessage()**:设置dialog的内容
- **dialog.setCancelable()**:是否可以点击dialog以外区域取消
- **dialog.setPositiveButton()**:为确定按钮设置点击事件
- **dialog.setNegativeButton()**:为取消按钮设置点击事件
- **dialog.show()**:显示dialog
- **ProgressDialog**:创建一个带进度条的dialog
- **dialog.dismiss()**:关闭dialog

##2016年7月13日

###Layout

- **LinearLayout**:线性布局，将所包含的控件在线性方向上依次排列
- **android:orientation**:指定布局的排列方向，**vertical**为垂直排列，**horizontal**为水平排列，默认值为水平排列
- **android:layout_gravity**:控件在布局中的对齐方式。当布局为**horizontal**时，只有垂直方向的对齐方式会生效，反之亦然
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

##2016年7月15日

###Layout

- **android:background**:为控件或布局指定一个背景，可以使用颜色或者图片来填充
- **android:layout_margin**:指定控件在上下左右方向上的偏移距离，也可以使用**marginTop**等来指定特定方向的偏移距离

###自定义控件

- **TitleLayout继承自LinearLayout**，重写其构造函数，当布局被调用时会调用该构造函数，并执行其中对于控件的操作
- **LayoutInflater.from(context).inflate(R.layout.title, this)**:通过LayoutInflater的from()方法，构建一个LayoutInflater对象，然后调用inflate()方法动态加载一个布局文件。两个参数为**要加载的布局文件id，加载好的布局文件的父布局**
- 通过指定**完整包名**在其他布局中添加该自定义控件

```

    <com.chenggoi.androidstudy.TitleLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </com.chenggoi.androidstudy.TitleLayout>

```

##2016年7月19日

###Layout

- **\<ListView\>**:列表控件
- **px**:以像素为单位
- **pt**:以磅为单位，以上两种单位会存在因屏幕分辨率不同而产生的适配问题，因此多用于文字
- **dp**:密度无关像素，也称作**dip**，在不同密度(屏幕每英寸所包含的像素数，通常以dpi为单位)的屏幕中的显示比例保持一直。根据Android规定，在160dpi的屏幕上，1dp=1px，在320dpi的屏幕上，1dp=2px。
- **sp**:可伸缩像素，采用与dp相同的设计理念来解决文字大小的适配问题


###Activity

- **ArrayAdapter\<\>**:通过泛型来指定适配器的类型，并在构造函数中将适配的数据传入即可
- **listView.setAdapter()**:将构建好的适配器对象传递进去，建立ListView与数据之间的关联
- **listView.setOnItemClickListener()**:为ListView上的Item注册一个监听器，对item的点击事件进行监听。在**onItemClick()**方法中，可以根据position来判断用户点击的是哪一个item子项。
- **getResources().getDisplayMetrics().xdpi**:获取x轴方向上的屏幕密度
- **getResources().getDisplayMetrics().ydpi**:获取y轴方向上的屏幕密度

###Adapter

- **getView()**:重写Adapter的该方法，该方法在每个子项被滚动到的时候会被调用，并返回每个子项的布局。其参数中的**convertView**用于将之前加载好的布局进行缓存，以便日后进行重用，提高效率
- **getItem()**:通过该方法可以得到当前子项的实例
- **LayoutInflater.from()**:该方法用于为该子项加载传入的布局
- **imageView.setImageResource**:设置显示的图片
- **textView.setText**:设置显示的文字
- **提高ListView加载效率**:对控件实例进行缓存。创建一个ViewHolder类，将全部控件实例放于其中，然后调用View的setTag()方法，将ViewHolder对象储存在View中。当convertView不为空时调用View的getTag()方法将ViewHolder重新取出，省去每次都要findViewById().

##2016年7月22日

###Layout

- **\<fragment\>**:碎片布局
- **android:name**:显式指明需要添加的碎片类名
- **限定符**:通过对layout进行限定，来根据设备屏幕大小动态加载布局，如**layout-large**,**layout-ldpi**,**layout-land**分别对应屏幕大小、屏幕分辨率、屏幕横竖屏
- **android:padding**:给控件的周围加上补白，使文本不会紧靠在边缘上
- **android:singleLine**:设置为true时表示文字单行显示
- **android:ellipsize**:设定当文本超出控件宽度时的缩略方式，可选值有**start(省略号在开头)、end(省略号在结尾)、middle(省略号在中间)、marquee(获取焦点时，以跑马灯的形式滚动显示)**

###Fragment

- **onCreateView()**:与Activity的onCreate()方法作用相同,为碎片加载布局时调用
- **getActivity()**:获取与当前碎片关联的活动实例，从而调用活动中的方法。而且当fragment中需要context对象时，也可以使用该方法
- **onAttach()**:当碎片和活动建立关联的时候调用
- **onActivityCreated()**:确保与碎片相关联的活动已经创建完毕的时候调用
- **onDestoryView()**:当与碎片关联的视图被移除的时候调用
- **onDetach()**:当碎片和活动解除关联的时候调用

![Fragment生命周期][https://developer.android.com/images/fragment_lifecycle.png]

###Activity

- **getFragmentManager()**:获取FragmentManager实例
- **fragmentManager.beginTransaction()**:开启一个fragment事物，用于对fragment进行添加,移除,替换,以及执行其他动作
- **transaction.replace()**:向容器内添加碎片，两个参数为**传入容器的id，待添加的碎片实例**
- **transaction.commit()**:提交执行事务
- **transaction.addToBackStack()**:接收一个名字用于描述返回栈的状态，当按下back键时，不会直接退出fragment页面，而是返回上一个fragment页面
- **fragmentManager.findFragmentById()**:通过布局ID来获取Fragment实例，从而调用Fragment中的方法

##2016年7月26日

###Broadcast

- **标准广播(Normal broadcasts)**:完全异步执行的广播，在广播发出后，所有的广播接收器几乎都会在同一时间接收到这条广播信息。效率比较高但是无法被截断
- **有序广播(Ordered broadcasts)**:同步执行广播，在广播发出后，同一时刻只会有一个广播接收器能够收到这条消息，当这个广播接收器中的逻辑执行完毕后，广播才会继续传递。此时广播有优先级顺序，优先级高的接收器可以对广播进行截断
- **BroadcastReceiver**:广播接收者，当接收到广播时，会执行onRecive()方法，在onReceive()方法中，尽量不要执行过多操作，否则长时间没有结束会报错
- **intentFilter.addAction("")**:添加要监听的广播的action
- **registerReceiver()**:对Receiver进行动态注册，将Receiver实例和IntentFilter实例都传进去
- **unregisterReceiver()**:动态注册的广播必须在onDestory()方法中调用该方法取消注册
- **getSystemService()**:获取系统服务的实例
- **connectivityManager.getActiveNetworkInfo()**:得到NetworkInfo实例
- **networkInfo.isAvailable()**:判断当前是否有网络
- **sendBroadcast()**:发送一条标准广播，参数为**指定了action的Intent实例**
- **sendOrderedBroadcast()**:发送一条有序广播，参数为**Intent,与权限相关的字符串**
- **abortBroadcast()**:将该条广播截断，后面的广播接收器无法再收到该条广播
- **LocalBroadcastManager.getInstance()**:获取一个LocalBroadcastManager的实例，用于管理本地广播。本地广播只能在同一个程序内被接收，并且无法通过静态注册的方式来接收
- **localBroadcastManager.sendBroadcast()**:发送本地广播
- **localBroadcastManager.registerReceiver()**:注册本地广播
- **localBroadcastManager.unregisterReceiver()**:销毁本地广播

###AndroidManifest

- **\<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /\>**:添加查询系统网络状态的权限
- **\<receiver\>**:静态注册广播接收器，通过**android:name**指定具体注册哪一个广播接收器，**\<intent-filter\>**标签内加入想要接收的广播
- **\<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /\>**:添加监听系统开机广播的权限
- **android:priority**:为广播接收器设置优先级，有序广播会按照优先级顺序进行接收










