package com.java8.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 环绕执行模式
 *
 * @author pengdh
 * @date 2017/12/07
 */
public class ExecuteAround {

	public static void main(String[] args) throws IOException {
		System.out.println(processLimitFile());

		String oneLine = processFile(b -> b.readLine());
		System.out.println(oneLine);
		String twoLine = processFile(b -> b.readLine() + b.readLine());
		System.out.println(twoLine);
	}

	public static String processLimitFile() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			return p.process(br);
		}
	}

	/**
	 * Lambda 仅可以用于上线问是函数式接口的情况，
	 * 需要创建一个匹配 BufferedReader -> String
	 */
	public interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}
}
