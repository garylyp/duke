package utils;

import exception.EmptyDescriptionException;
import task.TaskList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * <p>
 *     Helps to scan user input and process them into information.
 * </p>
 */
public class Parser {

    private Scanner sc;

    public Parser() {
        sc = new Scanner(System.in);
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Clears the current line the scanner is on.
     */
    public void nextLine() {
        sc.nextLine();
    }

    /**
     * Checks whether there is more content for the scanner to read.
     *
     * @return Whether there is next or not.
     */
    public boolean hasNext() {
        return sc.hasNext();
    }

    /**
     * Reads and returns the next action in the user input.
     *
     * @return The next action string.
     */
    public String getNextAction() {
        return sc.next();
    }

    /**
     * <p>
     *     Reads and breaks down the content after the "event" action keyword.
     *     Invalid input argument types or format will be highlighted to the
     *     user.
     * </p>
     *
     * @return <p>
     *     If successful, an array of String of length 2 consisting of the Event's
     *     name and additional info.
     *
     *     Else, a null object.
     * </p>
     *
     */
    public String[] parseEventDetail() {
        try {
            String taskName = sc.nextLine().trim();
            String[] taskInfo = taskName.split("\\s*/at\\s*");
            if (taskName.isEmpty() || taskInfo[0].trim().isEmpty() || taskInfo[1].equals("")) {
                throw new EmptyDescriptionException();
            }
            return taskInfo;
        } catch (EmptyDescriptionException e) {
            System.out.printf("     ☹ OOPS!!! The description of a %s cannot be empty.\n", "event");
            return null;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("     ☹ OOPS!!! There must be exactly one argument before and\n"
                    + "     one argument after the keyword %s.\n", "/at");
            return null;
        }
    }

    /**
     * <p>
     *     Reads and breaks down the content after the "deadline" action keyword.
     *     Invalid input argument types or format will be highlighted to the user.
     * </p>
     *
     * @return <p>
     *     If successful, an array of String of length 2 consisting of the Deadline
     *     Task's name and deadline, a String in the format "DD/MM/YYYY HHmm".
     *
     *     Else, a null object.
     * </p>
     *
     */
    public String[] parseDeadlineDetail() {
        try {
            String taskName = sc.nextLine().trim();
            String[] taskInfo = taskName.split("\\s*/by\\s*");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
            sdf.setLenient(false);
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(taskInfo[1]));

            if (taskName.isEmpty() || taskInfo[0].trim().isEmpty()) {
                throw new EmptyDescriptionException();
            }
            return taskInfo;

        } catch (EmptyDescriptionException e) {
            System.out.printf("     ☹ OOPS!!! The description of a %s cannot be empty.\n", "deadline");
            return null;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("     ☹ OOPS!!! There must be exactly one argument before and\n"
                    + "     one argument after the keyword %s.\n", "/by");
            return null;

        } catch (ParseException e) {
            System.out.print("     ☹ OOPS!!! Date must be in the format \"dd/MM/yyyy HHmm\"\n + "
                    + "     and must be valid.");
            return null;
        }
    }

    /**
     * <p>
     *     Reads and breaks down the content after the "todo" action keyword.
     *     Invalid input argument types or format will be highlighted to the
     *     user.
     * </p>
     *
     * @return <p>
     *     If successful, a String representing the Task's name.
     *
     *     Else, a null object.
     * </p>
     *
     */
    public String parseTodoDetail() {
        try {
            String taskName = sc.nextLine().trim();
            if (taskName.isEmpty()) {
                throw new EmptyDescriptionException();
            }
            return taskName;
        } catch (EmptyDescriptionException e) {
            System.out.printf("     ☹ OOPS!!! The description of a %s cannot be empty.\n", "todo");
            return null;
        }
    }

    /**
     * <p>
     *     Reads the next integer from user input where the integer must be
     *     a valid index for the tasks in TaskList.
     * </p>
     *
     * @return
     *     If successful, an Integer representing the task index.
     *     Else, a null object.
     *
     */
    public Integer getTaskIdx() {

        TaskList taskList = TaskList.newInstance();
        try {
            int idx = Integer.parseInt(sc.next()) - 1;
            sc.nextLine();
            taskList.get(idx);
            return idx;

        } catch (IndexOutOfBoundsException e) {
            if (taskList.isEmpty()) {
                System.out.printf("     ☹ OOPS!!! You have no task at the moment.\n", 1, taskList.size());
            } else {
                System.out.printf("     ☹ OOPS!!! Task index number must be a number from %d to %d.\n",
                        1,
                        taskList.size());
            }
            return null;

        } catch (NumberFormatException e) {
            System.out.printf("     ☹ OOPS!!! Task index number must be a number from %d to %d.\n",
                    1,
                    taskList.size());
            return null;
        }
    }

    public String parseFindKeyword() {
        try {
            String keyword = sc.nextLine().trim();
            if (keyword.isEmpty()) {
                throw new EmptyDescriptionException();
            }
            return keyword;
        } catch (EmptyDescriptionException e) {
            System.out.print("     ☹ OOPS!!! The keyword for \"find\" cannot be empty.\n");
            return null;
        }
    }
}
