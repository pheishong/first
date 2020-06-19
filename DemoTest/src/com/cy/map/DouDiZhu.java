package com.cy.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DouDiZhu {

	public static void main(String[] args) {

		Map<Integer,String> poker = new HashMap<>();
		List<Integer> pokerIndex = new ArrayList<>();

		List<String> colors = new ArrayList<>();
//		colors.add("♠");
//		colors.add("♥");
//		colors.add("♣");
//		colors.add("♦");
		Collections.addAll(colors, "♠","♥","♣","♦");

		List<String> numbers = new ArrayList<>();
//		numbers.add("2");
//		numbers.add("A");
//		numbers.add("K");
//		numbers.add("Q");
//		numbers.add("J");
//		numbers.add("10");
//		numbers.add("9");
//		numbers.add("8");
//		numbers.add("7");
//		numbers.add("6");
//		numbers.add("5");
//		numbers.add("4");
//		numbers.add("3");
		Collections.addAll(numbers, "2","A","K","Q","J","10","9","8","7","6","5","4","3");
		int index = 0;
		poker.put(index, "大王");
		pokerIndex.add(index);
		index++;
		poker.put(index, "小王");
		pokerIndex.add(index);
		index++;
		//组装poker
		for (String number : numbers) {
			for (String color : colors) {
				poker.put(index, color+number);
				pokerIndex.add(index);
				index++;
			}
		}
		
		//洗牌
		Collections.shuffle(pokerIndex);
		//定义玩家
		List<Integer> player01 = new ArrayList<>();
		List<Integer> player02 = new ArrayList<>();
		List<Integer> player03 = new ArrayList<>();
		List<Integer> dipai = new ArrayList<>();
		//发牌
		for (int i = 0; i < pokerIndex.size(); i++) {
			Integer in = pokerIndex.get(i);
			if(i>=51) 
				dipai.add(in);
			else if(i%3==0)
				player01.add(in);
			else if(i%3==1)
				player02.add(in);
			else if(i%3==2)
				player03.add(in);
		}
		//给玩家的牌排序
		Collections.sort(player01);
		Collections.sort(player02);
		Collections.sort(player03);
		Collections.sort(dipai);
		
		//看牌
		lookPoker("刘德华",poker,player01);
		lookPoker("周润发",poker,player02);
		lookPoker("周星驰",poker,player03);
		lookPoker("底牌",poker,dipai);
		
		
		
	}
	
	public static void lookPoker(String name,Map<Integer,String> poker,List<Integer> list) {
		//输出玩家名称
		System.out.print(name+":");
		for (Integer key : list) {
			//根据索引在集合中到对应的牌
			String value = poker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();//打印每一个玩家的牌，换行
	}
}
