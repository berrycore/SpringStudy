package advisor.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMyAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = method.getName();
		System.out.println("Before 어드바이스 입니다.");
		System.out.println(methodName + " 전에 실행 됩니다");
	}

}
