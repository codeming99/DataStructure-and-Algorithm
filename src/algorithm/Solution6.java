package algorithm;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。
 * 但是，每个孩子最多只能给一块糖果。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的糖果的最小尺寸；
 * 并且每块糖果 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个糖果 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块糖果。
 *
 * 例如
 * 输入：1 2 3
 *      1 1
 *
 * 输出：1
 *
 * 使用贪心算法，每颗糖都找比他小的最大的胃口数，直接用有序表完成操作
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String[] candy = sc.nextLine().split(" ");
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(String item : str){
            treeSet.add(Integer.parseInt(item));
        }

        int sum = 0;
        int temp;
        for(String item : candy){
            if(treeSet.floor(Integer.parseInt(item)) != null){
                temp = treeSet.floor(Integer.parseInt(item));
                sum++;
                treeSet.remove(temp);
            }
        }

        System.out.println(sum);
    }
}
