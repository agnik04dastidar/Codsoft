import java.util.Scanner;

class Student{
    int[] subjects;
    int totalMarks;
    double avgPer;
    String grade;

    Student(int n){
        subjects = new int[n];
        totalMarks = 0;
        avgPer = 0.0;
        grade = "";
    }

    public void marks(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            subjects[i] = sc.nextInt();
        }
    }

    public void result(){
        for (int i = 0; i < subjects.length; i++) {
            totalMarks += subjects[i];
        }
        avgPer = (double) totalMarks / subjects.length;
        calculateGrade();
    }

    public void calculateGrade(){
        if (avgPer>=90 && avgPer<=100) {
            grade = "O";
        } else if (avgPer>=80 && avgPer<90) {
            grade = "A";
        } else if (avgPer>=70 && avgPer<80) {
            grade = "B";
        } else if (avgPer>=60 && avgPer<70) {
            grade = "C";
        } else if (avgPer>=50 && avgPer<60) {
            grade = "D";
        } else {
            grade = "F";
        }
    }

    public void displayResults(){
        System.out.println("\nResult of the student:");
        System.out.println("Total Marks: " + totalMarks + " out of " + (subjects.length * 100));
        System.out.printf("Average Percentage: %.2f%%\n", avgPer);
        System.out.println("Grade: " + grade);
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int n = sc.nextInt();

        Student s = new Student(n);
        s.marks();
        s.result();
        s.displayResults();
    }
}
