import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
 //C:\Users\Zahri\Downloads\coding sample\input_files/comma.txt

    public class ScanDelimitedComma {

        public ScanDelimitedComma() {
            // txt file with commas
            File commaFile = new File("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/comma.txt");
            Scanner sc = null;

            try {
                sc = new Scanner(commaFile);
                cleanFile();
                // Check if there is another line of input
                while(sc.hasNextLine()){
                    String str = sc.nextLine();
                    parseLine(str);
                }

            } catch (IOException | ParseException exp) {
                // TODO Auto-generated catch block
                exp.printStackTrace();
            }

            sc.close();
        }

        private static void cleanFile() throws IOException {

            BufferedWriter writerNew =  Files.newBufferedWriter(Paths.get("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\buffered.txt")  //Set true for append mode
            );

            writerNew.write("");
            writerNew.flush();
            writerNew.close();
        }

        private static void parseLine(String str) throws ParseException, IOException {
            String firstName, lastName, gender, color, date;
            Scanner sc = new Scanner(str);

            sc.useDelimiter(",");

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //String today = formatter.format(date);

            //String datePattern = ("MM/dd/yyyy");
            //DateFormat sdf = new SimpleDateFormat(datePattern);
            //Date date = new Date();

            // Check if there is another line of input
            while(sc.hasNext()){
                lastName = sc.next();
                firstName = sc.next();
                gender = sc.next();
                color = sc.next();
                date = sc.next();

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\buffered.txt", true)  //Set true for append mode
                );

                //writer.newLine();   //Add new line
                writer.write(lastName + " ");
                writer.write(firstName + " ");
                writer.write(gender + " ");
                writer.write(date + " ");
                writer.write(color + "\r\n");
                writer.close();

                System.out.println(lastName + " " + firstName + " " + " " + gender + " " + date + " " + color);
               // System.out.println(lastName + firstName + gender + date + color);
            }
            sc.close();
        }
    }

