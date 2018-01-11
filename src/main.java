import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String args[]) throws Exception {
        Scanner st = new Scanner(System.in);
        Scanner si = new Scanner(System.in);
        // Starts main block here

        while (true) {
            // options for the users
            System.out.println("============================");
            System.out.println("1. admin");
            System.out.println("2. faculty");
            System.out.println("3. student");
            System.out.println("4. end program");
            System.out.println("============================");
            System.out.print("give your choice: ");
            String input = st.nextLine();

            //admin all codes here
            if (input.equals("1") || input.equals("admin")) {
                while (true) {
                    System.out.println("============================");
                    System.out.println("1. login");
                    System.out.println("2. exit");
                    System.out.println("============================");
                    System.out.print("give your choice:");
                    String choice = st.nextLine();
                    // login option chosen
                    if (choice.equals("1") || choice.equals("login")) {
                        System.out.print("enter id:");
                        String id = st.nextLine();
                        System.out.print("enter password:");
                        String pass = st.nextLine();

                        File location = new File("data/admin/" + id + ".txt");
                        boolean check = location.exists();
                        // if id exists
                        if (check == true) {
                            Scanner scan = new Scanner(location);
                            scan.nextLine();//don't need the first line. so didn't store id.
                            String passString = scan.nextLine();//password is in the second line. so i stored it.
                            scan.close();
                            String arr[] = passString.split(":");
                            String mainPassword = arr[1];
                            //id and password matching
                            if (id.equals(id) && pass.equals(mainPassword)) {
                                while (true) {
                                    System.out.println("============================");
                                    System.out.println("1. your information");
                                    System.out.println("2. admin information");
                                    System.out.println("3. add admin");
                                    System.out.println("4. delete admin");
                                    System.out.println("5. edit admin");
                                    System.out.println("6. faculty information");
                                    System.out.println("7. add faculty");
                                    System.out.println("8. edit faculty");
                                    System.out.println("9. delete faculty");
                                    System.out.println("10. student information");
                                    System.out.println("11. add student");
                                    System.out.println("12. edit student");
                                    System.out.println("13. delete student");
                                    System.out.println("14. logout");
                                    System.out.println("============================");
                                    System.out.print("give your choice:");
                                    input = st.nextLine();
                                    //if faculty information chosen
                                    if (input.equals("1") || input.equals("your information")) {
                                        //information printing
                                        System.out.println("============================");
                                        File ff = new File("data/admin/" + id + ".txt");
                                        Scanner fsc = new Scanner(ff);
                                        while (fsc.hasNextLine()) {
                                            System.out.println(fsc.nextLine());
                                        }
                                        fsc.close();
                                    }
                                    // other admin information watching
                                    else if (input.equals("2") || input.equals("admin information")) {
                                        System.out.print("Give admin id: ");
                                        id = st.nextLine();
                                        File admin = new File("data/admin/" + id + ".txt");
                                        boolean stdCheck = admin.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            Scanner fsc = new Scanner(admin);
                                            while (fsc.hasNextLine()) {
                                                System.out.println(fsc.nextLine());
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }
                                    // adding new admin
                                    else if (input.equals("3") || input.equals("add admin")) {
                                        System.out.print("Give admin new id:");
                                        int adminId = si.nextInt();
                                        System.out.print("Give admin Password:");
                                        String adpass = st.nextLine();
                                        System.out.print("Give admin name:");
                                        String adname = st.nextLine();
                                        System.out.print("Give admin Address:");
                                        String admAdd = st.nextLine();

                                        File admina = new File("data/admin/" + adminId + ".txt");
                                        boolean stdCheck = admina.exists();
                                        if (stdCheck == false) {
                                            admin adm = new admin(adminId, adpass, adname, admAdd);
                                            String s = String.valueOf(adm);
                                            //System.out.println(s);
                                            PrintWriter writer = new PrintWriter("data/admin/" + adminId + ".txt", "UTF-8");
                                            writer.println(s);
                                            writer.close();

                                            System.out.println("============================");
                                            System.out.println("your added new admin information :");
                                            Scanner fsc = new Scanner(admina);
                                            while (fsc.hasNextLine()) {
                                                System.out.println(fsc.nextLine());
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("your given id already exists. try with new id. thanks");
                                        }
                                    }
                                    // admin delete codes
                                    else if (input.equals("4") || input.equals("delete admin")) {
                                        System.out.print("Give admin id: ");
                                        id = st.nextLine();
                                        File admin = new File("data/admin/" + id + ".txt");
                                        boolean stdCheck = admin.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            admin.delete();
                                            System.out.println("admin id has been deleted.");
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }

                                    //edit admin information
                                    else if (input.equals("5") || input.equals("edit admin")) {
                                        System.out.print("Give admin id: ");
                                        id = st.nextLine();
                                        File ad = new File("data/admin/" + id + ".txt");
                                        boolean stdCheck = ad.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            System.out.println("current information :");
                                            Scanner ads = new Scanner(ad);
                                            while (ads.hasNextLine()) {
                                                System.out.println(ads.nextLine());
                                            }
                                            ads.close();
                                            while (true) {
                                                System.out.println("============================");
                                                System.out.println("1. change password");
                                                System.out.println("2. change name");
                                                System.out.println("3. change address");
                                                System.out.println("4. exit");
                                                System.out.println("============================");
                                                System.out.print("give your choice:");
                                                input = st.nextLine();
                                                String store = "";
                                                if (input.equals("1")) {
                                                    System.out.print("Give new password: ");
                                                    store = st.nextLine();
                                                    store = "Password:" + store;
                                                } else if (input.equals("2")) {
                                                    System.out.print("Give new name: ");
                                                    store = st.nextLine();
                                                    store = "Name:" + store;
                                                } else if (input.equals("3")) {
                                                    System.out.print("Give new address: ");
                                                    store = st.nextLine();
                                                    store = "Address:" + store;
                                                } else if (input.equals("4")) {
                                                    break;
                                                } else {
                                                    continue;
                                                }
                                                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("data/admin/" + id + ".txt"), StandardCharsets.UTF_8));
                                                fileContent.set(Integer.parseInt(input), store);
                                                Files.write(Paths.get("data/admin/" + id + ".txt"), fileContent, StandardCharsets.UTF_8);
                                                fileContent.clear();

                                                System.out.println("============================");
                                                System.out.println("updated information :");
                                                ads = new Scanner(ad);
                                                while (ads.hasNextLine()) {
                                                    System.out.println(ads.nextLine());
                                                }
                                                ads.close();
                                                System.out.println("============================");

                                            }

                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }
                                    //if faculty information chosen
                                    else if (input.equals("6") || input.equals("faculty information")) {
                                        System.out.print("Give faculty id: ");
                                        id = st.nextLine();
                                        File fc = new File("data/faculty/" + id + ".txt");
                                        boolean stdCheck = fc.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            Scanner fsc = new Scanner(fc);
                                            while (fsc.hasNextLine()) {
                                                System.out.println(fsc.nextLine());
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }

                                    // adding faculty
                                    else if (input.equals("7") || input.equals("add faculty")) {
                                        System.out.print("Give faculty new id:");
                                        int fId = si.nextInt();
                                        System.out.print("Give faculty Password:");
                                        String fpass = st.nextLine();
                                        System.out.print("Give Faculty name:");
                                        String fname = st.nextLine();
                                        System.out.print("Give faculty Post:");
                                        String fpost = st.nextLine();
                                        System.out.print("Give faculty Address:");
                                        String fadd = st.nextLine();

                                        File file = new File("data/faculty/" + fId + ".txt");
                                        boolean stdCheck = file.exists();
                                        if (stdCheck == false) {
                                            faculty f = new faculty(fId, fpass, fname, fpost, fadd);
                                            String s = String.valueOf(f);
                                            //System.out.println(s);
                                            PrintWriter writer = new PrintWriter("data/faculty/" + fId + ".txt", "UTF-8");
                                            writer.println(s);
                                            writer.close();

                                            System.out.println("============================");
                                            System.out.println("your added new faculty information :");
                                            Scanner fsc = new Scanner(file);
                                            while (fsc.hasNextLine()) {
                                                System.out.println(fsc.nextLine());
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("your given id already exists. try with new id. thanks");
                                        }
                                    }

                                    //editing faculty
                                    else if (input.equals("8") || input.equals("edit faculty")) {
                                        System.out.print("Give faculty id: ");
                                        id = st.nextLine();
                                        File ad = new File("data/faculty/" + id + ".txt");
                                        boolean stdCheck = ad.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            System.out.println("current information :");
                                            Scanner ads = new Scanner(ad);
                                            while (ads.hasNextLine()) {
                                                System.out.println(ads.nextLine());
                                            }
                                            ads.close();
                                            while (true) {
                                                System.out.println("============================");
                                                System.out.println("1. change password");
                                                System.out.println("2. change name");
                                                System.out.println("3. change post");
                                                System.out.println("4. change address");
                                                System.out.println("5. exit");
                                                System.out.println("============================");
                                                System.out.print("give your choice:");
                                                input = st.nextLine();
                                                String store = "";
                                                if (input.equals("1")) {
                                                    System.out.print("Give new password: ");
                                                    store = st.nextLine();
                                                    store = "Password:" + store;
                                                } else if (input.equals("2")) {
                                                    System.out.print("Give new name: ");
                                                    store = st.nextLine();
                                                    store = "Name:" + store;
                                                } else if (input.equals("3")) {
                                                    System.out.print("Give new post: ");
                                                    store = st.nextLine();
                                                    store = "Post:" + store;
                                                } else if (input.equals("4")) {
                                                    System.out.print("Give new address: ");
                                                    store = st.nextLine();
                                                    store = "Address:" + store;
                                                } else if (input.equals("5")) {
                                                    break;
                                                } else {
                                                    continue;
                                                }
                                                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("data/faculty/" + id + ".txt"), StandardCharsets.UTF_8));
                                                fileContent.set(Integer.parseInt(input), store);
                                                Files.write(Paths.get("data/faculty/" + id + ".txt"), fileContent, StandardCharsets.UTF_8);
                                                fileContent.clear();

                                                System.out.println("============================");
                                                System.out.println("updated information :");
                                                ads = new Scanner(ad);
                                                while (ads.hasNextLine()) {
                                                    System.out.println(ads.nextLine());
                                                }
                                                ads.close();
                                                System.out.println("============================");

                                            }

                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }

                                    // faculty delete codes
                                    else if (input.equals("9") || input.equals("delete faculty")) {
                                        System.out.print("Give faculty id: ");
                                        id = st.nextLine();
                                        File faculty = new File("data/faculty/" + id + ".txt");
                                        boolean stdCheck = faculty.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            faculty.delete();
                                            System.out.println("faculty id has been deleted.");
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }

                                    //if student information chosen
                                    else if (input.equals("10") || input.equals("student information")) {
                                        System.out.print("Give student id: ");
                                        id = st.nextLine();
                                        File student = new File("data/student/" + id + ".txt");
                                        boolean stdCheck = student.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            Scanner fsc = new Scanner(student);
                                            while (fsc.hasNextLine()) {
                                                System.out.println(fsc.nextLine());
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }

                                    // adding new student
                                    else if (input.equals("11") || input.equals("add student")) {
                                        System.out.print("Give student new id:");
                                        int sId = si.nextInt();
                                        System.out.print("Give student Password:");
                                        String spass = st.nextLine();
                                        System.out.print("Give student name:");
                                        String sname = st.nextLine();
                                        System.out.print("Give student semester:");
                                        String ssem = st.nextLine();
                                        System.out.print("Give student result(careful give double value): ");
                                        double sresult = si.nextDouble();
                                        System.out.print("Give student Address:");
                                        String sadd = st.nextLine();

                                        File file = new File("data/student/" + sId + ".txt");
                                        boolean stdCheck = file.exists();
                                        if (stdCheck == false) {
                                            student std = new student(sId, spass, sname, ssem, sresult, sadd);
                                            String s = String.valueOf(std);
                                            //System.out.println(s);
                                            PrintWriter writer = new PrintWriter("data/student/" + sId + ".txt", "UTF-8");
                                            writer.println(s);
                                            writer.close();

                                            System.out.println("============================");
                                            System.out.println("your added new student information :");
                                            Scanner fsc = new Scanner(file);
                                            while (fsc.hasNextLine()) {
                                                System.out.println(fsc.nextLine());
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("your given id already exists. try with new id. thanks");
                                        }
                                    }

                                    //if admin choose to change student information
                                    else if (input.equals("12") || input.equals("edit student")) {
                                        System.out.print("Give student id: ");
                                        id = st.nextLine();
                                        File ad = new File("data/student/" + id + ".txt");
                                        boolean stdCheck = ad.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            System.out.println("current information :");
                                            Scanner ads = new Scanner(ad);
                                            while (ads.hasNextLine()) {
                                                System.out.println(ads.nextLine());
                                            }
                                            ads.close();
                                            while (true) {
                                                System.out.println("============================");
                                                System.out.println("1. change password");
                                                System.out.println("2. change name");
                                                System.out.println("3. change semester");
                                                System.out.println("4. change result");
                                                System.out.println("5. change address");
                                                System.out.println("6. exit");
                                                System.out.println("============================");
                                                System.out.print("give your choice:");
                                                input = st.nextLine();
                                                String store = "";
                                                if (input.equals("1")) {
                                                    System.out.print("Give new password: ");
                                                    store = st.nextLine();
                                                    store = "Password:" + store;
                                                } else if (input.equals("2")) {
                                                    System.out.print("Give new name: ");
                                                    store = st.nextLine();
                                                    store = "Name:" + store;
                                                } else if (input.equals("3")) {
                                                    System.out.print("Give new semester: ");
                                                    store = st.nextLine();
                                                    store = "Semester:" + store;
                                                } else if (input.equals("4")) {
                                                    System.out.print("Give new result: ");
                                                    store = st.nextLine();
                                                    store = "Result:" + store;
                                                } else if (input.equals("5")) {
                                                    System.out.print("Give new address: ");
                                                    store = st.nextLine();
                                                    store = "Address:" + store;
                                                } else if (input.equals("6")) {
                                                    break;
                                                } else {
                                                    continue;
                                                }
                                                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("data/student/" + id + ".txt"), StandardCharsets.UTF_8));
                                                fileContent.set(Integer.parseInt(input), store);
                                                Files.write(Paths.get("data/student/" + id + ".txt"), fileContent, StandardCharsets.UTF_8);
                                                fileContent.clear();

                                                System.out.println("============================");
                                                System.out.println("updated information :");
                                                ads = new Scanner(ad);
                                                while (ads.hasNextLine()) {
                                                    System.out.println(ads.nextLine());
                                                }
                                                ads.close();
                                                System.out.println("============================");

                                            }

                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }


                                    //student delete
                                    else if (input.equals("13") || input.equals("delete student")) {
                                        System.out.print("Give student id: ");
                                        id = st.nextLine();
                                        File std = new File("data/student/" + id + ".txt");
                                        boolean stdCheck = std.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            std.delete();
                                            System.out.println("student id has been deleted.");
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }
                                    //if logout chosen
                                    else if (input.equals("14") || input.equals("logout")) {
                                        System.out.println("Successfully logged out.");
                                        break;
                                    }
                                }
                            }
                            //if password don't match for admin
                            else {
                                System.out.println("does not match id or pass");
                            }
                        }
                        //if id is not found.
                        else {
                            System.out.println("can not found your id. contact admin to add information.");
                        }
                    }
                    //if exit option chosen then going to previous menu
                    else if (choice.equals("2") || choice.equals("exit")) {
                        break;
                    }
                }
            }


            //faculty option selected
            else if (input.equals("2") || input.equals("faculty")) {
                while (true) {
                    System.out.println("============================");
                    System.out.println("1. login");
                    System.out.println("2. exit");
                    System.out.println("============================");
                    System.out.print("give your choice:");
                    String choice = st.nextLine();
                    // login option chosen
                    if (choice.equals("1") || choice.equals("login")) {
                        System.out.print("enter id:");
                        String id = st.nextLine();
                        System.out.print("enter password:");
                        String pass = st.nextLine();

                        File location = new File("data/faculty/" + id + ".txt");
                        boolean check = location.exists();
                        // if id exists
                        if (check == true) {
                            Scanner scan = new Scanner(location);
                            scan.nextLine();//don't need the first line. so didn't store id.
                            String passString = scan.nextLine();//password is in the second line. so i stored it.
                            scan.close();
                            String arr[] = passString.split(":");
                            String mainPassword = arr[1];
                            //id and password matching
                            if (id.equals(id) && pass.equals(mainPassword)) {
                                while (true) {
                                    System.out.println("============================");
                                    System.out.println("1. faculty information");
                                    System.out.println("2. student information");
                                    System.out.println("3. student result change");
                                    System.out.println("4. logout");
                                    System.out.println("============================");
                                    System.out.print("give your choice:");
                                    input = st.nextLine();
                                    //if faculty information chosen
                                    if (input.equals("1") || input.equals("faculty information")) {
                                        //information printing
                                        System.out.println("============================");
                                        File ff = new File("data/faculty/" + id + ".txt");
                                        Scanner fsc = new Scanner(ff);
                                        while (fsc.hasNextLine()) {
                                            System.out.println(fsc.nextLine());
                                        }
                                        fsc.close();
                                    }
                                    //if student information chosen
                                    else if (input.equals("2") || input.equals("student information")) {
                                        System.out.print("Give student id: ");
                                        id = st.nextLine();
                                        File student = new File("data/student/" + id + ".txt");
                                        boolean stdCheck = student.exists();
                                        if (stdCheck == true) {
                                            System.out.println("============================");
                                            Scanner fsc = new Scanner(student);
                                            int j = 1;
                                            while (fsc.hasNextLine()) {
                                                if (j == 2) {
                                                    fsc.nextLine();// password won't appear to faculty.
                                                } else {
                                                    System.out.println(fsc.nextLine());
                                                }
                                                j++;
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("no id found .check with valid id. thanks");
                                        }
                                    }
                                    //if faculty choose to change student grade
                                    else if (input.equals("3") || input.equals("student result change")) {

                                        System.out.print("Give student id: ");
                                        id = st.nextLine();
                                        System.out.print("enter new grade: ");
                                        String grade = st.nextLine();
                                        File student = new File("data/student/" + id + ".txt");
                                        boolean stdCheck = student.exists();
                                        if (stdCheck == true) {
                                            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("data/student/" + id + ".txt"), StandardCharsets.UTF_8));
                                            fileContent.set(4, "Result:" + grade);
                                            Files.write(Paths.get("data/student/" + id + ".txt"), fileContent, StandardCharsets.UTF_8);
                                            fileContent.clear();

                                            System.out.println("============================");
                                            System.out.println("after result change :");
                                            Scanner fsc = new Scanner(student);
                                            int j = 1;
                                            while (fsc.hasNextLine()) {
                                                if (j == 2) {
                                                    fsc.nextLine();// password won't appear to faculty.
                                                } else {
                                                    System.out.println(fsc.nextLine());
                                                }
                                                j = j + 1;
                                            }
                                            fsc.close();
                                        } else {
                                            System.out.println("no id found . give valid one.");
                                        }

                                    }
                                    //if logout chosen
                                    else if (input.equals("4") || input.equals("logout")) {
                                        System.out.println("Successfully logged out.");
                                        break;
                                    }
                                }
                            }
                            //if password don't match for admin
                            else {
                                System.out.println("does not match id or pass");
                            }
                        }
                        //if id is not found.
                        else {
                            System.out.println("can not found your id. contact admin to add information.");
                        }
                    }
                    //if exit option chosen then going to previous menu
                    else if (choice.equals("2") || choice.equals("exit")) {
                        break;
                    }
                }
            }

            //student option selected
            else if (input.equals("3") || input.equals("student")) {
                while (true) {
                    System.out.println("============================");
                    System.out.println("1. login");
                    System.out.println("2. exit");
                    System.out.println("============================");
                    System.out.print("give your choice:");
                    String choice = st.nextLine();
                    // login option chosen
                    if (choice.equals("1") || choice.equals("login")) {
                        System.out.print("enter id:");
                        String id = st.nextLine();
                        System.out.print("enter password:");
                        String pass = st.nextLine();

                        File location = new File("data/student/" + id + ".txt");
                        boolean check = location.exists();
                        // if id exists
                        if (check == true) {

                            Scanner scan = new Scanner(location);
                            scan.nextLine();//don't need the first line. so didn't store id.
                            String passString = scan.nextLine();//password is in the second line. so i stored it.
                            scan.close();
                            String arr[] = passString.split(":");
                            String mainPassword = arr[1];
                            //id and password matching
                            if (id.equals(id) && pass.equals(mainPassword)) {
                                while (true) {
                                    System.out.println("============================");
                                    System.out.println("1. information");
                                    System.out.println("2. logout");
                                    System.out.println("============================");
                                    System.out.print("give your choice:");
                                    input = st.nextLine();
                                    if (input.equals("1") || input.equals("information")) {
                                        //information printing
                                        System.out.println("============================");
                                        File ff = new File("data/student/" + id + ".txt");
                                        Scanner fsc = new Scanner(ff);
                                        while (fsc.hasNextLine()) {
                                            System.out.println(fsc.nextLine());
                                        }
                                        fsc.close();
                                    } else if (input.equals("2") || input.equals("logout")) {
                                        System.out.println("Successfully logged out.");
                                        break;
                                    }
                                }
                            }
                            //if password don't match for admin
                            else {
                                System.out.println("does not match id or pass");
                            }
                        }
                        //if id is not found.
                        else {
                            System.out.println("can not found your id. contact admin to add information.");
                        }
                    }
                    //if exit option chosen then going to previous menu
                    else if (choice.equals("2") || choice.equals("exit")) {
                        break;
                    }
                }
            }
            // end option selected
            else if (input.equals("4") || input.equals("end program") || input.equals("end")) {
                System.out.println("successfully program ended. thanks");
                break;
            }
        }
    }
}
