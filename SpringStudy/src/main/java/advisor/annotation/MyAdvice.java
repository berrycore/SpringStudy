package advisor.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class MyAdvice {
	
	/*
	 * pointcut 을 찾는 execution 의 사용법
	 * 
	 * 사용법 : execution(1 2 3)
	 *    1 : public, private, protected, (생략가능)
	 *    2 : 메서드의 리턴 타입
	 *    3 : 패키지이름.클래스이름.메서드이름(매개변수의 type...)
	 * 
	 *  예1)   execution(* name())
	 *        메서드이름이 name 이고 매개변수가 있거나 없는 메서드
	 *  
	 *  예2)   execution(* name(..))
	 *        메서드이름이 name 이고 매개변수가 있거나 없는 메서드
	 *        점 두개(..) 는 0개 이상을 의미
	 *    
	 *  예3)   execution(public void name*())
	 *        public 이고 return type 이 없으며 메서드 이름이 name 으로 시작하고 매개변수가 없는 메서드
	 *        
	 *  예4)   execution(public * sample.*.*(..))
	 *        public 이고 모든return type 이며 sample 패키지에 속한 모든 메서드
	 *        
	 *  예5)   execution(* sample..*.*(..))
	 *        public 이고 모든return type 이며 sample 및 그 하위 패키지에 속한 모든 메서드
	 *        
	 *  예6)   execution(public * name*(..)) || execution(* sample..*.*.(..))
	 *        public 이고 name 으로 시작하는 모든 메서드, 또는 , sample 패키지 및 그 하위 패키지에 있는 모든 클래스의 메서드
	 * 
	 */

	@Around("execution (* sayHello())")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		
		StopWatch sw = new StopWatch();
		String methodName = pjp.getSignature().getName();
		System.out.println("어라운드 어드바이스 실행");
		sw.start(methodName);
		
		Object obj = pjp.proceed();
		sw.stop();
		
		System.out.println("어라운드 어드바이스 재실행");
		System.out.println("메서드 실행 시간 : " + sw.getTotalTimeMillis() / 1000);
		
		return obj;
	}
}
