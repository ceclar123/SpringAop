package org.bond.test;

import org.bond.service.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {

	public static void main(String[] args) {
		/*
		 * ͨ�������ļ�������
		 */
		// ����spring IOC����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"Spring-Arithmetic.xml");
		// ��IOC�����л�ȡbeanʵ��
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
