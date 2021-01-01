import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AOC_2020_4_2 {
    private static class Passport {
        String byr, iyr, eyr, hgt, hcl, ecl, pid, cid;
    
        public Passport() { }
    
        public boolean isValid(){
            return this.isBYRValid() &&
            this.isCIDValid() &&
            this.isECLValid() &&
            this.isEYRValid() &&
            this.isHCLValid() &&
            this.isHGTValid() &&
            this.isIYRValid() &&
            this.isPIDValid();
        }
    
        private boolean isBYRValid(){
            return this.byr != null && byr.length() == 4 && Integer.parseInt(this.byr) >= 1920 && Integer.parseInt(this.byr) <= 2002; 
        }
    
        private boolean isIYRValid(){
            return this.iyr != null && iyr.length() == 4 && Integer.parseInt(this.iyr) >= 2010 && Integer.parseInt(this.iyr) <= 2020; 
        }
    
        private boolean isEYRValid(){
            return this.eyr != null && eyr.length() == 4 && Integer.parseInt(this.eyr) >= 2020 && Integer.parseInt(this.eyr) <= 2030; 
        }
    
        private boolean isHGTValid(){
            if(this.hgt != null && this.hgt.contains("cm")) {
                int cm = Integer.parseInt( this.hgt.split("cm")[0]);
                return cm >= 150 && cm <= 193;
            } 
            if(this.hgt != null && this.hgt.contains("in")) {
                int in = Integer.parseInt( this.hgt.split("in")[0]);
                return in >= 59 && in <= 76;
            }
            return false;
        }
    
        private boolean isHCLValid() {
            return this.hcl != null && this.hcl.contains("#") && this.hcl.split("#")[1].matches("^[a-f|0-9]+");
        }
    
        private boolean isECLValid() {
            return this.ecl != null && (this.ecl.contains("amb") || this.ecl.contains("blu") || this.ecl.contains("brn") || this.ecl.contains("gry") || this.ecl.contains("grn") || this.ecl.contains("hzl") || this.ecl.contains("oth") );
        }
    
        private boolean isPIDValid() {
            try{
                int pid = Integer.parseInt(this.pid);
                return this.pid != null && this.pid.length() == 9;
            } catch(NumberFormatException e){
                return false;
            }
        }
    
        private boolean isCIDValid() {
            return true;
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