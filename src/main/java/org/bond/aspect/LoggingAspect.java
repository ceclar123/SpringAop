package org.bond.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* org.bond.service.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out
				.println("------------------before-begin----------------------------------");
		System.out.println("ǰ��֪ͨ ");
		System.out.println("���� : " + joinPoint.getSignature().getName());
		System.out
				.println("------------------before-end----------------------------------");
	}

	@After("execution(* org.bond.service.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out
				.println("------------------after-begin----------------------------------");
		System.out.println("����֪ͨ");
		System.out.println("���� : " + joinPoint.getSignature().getName());
		System.out
				.println("------------------after-end----------------------------------");

	}

	@AfterReturning(pointcut = "execution(* org.bond.service.CustomerBo.addCustomerReturnValue(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		System.out
				.println("------------------AfterReturning-begin----------------------------------");
		System.out.println("����֪ͨ");
		System.out.println("���� : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out
				.println("------------------AfterReturning-end----------------------------------");

	}

	@AfterThrowing(pointcut = "execution(* org.bond.service.CustomerBo.addCustomerThrowException(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out
				.println("------------------AfterThrowing-begin----------------------------------");
		System.out.println("�쳣֪ͨ");
		System.out.println("���� : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out
				.println("------------------AfterThrowing-end----------------------------------");
	}

	@Around("execution(* org.bond.service.CustomerBo.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out
				.println("------------------Around-begin----------------------------------");
		System.out.println("����֪ͨ");
		System.out.println("���� : " + joinPoint.getSignature().getName());
		System.out.println("���� : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		joinPoint.proceed();
		System.out.println("Around after is running!");
		System.out
				.println("------------------Around-end----------------------------------");
	}

}