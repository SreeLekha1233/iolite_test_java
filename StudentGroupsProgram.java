
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGroupsProgram {
    public static void main(String[] args) {
        // Created a user input,read user input from console.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting hour:");
        int startingHour = scanner.nextInt();

        System.out.print("Enter the ending hour:");
        int endingHour = scanner.nextInt();

        System.out.print("Enter Student at starting hour:");
        int studentsAtStartingHour = scanner.nextInt();
        
        System.out.print("Enter Students in group:");
        int studentsInGroup = scanner.nextInt();

        scanner.close();

        //calculate student count for each hour,return a list of integers
        List<Integer> studentCounts = findStudentCounts(studentsAtStartingHour, startingHour, endingHour);
        //iterate over student counts and print hour and corresponding count for each hour
        printStudentCounts(studentCounts,startingHour);
        //print groups for each hour 
        //calculate no of group and no of students in each group accordigly
        generateAndPrintGroups(studentCounts, studentsInGroup,startingHour);
    }


    //finding the student count with the increment of 10% from prev hour
    private static List<Integer> findStudentCounts(int studentsAtStartingHour, int startingHour, int endingHour) {
        List<Integer> studentCounts = new ArrayList<>();//created an arraylist
        studentCounts.add(studentsAtStartingHour);

        double incrementPercentage = 0.1;
        double currentCount = studentsAtStartingHour;
        //calculate the student count for each hour based on prev hr.
        for (int hour = startingHour + 1; hour <= endingHour; hour++) {//iterate from starting hr to ending hr
            currentCount += currentCount * incrementPercentage;//calculating the 10%
            int roundedCount = (int) Math.round(currentCount);//rounding the value if decimal with math.round() mthod
            studentCounts.add(roundedCount);
        }

        return studentCounts;
    }

    //finding the students to each corresponding hour
    private static void printStudentCounts(List<Integer> studentCounts,int startingHour) {
        int hour = startingHour;
        for (int count : studentCounts) {//enhanced for loop /for each loop,each element is assigned to the variable count
            System.out.println(formatHour(hour) + ": " + count + " students");
            hour++;
        }
    }

    //finding the groups and students in the group in each hour
    private static void generateAndPrintGroups(List<Integer> studentCounts, int studentsInGroup,int startingHour) {
        int hour = startingHour;
        for (int count : studentCounts) {//enhanced for loop
            System.out.println("\nGroups for " + formatHour(hour) + " - " + count + " students");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            int groupNumber = 1;
            int totalStudents = count;//initializes the variable totalStudents with the initial count of students for the hour
            while (totalStudents > 0) {
                int studentsInCurrentGroup =0;
                if(totalStudents>studentsInGroup){
                    studentsInCurrentGroup=studentsInGroup;
                }
                else{
                    studentsInCurrentGroup=totalStudents;
                }
                System.out.println("Group " + groupNumber + ": " + studentsInCurrentGroup + " students");
                totalStudents -= studentsInCurrentGroup;
                groupNumber++;
            }

            hour++;
        }
    }


    //formating in 12 hrs instead of 24 hrs
   private static String formatHour(int hour) {
    String suffix;
    if (hour >= 12) {
        suffix = "PM";
    } else {
        suffix = "AM";
    }
    if (hour > 12) {
        hour = hour - 12;
    }
    return hour + " " + suffix;
    }

}
