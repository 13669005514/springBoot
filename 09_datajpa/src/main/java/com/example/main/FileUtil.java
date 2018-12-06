package com.example.main;

import java.io.*;
import java.util.Map;

/**
 * @Description:
 * 对java文件的相关操作
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 17:15
 */
public class FileUtil {

    /**
     * 一行一行写入文件，解决写入中文字符时出现乱码
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     * @throws IOException
     */
    public static void writeFile(String lineContext) throws IOException {

        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(new File("H:/1205/NewRedisConfig.java"),true);
        OutputStreamWriter osw=new OutputStreamWriter(fos, "GBK");
        BufferedWriter  bw=new BufferedWriter(osw);
        bw.write(lineContext+"\t\n");
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }

    /**
     * 替换文本文件中的 旧变量名
     * @param
     * @throws IOException
     */
    public static void replacTextContent(Map<String,Integer> map) throws IOException{
        File file = new File("H:/1205/NewRedisConfig.java");
        FileReader in = new FileReader(file);
        BufferedReader bufIn = new BufferedReader(in);
        // 内存流, 作为临时流
        CharArrayWriter  tempStream = new CharArrayWriter();
        // 替换
        String line = null;
        while ( (line = bufIn.readLine()) != null) {
            for (String key : map.keySet()) {
                if (line.indexOf(key) != -1) {
                    // 替换每行中, 符合条件的字符串
                    int index = map.get(key) ;
                    String variableName = String.valueOf((char)index);
                    line = line.replaceAll(key,variableName);
                }
            }
            // 将该行写入内存
            tempStream.write(line);
            // 添加换行符
            tempStream.append(System.getProperty("line.separator"));
        }
        // 关闭 输入流
        bufIn.close();
        // 将内存中的流 写入 文件
        FileWriter out = new FileWriter(file);
        tempStream.writeTo(out);
        out.close();
    }

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


}
