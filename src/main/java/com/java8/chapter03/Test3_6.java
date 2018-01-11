package com.java8.chapter03;

import com.java8.chapter01.Apple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 3.6测试用例
 *
 * @author pengdh
 * @date 2017/12/28
 */
public class Test3_6 {

	public static void main(String[] args) {
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(110);
		System.out.println(a2);

		List<Integer> integers = Arrays.asList(1, 4, 6);
		List<Apple> apples = map(integers, Apple :: new);
		System.out.println(apples);

		BiFunction<Integer, String, Apple> c3 = Apple :: new;
		Apple a3 = c3.apply(110, "red");
		System.out.println(a3);

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "red");
		map.put(2, "green");
		List<Apple> apples1 = map(map, Apple :: new);
		System.out.println(apples1);
	}

	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Integer e : list) {
			result.add(f.apply(e));
		}
		return result;
	}

	public static List<Apple> map(Map<Integer, String> map, BiFunction<Integer, String, Apple> f) {
		List<Apple> result = new ArrayList<>();
		for (Entry<Integer, String> e : map.entrySet()) {
			result.add(f.apply(e.getKey(), e.getValue()));
		}
		return result;
	}
}
