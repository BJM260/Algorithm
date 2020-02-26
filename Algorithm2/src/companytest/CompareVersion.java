import java.util.Scanner;

/**
 * 题目描述：
 *      比较版两个本号version1和version2大小：
 * 输入描述：
 *      版本号可以由数字和字符'.'组成，输入时版本号之间用', '隔开；
 * 输出描述：
 *      version1>version2时return 1;
 *      version1<version2时return -1;
 *      version1==version2时return 0;
 * 例子：
 *      输入：1.10.1, 1.2.3
 *      输出：1
 */
public class CompareVersion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] version = input.split(", ");
        int res = compareVersionNumber(version[0].trim().replaceAll(",", ""), version[1].trim());
        System.out.println(res);
    }

    private static int compareVersionNumber(String input, String input2){
        if(input == null || input2 == null)
            return 0;
        //两个version用"."作为间隔进行分隔，然后对每段分隔进行大小比较
        //由于"."中的.可以代表正则表达式中的任意一个字符，所以需要用\\防止转意
        String[] version = input.split("\\.");
        String[] version2 = input2.split("\\.");
        int len = version.length > version2.length? version2.length: version.length;
        //version号中的每段数字进行比较
        for(int i = 0; i < len; ++i){
            if(Integer.parseInt(version[i]) - Integer.parseInt(version2[i]) > 0)
                return 1;
            else if(Integer.parseInt(version[i]) - Integer.parseInt(version2[i]) == 0)
                continue;
            else
                return -1;
        }
        //如果某个version号比另一个version号长或短
        if(version.length > version2.length)
            return 1;
        else if(version.length < version2.length)
            return -1;
        //以上情况都不满足，那两个version号相同
        return 0;
    }
}
