package com.example.ad.utils;


import java.util.Map;
import java.util.function.Supplier;

public class CommonUtil {

    // 判断key 是否在map 中，如果在就直接返回，否则就在factory返回新的对象
    public static <K, V> V getorCreate(K key, Map<K, V> map, Supplier<V> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }

    public static String stringConcat(String... args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg);
            result.append("-");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
