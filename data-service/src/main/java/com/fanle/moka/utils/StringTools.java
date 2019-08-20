package com.fanle.moka.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//import java.util.Arrays;
//import java.util.List;

/**
 * Description:字符串工具类
 *
 * @author maixingjie
 * @date 2013-7-30
 */
public final class StringTools {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

//	/**
//	 * 16进制字符
//	 */
//	private static final char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    /**
     * 10进制2位小数格式
     */
    private static final Format numformat = new DecimalFormat("#.##");
    /**
     * 用于长度补位
     */
    private static final String zeros = "00000000000000000000";
    /**
     * 需要进行过滤并替换的sql字符
     */
    private static final String[][] sqlhandles = {{"'", "''"}, {"\\\\", "\\\\\\\\"}};


    // ===========================================================
    // Constructors
    // ===========================================================
    private StringTools() {
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * Description:判断某个字符串是否包含在某个数组中。如果数组为null则返回false
     *
     * @param str
     * @param array
     * @return
     * @author maixingjie
     * @date 2013-7-30
     */
    public static boolean isContainsString(String str, String[] array) {
        if (array == null) {
            return false;
        }
        for (String s : array) {
            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description:从一个流中指定字符集读取字符串
     *
     * @param in      InputStream 输入流
     * @param charset String 字符集
     * @return String
     * @throws IOException
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String read(InputStream in, String charset) throws IOException {
        int pos = -1;
        byte[] buf = new byte[1024 * 8];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((pos = in.read(buf)) != -1) {
            out.write(buf, 0, pos);
        }
        return (charset == null) ? new String(out.toByteArray()) : new String(out.toByteArray(), charset);
    }

    /**
     * Description:从一个流中指定字符集读取字符串
     *
     * @param in InputStream 输入流
     * @return String
     * @throws IOException
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String read(InputStream in) throws IOException {
        return read(in, null);
    }

    /**
     * Description:返回全局唯一序列号，模拟Sql Server的newid()函数功能
     *
     * @return String 唯一id
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String createSequence() {
        return UUID.randomUUID().toString();
    }

    /**
     * Description:转换成js代码
     *
     * @param unicode String
     * @return
     * @author maixingjie
     * @date 2013-7-30
     */
//    public static final String escapeJs(String unicode) {
//        return org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(unicode);
//    }
//
//    /**
//     * Description:转换成html代码
//     *
//     * @param unicode String
//     * @return
//     * @author maixingjie
//     * @date 2013-7-30
//     */
//    public static final String escapeHtml(String unicode) {
//        return org.apache.commons.lang.StringEscapeUtils.escapeHtml(unicode);
//    }

    /**
     * Description:将字符串中可能包含有非法的sql字符进行过滤，例如过滤'。
     *
     * @param str String 需要进行过滤的字符串
     * @return String 过滤后的安全字符串
     * @author maixingjie
     * @date 2013-7-30
     */
    public static final String escapeSql(String str) {
        if (str == null) {
            return "";
        }
        for (String[] ss : sqlhandles) {
            str = str.replaceAll(ss[0], ss[1]);
        }
        return str;
    }

    /**
     * Description:将字符串中可能包含有非法的sql字符进行过滤，例如过滤'。
     *
     * @param obj Object过滤对象
     * @return String 过滤后的安全字符串
     * @author maixingjie
     * @date 2013-7-30
     */
    public static final String escapeSql(Object obj) {
        if (obj == null) {
            return "";
        }
        return escapeSql(obj.toString());
    }

    /**
     * Description:对字符进行URL编码。客户端使用js的decodeURIComponent进行解码
     *
     * @param str String 字符串源码
     * @return String URL编码后的字符串
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String encodeURL(String str) {
        try {
            return java.net.URLEncoder.encode(str, "utf-8").replaceAll("\\+", "%20");
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Description:对url进行解码
     *
     * @param str String 字符串源码
     * @return String URL解码后的字符串
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String decodeURL(String str) {
        try {
            return java.net.URLDecoder.decode(str, "utf-8");
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Description:判断字符串是否为空
     *
     * @param str String 要判断的字符串对象
     * @return boolean
     * @author maixingjie
     * @date 2013-7-30
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Description:判断字符串是否为非空
     *
     * @param str String 要判断的字符串对象
     * @return boolean
     * @author maixingjie
     * @date 2013-7-30
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * Description:将数值转换成特定长度的字符串(前面补0)
     *
     * @param value  long 数值
     * @param length ing 指定的位数长度
     * @return
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String toLenString(long value, int length) {
        String val = value + "";
        if (val.length() > length) {
            throw new RuntimeException("定义的长度小于数值的长度。");
        }
        if (val.length() < length) {
            return zeros.substring(0, length - val.length()) + val;
        } else {
            return val;
        }
    }

    /**
     * Description:转换成用B,KB,MB,GB,TB单位来表示的大小
     *
     * @param sizes long 大小数值
     * @return String
     * @author maixingjie
     * @date 2013-7-30
     */
    public static String formatFileLength(long sizes) {
        if (sizes < 0) sizes = 0;
        String str = "";
        if (sizes < 1024) { // 小于1KB
            str += "" + sizes + "B";
        } else if (sizes < 1024 * 1024) { // 小于1MB
            str += "" + numformat.format(sizes / 1024.0) + "K";
        } else if (sizes < 1024 * 1024 * 1024) {  // 小于1GB
            str += "" + numformat.format(sizes / (1024 * 1024.0)) + "M";
        } else if (sizes < 1024 * 1024 * 1024 * 1024L) {  // 小于1TB
            str += "" + numformat.format(sizes / (1024 * 1024 * 1024.0)) + "G";
        } else {  // 大于1TB
            str += "" + numformat.format(sizes / (1024 * 1024 * 1024 * 1024.0)) + "T";
        }
        for (int i = 0; i < 8 - str.length(); i++) {
            str = " " + str;
        }
        return str;
    }

//	/**
//	 * Description:得到系统的时间戳
//	 *
//	 * @return
//	 * @author maixingjie
//	 * @TodayStamp 2013-7-30
//	 */
//	public static String getTradeSn(){
//		return "" + new java.util.Date().getTime();
//	}

    /**
     * Description:根据时间戳和随机数生成一个唯一值（时间戳+3位随机值）
     *
     * @param isFromat 时间戳是或否格式化，true,时间戳表现为yyyymmddhhMMsslll，false则是毫秒long的字符串
     * @return
     * @author maixingjie
     * @date 2015-1-29
     */
    public static String getUniqueName(boolean isFromat) {
        long tiemstamp = System.currentTimeMillis();
        long rnd = (long) (1000 * Math.random());
        if (rnd < 100) {
            rnd = 1000 - rnd;
        }
        if (isFromat) {
            return String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS%1$tL", tiemstamp) + rnd;
        } else {
            return tiemstamp + "" + rnd;
        }
    }

    /**
     * Description:根据时间戳和随机数生成一个唯一值（时间戳+3位随机值）
     *
     * @return
     * @author maixingjie
     * @date 2015-1-29
     */
    public static String getUniqueName() {
        return getUniqueName(false);
    }


    /**
     * Description:尝试将对象转换成double类型，如果失败时也不抛出异常而返回0
     *
     * @param fieldValue Object
     * @return
     * @author maixingjie
     * @date 2013-7-30
     */
    public static double tryParseDouble(Object fieldValue) {
        try {
            double rs = (Double) fieldValue;
            return rs;
        } catch (Exception ex) {
            try {
                return Double.parseDouble(fieldValue.toString());
            } catch (Exception exx) {
                return 0;
            }
        }
    }


    /**
     * 将数组进行排序然后再组成字符串
     *
     * @param totalStringList
     * @return
     */
    public static String ArrayToSortString(List<String> totalStringList) {
        String str = "";

        if (totalStringList != null && totalStringList.size() > 0) {
            String[] strs = totalStringList.toArray(new String[totalStringList.size()]);
            Arrays.sort(strs);
            for (String s : strs) {
                str += s;
            }
        }
        return str;
    }

    /**
     * Description:列出对象中所有get/is方法以及返回值,格式是classname[getmethodname=rtnstring,getmethodname2=rtnstring2]
     *
     * @param data
     * @return
     * @date 2013-8-5
     */
    public static String listingString(Object data) {
        return listingString(data, true);
    }

    /**
     * Description:列出对象中所有参数为0的get/is方法以及其返回值,格式是classname[getmethodname=rtnstring,getmethodname2=rtnstring2]
     *
     * @param data
     * @param snapped 是否只列出有返回值的方法
     * @return
     * @date 2013-8-5
     */
    public static String listingString(Object data, boolean snapped) {
        StringBuilder sb = new StringBuilder(100);
        sb.append(data.getClass().getSimpleName()).append("[");
        try {
            boolean flag = false;
            boolean isstring = true;
            Object obj = null;
            String str = "";
            for (Method m : data.getClass().getDeclaredMethods()) {
                if ((m.getName().startsWith("get") || m.getName().startsWith("is")) && m.getParameterTypes().length == 0) {
                    int l = m.getName().startsWith("get") ? 3 : 2;
                    obj = m.invoke(data);
                    if (snapped && obj == null) continue;
                    isstring = obj instanceof String;
                    if (!isstring && snapped) {
                        if (obj instanceof Number && ((Number) obj).intValue() == 0) continue;
                        if (obj instanceof Boolean && ((Boolean) obj) == false) continue;
                    }
                    str = isstring ? ("\"" + obj + "\"") : String.valueOf(obj);
                    if (flag) sb.append(", ");
                    sb.append(m.getName().substring(l).toLowerCase()).append("=").append(str);
                    flag = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * <p>Capitalizes a String changing the first letter to title case as
     * per {@link Character#toTitleCase(char)}. No other letters are changed.</p>
     * <p>
     * <p>For a word based algorithm, see {@link org.apache.commons.lang3.text.WordUtils#capitalize(String)}.
     * A {@code null} input String returns {@code null}.</p>
     * <p>
     * <pre>
     * StringUtils.capitalize(null)  = null
     * StringUtils.capitalize("")    = ""
     * StringUtils.capitalize("cat") = "Cat"
     * StringUtils.capitalize("cAt") = "CAt"
     * </pre>
     *
     * @param str the String to capitalize, may be null
     * @return the capitalized String, {@code null} if null String input
     * @see org.apache.commons.lang3.text.WordUtils#capitalize(String)
     * @see #uncapitalize(String)
     * @since 2.0
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuilder(strLen)
                .append(Character.toTitleCase(str.charAt(0)))
                .append(str.substring(1))
                .toString();
    }

    /**
     * <p>Uncapitalizes a String changing the first letter to title case as
     * per {@link Character#toLowerCase(char)}. No other letters are changed.</p>
     * <p>
     * <p>For a word based algorithm, see {@link org.apache.commons.lang3.text.WordUtils#uncapitalize(String)}.
     * A {@code null} input String returns {@code null}.</p>
     * <p>
     * <pre>
     * StringUtils.uncapitalize(null)  = null
     * StringUtils.uncapitalize("")    = ""
     * StringUtils.uncapitalize("Cat") = "cat"
     * StringUtils.uncapitalize("CAT") = "cAT"
     * </pre>
     *
     * @param str the String to uncapitalize, may be null
     * @return the uncapitalized String, {@code null} if null String input
     * @see org.apache.commons.lang3.text.WordUtils#uncapitalize(String)
     * @see #capitalize(String)
     * @since 2.0
     */
    public static String uncapitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuilder(strLen)
                .append(Character.toLowerCase(str.charAt(0)))
                .append(str.substring(1))
                .toString();
    }

    public static String yuantofen(String money) {
        try {
            if (Float.parseFloat(money) * 100 < 0) {
                throw new RuntimeException("金额必须大于0");
            }
        } catch (Exception e) {
            throw new RuntimeException("请输入正确金额");
        }
        return String.format("%.0f", Float.parseFloat(money) * 100);
    }


    public static String genUUid() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}

