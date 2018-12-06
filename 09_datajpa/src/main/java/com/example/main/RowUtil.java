package com.example.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * @Description:
 * 对每行代码进行处理
 * @Auther: zhangfx
 * @Date: 2018/12/6/ 14:03
 */
public class RowUtil {

    //用于确认新的变量名称
    public static int index = 96;

    /**
     * 去掉行尾注释(使用正则匹配去除)
     * @param line 每行代码
     * @return 没有注释的代码
     */
    public static String removeEndComment(String line) {
        Pattern pattern = Pattern.compile("//(.*)");//特征是所有以双斜线开头的
        Matcher matcher1 = pattern.matcher(line);
        line = matcher1.replaceAll("");  //替换为""
        return line;
    }

    /**
     * 寻找等号左边的变量名  并重新定义名称
     * @param line 每行代码
     * @param map 用于存储当前变量名 和 新的变量名
     * @return 重新定义变量名的代码
     */
    public static String getVariableNames (String line, Map<String,Integer> map) {
        String[] strarray = line.trim().split(" ");
        //用于存储分割后的代码
        List<String> tmp = new ArrayList<String>();
        for (String str : strarray) {
            //去除中间包含空格的数组
            if (str != null && str.length() != 0) {
                tmp.add(str);
            }
        }
        //确定等号的位置
        int i = tmp.indexOf("=");
        //判断map中是否已存在当前变量名
        boolean key = map.containsKey(tmp.get(i - 1));
        //如果存在 则取出新的变量名,不存在则 重新定义变量名
        if (key) {
            index=map.get(tmp.get(i - 1));
        } else {
            index+=1;
            map.put(tmp.get(i - 1),index);
        }
        //得到新的变量名
        String variableName = String.valueOf((char)index);
        //替换变量名
        tmp.set(i - 1, variableName);
        //将list里的内容 拼凑成一行代码
        StringBuilder sb = new StringBuilder();
        sb.append("       ");
        for (String s : tmp) {
            sb.append(" "+s);
        }
        return sb.toString();
    }



}
