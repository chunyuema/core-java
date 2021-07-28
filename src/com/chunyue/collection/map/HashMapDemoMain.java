package com.chunyue.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemoMain {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // There is no intrinsic ordering; similar to hash set
        map.put("first name", "chunyue");
        map.put("last name", "ma");
        System.out.println(map);
        System.out.println(map.get("first name"));
        // return null, wont throw an error
        System.out.println(map.get("first name yes"));

        // return an array of keys
        System.out.println((map.keySet()).getClass()); //class java.util.HashMap$KeySet
        Set<String> set = map.keySet();
        for (String key : set){
            System.out.println(key + ": " + map.get(key));
        }

        // override what is already in the hashmap
        map.put("last name", "mama");
        System.out.println(map);
    }
}
