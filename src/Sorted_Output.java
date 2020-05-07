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


public class Sorted_Output {

        public static String BUFFERED_FILE = "\"C:\\\\Users\\\\Zahri\\\\Downloads\\\\coding sample\\\\input_files/buffered.txt\"";
        public static String COMMA_FILE_PATH = "\"C:\\\\Users\\\\Zahri\\\\Downloads\\\\coding sample\\\\input_files/buffered.txt\"";

    //ArrayList where we will retrieve DOB String and convert it to the Date format
        // Then, we will add the Date to the same record this will allow us to sort records in files by dates
        public ArrayList<User> userArr = new ArrayList<>();


        File commaFile = new File(BUFFERED_FILE);
        Scanner sc = null;

        //Constructor
        public Sorted_Output() {

        }

            //Main method that will sort all the files
            public void sortTheFiles() {

                try {
                    //cleanFileNameSorted();
                    parseLine(BUFFERED_FILE);
                    //nameSortedOutput();
                    //cleanFileGenderSorted();
                    //genderSortedOutput();
                    //cleanFileDateSorted();
                    //dateSortedOutput();
                    }   catch ( ParseException exp) {
                        // Auto-generated catch block
                        exp.printStackTrace();
                        }

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

        private void parseLine(String str) throws ParseException {
            String firstName, lastName, gender, color, date;
            Scanner sc = new Scanner(str);

            sc.useDelimiter("\\s+");

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            // Check if there is another line of input
            while(sc.hasNext()){

                lastName = sc.next().trim();
                firstName = sc.next().trim();
                gender = sc.next().trim();
                date = sc.next().trim();
                color = sc.next().trim();

                userArr.add(new User(lastName, firstName, gender, date, color, ConvertDate.convertDate(date)));
                //System.out.println(lastName + " " + firstName + " " + " " + gender + " " + date + " " + color);
                //System.out.println(userArr.toString());

                // System.out.println(lastName + firstName + gender + date + color);
            }
            sc.close();
        }

        public void nameSortedOutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new NameSorter());

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

                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");
                writer.close();
            }

        }

    }

