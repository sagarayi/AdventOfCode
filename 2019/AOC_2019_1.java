import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AOC_2019_1{
    public static void main(String[] args) throws Exception {
        // URL url = getClass().getResource("ListStopWords.txt");
        System.out.println(new File(".").getCanonicalPath());
        File file = new File("2019/2019_1_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Integer> inputList = new ArrayList<>();
        String str;
        while((str = br.readLine()) != null){
            inputList.add(Integer.parseInt(str));
        }
        br.close();

        System.out.println(getTotalFuelUpper(inputList.stream().mapToInt(Integer::intValue).toArray()));
    }

    private static long getTotalFuelUpper(int[] masses){
        long sum = 0;
        for(int ele : masses){
            int temp = getFuelForMass(ele);
            while(temp > 0){
                sum += temp;
                temp = getFuelForMass(temp);
            }
            // sum += (int)(Math.floor(ele/3.0) - 2);
        }
        return sum;
    }

    private static int getFuelForMass(int mass){
        return (int)(Math.floor(mass/3.0) - 2);
    }
}