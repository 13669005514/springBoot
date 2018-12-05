package com.example.main;

import java.io.*;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 17:15
 */
public class FileUtil {

    /**
     * 一行一行写入文件，解决写入中文字符时出现乱码
     *
     * 流的关闭顺序：先打开的后关，后打开的先关，
     *       否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */
    public static void writeFile(String lineContext) throws IOException {

        //写入中文字符时解决中文乱码问题
        FileOutputStream fos=new FileOutputStream(new File("H:/1205/NewRedisConfig.java"),true);
        OutputStreamWriter osw=new OutputStreamWriter(fos, "GBK");
        BufferedWriter  bw=new BufferedWriter(osw);
        //简写如下：
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        //        new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8"));
        bw.write(lineContext+"\t\n");
        //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
        bw.close();
        osw.close();
        fos.close();
    }
}
