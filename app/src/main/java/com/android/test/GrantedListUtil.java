package com.android.test;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Despciption todo
 * @Author hss
 * @Date 16/06/2023 17:25
 * @Version 1.0
 */
public class GrantedListUtil {

    public static Map<String,String> list = new TreeMap<>();
    static final String saf_granted_list = "saf_granted_list";
    static final String saf_granted_list_key = "list";

    static void readList(Context context){
        Map<String, ?> all = context.getSharedPreferences(saf_granted_list, Context.MODE_PRIVATE).getAll();
        for (String s : all.keySet()) {
            list.put(s,all.get(s)+"");
        }
    }

    static void save(Uri uri,Context context){
        String str = uri.toString();
        String key = "xx";
        if(str.contains("%2F")){
            key = str.substring(str.lastIndexOf("%2F")+3);
            Log.d("xxx","key-->"+key);
        }
        //content://com.android.externalstorage.documents/tree/primary%3AAndroid%2Fdata%2Fcom.baidu.input_mi
        list.put(key,uri.toString());
        context.getSharedPreferences(saf_granted_list,Context.MODE_PRIVATE).edit().putString(key,uri.toString()).apply();
    }
}
