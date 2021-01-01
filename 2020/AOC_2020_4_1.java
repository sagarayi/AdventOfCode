import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AOC_2020_4_1 {
    public static void main(String[] args) throws Exception {
        File file = new File("2020_4_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Passport> inputList = new ArrayList<>();
        String str;
        String inputStr = "";
        while((str = br.readLine()) != null){
            if(str.length() == 0){
                inputList.add(parseInput(inputStr));
                inputStr = "";
            } else {
                inputStr += " " + str;
            }
        }
        inputList.add(parseInput(inputStr));
        br.close(); 

        System.out.println(validPassportCount(inputList));
    }

    private static Passport parseInput(String inputLine) {
        String [] items = inputLine.split(" ");
        Passport passport = new Passport();
        for(String item : items){
            if(item.contains("ecl:")){
                passport.ecl = item.split("ecl:")[1];
            } else if(item.contains("byr:")){
                passport.byr = item.split("byr:")[1];
            } else if(item.contains("iyr:")){
                passport.iyr = item.split("iyr:")[1]; 
            } else if(item.contains("eyr:")){
                passport.eyr = item.split("eyr:")[1];
            } else if(item.contains("hgt:")){
                passport.hgt = item.split("hgt:")[1]; 
            } else if(item.contains("hcl:")){
                passport.hcl = item.split("hcl:")[1];
            } else if(item.contains("pid:")){
                passport.pid = item.split("pid:")[1]; 
            } else if(item.contains("cid:")){
                passport.cid = item.split("cid:")[1];
            }
        }
        System.out.println(passport.isValid());
        return passport;
    }

    private static int validPassportCount(List<Passport> inputPassports){
        int count = 0;
        for(Passport p: inputPassports){
            if(p.isValid()){
                count ++;
            }
        }

        return count;
    }


}

class Passport {
    String byr, iyr, eyr, hgt, hcl, ecl, pid, cid;

    public Passport() { }

    public boolean isValid(){
        return ((this.byr != null 
        && this.iyr != null 
        && this.eyr != null 
        && this.hgt != null 
        && this.hcl != null
        && this.ecl != null
        && this.pid != null
        && this.cid != null) || 
        (this.byr != null 
        && this.iyr != null 
        && this.eyr != null 
        && this.hgt != null 
        && this.hcl != null
        && this.ecl != null
        && this.pid != null));
    }

    @Override
    public String toString() {
        return "{" +
            " byr='" + byr + "'" +
            ", iyr='" + iyr + "'" +
            ", eyr='" + eyr + "'" +
            ", hgt='" + hgt + "'" +
            ", hcl='" + hcl + "'" +
            ", ecl='" + ecl + "'" +
            ", pid='" + pid + "'" +
            ", cid='" + cid + "'" +
            "}";
    }
}
