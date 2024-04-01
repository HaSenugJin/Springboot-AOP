package shop.mtcoding.aopstudy.config.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAdvice {

    @Pointcut("@annotation(shop.mtcoding.aopstudy.config.annotation.Hello)")
    public void hello() {}

    @Before("hello()")
    public void helloAdvice(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();

        for (Object arg : args) {
            if (arg instanceof String) {
                String username = (String) arg;
                System.out.println(username + "님 안녕하세요");
            }
        }
    }
}
