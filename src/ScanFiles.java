import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
 //C:\Users\Zahri\Downloads\coding sample\input_files/comma.txt

    public class ScanFiles {

        public final String COMMA_FILE = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/comma.txt";
        public final String PIPE_FILE = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/pipe.txt";
        public final String SPACE_FILE = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/space.txt";
        public final String BUFF_FILE = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\buffered.txt";
        public final String DATE_SORTED = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Date_Sorted_Output.txt";
        public final String NAME_SORTED = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Name_Sorted_Output.txt";
        public final String GENDER_SORTED = "C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\Gender_Sorted_Output.txt";

        File commaFile = new File(COMMA_FILE);
        File pipeFile = new File(PIPE_FILE);
        File spaceFile = new File(SPACE_FILE);

        public ArrayList<User> userArr = new ArrayList<>();

        public ScanFiles() throws IOException, ParseException {
         scanCommaFile();
         scanPipeFile();
         scanSpaceFile();
         nameSortedOutput();
         genderSortedOutput();
         dateSortedOutput();
        }




        //Scanning a file with a comma delimiter and appending the lines to buffered.txt file
        private void scanCommaFile() throws FileNotFoundException, ParseException {
            Scanner sc = new Scanner(commaFile);

                    while (sc.hasNextLine()) {
                        String firstName, lastName, gender, color, date;
                        String str = sc.nextLine();
                        Scanner insc = new Scanner(str);
                        insc.useDelimiter(",");

                        while (insc.hasNext()) {
                            lastName = insc.next().trim();
                            firstName = insc.next().trim();
                            gender = checkGender(insc.next().trim());
                            color = insc.next().trim();
                            date = insc.next().trim();

                            System.out.println(lastName + " " + firstName + " " + gender + " " + date + " " + color);
                            userArr.add(new User(lastName, firstName, gender, date, color, ConvertDate.convertDate(date)));

                            BufferedWriter writer = null;
                            try {
                                writer = new BufferedWriter(
                                        new FileWriter(BUFF_FILE, false)
                                );


                                writer.write(lastName + " ");
                                writer.write(firstName + " ");
                                writer.write(gender + " ");
                                writer.write(date + " ");
                                writer.write(color + "\r\n");
                                writer.close();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                sc.close();
            }

        private void scanPipeFile() throws FileNotFoundException, ParseException {
            Scanner sc = new Scanner(pipeFile);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                Scanner insc = new Scanner(str);
                String firstName, lastName, gender, color, date, dateRep, pos;
                insc.useDelimiter("[|]");

                while (insc.hasNext()) {
                    lastName = insc.next().trim();
                    firstName = insc.next().trim();
                    pos = insc.next().trim();
                    gender = checkGender(insc.next().trim());
                    color = insc.next().trim();
                    date = insc.next().trim();
                    dateRep = date.replace("-","/");
                    System.out.println(lastName + " " + firstName + " " + gender + " " + dateRep + " " + color);

                    userArr.add(new User(lastName, firstName, gender, dateRep, color, ConvertDate.convertDate(dateRep)));

                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter(
                                new FileWriter(BUFF_FILE, true)
                        );

                        writer.write(lastName.trim() + " ");
                        writer.write(firstName.trim() + " ");
                        writer.write(gender.trim() + " ");
                        writer.write(dateRep.trim() + " ");
                        writer.write(color.trim() + "\r\n");
                        writer.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // System.out.println(lastName + firstName + gender + date + color);
                }
            }
            sc.close();
        }

        private void scanSpaceFile() throws FileNotFoundException, ParseException {
            Scanner sc = new Scanner(spaceFile);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                Scanner insc = new Scanner(str);
                String firstName, lastName, gender, color, date, dateRep, pos;
                insc.useDelimiter("\\s+");

                while (insc.hasNext()) {
                    lastName = insc.next().trim();
                    firstName = insc.next().trim();
                    pos = insc.next().trim();
                    gender = checkGender(insc.next().trim());
                    date = insc.next().trim();
                    dateRep = date.replace("-","/");
                    color = insc.next().trim();

                    System.out.println(lastName + " " + firstName + " " + gender + " " + dateRep + " " + color);

                    userArr.add(new User(lastName, firstName, gender, dateRep, color, ConvertDate.convertDate(dateRep)));

                    BufferedWriter writer = null;
                    try {
                        writer = new BufferedWriter(
                                new FileWriter(BUFF_FILE, true)
                        );


                        writer.write(lastName.trim() + " ");
                        writer.write(firstName.trim() + " ");
                        writer.write(gender.trim() + " ");
                        writer.write(dateRep.trim() + " ");
                        writer.write(color.trim() + "\r\n");
                        writer.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // System.out.println(lastName + firstName + gender + date + color);
                }
            }
            sc.close();
        }

        private void nameSortedOutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new NameSorter());
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(NAME_SORTED, false)
            );

            for (User user : userArr) {
                System.out.println(user);

                lastName = user.getLastName();
                firstName = user.getFirstName();
                gender = user.getGender();
                date = user.getUserDate();
                color = user.getColor();



                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");

            } writer.close();

        }

        private void genderSortedOutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new GenderSorter());
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(GENDER_SORTED, false)
            );

            for (User user : userArr) {
                System.out.println(user);

                lastName = user.getLastName();
                firstName = user.getFirstName();
                gender = user.getGender();
                date = user.getUserDate();
                color = user.getColor();



                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");

            } writer.close();

        }

        private void dateSortedOutput() throws IOException {
            String lastName, firstName, gender, date, color;

            userArr.sort(new DateSorter());
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(DATE_SORTED, false)  //Set true for append mode
            );

            for (User user : userArr) {
                System.out.println(user);

                lastName = user.getLastName();
                firstName = user.getFirstName();
                gender = user.getGender();
                date = user.getUserDate();
                color = user.getColor();



                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(date + " ");
                writer.write(color.trim() + "\r\n");

            } writer.close();

        }

        public static String checkGender(String checkGender) {
            if (checkGender.trim().charAt(0) == 'M') {
                checkGender = "Male";
            } else if (checkGender.trim().charAt(0) == 'F') {
                checkGender = "Female";
            }
            return checkGender;
        }

    }





