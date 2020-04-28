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

public class CreateNewFile {

    //C:\Users\Zahri\Downloads\coding sample\input_files/comma.txt

    public static ArrayList<User> userArr = new ArrayList<>();

    public CreateNewFile() {


            // txt file with commas
            File commaFile = new File("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/buffered.txt");
            Scanner sc = null;

            try {
                sc = new Scanner(commaFile);
                // Check if there is another line of input
                while(sc.hasNextLine()){
                    String str = sc.nextLine();
                    parseLine(str);
                }

            } catch (IOException | ParseException exp) {
                // Auto-generated catch block
                exp.printStackTrace();
            }

            sc.close();
        }

       private static void parseLine(String str) throws ParseException, IOException {
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

                System.out.println(date);
                Date ddate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
                System.out.println(ddate);
                userArr.add(new User(lastName, firstName, gender, date, color, ddate));

//                BufferedWriter writer = new BufferedWriter(
//                        new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\buffered.txt", true)  //Set true for append mode
//                );
//
//                //writer.newLine();   //Add new line
//                writer.write(lastName + " ");
//                writer.write(firstName + " ");
//                writer.write(gender + " ");
//                writer.write(date + " ");
//                writer.write(color + "\r\n");
//                writer.close();

                //System.out.println(lastName + " " + firstName + " " + " " + gender + " " + date + " " + color);
                //System.out.println(userArr.toString());

                // System.out.println(lastName + firstName + gender + date + color);
            }
            sc.close();
        }
    }



