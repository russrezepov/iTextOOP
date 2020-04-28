import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//C:\Users\Zahri\Downloads\coding sample\input_files/pipe.txt

public class ScanDelimitedSpace {

public ScanDelimitedSpace() {
        File commaFile = new File("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/space.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(commaFile);
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

    private static void parseLine(String str) throws ParseException, IOException {
        String firstName, lastName, pos, gender, color, date;
        Scanner sc = new Scanner(str);

        sc.useDelimiter("\\s+");

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //String today = formatter.format(date);

        //String datePattern = ("MM/dd/yyyy");
        //DateFormat sdf = new SimpleDateFormat(datePattern);
        //Date date = new Date();


        // Check if there is another line of input
        while(sc.hasNext()){
            lastName = sc.next();
            firstName = sc.next();
            pos = sc.next();
            gender = sc.next();
            date = sc.next();
            String dateRep = date.replace("-","/");
            color = sc.next();

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\buffered.txt", true)  //Set true for append mode
            );
            //writer.newLine();   //Add new line
            writer.write(lastName + " ");
            writer.write(firstName + " ");
            writer.write(gender + " ");
            writer.write(dateRep + " ");
            writer.write(color + "\r\n");
            writer.close();

            System.out.println(lastName + " " + firstName + " " + " " + gender + " " + dateRep + " " + color);
        }
        sc.close();
    }
}
