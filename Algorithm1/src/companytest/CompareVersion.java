package companytest;

import java.util.Scanner;

public class CompareVersion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] version = input.split(", ");
        int res = compareVersionNumber(version[0].replaceAll(", ", ""), version[1]);
        System.out.println(res);

//        String input = "1.2.3";
//        System.out.println(input.split(".")[0]);
    }

    private static int compareVersionNumber(String input, String input2){
        if(input == null || input2 == null)
            return 0;
//        char[] version = input.toCharArray();
//        char[] version2 = input2.toCharArray();
        String[] version = input.split("\\.");
        String[] version2 = input2.split("\\.");
        int len = version.length > version2.length? version.length: version2.length;

//        for(int i = 0; i < len; ++i){
////            if(version[i] == '.')
////                return -1;
////            if(version2[i] == '.')
////                return 1;
//            if(version[i] == version2[i])
//                continue;
//            if(version[i] - version2[i] > 0)
//                return 1;
//            else
//                return -1;
//        }

        for(int i = 0; i < len; ++i){
            if(Integer.parseInt(version[i]) - Integer.parseInt(version2[i]) > 0)
                return 1;
            else if(Integer.parseInt(version[i]) - Integer.parseInt(version2[i]) == 0)
                continue;
            else
                return -1;
        }

//        if(input.compareTo(input2) > 0)
//            return -1;
//        else if(input.compareTo(input2) < 0)
//            return 1;
        return 0;
    }
}
