package com.java8.chaptor02;

/**
 * 匿名类谜题
 *
 * @author pengdh
 * @date 2017/12/03
 */
public class MeaningOfThis {
	public final int value = 4;
	public void doIt() {
		int value = 6;
		Runnable r = new Runnable() {
			public final int value = 5;
			public void run() {
				int value = 10;
				System.out.println(this.value);
			}
		};
		r.run();
	}

	public static void main(String[] args) {
		MeaningOfThis m = new MeaningOfThis();
		m.doIt();
	}
}
