package com.example.main;

import java.util.*;


/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/5 20:13
 */
public class  LineUtil{

    public static int index = 96;

    public static String getLine (String str, Map<String,Integer> map) {
        String[] strarray = str.trim().split(" ");
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i < strarray.length; i++) {
            if (strarray[i] != null && strarray[i].length() != 0) {
                tmp.add(strarray[i]);
            }
        }
        int i = tmp.indexOf("=");
        boolean key = map.containsKey(tmp.get(i - 1));
        System.out.println(tmp.get(i - 1));
        //
        if (key) {
            index=map.get(tmp.get(i - 1));
        } else {
            index+=1;
            map.put(tmp.get(i - 1),index);
        }
        String variableName = String.valueOf((char)index);
        tmp.set(i - 1, variableName);

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
//        Map<String,Integer> map = new HashMap<String, Integer>();
//        getLine(str,map);
        int i = 97;
        String s = String.valueOf((char)i);

        System.out.println(s);




    }
}
