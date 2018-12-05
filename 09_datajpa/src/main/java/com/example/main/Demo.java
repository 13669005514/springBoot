package com.example.main;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 17:08
 */
public class Demo {

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
        while ((line=br.readLine())!=null) {
            System.out.println(line);
            line = line.trim();
            boolean a = line.startsWith("/*");
            boolean c = line.startsWith("*");
            boolean b = line.startsWith("//");
            if (a || b || c) {
                continue;
            }
            Pattern pattern1 = Pattern.compile("//(.*)");    //特征是所有以双斜线开头的
            Matcher matcher1 = pattern1.matcher(line);
            line = matcher1.replaceAll("");  //替换第一种注释
            FileUtil.writeFile(line);
        }
        br.close();
        isr.close();
        fis.close();
    }


}
