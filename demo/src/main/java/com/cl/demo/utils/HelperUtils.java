package com.cl.demo.utils;

import com.cl.demo.entities.TaskStatus;

import java.util.Date;

public class HelperUtils {

    //String Compare
    public static String compare(String original, String update){
/*        if(original.equals(update)){
            return original;
        } else {
            return update;
        }*/

        return original.equals(update)? original: update;
    }

    //TaskStatus compare
    public static TaskStatus compare(TaskStatus original, TaskStatus update){
        if(update==null){
            return original;
        }
        return original != null && original.equals(update) ? original : update;
    }

    //Date compare
    public static Date compare(Date original, Date update){
        if(update==null){
            return original;
        }
        return original != null && original.equals(update) ? original : update;
    }

    //Boolean compare
    public static Boolean compare(Boolean original, Boolean update){
        if(update==null){
            return original;
        }
        return original != null && original.equals(update) ? original : update;
    }

    //Long compare
    public static Long compare(Long original, Long update){
        if(update==null){
            return original;
        }
        return original != null && original.equals(update) ? original : update;
    }


}
