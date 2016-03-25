package cn.alien95.collections;

import java.util.*;

/**
 * Created by llxal on 2015/11/18.
 */
public class MyHashMap<K,V> {

    private final static int  SIZE = 6;
    List<Map.Entry<K,V>>[] map = new List[SIZE];

    public MyHashMap(){}

    public MyHashMap(K key,V value){
        put(key,value);
    }

    public void put(K key,V value){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(map[index] == null){
            map[index] = new ArrayList<>();
        }else {
            Iterator<Map.Entry<K,V>> iterator = map[index].iterator();
            Map.Entry<K,V> entry;
            while (iterator.hasNext()){
                entry = iterator.next();
                if(entry.getKey().equals(key)){
                    entry.setValue(value);
                    return;
                }
            }
        }
        map[index].add(new MyEntry(key,value));
    }


    public V getValue(K key){
        int index = Math.abs(key.hashCode()) % SIZE;
        System.out.println("index:"+index);
        if(map[index] == null){
            return null;
        }
        Iterator<Map.Entry<K,V>> iterator = map[index].listIterator();
        System.out.println(map[index]);
        Map.Entry<K,V> entry;
        while (iterator.hasNext()){
            entry = iterator.next();
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }

    class MyEntry<KEY,VALUE> implements Map.Entry<KEY,VALUE>{
        KEY key;
        VALUE value;

        public MyEntry(KEY key,VALUE value){
            this.key = key;
            this.value = value;
        }


        @Override
        public KEY getKey() {
            return key;
        }

        @Override
        public VALUE getValue() {
            return value;
        }

        @Override
        public VALUE setValue(VALUE value) {
            return this.value = value;
        }
    }
}
