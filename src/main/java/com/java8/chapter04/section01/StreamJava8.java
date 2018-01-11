package com.java8.chapter04.section01;

import static java.util.stream.Collectors.toList;

import com.java8.chapter04.Dish;
import java.util.Comparator;
import java.util.List;

/**
 * java8 处理集合方式
 *
 * @author pengdh
 * @date 2018/01/11
 */
public class StreamJava8 {

	public List<String> filterCalories() {
		List<String> lowCaloricDishesName = Dish.menu.parallelStream()
				.filter(dish -> dish.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(toList());
		return lowCaloricDishesName;
	}
}
