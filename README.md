# Android 5.0 共享元素动画学习

最近在网上看了关于共享元素动画的一些文章，和官方的关于共享元素动画的Demo，可自己动手做的时候却也发现一些坑，这里也做了一个小例子，希望能帮助下还没开始研究的小伙伴们，快速理解下共享元素动画的步骤。

废话不多说，直接入正题（不想听我啰嗦的直接拖到最下面跳转Github获取Demo代码吧 (っ'-')╮ ）。

---

本Demo由两个Activity组成，一个负责显示列表图片（起始Activity）。另一个则负责显示点击后的大图（目标Activity），以下的起始和目标均表示这两个Activity。

### 1. Demo预览

图片较大，如果加载不出来请从Github保存到本地再预览。

https://github.com/ijero/ShareElementDemo/blob/master/imgs/Demo.gif

![](https://github.com/ijero/ShareElementDemo/blob/master/imgs/Demo.gif)

### 2. Activity主题配置

配置代码：

	<item name="android:windowContentTransitions">true</item>

最后在目标的Activity中配置Window属性，使其支持`Transition`：

    getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    getWindow().setExitTransition(new Explode());

AndroidManifest.xml

`MainActivity`

	<activity
        android:label="@string/app_name"
        android:name=".MainActivity"
        android:theme="@style/TransitionTheme">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>

`DetailActivity`

    <activity
        android:label="@string/str_picture_detail"
        android:name=".DetailActivity"
        android:theme="@style/TransitionTheme" />

可以看到两个Activity的主题是引用的同一个Style：

	android:theme="@style/TransitionTheme" 

下面看看这个相关的主题配置`values-v21/styles.xml`： 

	<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

    <style name="TransitionTheme" parent="AppTheme">
        <item name="android:windowContentTransitions">true</item>
    </style>

下面看看这个相关的主题配置`values/styles.xml`： 

	<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

    <style name="TransitionTheme" parent="AppTheme" />

这里注意一下，这个Style为什么要复制一遍到`values`的`styles.xml`?

原因是保证在低于Android L的版本上也能找到这个style，所以复制一遍style，但是留空就行。

```
注意：用来做共享元素动画的Activity的主题（Theme）必须继承自android:Theme.Material.XXX。
即是因为Material Design引入的，所以在V21的以上的版本主题包下才有这个主题。
我们平时使用的Theme.AppCompat.Light.DarkActionBar，
它的V21包对应的正是继承自Theme.Material.Light.NoActionBar，
所以默认在V21版本以上能支持共享元素动画。
```

至此，配置主题完毕。

### 2. 声明共享元素

配置代码（java方式）：

	view.setTransitionName("shareElementName");

配置代码（xml方式）:

	android:transitionName="shareElementName"

以上方式选一即可。

注意：两个Activity的共享控件的`TransitionName`要保持一致！

要在两个Activity之间进行元素共享，那么就要明确要进行共享的是什么元素，是一个TextView？Button？还是ImageView等等。。。所以要在两个不同的Activity中共享控件View要有同样的标识。这里我这个Demo就以共享一个ImageView为例，共享其他控件也是同一个道理。

这里起始的控件是RecyclerView中的ItemView。

起始配置：`ImageAdapter`

	private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	    ImageView imgView;
	
	    ViewHolder(View itemView) {
	        super(itemView);
	
	        imgView = (ImageView) itemView.findViewById(R.id.iv_item_image);
	        imgView.setTransitionName(Contract.SHARED_IMAGE_ELEMENT_NAME);
	        imgView.setOnClickListener(this);
	    }
	
	    @Override
	    public void onClick(View v) {
	        if (onItemClickListener == null) {
	            return;
	        }
	        int position = getAdapterPosition();
	        onItemClickListener.onClickItem(v, position, imgs.get(position));
	    }
	}

目标配置：

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
	    getWindow().setExitTransition(new Explode());
	    setContentView(R.layout.activity_detail);
	
	    ImageView imageView = (ImageView) findViewById(R.id.iv_detail);
	    ViewCompat.setTransitionName(imageView, Contract.SHARED_IMAGE_ELEMENT_NAME);
	
	    // ...
	}

