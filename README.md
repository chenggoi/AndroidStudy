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

- 在**<application></application>**标签中注册当前活动
            <activity
                android:name=".MainActivity"
                android:label="This is MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

- **android:name**:具体注册的活动名称
- **android:label**:程序的快捷方式名称
- **<action android:name="android.intent.action.MAIN" />**:声明该活动为主活动，打开app的第一页面
- **<category android:name="android.intent.category.LAUNCHER" />**:该程序会显示在程序列表中，即创建图标
- **<data android:scheme="http"/>**:定义该活动能够相拥的数据协议，http是网络协议，geo是地理位置，tel是电话
###Intent
- **Intent intent = new Intent(MainActivity.this, SecondActivity.class)**:显式Intent的创建，构造函数的两个参数为**Context,目标活动**
- **startActivity(intent)**:通过该方法执行intent，打开第二个活动，按back建即可返回
- **startActivityForResult(intent, 1)**:启动活动，并在活动销毁时返回一个结果给上一个活动
- **Intent intent = new Intent("com.chenggoi.androidstudy.ACTION_START")**:隐式Intent的创建，通过**<action>标签**来确定开启的活动，只有在活动包含的action标签吻合时，才会启动
- **intent.addCategory()**:添加一个**category*，只有在category也对应上时才能打开该活动。一个活动只能有**一个**action，但是可以有**多个**category
- **Intent.ACTION_VIEW**:系统内置的action，用于启动浏览器
- **Intent.ACTION_DIAL**:系统内置的action，用于启动拨号界面
- **intent.setData(Uri.parse("http://chenggoi.com"))**:将网址的uri信息绑定到intent上传递给要打开的应用
- **intent.putExtra("extera_data",data)**:通过intent传递信息，两个参数分别为**信息标签，信息内容**
- **getIntent()**:获取用于启动Activity的Intent
- **intent.getStringExtra()**:获取intent中包含的指定类型指定标签的数据
- **setResult(RESULT_OK,intent)**:将intent返回给上一个活动，只有在该活动被销毁时才会调用，并触发上一个活动的onActivityResult()方法
- **onActivityResult()**:通过重写该方法处理活动销毁时返回的信息，该方法的三个参数为**启动第二活动时传入的请求码，返回数据时传入的处理结果，携带着返回数据的intent**，可以根据三个参数，判断数据来源，处理结果是否成功，并将intent中的数据取出







