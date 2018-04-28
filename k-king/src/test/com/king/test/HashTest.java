package com.king.test;

/**
 * @author King
 * @date 2017/12/28
 */
public class HashTest {

    public static void main(String[] args) {
        System.out.println(indexFor(30,16));
    }


    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    static int indexFor(int h, int length) {
        return h & (length-1);
    }

}