Xml配置的方式也比较简单，就是在两个Activity的布局文件中为要共享的控件加上`android:transitionName="shareElementName"`属性即可。这里我贴一下例子代码：

	<ImageView
        android:transitionName="@string/share_image"
        android:id="@+id/iv_detail"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_margin="10dp"
        android:layout_weight="1"
        android:scaleType="centerCrop" />

### 3.开启动画

起始的跳转代码：

	Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, Contract.SHARED_IMAGE_ELEMENT_NAME).toBundle();
	ActivityCompat.startActivity(this,intent, options);

主要要讲一下这个`ActivityOptionsCompat.makeSceneTransitionAnimation`，该方法是对共享元素的封装配置。先看看源码：

	public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity,
            View sharedElement, String sharedElementName) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompat.ActivityOptionsImpl24(
                    ActivityOptionsCompat24.makeSceneTransitionAnimation(activity,
                            sharedElement, sharedElementName));
        } else if (Build.VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompat.ActivityOptionsImpl23(
                    ActivityOptionsCompat23.makeSceneTransitionAnimation(activity,
                            sharedElement, sharedElementName));
        } else if (Build.VERSION.SDK_INT >= 21) {
            return new ActivityOptionsCompat.ActivityOptionsImpl21(
                    ActivityOptionsCompat21.makeSceneTransitionAnimation(activity,
                            sharedElement, sharedElementName));
        }
        return new ActivityOptionsCompat();
    }

参数：

	第一个参数：上下文Activity。
	第二个参数：共享元素在起始界面是哪一个View。
	第三个参数：共享元素标识的`setTransitionName`。

可以看出这是在针对不同的版本进行不同数据的封装，如果版本小于21，就不进行封装，直接返回`ActivityOptionsCompat`对象，那么也就是说在版本小于21的系统上，并不做什么操作。

接下来就是使用`toBundle()`方法得到封装之后的Bundle对象，这里直接点击查看源码会发现返回null，其实具体的返回对象是在不同版本的封装实现类里面，这里就不赘述了，只是提醒下别在这里犯懵。

我们在平时启动一个Activity，传递一些数据就是往`Intent`对象中put一堆数据，如String、Integer、Boolean数据等等，其中有时候也用到Bundle来传递一些特殊的数据。

`ActivityCompat`这个类，是为了同时兼容高低版本的Activity辅助类，里面封装了一些Activity相关操作的方法。这里顺便提及一下，为兼容低版本提供的类还有其他的，如：`ContextCompat`、`ViewCompat`、`ResourcesCompat`等等，平时使用这些API，如`ResourcesCompat`获取资源文件的话，能够提升兼容性问题。这些支持API均在`android.support.v4`里面。

我的跳转代码示例：

    @Override
    public void onClickItem(View view, int position, ImageBean.ImgsBean imgsBean) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache();

        byte[] bitmapByte = bitmap2Bytes(bitmap);
		
        intent.putExtra("bitmap", bitmapByte);
        intent.putExtra("imageUrl", imgsBean);
        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, Contract.SHARED_IMAGE_ELEMENT_NAME).toBundle();
        ActivityCompat.startActivity(this,intent, options);
        view.setDrawingCacheEnabled(false);
    }

这里传递的数据量有点大，可以看到传递了一个完整的JavaBean和一个Bitmap的字节数组，这样其实是很不好的。然后由于人懒，就没做太多细分参数的操作，本来目标Activity就只是用到了图片和标题，可以直接传递一个字符串和图片URL的。

在目标的Activity中，如果使用了url再重新加载一遍图片，会重新刷新一遍这个控件，会闪烁一下，所以推荐本地处理，可以先将图片保存到本地，在列表中加载本地的图片，在目标Activity中也加在本地的图片就行。

### 4. 总结

实现一个共享元素动画的步骤：

	1. 配置主题和目标的Activity
	2. 配置起始和目标的共享元素名称，并保持一致。
	3. 配置启动目标时的参数。

Github传送门：

<a href="https://github.com/ijero/ShareElementDemo">https://github.com/ijero/ShareElementDemo</a>

