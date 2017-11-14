package com.wmd.utils.toolsutils;

import android.text.TextUtils;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;

/**
 * 时间：2017/11/14/13：40
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class StringUtils {
    /**
     * 判断是否为空（String）
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return TextUtils.isEmpty(value);
    }

    /**
     * 判断是否为空(CharSequence)
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(CharSequence value) {
        return TextUtils.isEmpty(value);

    }

    /**
     * 判断是否为空(EditText)
     *
     * @param editText
     * @return
     */
    public static boolean isEmpty(EditText editText) {
        return TextUtils.isEmpty(editText.getText().toString().trim());
    }


    /**
     * 是否解析ArrayInt
     *
     * @param array
     * @param value
     * @param split
     * @return
     */
    public static boolean parseArrayInt(int[] array, String value, String split) {
        if (array == null || StringUtils.isEmpty(value))
            return false;

        boolean ret = false;
        String[] ss = value.split(split);
        for (int i = 0; i < array.length && i < ss.length; i++) {
            ret = true;
            array[i] = Integer.parseInt(ss[i]);
        }

        return ret;
    }

    /**
     * 是否解析ArrayString
     *
     * @param array
     * @param value
     * @param split
     * @return
     */
    public static boolean parseArrayString(String[] array, String value,
                                           String split) {
        if (array == null || StringUtils.isEmpty(value))
            return false;

        boolean ret = false;
        String[] ss = value.split(split);
        for (int i = 0; i < array.length && i < ss.length; i++) {
            ret = true;
            array[i] = ss[i];
        }

        return ret;
    }

    /**
     * 对比两个String是否相等
     *
     * @param compa
     * @param compb
     * @return
     */
    public static boolean isEqual(String compa, String compb) {
        if (compa == null || compb == null) return false;

        return compa.equals(compb);
    }

    /**
     * 去除字符串尾部空格
     *
     * @param str
     * @return
     */
    public static String trimEnd(String str) {
        return str.replaceAll("[\\s]*$", "");
    }

    /**
     * 将字符串中所有的非标准字符（双字节字符）替换成两个标准字符（**，或其他的也可以）
     *
     * @param str
     * @return
     */
    public static String convert(String str) {
        return str.replaceAll("[^\\x00-\\xff]", "**");
    }

    /**
     * 获取UTF8Dom
     *
     * @return
     */
    public static String getUTF8Dom() {
        byte[] buffer = new byte[3];
        buffer[0] = (byte) 0xEF;
        buffer[1] = (byte) 0xBB;
        buffer[2] = (byte) 0xBF;

        try {
            return new String(buffer, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 复制
     *
     * @param src
     * @param dest
     * @return
     */
    public static boolean copyString(String[] src, String[] dest) {
        if (src == null || dest == null)
            return false;

        for (int i = 0; i < dest.length; i++) {
            dest[i] = "";
        }

        for (int i = 0; i < dest.length && i < src.length; i++) {
            dest[i] = src[i];
        }

        return true;
    }

    /**
     * 获取Url名称
     *
     * @param url
     * @return
     */
    public static String getUrlName(String url) {
        if (StringUtils.isEmpty(url))
            return "";

        int index = url.indexOf("?");
        if (index > 0)
            url = url.substring(0, index);

        index = url.lastIndexOf("/");
        if (index < 0)
            index = url.indexOf("\\");

        if (index < 0)
            return url;

        return url.substring(index + 1);
    }

    /**
     * 时间转换
     *
     * @param tm
     * @return
     */
    public static String getTime(int tm) {
        int h = tm / 3600;
        int m = tm / 60;
        int s = tm % 60;

        if (h > 0)
            return String.format("%02d:%02d:%02d", h, m, s);

        else if (m > 0)
            return String.format("%02d:%02d", m, s);

        return String.format("%02d", s);
    }

    /**
     * String转换成Double
     *
     * @param value
     * @param default_value
     * @return
     */
    public static double parseDouble(String value, double default_value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return default_value;
    }

    /**
     * 转化成Int
     *
     * @param value
     * @return
     */
    public static int parseInt(String value) {
        if (isEmpty(value))
            return 0;

        try {
            return Integer.parseInt(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    /**
     * 转换成Long
     *
     * @param value
     * @param default_value
     * @return
     */
    public static long parseLong(String value, long default_value) {
        try {
            return Long.parseLong(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return default_value;
    }


    /**
     * String转成Int
     *
     * @param value
     * @param default_value
     * @return
     */
    public static int parseInt(String value, int default_value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return default_value;
    }

    /**
     * 截取字符串
     *
     * @param src
     * @param find
     * @param second
     * @return
     */
    public static String subString(String src, String find, int second) {
        int index = -find.length(), n = 0;
        do {
            int end = src.indexOf(find, index + find.length());
            if (end < 0) break;

            n++;
            index = end;
            if (n == second) return src.substring(0, index);

        } while (index > 0 && n < second);

        return src;
    }


}
