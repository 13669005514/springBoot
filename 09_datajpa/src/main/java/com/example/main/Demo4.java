package com.example.main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * 实现对java文件注释删除和变量名替换为(a-z)的思路:
 * 1.去掉多行注释 单行注释
 * 2.去掉行尾注释
 * 3.提取等号左边定义的变量名 并且修改成新的变量名
 * 4.将旧变量名称和新变量名称存放到map中
 * 5.最后对文件中未修改的变量名进行从map中匹配修改
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 17:08
 */
public class Demo4 {

    public static void main(String[] args) throws Exception {
        //清空要写入的文件里的内容
        FileUtil.clearInfoForFile();
        //1.读取文件内容(一行一行读取内容)
        FileInputStream fis=new FileInputStream("H:/1205/RedisConfig.java");
        InputStreamReader isr=new InputStreamReader(fis, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String line="";
        //用于存储变量名集合
        Map<String, Integer> map = new HashMap<>();
        while ((line=br.readLine())!=null) {
            //替换多行和单行注释
            String lineTrim = line.trim();
            boolean a = lineTrim.startsWith("/*");
            boolean c = lineTrim.startsWith("*");
            boolean b = lineTrim.startsWith("//");
            if (a || b || c) {
                continue;
            }
            //替换行尾注释
            if (line.indexOf("//") != -1) {
                line = RowUtil.removeEndComment(line);
            }
            //查找所有定义的变量 并替换变量名称
            if (line.indexOf("=") != -1 && line.indexOf(";") != -1) {
                line = RowUtil.getVariableNames(line, map);
            }
            //将修改后的内容写入文件中
            FileUtil.writeFile(line);
        }
        br.close();
        isr.close();
        fis.close();
        //对文件中未修改的变量名进行从map中匹配修改
        FileUtil.replacTextContent(map);
    }


}
