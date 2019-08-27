package utils;

import task.Task;

import java.util.List;

public class Ui {
    public static final String LIST_ACTION_TITLE =
            "     Here are the tasks in your list:\n";
    public static final String FIND_ACTION_TITLE =
            "     Here are the matching tasks in your list:\n";
    private static final String LOGO =
              " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    private static final String DIVIDER = "    ____________________________________________________________\n";

    public void printHelloMessage() {
        System.out.println("Hello from\n" + LOGO);
        System.out.print(DIVIDER);
        System.out.print("     Hello! I'm Duke\n");
        System.out.print("     What can I do for you?\n");
        System.out.print(DIVIDER);
    }

    public void printHelpMessage() {
        System.out.print("     List of commands:\n");
        System.out.print("     bye     : Exits from the program\n");
        System.out.print("     list    : List all existing tasks\n");
        System.out.print("     help    : Prints the list of commands\n");
        System.out.print("     done n  : Marks the n-th task on the list as done\n");
        System.out.print("     delete n: Deletes the n-th task on the list\n");
        System.out.print("     todo taskName :\n"
                + "               Adds a new Todo task with the given name.\n");
        System.out.print("     event taskName /at additionalInfo :\n"
                + "               Adds a new Event task with the given additional\n"
                + "               info.\n");
        System.out.print("     deadline taskName /by DD/MM/YYYY HHmm :\n"
                + "               Adds a new Deadline task with the deadline in the\n"
                + "               given format.\n");
        System.out.print("     search keyword :\n"
                + "               Returns a list of task with names containing the\n"
                + "               keyword.\n");
    }

    public void printByeMessage() {
        System.out.print("     Bye. Hope to see you again soon!\n");
    }

    public void printDivider() {
        System.out.print(DIVIDER);
    }


    public void printEmptyTaskListMessage() {
        System.out.print("    You have no task at the moment.\n");
    }

    public void printTaskList(List<Task> taskList, String title) {
        System.out.print(title);
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("    %d.", i + 1);
            System.out.printf("%s\n", taskList.get(i));
        }
    }

    public void printMarkedAsDoneMessage(Task task) {
        System.out.print("     Nice! I've marked this task as done:\n");
        System.out.printf("       %s\n", task);
    }

    public void printTaskDeletedMessage(Task task, int taskListSize) {
        System.out.print("     Noted. I've removed this task:\n");
        System.out.printf("       %s\n", task);
        System.out.printf("     Now you have %d tasks in the list.\n", taskListSize);
    }


    public void printTaskAddedMessage(Task task, int taskListSize) {
        System.out.print("     Got it. I've added this task:\n");
        System.out.printf("       %s\n", task);
        System.out.printf("     Now you have %d tasks in the list.\n", taskListSize);
    }
}
