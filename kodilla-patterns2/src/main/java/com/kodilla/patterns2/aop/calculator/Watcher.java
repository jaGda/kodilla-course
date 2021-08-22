package com.kodilla.patterns2.aop.calculator;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
            "&& args(theNumber) && target(object)")
    public void factorialLogEvent(BigDecimal theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto,userId) && target(object)")
    public void processOrderLogEvent(OrderDto orderDto, Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: order size - " + orderDto.getItems().size() + ", user ID - " + userId);
    }


    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
