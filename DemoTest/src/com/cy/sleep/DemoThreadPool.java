package com.cy.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoThreadPool {

	public static void main(String[] args) {
//		ExecutorService pool = Executors.newFixedThreadPool(2);
//		pool.submit(new RunnableImpl());
//		pool.submit(new RunnableImpl());
	
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"新线程创建了");
			}
		};
		new Thread(r).start();
		
		//============================================================
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"新线程创建了");
			}
		}).start();
		//=============================================================
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"新线程创建了");
		}).start();
		
		//=============================================
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}


class RunnableImpl implements Runnable{

	@Override
	public void run() {
		System.out.println("开启线程"+Thread.currentThread().getName());
		
	}
	
}