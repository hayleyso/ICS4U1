/* Author: Hayley So
 * Description: Two Dimensional Array Exercise #2 for ICS4U1 class.
 * Purpose: This program is to review reading from and writing to files.
 * Date: 09/18/2024
 * JDK version: 22.02
 * */
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 
 public class L4Array {
 
    // Main method
     public static void main(String[] args) throws FileNotFoundException {
         L4Array A = new L4Array();
         File file = new File("C:\\Users\\hayle\\Downloads\\marks_input.txt");
         Scanner sc = new Scanner(file);
 
         int numStudents = sc.nextInt();
         int numMarks = sc.nextInt();  
 
         String[] studentNames = new String[numStudents];
         int[][] studentMarks = new int[numStudents][numMarks];
 
         for (int i = 0; i < numStudents; i++) {
             studentNames[i] = sc.next();
             for (int j = 0; j < numMarks; j++) {
                 studentMarks[i][j] = sc.nextInt();
             }
         }
         sc.close();
 
         double[] testAvg = A.findTestAverage(studentMarks);
         double[] individualAvg = A.findIndividualAverage(studentMarks);
 
         System.out.println("");
         System.out.println("     Student Name        |                Test Marks               |      Individual Average");
         System.out.println("---------------------------------------------------------------------------------------------------");
         for (int i = 0; i < numStudents; i++) {
             System.out.printf("%-25s|", studentNames[i]);
 
             for (int j = 0; j < numMarks; j++) {
                 System.out.printf("%7d%% ", studentMarks[i][j]);
             }
 
             System.out.print("     |");
 
             System.out.printf("%15.1f%%", individualAvg[i]);
             System.out.println();
         }
 
         System.out.println();
         System.out.print("Test Averages:             ");
         for (int j = 0; j < numMarks; j++) {
             System.out.printf("%7.1f%% ", testAvg[j] );
         }
         System.out.println();
     } // End main method
 
     /* Finds the average of the students for each test.
     * @param int[][] marks
     * @return (double[]) testAvg
     * */
     public double[] findTestAverage(int[][] marks) {
         int numTests = marks[0].length;
         double[] testAvg = new double[numTests];
 
         for (int j = 0; j < numTests; j++) {
             int sum = 0;
             for (int i = 0; i < marks.length; i++) {
                 sum += marks[i][j];
             }
             testAvg[j] = (double) sum / marks.length;
         }
         return testAvg;
     } // End findTestAverage method
 
     /* Finds the individual average of each student based on their marks.
     * @param int[][] marks
     * return (double[]) individualAvg
     * */
     public double[] findIndividualAverage(int[][] marks) {
         int numStudents = marks.length;
         double[] individualAvg = new double[numStudents];
 
         for (int i = 0; i < numStudents; i++) {
             int sum = 0;
             for (int j = 0; j < marks[0].length; j++) {
                 sum += marks[i][j];
             }
             individualAvg[i] = (double) sum / marks[0].length;
         }
         return individualAvg;
     } // End findIndividualAverage method
 
 } /* End Array42 class */