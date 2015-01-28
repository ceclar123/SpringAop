package org.bond.test;

import org.bond.service.CustomerBo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		/*
		 * 采用注解方式
		 */
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"Spring-Customer.xml");

		CustomerBo customer = appContext.getBean(CustomerBo.class);
		// CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		customer.addCustomer();
		customer.addCustomerReturnValue();
		customer.addCustomerThrowException();
		// customer.addCustomerAround("张三");

	}
}