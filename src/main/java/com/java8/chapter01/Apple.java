package com.java8.chapter01;

/**
 * @author pengdh
 * @date 2017/11/28
 */
public class Apple {
	private int weight = 0;
	private String color = "";

	public Apple(String color) {
		this.color = color;
	}

	public Apple(int weight) {

		this.weight = weight;
	}

	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple{" +
				"weight=" + weight +
				", color='" + color + '\'' +
				'}';
	}
}
