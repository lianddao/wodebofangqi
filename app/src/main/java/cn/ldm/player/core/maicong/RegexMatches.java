package cn.ldm.player.core.maicong;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    private static final String TAG = "RegexMatches";

    public static String kuGouMain(String script) {
        String str = script;

        //      \[{"Hash":.*]
        //      ①字面量要加两个\\ ②运算符不加任何修饰 ③\在拼接字符串是特别会出现错误,应使用 String.value('\\')
        String pattern = String.valueOf('\\') + String.valueOf('[') + "\\{\"Hash\":.*]";
        //        System.out.println(pattern);

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        String result = "";
        while (m.find()) {
            result = m.group(0);
            //            System.out.println(result);
        }
        return result;
    }

}