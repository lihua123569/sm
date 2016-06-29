package com.sina.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  //import org.springframework.stereotype.Component;
public class MyTestServiceImpl  implements IMyTestService {
      @Scheduled(cron="0/10 * *  * * ? ")   //每5秒执行一次
      @Override
      public void myTest(){
            System.out.println("进入测试");
      }
      
      /**  
       * 定时计算。每天凌晨 01:00 执行一次  
       */    
      @Scheduled(cron = "0 0 1 * * *")   
      public void show(){  
          System.out.println("Annotation：is show run");  
      }  
        
      /**  
       * 心跳更新。启动时执行一次，之后每隔2秒执行一次  
       */    
      @Scheduled(fixedRate = 10000*2)   
      public void print(){  
          System.out.println("Annotation：print run");  
      }  
}