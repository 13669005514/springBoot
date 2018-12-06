package com.example.main;

import java.util.*;


/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/5 20:13
 */
public class  LineUtil{

    public static int index = 97;

    public static String getLine (String str, Map<String,Integer> map) {
        String[] strarray = str.split(" ");
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i < strarray.length; i++) {
            if (strarray[i] != null && strarray[i].length() != 0) {
                tmp.add(strarray[i]);
                System.out.println(strarray[i]);
            }
        }
        int i = tmp.indexOf("=");
        boolean key = map.containsKey(tmp.get(i - 1));
        //
        if (key) {

        } else {


        }



        tmp.set(i - 1, "a ");


        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(" "+s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "  RedisTemplate<String, Object> template = new RedisTemplate<>();";
        //Set<String> set = new HashSet<String>();
        Map<String,Integer> map = new HashMap<String, Integer>();
        getLine(str,map);


    }
}
