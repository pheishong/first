package com.cy.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculateString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = scan.next();

		Map<Character,Integer> map = new HashMap<>();

		for (char c : str.toCharArray()) {
			if(map.containsKey(c)) {
				Integer value = map.get(c);
				value++;
				map.put(c, value);
			}else {
				map.put(c, 1);
			}
		}
		for (Character key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println(key+"="+value);
		}
	}
}
