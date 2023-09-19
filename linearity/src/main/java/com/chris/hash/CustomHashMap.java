package com.chris.hash;


import java.util.Map;
import java.util.Objects;

/**
 * @author 史偕成
 * @date 2023/09/18 12:38
 **/
public class CustomHashMap<K, V> {

    private static class Node<K, V> {

        // hash值
        final int hash;

        // 键
        final K key;

        // 值
        V value;

        // 下一个节点指针
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public K getKey() {
            return key;
        }

        public final int hashCode() {
            int keyHashCode = Objects.hashCode(key);
            System.out.println("key hash code : " + keyHashCode);
            int valueHashCode = Objects.hashCode(value);
            System.out.println("value hash code : " + valueHashCode);
            int hashCode = keyHashCode ^ valueHashCode;
            System.out.println("hash code : " + hashCode);
            return hashCode;
        }

        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }
}
