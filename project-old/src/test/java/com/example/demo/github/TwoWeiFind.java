package com.example.demo.github;

public class TwoWeiFind {

    public class Solution {
        public boolean Find(int [][] array,int target) {
            if(array.length == 0)
                return false;
            int len = array.length;
            int wid = array[0].length;
            if( wid == 0)
                return false;
            int i=len-1,j=0;//从左下角开始移动
            while(i>=0&&j<wid){
                if( array[i][j] > target ){//比target大就向上移动
                    i--;
                }else if( array[i][j] < target){//比target小就向右移动，以便增大
                    j++;
                }else{
                    return true;
                }
            }
            return false;
        }
    }
}
