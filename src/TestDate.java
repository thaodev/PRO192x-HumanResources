import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        /**
         * Method 1 for date
         */
        boolean isDateFormatInvalid = true;
        do {
            System.out.println("Enter Start Date (format dd/MM/YYYY): ");
            Scanner src = new Scanner(System.in);
            String date = src.nextLine();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = null;
            df.setLenient(false);
            try {
                startDate = df.parse(date);
                isDateFormatInvalid = false;

            } catch (Exception e) {
                System.out.println("Please enter the correct date format");
                isDateFormatInvalid = true;
            }
        } while (isDateFormatInvalid);
        /*String str[] = {"year", "month", "day" };
        String date = "";

        for(int i=0; i<3; i++) {
            System.out.println("Enter " + str[i] + ": ");
            date = date + scanner.next() + "/";
        }
        date = date.substring(0, date.length()-1);
        System.out.println("date: "+ date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date parsedDate = null;

        try {
            parsedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parsedDate);*/

       /* System.out.println("dd-mm-yyyy");
        String date = scanner.nextLine();
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
        System.out.println(date1);*/
        /**
         * MEthod 2 for local date
         */
        boolean isFormatInvalid;
        do {
            System.out.println("Enter Start Date (format dd/MM/YYYY): ");
            Scanner src = new Scanner(System.in);
            String date = src.nextLine();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //LocalDate dft = LocalDate.of("dd/mm/yyyy");
            LocalDate startDate = null;
            //df.setLenient(false);
            try {
                startDate = LocalDate.parse(date, df);
                isFormatInvalid = false;

            } catch (Exception e) {
                System.out.println("Please enter the correct date format");
                isFormatInvalid = true;
            }
        } while (isFormatInvalid);

    }
}
