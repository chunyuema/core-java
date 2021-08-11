package com.chunyue.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemoMain {

    public static Map<String, String> map = new HashMap<>();

    static {
        // There is no intrinsic ordering; similar to hash set
        map.put("first name", "chunyue");
        map.put("last name", "ma");
    }
    public static void main(String[] args) {
        System.out.println(map);
        System.out.println(map.get("first name"));
        System.out.println(map.get("first name yes")); // return null, wont throw an error
        // putForUpdate();
        // keySeyDemo();
        // mapEntryDemo();
    }

    public static void putForUpdate(){
        System.out.println("==== use put to override the values====");
        map.put("last name", "mama");
        System.out.println(map);
    }

    public static void keySeyDemo(){
        System.out.println("=====keySet() method demo =======");
        System.out.println((map.keySet()).getClass()); //class java.util.HashMap$KeySet
        Set<String> set = map.keySet();
        for (String key : set){
            System.out.println(key + ": " + map.get(key));
        }

    }

    public static void mapEntryDemo(){
        System.out.println("======Map.Entry Interface Demo=======");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println("The entry set is: " + entrySet);
        for (Map.Entry<String, String> me: entrySet){
            System.out.println(me);
        }
    }
}
