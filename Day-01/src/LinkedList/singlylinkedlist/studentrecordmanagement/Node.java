package LinkedList.singlylinkedlist.studentrecordmanagement;

public class Node {
    StudentRecord student;
    Node next;

    // Constructor
    public Node(StudentRecord student) {
        this.student = student;
        this.next = null;
    }
}

// SinglyLinkedList class to manage the list of student records
class SinglyLinkedList {
    private Node head;

    // Constructor
    public SinglyLinkedList() {
        head = null;
    }

    // Add a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(new StudentRecord(rollNumber, name, age, grade));
        newNode.next = head;
        head = newNode;
    }

    // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(new StudentRecord(rollNumber, name, age, grade));
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Add a new student record at a specific position
    public void addAtPosition(int rollNumber, String name, int age, char grade, int position) {
        Node newNode = new Node(new StudentRecord(rollNumber, name, age, grade));
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            int currentPosition = 0;
            while (temp != null && currentPosition < position - 1) {
                temp = temp.next;
                currentPosition++;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Position out of range.");
            }
        }
    }

    // Delete a student record by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.student.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.student.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Search for a student record by roll number
    public void searchByRollNumber(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.rollNumber == rollNumber) {
                System.out.println("Student found: " + temp.student.name + ", Age: " + temp.student.age + ", Grade: " + temp.student.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.student.rollNumber + ", Name: " + temp.student.name +
                    ", Age: " + temp.student.age + ", Grade: " + temp.student.grade);
            temp = temp.next;
        }
    }

    // Update a student's grade by roll number
    public void updateGrade(int rollNumber, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.student.rollNumber == rollNumber) {
                temp.student.grade = newGrade;
                System.out.println("Grade updated to " + newGrade + " for student Roll Number: " + rollNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }
}
