package com.java8.chaptor03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import sun.applet.Main;

/**
 * @author pengdh
 * @date 2017/12/24
 */
public class Test03 {

	public static void main(String[] args) {
		Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
		List<String> nonEmpty = filter(Arrays.asList("a", "b", "c"), nonEmptyStringPredicate);
		System.out.println("Predicate.test" + nonEmpty);

		forEach(Arrays.asList(1, 2, 3, 4, 5), integer-> System.out.println("Consumer.accept" + integer));

		List<Integer> l = map(Arrays.asList("function", "use"), s -> s.length());
		System.out.println("Function.apply" + l);
	}

	/**
	 * Predicate.test
	 *
	 * @param list
	 * @param p
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}

	/**
	 * Consumer.accept
	 *
	 * @param list
	 * @param c
	 * @param <T>
	 */
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T i : list) {
			c.accept(i);
		}
	}

	/**
	 * Function.apply
	 *
	 * @param list
	 * @param f
	 * @param <T>
	 * @param <R>
	 * @return
	 */
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
}
