import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AOC_2020_1_2 {
    public static void main(String[] args) throws Exception{
        System.out.println(new File(".").getCanonicalPath());
        File file = new File("2020_1_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Integer> inputList = new ArrayList<>();
        String str;
        while((str = br.readLine()) != null){
            inputList.add(Integer.parseInt(str));
        }
        br.close(); 

        System.out.println(productTripleSum(inputList, 2020)); 
    }

    private static long productTripleSum(List<Integer> inputList, int sum) {
        for(int ele : inputList){
            long res = AOC_2020_1_1.productOfSum(inputList, sum - ele);
            if(res > 0){
                return res * ele;
            }
        }
        return 0;
    }
}
