package pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.domain;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMeasurementAspect {

    private long startTime;
    private long stopTime;

    @Before("@annotation(pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.CuntDurationTime)")
    private void startCounter(){
        startTime=System.currentTimeMillis();
    }

    @After("@annotation(pl.kmiecik.m9_mongodb_vs_hibernate_1000csv_homework.CuntDurationTime)")
    private void stopCounter(){
        stopTime=System.currentTimeMillis();
    showDurationTime();
    }

    private void showDurationTime() {
        long durrationTime = stopTime - startTime;
        System.out.println("Durration time in ms = " + durrationTime);
    }


}
