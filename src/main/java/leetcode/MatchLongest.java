package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * @author: xfh
 * @create: 2019-07-01 17:29
 **/

public class MatchLongest {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }else {
            String pre = strs[0];
            for(int i = 1;i<strs.length;i++){
               while (!pre.equals(strs[i].length()>pre.length()?strs[i].substring(0,pre.length()):pre.length())){
                   pre = pre.substring(0,pre.length()-1);
               }
            }
            return pre;
        }
    }

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(a));
    }
}
