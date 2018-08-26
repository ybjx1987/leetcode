package com.leetcode.problem;

/**
 * Created by YuBing on 2018/8/22.
 */
public class MedianOfTwoSortedArrays {

    /**
     * 通过二分查找中位数
     */
    private static double solution1(int [] nums1, int [] nums2){

        if(nums1.length > nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int min = 0;
        int max = len1;
        int v = (len1 + len2 + 1) / 2;
        int i,j,left,right;
        while(min <= max){
            i = (min + max) / 2;
            j = v - i;
            if(i < max && nums2[j - 1] > nums1[i]){
                min = i + 1;
            }else if(i > min && nums2[j] < nums1[i - 1]){
                max = i - 1;
            }
            else{
                if(i == 0){
                    left = nums2[j - 1];
                }
                else if(j == 0){
                    left = nums1[i - 1];
                }
                else{
                    left = nums1[i - 1] > nums2[j - 1]?nums1[i - 1]:nums2[j - 1];
                }
                if((len1 + len2) % 2 == 1){
                    return left;
                }
                if(i == len1){
                    right = nums2[j];
                }
                else if(j == len2){
                    right = nums1[i];
                }
                else{
                    right = nums1[i]>nums2[j]?nums2[j]:nums1[i];
                }
                return (left + right) / 2.0;
            }
        }
        return 0.0;
    }


    public static void main(String [] args){
        System.out.println(solution1(new int[]{1, 3}, new int []{2}));
        System.out.println(solution1(new int[]{1, 2}, new int []{3,4}));
        System.out.println(solution1(new int[]{}, new int []{1}));
        System.out.println(solution1(new int[]{}, new int []{1,2}));
        System.out.println(solution1(new int[]{3}, new int []{1,2,4}));
        System.out.println(solution1(new int[]{3,7}, new int []{1,2,4}));
    }
}
