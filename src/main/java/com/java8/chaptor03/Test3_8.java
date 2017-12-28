package com.java8.chaptor03;

import java.util.function.Function;

/**
 * 函数式接口中默认方法操作
 *
 * @author pengdh
 * @date 2017/12/28
 */
public class Test3_8 {

	public static String addHeader(String text) {
		return "From Raoul，Mario and Alan：" + text;
	}

	public static String addFooter(String text) {
		return text + " King regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}

	public static void main(String[] args) {
		Function<String, String> addHeader = Test3_8::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Test3_8::checkSpelling)
				.andThen(Test3_8::addFooter);

		String s = transformationPipeline.apply("hello labda");
		System.out.println(s);
	}
}
