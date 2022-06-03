package com.jyami.leetCode.problem

class Solution304 {
}

class NumMatrix(matrix: Array<IntArray>) { // 한개 클래스를 생성해서 계속해서 사용하는 로직이기 때문에, dp 사용함

    val dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }
    init{
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] + matrix[i][j] - dp[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return dp[row2][col2] - dp[row1][col1] + dp[row2][col1] + dp[row1][col2]
    }

}