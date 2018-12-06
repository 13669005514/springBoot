package com.example.main;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 17:08
 */
public class Demo {

     static Pattern pattern1 = null;
    // 清空已有的文件内容，以便下次重新写入新的内容
    public static void clearInfoForFile() {
        File file =new File("H:/1205/NewRedisConfig.java");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        clearInfoForFile();//清空要写入的文件里的内容
        //1.读取文件内容(一行一行读取内容)
        FileInputStream fis=new FileInputStream("H:/1205/RedisConfig.java");
        InputStreamReader isr=new InputStreamReader(fis, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String line="";
        //用于存储变量名集合
        Set<String> set = new HashSet<String>();
        while ((line=br.readLine())!=null) {
            //System.out.println(line);
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
                pattern1 = Pattern.compile("//(.*)");    //特征是所有以双斜线开头的
                Matcher matcher1 = pattern1.matcher(line);
                line = matcher1.replaceAll("");  //替换第一种注释
            }
            //查找所有变量
            if (line.indexOf("=") != -1 && line.indexOf(";") != -1) {
                System.out.println(line);
                LineUtil.getLine(line,set);
            }
            //将修改后的内容写入文件中
            FileUtil.writeFile(line);
        }
        br.close();
        isr.close();
        fis.close();
    }


}
