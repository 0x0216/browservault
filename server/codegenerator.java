import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class codegenerator {
    private static final String master = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
    public static void main(String[] args) throws IOException {
       double count = Math.random()*4 + 12;
       StringBuilder bruh = new StringBuilder();
       for (int i =0; i < count; i++){
           int character = (int)(Math.random()*master.length());
           bruh.append(master.charAt(character));
       }
        filer(bruh);
        
    }
    public static void filer(StringBuilder s) throws IOException{
        File file = new File("C:\\" +s.toString() + ".txt");
        FileWriter br = new FileWriter("C:\\" +s.toString() + ".txt");
        String su = s.toString();
        br.write(su);
        
    }

    
}
