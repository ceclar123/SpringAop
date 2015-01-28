package org.bond.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MessageAspect {
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("前置通知：The method " + methodName + " begins with "
				+ args);
		System.out
				.println("-------------------------------------------------------");
	}

	public void afterMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		// List<Object>args = Arrays.asList(joinpoint.getArgs()); 后置通知方法中可以获取到参数
		System.out.println("后置通知：The method " + methodName + " ends ");
		System.out
				.println("-------------------------------------------------------");
	}

	public void afterReturnning(JoinPoint joinpoint, Object result) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("返回通知：The method " + methodName + " ends with "
				+ result);
		System.out
				.println("-------------------------------------------------------");
	}

	public void afterThrowing(JoinPoint joinpoint, Exception e) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("异常通知：The method " + methodName
				+ " occurs exception " + e);
		System.out
				.println("-------------------------------------------------------");
	}

	public Object aroundMethod(ProceedingJoinPoint point) {
		Object result = null;
		String methodName = point.getSignature().getName();
		try {
			// 前置通知
			System.out.println("The method " + methodName + " begins with "
					+ Arrays.asList(point.getArgs()));
			// 执行目标方法
			result = point.proceed();
			// 翻译通知
			System.out.println("The method " + methodName + " ends with "
					+ result);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("The method " + methodName
					+ " occurs exception " + e);
			throw new RuntimeException(e);
		}
		// 后置通知
		System.out.println("The method " + methodName + " ends");
		System.out
				.println("-------------------------------------------------------");
		return result;
	}
}
