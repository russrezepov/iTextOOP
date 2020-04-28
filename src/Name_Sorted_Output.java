import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


    public class Name_Sorted_Output {

        //C:\Users\Zahri\Downloads\coding sample\input_files/comma.txt

        public ArrayList<User> userArr = new ArrayList<>();

        public Name_Sorted_Output() {


            // txt file with commas
            File commaFile = new File("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/buffered.txt");
            Scanner sc = null;

            try {
                sc = new Scanner(commaFile);
                // Check if there is another line of input
                while(sc.hasNextLine()){
                    String str = sc.nextLine();
                    cleanFileNameSorted();
                    parseLine(str);
                    nameSortedoutput();
                    cleanFileGenderSorted();
                    genderSortedOutput();
                    cleanFileDateSorted();
                    dateSortedOutput();
                }

            } catch (IOException | ParseException exp) {
                // Auto-generated catch block
                exp.printStackTrace();
            }

            sc.close();
        }

        private void cleanFileNameSorted() throws IOException {

            BufferedWriter writerNew =  Files.newBufferedWriter(Paths.get("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Name_Sorted_Output.txt")  //Set true for append mode
            );

            writerNew.write("");
            writerNew.flush();
            writerNew.close();
        }

        private void cleanFileGenderSorted() throws IOException {

            BufferedWriter writerNew =  Files.newBufferedWriter(Paths.get("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Gender_Sorted_Output.txt")  //Set true for append mode
            );

            writerNew.write("");
            writerNew.flush();
            writerNew.close();
        }

        private void cleanFileDateSorted() throws IOException {

            BufferedWriter writerNew =  Files.newBufferedWriter(Paths.get("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Date_Sorted_Output.txt")  //Set true for append mode
            );

            writerNew.write("");
            writerNew.flush();
            writerNew.close();
        }

        private void parseLine(String str) throws ParseException, IOException {
            String firstName, lastName, gender, color, date;
            Scanner sc = new Scanner(str);

            sc.useDelimiter("\\s+");

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //String today = formatter.format(date);

            //String datePattern = ("MM/dd/yyyy");
            //DateFormat sdf = new SimpleDateFormat(datePattern);
            //Date date = new Date();

            // Check if there is another line of input
            while(sc.hasNext()){


                lastName = sc.next().trim();
                firstName = sc.next().trim();
                gender = sc.next().trim();
                date = sc.next().trim();
                color = sc.next().trim();
                Date ddate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
                System.out.println(ddate);
                userArr.add(new User(lastName, firstName, gender, date, color, ddate));



                //System.out.println(lastName + " " + firstName + " " + " " + gender + " " + date + " " + color);
                //System.out.println(userArr.toString());

                // System.out.println(lastName + firstName + gender + date + color);
            }
            sc.close();
        }

        public void nameSortedoutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new NameSorter());
            //NameSorter ns = new NameSorter();
//            Collections.sort(userArr);
//            User.sort(new NameSorter());
//            System.out.println(User);

            for (User user : userArr) {
                System.out.println(user);

                lastName = user.getLastName();
                firstName = user.getFirstName();
                gender = user.getGender();
                date = user.getUserDate();
                color = user.getColor();

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Name_Sorted_Output.txt", true)  //Set true for append mode
                );

                //writer.newLine();   //Add new line
                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");
                writer.close();
            }

        }

        public void genderSortedOutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new GenderSorter().reversed());
            //NameSorter ns = new NameSorter();
//            Collections.sort(userArr);
//            User.sort(new NameSorter());
//            System.out.println(User);

            for (User user : userArr) {
                System.out.println(user);

                lastName = user.getLastName();
                firstName = user.getFirstName();
                gender = user.getGender();
                date = user.getUserDate();
                color = user.getColor();

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Gender_Sorted_Output.txt", true)  //Set true for append mode
                );

                //writer.newLine();   //Add new line
                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");
                writer.close();
            }

        }

        public void dateSortedOutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new DateSorter());
            //NameSorter ns = new NameSorter();
//            Collections.sort(userArr);
//            User.sort(new NameSorter());
//            System.out.println(User);

            for (User user : userArr) {
                System.out.println(user);

                lastName = user.getLastName();
                firstName = user.getFirstName();
                gender = user.getGender();
                date = user.getUserDate();
                color = user.getColor();

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Date_Sorted_Output.txt", true)  //Set true for append mode
                );

                //writer.newLine();   //Add new line
                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");
                writer.close();
            }

        }

    }

