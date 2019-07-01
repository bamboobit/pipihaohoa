package leetcode.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description:
 * 冒泡排序是比较相邻两数的大小来完成排序的。这里定义比较边界，也就是进行大小比较的边界。对于长度为n的数组，
 * 第一趟的比较边界为[0,n-1]，也就是说从a[0]开始，相邻元素两两比较大小，如果满足条件就进行交换，否则继续比较，一直到最后一个比较的元素为a[n-1]为止，
 * 此时第一趟排序完成。以升序排序为例，每趟排序完成之后，比较边界中的最大值就沉入底部，比较边界就向前移动一个位置。
 * 所以，第二趟排序开始时，比较边界是[0,n-2]。对于长度为n的序列，
 * 最多需要n趟完成排序，所以冒泡排序就由两层循环构成，最外层循环用于控制排序的趟数，最内层循环用于比较相邻数字的大小并在本趟排序完成时更新比较边界。
 * 时间On^2
 * @author: xfh
 * @create: 2019-06-28 14:41
 **/
@Slf4j
public class MaoPao {
    /*冒泡排序是比较相邻两数的大小来完成排序的。这里定义比较边界，也就是进行大小比较的边界。对于长度为n的数组，
     * 第一趟的比较边界为[0,n-1]，也就是说从a[0]开始，相邻元素两两比较大小，如果满足条件就进行交换，否则继续比较，一直到最后一个比较的元素为a[n-1]为止，
     * 此时第一趟排序完成。以升序排序为例，每趟排序完成之后，比较边界中的最大值就沉入底部，比较边界就向前移动一个位置。
     * 所以，第二趟排序开始时，比较边界是[0,n-2]。对于长度为n的序列，
     * 最多需要n趟完成排序，所以冒泡排序就由两层循环构成，最外层循环用于控制排序的趟数，最内层循环用于比较相邻数字的大小并在本趟排序完成时更新比较边界。
     * 时间On^2*/
    private static int[] maopao(int[] a){
        int temp;
        int round = 0;//遍历次数
        for(int i = a.length-1;i >0;i--){
            int swapTimes = 0;//一次遍历交换次数
            for(int j = 0;j < i;j++){
                if(a[j]>a[j+1]){
                   temp = a[j];
                   a[j] = a[j+1];
                   a[j+1] = temp;
                   swapTimes+=1;
                }
            }
            //优化，若存在一次遍历中未发生交换。说明已经有序。
            if(swapTimes == 0){
                return a;
            }
            round+=1;
            log.info("交换次数={}",swapTimes);
        }
        log.info("遍历次数={}",round);
        return a;
    }

    /*直接插入排序：（从头找到插入位置，位置之后之后一次位移）将待排序的数组划分为局部有序子数组subSorted和无序子数组subUnSorted，每次排序时从subUnSorted中挑出第一个元素，
     * 从后向前将其与subSorted各元素比较大小，按照大小插入合适的位置，插入完成后将此元素从subUnSorted中移除，
     * 重复这个过程直至subUnSorted中没有元素，总之就时从后向前，一边比较一边移动。
     * 时间On^2*/
    private static int[] insert(int[] a){
        int temp;
        for(int i = 1;i<a.length;i++){
            for(int j = 0;j<i;j++){
                if(a[i]<a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    /*
    * 折半插入排序*/
    private static int[] halfInsert(int[] a){
        int temp;
        for(int i = 1;i<a.length;i++){
            int low = 0;
            int high = i;
            int mid;
            //折半
            while (low<=high){
                mid = (low+high)/2;
                if(a[mid]<a[i]){
                    low = mid;
                }else {
                    high = mid;
                }

            }


        }
        return a;
    }

   /* private static int[] shellsort(int[] a){
        int step = 2;
        for()
        return a;
    }*/

    public static void main(String[] args) {
        int[] a = {-1,1,12,18,11,6,29,99,1012,2,78};
        //System.out.println(Arrays.toString(maopao(a)));
        //System.out.println(Arrays.toString(insert(a)));
        System.out.println(Arrays.toString(halfInsert(a)));

    }
}
