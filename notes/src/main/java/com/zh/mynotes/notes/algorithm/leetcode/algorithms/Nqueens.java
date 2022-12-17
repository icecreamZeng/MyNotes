package com.zh.mynotes.notes.algorithm.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//n皇后问题，每个皇后可以攻击同行同列或左上、左下、右上、右下方向的其他棋子
//现在有n*n的棋盘，n个皇后，需要他们互相不能攻击，求所有可能的摆放情况
public class Nqueens {

    static List<Integer[][]> result = new ArrayList<>();
   
    public static void main(String[] args) {
        solveNQueens(10);
        printResult(result);
    }


    private static void printResult(List<Integer[][]> list) {
        if(list == null || list.isEmpty()){
            System.out.println("没有结果!");
            return;
        }
        for(int i=0; i < list.size(); i ++){
            System.out.println("第"+(i +1)+"种情况");
            Integer[][] array = list.get(i);
            for (int j=0 ; j< array.length ; j++){
                System.out.println (Arrays.toString (array[j]));
            }
        }
    }


    public static  List<Integer[][]> solveNQueens(int  n){
        Integer[][] path = init(n);
        method(path,0);
        return result;
    }

    private static Integer[][] init(int n) {
        Integer[][] array = new Integer[n][n];
        for (int row = 0 ; row < n ; row ++){
            for (int col = 0; col < n; col++) {
                array[row][col] = 0;
            }
        }
        return array;
    }


    private static void method(Integer[][] path, int row) {
        //退出条件
        if(path.length<= row){        
            result.add(copy(path));
            return;
        }  

        //下一个路径
        int n = path.length ;
        for(int col = 0 ; col < n ; col ++){
            if(!isValid(path, row, col)){
                continue;
            }
            path[row][col] = 1;
            method(path, row + 1);
            path[row][col] = 0;
        }
    }

    //[row, col] -> [row-1, col+1]=[i,(col +row) -i]
    private static boolean isValid(Integer[][] path, int row, int col) {
        int n = path.length;
        for(int i = 0 ; i <row ;i ++){
            if(path[i][col] == 1){
                return false;
            }

            if ((i + col -row) >=0 && (i + col -row) < n && path[i][i + col -row] == 1){
                return false;
            }
            if ((col +row -i) >=0 && (col +row -i) < n && path[i][(col +row) -i] == 1){
                return false;
            }
        }
        return true;
    }


    private static Integer[][] copy(Integer[][] path) {
        int n = path.length;
        Integer[][] dest = new Integer[n][n];
        for(int row = 0; row < n ; row ++){
            for(int col = 0 ; col < n ; col ++){
                dest[row][col] = path[row][col];
            }
        }
        return dest;
    }

}
