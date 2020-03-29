
public class codegenerator {
    private static final String master = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
    public static void main(String[] args) {
       double count = Math.random()*4 + 12;
       StringBuilder bruh = new StringBuilder();
       for (int i =0; i < count; i++){
           int character = (int)(Math.random()*master.length());
           bruh.append(master.charAt(character));
       }
        System.out.println(bruh);
    }

}
