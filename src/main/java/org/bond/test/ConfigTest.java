package org.bond.test;

import org.bond.service.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {

	public static void main(String[] args) {
		/*
		 * 通过配置文件来处理
		 */
		// 创建spring IOC容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"Spring-Arithmetic.xml");
		// 从IOC容器中获取bean实例
		ArithmeticCalculator arithmeticCalculator = applicationContext
				.getBean(ArithmeticCalculator.class);
		// ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)
		// applicationContext
		// .getBean("arithmeticCalculator");

		int result = arithmeticCalculator.add(4, 6);
		System.out.println(result);
		result = arithmeticCalculator.sub(4, 6);
		System.out.println(result);
		System.out.println(result);
		result = arithmeticCalculator.mul(4, 6);
		System.out.println(result);
		System.out.println(result);
		result = arithmeticCalculator.div(4, 0);
		System.out.println(result);
	}

}
