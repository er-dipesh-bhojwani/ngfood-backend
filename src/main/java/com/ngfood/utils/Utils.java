package com.ngfood.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

     public   static  Double totalWeight(Long noOfBags, Long bagWeight){

         return BigDecimal.valueOf((double) (noOfBags * bagWeight) / 100)
                 .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

      public  static Double totalAmount(Long noOfBags, Long bagWeight, Long rate){

         double totalAmount =  BigDecimal.valueOf(totalWeight(noOfBags, bagWeight) * rate )
                 .setScale(3, RoundingMode.HALF_DOWN).doubleValue();
         System.out.println("Toatal Amount:" + totalAmount);
        // double difference = totalAmount * (cashDiscount / 100);
        return totalAmount;
     }
}
