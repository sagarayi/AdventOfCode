import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AOC_2020_2_1 {

    private static class Password {
        int minCount = 0;
        int maxCount = 0;
        String substring = "";
        String password = "";

        public Password(int minCount, int maxCount, String substring, String password){
            this.minCount = minCount;
            this.maxCount = maxCount;
            this.substring = substring;
            this.password = password;
        }

        public boolean isValid(){
            boolean firstPosRes = this.password.charAt(this.minCount-1) == substring.charAt(0);
            boolean secondPosRes = this.password.charAt(this.maxCount-1) == substring.charAt(0);
            return (firstPosRes && !secondPosRes) || (!firstPosRes && secondPosRes);
        }

        private List<Integer> occurancesOfSubStr(String str, String subStr){
            List<Integer> res = new ArrayList<>();
            int index = str.indexOf(subStr);
            while (index >= 0) {
                res.add(index);
                index = str.indexOf(subStr, index + 1);
            }
            return res;
        }
    }
    public static void main(String[] args) throws Exception{
        System.out.println(new File(".").getCanonicalPath());
        File file = new File("2020_2_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Password> inputList = new ArrayList<>();
        String str;
        while((str = br.readLine()) != null){

            inputList.add(parseInput(str));
        }
        br.close(); 

        System.out.println(validPasswordCount(inputList));
    }

    private static Password parseInput(String input) {
        String[] row = input.split(" ");
        int minCount = Integer.parseInt(row[0].split("-")[0]);
        int maxCount = Integer.parseInt(row[0].split("-")[1]);
        String substring = row[1].split(":")[0];
        String pass = row[2];
        return new Password(minCount, maxCount, substring, pass);
    }

    private static long validPasswordCount(List<Password> passwords) {
        long count = 0;
        for(Password password: passwords){
            if(password.isValid()){
                count ++;
            }
        }
        return count;
    }
}
