package com.suhang.road.util;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileUtil {

    public  ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        ArrayList<String> filesnew = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
            }
        }

        for (int i=0;i<files.size();i++) {
            if (!files.get(i).equals("/tmp/export/.DS_Store")) {
                filesnew.add(files.get(i).substring(12,26));
            }
        }

        Collections.sort(filesnew);
        for (int i=filesnew.size()-1;i>=0;i--){
            result.add(filesnew.get(i));
        }
        return result;
    }

    public static void main(String []args){
        ArrayList<String> files = new FileUtil().getFiles("/tmp/export/");
        System.out.println(files);
    }


}
