package com.jyami.exam.codility;

/**
 * Created by jyami on 2020/01/10
 */
public class Naver_Intern_Codility_1 {
    public static void main(String[] args) {
        int[][] array = {{0,1,9,3},{7,5,8,3},{9,2,9,4},{4,6,7,1}};
        System.out.println(new Solution().solution(array));

    }

    static class Solution {
        public int solution(int[][] A) {
            int row = A.length;
            int col = A[0].length;
            int count =0;
            for(int p=1; p<row-1; p++){
                for(int q =1; q<col-1; q++){
                    if(isSaddlePoint1(p,q,A) || isSaddlePoint2(p,q,A))
                        count++;
                }
            }
            return count;
        }

        public boolean isSaddlePoint1(int p, int q, int[][] A){ // row min / col max
            return (A[p][q-1] > A[p][q] && A[p][q] < A[p][q+1]) && (A[p-1][q] < A[p][q]  && A[p][q] > A[p+1][q]);
        }

        public boolean isSaddlePoint2(int p, int q, int[][] A){ // row max / col min
            return (A[p][q-1] < A[p][q] && A[p][q] > A[p][q+1]) && (A[p-1][q] > A[p][q]  && A[p][q] < A[p+1][q]);
        }
    }

}
