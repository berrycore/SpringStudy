package advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		StopWatch sw = new StopWatch();
		String methodName = invocation.getMethod().getName();
		
		sw.start(methodName);	// 측정 시작
		System.out.println("어드바이스 실행됨, " + "호출 메서드 이름 : " + methodName);
		
		Object obj = invocation.proceed();
		
		sw.stop();	// 측정 중지
		System.out.println("어드바이스 다시 실행됨, " + "메서드 실행시간 : " + sw.getTotalTimeMillis() / 1000);
		
		return obj;
	}

}
