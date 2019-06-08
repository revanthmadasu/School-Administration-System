
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class GetCurrentDateTime {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        String s =DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
        System.out.println(s);

    }

}