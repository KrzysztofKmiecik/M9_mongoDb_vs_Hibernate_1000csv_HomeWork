package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.application;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
class TimeMeasurementAspect {

    @Around("@annotation(pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain.CuntDurationTime)")
    private void countTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        final long stopTime = System.currentTimeMillis();
        final long durationTime = stopTime - startTime;

        System.out.println("DurationTime of method " + joinPoint.getSignature().getName() + " is equal = " + durationTime + " ms");
    }
}
