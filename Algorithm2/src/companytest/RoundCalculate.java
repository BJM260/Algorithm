import java.util.Arrays;
import java.util.Scanner;

public class RoundCalculate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        float[] inputNumber = new float[input.length];
        for (int i = 0; i < input.length; ++i)
            inputNumber[i] = Float.valueOf(input[i]);
        float res = maxDefference(inputNumber);
        System.out.println(res);
//        System.arraycopy();
    }

    private static float maxDefference(float[] inputNumber){
        if(inputNumber == null || inputNumber.length == 0)
            return 0;
        Arrays.sort(inputNumber);
        if(inputNumber[inputNumber.length - 1] <= 180)
            return Math.abs(inputNumber[inputNumber.length - 1] - inputNumber[0]);
        else if(inputNumber[0] > 180)
            return Math.abs(inputNumber[inputNumber.length - 1] - inputNumber[0]);
        else {
            float closest = inputNumber[0];
            for(int i = 0; i < inputNumber.length; ++i)
                if(Math.abs(180 - inputNumber[i]) < Math.abs(180 - closest))
                    closest = inputNumber[i];
            return Math.abs(closest - inputNumber[0]);
        }
    }
}
