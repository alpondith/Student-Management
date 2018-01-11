import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class practice {
    public static void main(String args[]) throws Exception {


      /* creating file to a specific directory.
        PrintWriter writer = new PrintWriter("data/aa.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.println("The 3rd fucking line");
        writer.close();*/

       /* int i =1;
        while(true){
            System.out.println("baal");

            i++;
            if (i == 3){
                break;
            }
        }*/

        /*student s = new student(1, "Aaaa", "summer16", "fall06",3.3,"Gazipur");

       // System.out.println(s);
       // String ss = String.valueOf(s);
        //System.out.println(s);


        PrintWriter writer = new PrintWriter("data/student/bb.txt", "UTF-8");
        writer.println(s);
        writer.close();

        File ff = new File("data/student/bb.txt");
        Scanner fsc = new Scanner(ff);
        while (fsc.hasNextLine() ){
            System.out.println(fsc.nextLine());
        }
        fsc.close();*/

      /*faculty f = new faculty(1, "c", "abul", "head sir","comilla");
        System.out.println(f);
        String s = String.valueOf(f);
        System.out.println(s);


        PrintWriter writer = new PrintWriter("data/faculty/1.txt", "UTF-8");
        writer.println(s);
        writer.close();*/


       /* File location = new File("data/student/bb.txt");
        boolean exists = location.exists();
        System.out.println(exists);*/




        /*List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("1.txt"), StandardCharsets.UTF_8));
        fileContent.set(4, "hugar result");
        Files.write(Paths.get("1.txt"), fileContent, StandardCharsets.UTF_8);*/



       /* List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).equals("old line")) {
                fileContent.set(i, "new line");
                break;
            }
        }

        Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
        */


        /*admin adm = new admin(1,"a","Admin","Gazipur");
        String s = String.valueOf(adm);
        System.out.println(s);
        PrintWriter writer = new PrintWriter("data/admin/1.txt", "UTF-8");
        writer.println(s);
        writer.close();*/

    }


}
