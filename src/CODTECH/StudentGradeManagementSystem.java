package CODTECH;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int tamilMark;
    private int englishMark;
    private int mathematicsMark;
    private int scienceMark;
    private int socialScienceMark;

    public Student(String name, int rollNumber, int tamilMark, int englishMark, int mathematicsMark, int scienceMark, int socialScienceMark) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.setTamilMark(tamilMark);
        this.setEnglishMark(englishMark);
        this.setMathematicsMark(mathematicsMark);
        this.setScienceMark(scienceMark);
        this.setSocialScienceMark(socialScienceMark);
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getTamilMark() {
        return tamilMark;
    }

    public int getEnglishMark() {
        return englishMark;
    }

    public int getMathematicsMark() {
        return mathematicsMark;
    }

    public int getScienceMark() {
        return scienceMark;
    }

    public int getSocialScienceMark() {
        return socialScienceMark;
    }

	public void setTamilMark(int tamilMark) {
		this.tamilMark = tamilMark;
	}

	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}

	public void setMathematicsMark(int mathematicsMark) {
		this.mathematicsMark = mathematicsMark;
	}

	public void setScienceMark(int scienceMark) {
		this.scienceMark = scienceMark;
	}

	public void setSocialScienceMark(int socialScienceMark) {
		this.socialScienceMark = socialScienceMark;
	}
}

class GradeManagementSystem {
    private ArrayList<Student> students;

    public GradeManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, int rollNumber, int tamilMark, int englishMark, int mathematicsMark, int scienceMark, int socialScienceMark) {
        students.add(new Student(name, rollNumber, tamilMark, englishMark, mathematicsMark, scienceMark, socialScienceMark));
    }

    public void updateStudent(int rollNumber, int tamilMark, int englishMark, int mathematicsMark, int scienceMark, int socialScienceMark) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setTamilMark(tamilMark);
                student.setEnglishMark(englishMark);
                student.setMathematicsMark(mathematicsMark);
                student.setScienceMark(scienceMark);
                student.setSocialScienceMark(socialScienceMark);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found!");
    }

    public void deleteStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayStudentDetails(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Tamil: " + student.getTamilMark());
                System.out.println("English: " + student.getEnglishMark());
                System.out.println("Mathematics: " + student.getMathematicsMark());
                System.out.println("Science: " + student.getScienceMark());
                System.out.println("Social Science: " + student.getSocialScienceMark());
                System.out.println("Overall Percentage: " + calculatePercentage(student) + "%");
                System.out.println("Grade: " + calculateGrade(student));
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    private double calculatePercentage(Student student) {
        int totalMarks = student.getTamilMark() + student.getEnglishMark() + student.getMathematicsMark() + student.getScienceMark() + student.getSocialScienceMark();
        return (double) totalMarks / 5;
    }

    private char calculateGrade(Student student) {
        double percentage = calculatePercentage(student);
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

public class StudentGradeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManagementSystem gradeManagementSystem = new GradeManagementSystem();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Adding Student:");
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter Tamil mark: ");
                    int tamilMark = scanner.nextInt();
                    System.out.print("Enter English mark: ");
                    int englishMark = scanner.nextInt();
                    System.out.print("Enter Mathematics mark: ");
                    int mathematicsMark = scanner.nextInt();
                    System.out.print("Enter Science mark: ");
                    int scienceMark = scanner.nextInt();
                    System.out.print("Enter Social Science mark: ");
                    int socialScienceMark = scanner.nextInt();
                    gradeManagementSystem.addStudent(name, rollNumber, tamilMark, englishMark, mathematicsMark, scienceMark, socialScienceMark);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("Updating Student:");
                    System.out.print("Enter roll number of student to update: ");
                    int updateRollNumber = scanner.nextInt();
                    System.out.print("Enter Tamil mark: ");
                    int updateTamilMark = scanner.nextInt();
                    System.out.print("Enter English mark: ");
                    int updateEnglishMark = scanner.nextInt();
                    System.out.print("Enter Mathematics mark: ");
                    int updateMathematicsMark = scanner.nextInt();
                    System.out.print("Enter Science mark: ");
                    int updateScienceMark = scanner.nextInt();
                    System.out.print("Enter Social Science mark: ");
                    int updateSocialScienceMark = scanner.nextInt();
                    gradeManagementSystem.updateStudent(updateRollNumber, updateTamilMark, updateEnglishMark, updateMathematicsMark, updateScienceMark, updateSocialScienceMark);
                    System.out.println("Student details updated successfully!");
                    break;
                case 3:
                    System.out.println("Deleting Student:");
                    System.out.print("Enter roll number of student to delete: ");
                    int deleteRollNumber = scanner.nextInt();
                    gradeManagementSystem.deleteStudent(deleteRollNumber);
                    break;
                case 4:
                    System.out.println("Displaying Student Details:");
                    System.out.print("Enter roll number of student to display details: ");
                    int displayRollNumber = scanner.nextInt();
                    gradeManagementSystem.displayStudentDetails(displayRollNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
