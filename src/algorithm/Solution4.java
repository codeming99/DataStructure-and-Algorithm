package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 农场有n只鸡鸭排为一个队伍，鸡用“C”表示，鸭用“D”表示。
 * 当鸡鸭挨着时会产生矛盾。需要对所排的队伍进行调整，使鸡鸭各在一边。
 * 每次调整只能让相邻的鸡和鸭交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。
 * 例如：CCDCC->CCCDC->CCCCD这样就能使之前的两处鸡鸭相邻变为一处鸡鸭相邻，需要调整队形两次。
 */
public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = reader.readLine().toCharArray();
        //分别统计C在前面和D在前面的移动次数
        int ret_C = 0,ret_D=0,count_C = 0,count_D = 0;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == 'C'){
                ret_C += i - count_C;
                count_C++;
            }else {
                ret_D += i - count_D;
                count_D++;
            }
        }

        System.out.println(Math.min(ret_C,ret_D));
    }
}
