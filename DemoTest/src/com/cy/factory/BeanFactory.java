package com.cy.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

	private static final Properties PRO = new Properties();;
	private static final Map<String,Object> BEANS = new ConcurrentHashMap<>();;
	static {
		try {
			InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("pro.properties");
			PRO.load(in);
			Enumeration<Object> keys = PRO.keys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement().toString();
				String beanPath = PRO.getProperty(key);
				Object value = Class.forName(beanPath).newInstance();
				BEANS.put(key, value);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化properties异常");
		}
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		return (T) BEANS.get(beanName);
	}

}
