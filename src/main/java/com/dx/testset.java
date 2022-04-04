package com.dx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author cs
 * @version 1.0
 * @copyright Copyright (c) cs
 * @since 2022/4/4
 */
public class testset {

    public static void main(String[] args) {
        System.out.println("你好的");

        String str = removeContentStyle("<h1><p><span\n" +
                "        style=\"color: #333333; font-family: 'Microsoft YaHei', -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', Arial, sans-serif; font-size: 13px; background-color: #ffffff;\">第二道简答题</span>\n" +
                "</p></h1>");
        System.out.println(str);
    }


    /**
     * 清除公告中的style
     *
     * @param content 公告内容
     * @return 字符串结果集
     */
    public static String removeContentStyle(String content) {
//        String regEx = " style=\'(.*?)\'";
//        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher(content);
//        if (m.find()) {
//            content = m.replaceAll("");
//        }
        String regEx2 = "font-family:(.*?);";
        Pattern p2 = Pattern.compile(regEx2);
        Matcher m2 = p2.matcher(content);
        if (m2.find()) {
            content = m2.replaceAll("");
        }
       /* String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        Pattern p3 = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m3 = p3.matcher(content);
        content = m3.replaceAll("");*/
        /*String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(content);
        content = m_html.replaceAll(""); //过滤html标签*/
        return content;
    }

}
