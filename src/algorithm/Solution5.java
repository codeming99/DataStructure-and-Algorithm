package algorithm;


import java.util.Scanner;

/**
 * 给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入比特币前卖出。
 *
 * 例如：输入： 7 1 5 6 4
 *      输出： 5
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int buy = scanner.nextInt();
        int profit = 0;
        while(scanner.hasNext()){
            //输入新的价格
            int price = scanner.nextInt();
            //每次输入最新的价格，更新最大的利润
            profit = Math.max(profit,price - buy);
            //保持买入价最低
            buy = Math.min(buy,price);
        }
        System.out.println(profit);
    }
}
