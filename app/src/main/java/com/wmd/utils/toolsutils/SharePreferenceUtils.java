package com.wmd.utils.toolsutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 时间：2017/10/26/14：31
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：SharePreference数据缓存工具
 * 声明：版权归作者所有
 */

public class SharePreferenceUtils {
    //保存在手机里的文件名
    public static final String SP_FILENAME = "sharepreference_data";

    /**
     * 保存数据的方法，根据不同的数据类型进行保存
     *
     * @param mC  上下文
     * @param key 键
     * @param val 需要保存的值
     */
    public static void putSharePreference(Context mC, String key, Object val) {
        SharedPreferences sp = mC.getSharedPreferences(SP_FILENAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if (val instanceof String) {
            editor.putString(key, (String) val);
        } else if (val instanceof Integer) {
            editor.putInt(key, (Integer) val);
        } else if (val instanceof Float) {
            editor.putFloat(key, (Float) val);
        } else if (val instanceof Long) {
            editor.putLong(key, (Long) val);
        } else if (val instanceof Boolean) {
            editor.putBoolean(key, (Boolean) val);
        } else {
            editor.putString(key, val.toString());
        }
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 根据键值获取对应的保存的数据
     *
     * @param mC         上下文
     * @param key        键
     * @param defaulyVal 默认值
     * @return 获取的值
     */
    public static Object getSharePreference(Context mC, String key, Object defaulyVal) {
        SharedPreferences sp = mC.getSharedPreferences(SP_FILENAME,
                Context.MODE_PRIVATE);
        if (defaulyVal instanceof String) {
            return sp.getString(key, (String) defaulyVal);
        } else if (defaulyVal instanceof Integer) {
            return sp.getInt(key, (Integer) defaulyVal);
        } else if (defaulyVal instanceof Float) {
            return sp.getFloat(key, (Float) defaulyVal);
        } else if (defaulyVal instanceof Long) {
            return sp.getLong(key, (Long) defaulyVal);
        } else if (defaulyVal instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaulyVal);
        }
        return null;
    }

    /**
     * 移除对应某个键值的数据
     *
     * @param mC  上下文
     * @param key 值
     */
    public static void removKey(Context mC, String key) {
        SharedPreferences sp = mC.getSharedPreferences(SP_FILENAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 移除所有键所保存的对应的值
     *
     * @param mC 上下文
     */
    public static void removeAllKey(Context mC) {
        SharedPreferences sp = mC.getSharedPreferences(SP_FILENAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILENAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }


    /**
     * 保存图片
     *
     * @param mC  上下文
     * @param key 键
     * @param iv  需要保存的图片
     */
    public static void putImg(Context mC, String key, ImageView iv) {
        BitmapDrawable bd = (BitmapDrawable) iv.getDrawable();
        Bitmap bitmap = bd.getBitmap();
        //将图片转换成字节数组输出流
        ByteArrayOutputStream byStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byStream);
        //将字数组流转成String
        byte[] byteArray = byStream.toByteArray();
        String imgString = new String(Base64.encodeToString(byteArray, Base64.DEFAULT));
        SharePreferenceUtils.putSharePreference(mC, key, imgString);
    }

    /**
     * 获取图片
     *
     * @param mC
     * @param key
     * @return
     */
    public static Bitmap getImg(Context mC, String key) {
        String imgString = (String) SharePreferenceUtils.getSharePreference(mC, key, "");
        if (!imgString.equals("")) {
            byte[] byteArray = Base64.decode(imgString, Base64.DEFAULT);
            ByteArrayInputStream byStream = new ByteArrayInputStream(byteArray);
            // 生成bitmap
            return BitmapFactory.decodeStream(byStream);
        }
        return null;
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     */
    private static class SharedPreferencesCompat
    {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
        private static Method findApplyMethod()
        {
            try
            {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e)
            {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         */
        public static void apply(SharedPreferences.Editor editor)
        {
            try
            {
                if (sApplyMethod != null)
                {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e)
            {
            } catch (IllegalAccessException e)
            {
            } catch (InvocationTargetException e)
            {
            }
            editor.commit();
        }
    }

}
