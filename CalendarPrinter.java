import java.util.Scanner;

public class CalendarPrinter {

    public static void printCalendar(int startDay, int numDays) {
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        for (String day : daysOfWeek) {
            System.out.print(day + " ");
        }
        System.out.println();

        // Adjust for 1-based indexing (1=Sun, ..., 7=Sat)
        int leadingSpaces = (startDay % 7); // Convert 1-7 to 0-6
        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if ((leadingSpaces + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter an # for the day of the week on which the month begins (1 = Sunday): ");
        int startDay = scanner.nextInt();

        System.out.print("Please enter the # of days for the month: ");
        int numDays = scanner.nextInt();

        printCalendar(startDay, numDays);

        scanner.close();
    }
}
