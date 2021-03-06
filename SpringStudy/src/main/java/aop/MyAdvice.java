package aop;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void logBefore(JoinPoint pjp)throws Throwable {
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().getName();
		//메서드이름과 클래스 이름을 획득함
		System.out.println(
			"AOP가 적용됨..."+className+","+methodName+"이 호출됨");
	}
}
