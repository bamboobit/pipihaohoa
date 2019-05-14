package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xfh
 * @Date: 2019/5/13
 * @Description:
 */
public class DividCake {
    private static  int maxPeople(int[] people,int[] cake){
        Arrays.sort(people);
        Arrays.sort(cake);
        Integer mid = 0;
        mid = mid+people.length-1;
        Boolean flag = canfeed(people,cake,mid);
    }

    private static Boolean canfeed(int[] people,int[] cake,Integer max){
        for(int i=max;i>=0;i--){

        }
    }
    public static void main(String[] args) {
        int[] people ={11,2,5,4};
        int[] cake ={12,10};
        Integer num = maxPeople(people,cake);
    }
}
