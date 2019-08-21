package leetcode;

/**
 * @description:
 * @author: xfh
 * @create: 2019-07-04 11:23
 **/
public class ZeroTest {
    public static void main(String[] args) {
        int j = 0;
        try {
            //int i = 100 / 0;
            //System.out.print(i);
            if(j==0){
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.print(1);
            throw new RuntimeException();
        }
        /* finally {
            System.out.print(2);
        }*/
        System.out.print(3);
    }
}
