package com.java8.chapter04.section01;

import com.java8.chapter04.Dish;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * java7处理集合方式
 *
 * @author pengdh
 * @date 2018/01/11
 */
public class CollectionJava7 {

	public List<String> filterCalories() {
		List<Dish> lowCaloricDishes = new ArrayList<>();
		for (Dish d : Dish.menu) {
			if (d.getCalories() < 400) {
				lowCaloricDishes.add(d);
			}
		}
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish d1, Dish d2) {
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowCaloricDishes) {
			lowCaloricDishesName.add(d.getName());
		}
		return lowCaloricDishesName;
	}
}
