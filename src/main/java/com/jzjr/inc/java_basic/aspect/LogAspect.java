package com.jzjr.inc.java_basic.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面类
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.jzjr.inc.java_basic.controller..*.*(..))")
    public void webLog() {}

    /**
     * 前置通知，在连接点值之前执行的通知
     * @param joinPoint
     */
    @Before(value = "webLog())")
    public void doBefore(JoinPoint joinPoint) {
        log.info("前置通知开始执行");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("url:{}",request.getRequestURL().toString());
        log.info("ip:{}",request.getRemoteAddr());
        log.info("http_method:{}",request.getMethod());
        log.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info("args:{}", Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 环绕通知功能丰富，它可以在方法执行前后执行，它可以决定目标方法执不执行
     * 环绕通知的返回值取决于目标方法的返回值，如果目标方法没有返回值或者
     * 目标方法没有执行则环绕通知没有返回值
     *
     * 环绕通知使用一个代理ProceedingJoinPoint类型的对象来管理目标对象，所以此通知的第一个参数必须是ProceedingJoinPoint类型。
     * 在通知体内调用ProceedingJoinPoint的proceed()方法会导致后台的连接点方法执行。
     * proceed()方法也可能会被调用并且传入一个Object[]对象，该数组中的值将被作为方法执行时的入参
     */
    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      log.info("环绕通知在目标方法执行前执行,目标方法名{}",proceedingJoinPoint.getSignature().getName());
        //调用目标方法
        Object proceed = proceedingJoinPoint.proceed();
        //目标方法发生异常将不执行环绕的后置
        log.info("环绕通知在目标方法执行后执行");
        return proceed;
    }


    /**
     * 后置通知，在连接点之后执行的通知
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning：限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
     * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        log.info("后置通知开始执行");
        // 处理完请求，返回内容
        log.info("response : " + ret);
    }

    /**
     * 后置异常通知，在方法抛出异常返回时执行的通知
     * throwing表示方法抛出的异常
     */
    @AfterThrowing(value = "webLog()",throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable throwable) {
        log.info("后置异常通知开始执行");
        log.error("a error occur:{}",throwable.getMessage());
    }

    /**
     * 后置最终通知，在某连接点退出时执行的通知(无论正常返回还是异常发生)
     */
    @After(value = "webLog()")
    public void doAfter() {
        log.info("最终通知执行");
    }
}
