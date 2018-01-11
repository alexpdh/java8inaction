package com.java8.chapter04.section01;

/**
 * 测试
 *
 * @author pengdh
 * @date 2018/01/11
 */
public class Test4_1 {

	public static void main(String[] args) {
		CollectionJava7 java7 = new CollectionJava7();
		System.out.println("java7" + java7.filterCalories());

		StreamJava8 java8 = new StreamJava8();
		System.out.println("java8" + java8.filterCalories());
	}
}
