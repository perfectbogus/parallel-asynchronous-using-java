package com.learnjava.util;

import org.apache.commons.lang3.time.StopWatch;

import static java.lang.Thread.sleep;

public class CommonUtil {

    public static StopWatch stopWatch = new StopWatch();

   public static void startTimer(){
       stopWatch.start();
   }

    public static long timeTaken(){
        stopWatch.stop();
        return stopWatch.getTime();
    }

    public static void delay(long delayMilliSeconds)  {
        try{
            sleep(delayMilliSeconds);
        }catch (Exception e){
            LoggerUtil.log("Exception is :" + e.getMessage());
        }

    }


}
