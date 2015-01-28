package org.bond.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MessageAspect {
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("ǰ��֪ͨ��The method " + methodName + " begins with "
				+ args);
		System.out
				.println("-------------------------------------------------------");
	}

	public void afterMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		// List<Object>args = Arrays.asList(joinpoint.getArgs()); ����֪ͨ�����п��Ի�ȡ������
		System.out.println("����֪ͨ��The method " + methodName + " ends ");
		System.out
				.println("-------------------------------------------------------");
	}

	public void afterReturnning(JoinPoint joinpoint, Object result) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("����֪ͨ��The method " + methodName + " ends with "
				+ result);
		System.out
				.println("-------------------------------------------------------");
	}

	public void afterThrowing(JoinPoint joinpoint, Exception e) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("�쳣֪ͨ��The method " + methodName
				+ " occurs exception " + e);
		System.out
				.println("-------------------------------------------------------");
	}

	public Object aroundMethod(ProceedingJoinPoint point) {
		Object result = null;
		String methodName = point.getSignature().getName();
		try {
			// ǰ��֪ͨ
			System.out.println("The method " + methodName + " begins with "
					+ Arrays.asList(point.getArgs()));
			// ִ��Ŀ�귽��
			result = point.proceed();
			// ����֪ͨ
			System.out.println("The method " + methodName + " ends with "
					+ result);
		} catch (Throwable e) {
			// �쳣֪ͨ
			System.out.println("The method " + methodName
					+ " occurs exception " + e);
			throw new RuntimeException(e);
		}
		// ����֪ͨ
		System.out.println("The method " + methodName + " ends");
		System.out
				.println("-------------------------------------------------------");
		return result;
	}
}
