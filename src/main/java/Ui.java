package main.java;

import java.util.List;

public class Ui {
    private static final String LOGO =
            " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    private static final String DIVIDER = "    ____________________________________________________________\n";

    void printHelloMessage() {
        System.out.println("Hello from\n" + LOGO);
        System.out.print(DIVIDER);
        System.out.print("\t Hello! I'm Duke\n");
        System.out.print("\t What can I do for you?\n");
        System.out.print(DIVIDER);
    }

    void printByeMessage() {
        System.out.print(DIVIDER);
        System.out.print("     Bye. Hope to see you again soon!\n");
        System.out.print(DIVIDER);
    }

    void printDivider() {
        System.out.print(DIVIDER);
    }


    void printEmptyTaskListMessage() {
        System.out.print("    You have no task at the moment.\n");
    }

    void printTaskList(List<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("    %d.", i+1);
            System.out.printf("%s\n", taskList.get(i));
        }
    }

    void printMarkedAsDoneMessage(Task task) {
        System.out.print("     Nice! I've marked this task as done:\n");
        System.out.printf("       %s\n", task);
    }

    void printTaskDeletedMessage(Task task, int taskListSize) {
        System.out.print("     Noted. I've removed this task:\n");
        System.out.printf("       %s\n", task);
        System.out.printf("     Now you have %d tasks in the list.\n", taskListSize);
    }

    void printTaskAddedMessage(Task task, int taskListSize) {
        System.out.print("     Got it. I've added this task:\n");
        System.out.printf("       %s\n", task);
        System.out.printf("     Now you have %d tasks in the list.\n", taskListSize);
    }
}
