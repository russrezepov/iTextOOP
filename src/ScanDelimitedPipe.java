import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

    //C:\Users\Zahri\Downloads\coding sample\input_files/pipe.txt

    public class ScanDelimitedPipe {

        public ScanDelimitedPipe() {
            // txt file with commas
            File commaFile = new File("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files/pipe.txt");
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
            String firstName, lastName, pos, color, date;
            Scanner sc = new Scanner(str);

            sc.useDelimiter("[|]");

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //String today = formatter.format(date);

            //String datePattern = ("MM/dd/yyyy");
            //DateFormat sdf = new SimpleDateFormat(datePattern);
            //Date date = new Date();


            // Check if there is another line of input
            while(sc.hasNext()){
                String gender, newGender;
                lastName = sc.next();
                firstName = sc.next();
                pos = sc.next();
                gender = sc.next();
                //System.out.println(gender.trim());

//                switch (gender.charAt(0))
//                {
//                    case 'M':
//                        newGender="Male";
//
//                    case 'F':
//                        newGender="Female";
//
//                }
//
                if (gender.trim().charAt(0)=='M'){
                    gender = "Male";
                } else if(gender.trim().charAt(0) == 'F'){
                    gender = "Female";
                }


                color = sc.next();
                date = sc.next();
                String dateRep = date.replace("-","/");

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\Zahri\\Downloads\\coding sample\\input_files\\buffered.txt", true)  //Set true for append mode
                );
                //writer.newLine();   //Add new line
                writer.write(lastName.trim() + " ");
                writer.write(firstName.trim() + " ");
                writer.write(gender.trim() + " ");
                writer.write(dateRep.trim() + " ");
                writer.write(color.trim() + "\r\n");
                writer.close();

                System.out.println(lastName + firstName + gender + dateRep + color);
            }
            sc.close();
        }
    }


