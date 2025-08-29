import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Grade Calculator ---");

        // Input: Get the number of subjects
        System.out.print("Enter the total number of subjects: ");
        int numSubjects = 0;
        // Input validation for the number of subjects
        while (true) {
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be positive. Please try again.");
                    System.out.print("Enter the total number of subjects: ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
                System.out.print("Enter the total number of subjects: ");
            }
        }


        // Array to store marks for each subject
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input: Get marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            int mark = -1;
            // Input validation for marks
            while (true) {
                if(scanner.hasNextInt()){
                    mark = scanner.nextInt();
                    if(mark >= 0 && mark <= 100){
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Marks should be between 0 and 100. Please try again.");
                        System.out.print("Enter marks for subject " + (i + 1) + ": ");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                    System.out.print("Enter marks for subject " + (i + 1) + ": ");
                }
            }
            // Calculate Total Marks
            totalMarks += marks[i];
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        // Formatting the average percentage to two decimal places
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("---------------");

        scanner.close();
    }
}
