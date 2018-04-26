package com.suhang.road.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInteger {

    public Integer getInteger(String resource ){
        if (resource==null||resource.equals("")){
            return 0;
        }
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(resource);
        String string = m.replaceAll("").trim();
        if (string==null||string.equals("")){
            return 0;
        }
        return Integer.parseInt(string);
    }

    public static void main(String[] args){
         int result = new GetInteger().getInteger("3120棵");
        System.out.println(result);
    }
}
