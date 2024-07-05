import java.util.Scanner;

public class ExamAudit {
    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            // Display menu options
            System.out.println("Menu:");
            System.out.println("1. Coursework results");
            System.out.println("2. Exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            // Handle menu choice
            switch (choice) {
                case 1:
                    viewCourseworkResults();
                    break;
                case 2:
                    viewExamResults();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }

    // Method to view coursework results
    public static void viewCourseworkResults() {
        // Coursework results
        int[] courseworkResults = {89, 87, 90, 88, 86};
        int numberOfCoursework = courseworkResults.length;
        System.out.println("Coursework Results:");
        for (int i = 0; i < numberOfCoursework; i++) {
            System.out.println("Coursework Result " + (i + 1) + ": " + courseworkResults[i]);
        }

        int completedCoursework = countCoursework(courseworkResults);
        System.out.println("Number of Coursework done: " + completedCoursework);
        
        // Confirm if the student has completed 2/3 of the coursework
        if (hasCompletedTwoThirds(courseworkResults, numberOfCoursework)) {
            System.out.println("Student has completed 2/3 of the coursework.");
        } else {
            System.out.println("Student has not completed 2/3 of the coursework. The student must repeat the course.");
        }
    }

    // Method to count the number of coursework
    public static int countCoursework(int[] coursework) {
        int count = 0;
        for (int i = 0; i < coursework.length; i++) {
            if (coursework[i] > 0) {
                count++;
            }
        }
        return count;
    }

    // Method to check if the student has completed 2/3 of the coursework
    public static boolean hasCompletedTwoThirds(int[] coursework, int totalCoursework) {
        int completedCoursework = countCoursework(coursework);
        return completedCoursework >= (2.0 / 3.0) * totalCoursework;
    }

    // Method to view exam results
    public static void viewExamResults() {
        // Exam results example
        int finalExamScore = 88;
        int[] courseworkResults = {89, 87, 90, 88, 86};
        double courseworkScore = calculateCourseworkScore(courseworkResults);
        double totalScore = courseworkScore + finalExamScore;

        System.out.println("Coursework Score (50%): " + courseworkScore);
        System.out.println("Final Exam Score (50%): " + finalExamScore);
        System.out.println("Total Score: " + totalScore);
    }

    // Method to calculate the coursework score
    public static double calculateCourseworkScore(int[] coursework) {
        double total = 0;
        for (int result : coursework) {
            total += result;
        }
        return (total / coursework.length) * 0.5;
    }
}
