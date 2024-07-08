package com.yongzh;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @author yongzh
 * @version 1.0
 * @description: TODO
 * @date 2024/2/19 21:02
 */
public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(()-> {
                System.out.println("run方法执行");
            }).start();

        int i = calculateNum((int a , int b) ->{
            return a + b;
        });
        System.out.println(i);
        printNUm( value -> value % 2 == 0 );
        System.out.println(Optional.ofNullable(typeConver(st ->
                Integer.valueOf(st)
        )));
    }
    public static  int calculateNum(IntBinaryOperator operator){
        int a= 10;
        int b = 20;
        return operator.applyAsInt(a,b);
    }
    public static void printNUm(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i:arr){
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }
    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }
}
