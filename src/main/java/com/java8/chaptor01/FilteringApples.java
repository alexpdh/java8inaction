package com.java8.chaptor01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pengdh
 * @date 2017/11/28
 */
public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(120, "red"));

		List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
		System.out.println(greenApples);
		List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
		System.out.println(heavyApples);

		List<Apple> greenApples2 = filterApples(inventory, apple -> "green".equals(apple.getColor()));
		System.out.println(greenApples2);
		List<Apple> heavyApples2 = filterApples(inventory, apple -> apple.getWeight() > 150);
		System.out.println(heavyApples2);

		List<Apple> greenApples3 = inventory.parallelStream().filter(apple -> apple.getColor().equals("green")).collect(
				Collectors.toList());
		System.out.println(greenApples3);
		List<Apple> heavyApples3 = inventory.stream().filter((apple -> apple.getWeight() > 150)).collect(
				Collectors.toList());
		System.out.println(heavyApples3);

	}

	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	public interface Predicate<T> {

		boolean test(T t);
	}

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}
