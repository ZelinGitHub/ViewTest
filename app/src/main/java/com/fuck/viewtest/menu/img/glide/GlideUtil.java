package com.fuck.viewtest.menu.img.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * 在Glide 3当中，像placeholder()、error()、diskCacheStrategy()等等一系列的API，都是直接串联在Glide三步走方法中使用的。
 * 而Glide 4中引入了一个RequestOptions对象，将这一系列的API都移动到了RequestOptions当中。
 * 这样做的好处是可以使我们摆脱冗长的Glide加载语句，而且还能进行自己的API封装，因为RequestOptions是可以作为参数传入到方法中的。
 * 比如可以写出这样的Glide加载工具类：
 */
public class GlideUtil {

    public static void load(Context context,
                            String url,
                            ImageView imageView,
                            RequestOptions options) {
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }
}
