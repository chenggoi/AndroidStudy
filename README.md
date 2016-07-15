# AndroidStudy


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















