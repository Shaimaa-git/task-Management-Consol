import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    String title;
    String description;
    int priority;
    String dueDate;
    boolean completed;

    public Task(String title, String description, int priority, String dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = false;
    }
}

public class TaskManagementSystem {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nTask Management System");
            System.out.println("1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Remove a task");
            System.out.println("5. View tasks by priority");
            System.out.println("6. View tasks by due date");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewAllTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    viewTasksByPriority();
                    break;
                case 6:
                    viewTasksByDueDate();
                    break;
                case 7:
                    System.out.println("Exiting Task Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task priority (1-5, where 5 is the highest): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter task due date: ");
        String dueDate = scanner.nextLine();

        Task task = new Task(title, description, priority, dueDate);
        tasks.add(task);

        System.out.println("Task added successfully!");
    }

    private static void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                printTaskDetails(i + 1, tasks.get(i));
            }
        }
    }

    private static void markTaskAsCompleted() {
        viewAllTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.completed = true;
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask() {
        viewAllTasks();
        System.out.print("Enter the task number to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewTasksByPriority() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            Collections.sort(tasks, Comparator.comparingInt(task -> task.priority));

            System.out.println("Tasks Sorted by Priority:");
            for (int i = 0; i < tasks.size(); i++) {
                printTaskDetails(i + 1, tasks.get(i));
            }
        }
    }

    private static void viewTasksByDueDate() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            Collections.sort(tasks, Comparator.comparing(task -> task.dueDate));

            System.out.println("Tasks Sorted by Due Date:");
            for (int i = 0; i < tasks.size(); i++) {
                printTaskDetails(i + 1, tasks.get(i));
            }
        }
    }

    private static void printTaskDetails(int taskNumber, Task task) {
        System.out.println("\nTask " + taskNumber + ":");
        System.out.println("Title: " + task.title);
        System.out.println("Description: " + task.description);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
        System.out.println("Status: " + (task.completed ? "Completed" : "Incomplete"));
    }
}
