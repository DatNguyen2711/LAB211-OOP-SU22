package Ccrm;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    //a string start with number from 0 to 9 and have number 5 after character '.' or number 0
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public static void main(String[] args) throws ParseException {
        ArrayList<Task> lt = new ArrayList<>();
        int id = 1;
        while (true) {
            System.out.println("======== Task Program ========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = InputChoice();
            switch (choice) {
                case 1:
                    addTask(lt, id);
                    id++;
                    break;
                case 2:
                    deleteTask(lt, id);
                    break;
                case 3:
                    print(lt);
                    break;
                case 4:
                    return;

            }
        }
    }


    static int InputChoice() {
        int choice = 0;
        boolean cout = false;
        while (cout = true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice > 0 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Enter number from (1 -> 4) again !!!");
                    cout = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer (1 -> 4) !!!");
                cout = true;
            }
        }
        return choice;
    }


    private static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Re-input");
            }
        }
    }


    private static String checkInputTaskTypeId() {
        while (true) {
            int n = InputChoice();
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }
    public static String inputDate(String mess) {
        System.out.print(mess);
        //set format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        //force user input exectly a date
        while(true) {
            String input = sc.nextLine();
            try {
                Date date = dateFormat.parse(input);
                //get current date
                Date curDate = Calendar.getInstance().getTime();
                //check range of date
                if (curDate.compareTo(date) < 0) {
                    System.out.print("Please input date that before current date: ");
                    continue;
                }
                dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
        }
    }

    private static String checkInputPlanFrom() {
        while (true) {
            try {
                String result = checkInputString();
                if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                        && Double.parseDouble(result) <= 17.5) {
                    return result;
                } else if (!result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                        && Double.parseDouble(result) <= 17.5) {
                    System.out.println("Must like the format a.b which a is integer and b is 0 or 5");
                    System.out.print("From:");
                } else if (!result.matches(PLAN_VALID) && (Double.parseDouble(result) < 8.0
                        || Double.parseDouble(result) > 17.5)) {
                    System.out.println("Must like the format a.b which a is integer and b is 0 or 5");
                    System.out.print("From:");
                } else if (result.matches(PLAN_VALID) && (Double.parseDouble(result) < 8.0
                        || Double.parseDouble(result) > 17.5)) {
                    System.out.println("In range of 8.0 to 17.5");
                    System.out.print("From:");

                }
            } catch (NumberFormatException e) {
                System.out.println("Must like the format a.b which a is integer and b is 0 or 5");
                System.out.print("From:");
            }
        }
    }

    private static String checkInputPlanto(String planFrom) {
        while (true) {
            String result = checkInputString();
            double x = Double.parseDouble(planFrom);
            try {
                if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                        && Double.parseDouble(result) <= 17.5 && Double.parseDouble(result) > x) {
                    return result;
                } else if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                        && Double.parseDouble(result) <= 17.5 && Double.parseDouble(result) <= x) {
                    System.out.println("Plan to must bigger than plan from");
                    System.out.print("To:");

                } else if (!result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                        && Double.parseDouble(result) <= 17.5) {
                    System.out.println("Must like the format a.b which a is integer and b is 0 or 5");
                    System.out.print("To:");
                } else if (!result.matches(PLAN_VALID) && (Double.parseDouble(result) < 8.0
                        || Double.parseDouble(result) > 17.5)) {
                    System.out.println("Must like the format a.b which a is integer and b is 0 or 5");
                    System.out.print("To:");
                } else if (result.matches(PLAN_VALID) && (Double.parseDouble(result) < 8.0
                        || Double.parseDouble(result) > 17.5)) {
                    System.out.println("In range of 8.0 to 17.5");
                    System.out.print("To:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Must like the format a.b which a is integer and b is 0 or 5");
                System.out.print("To:");
            }
        }
    }


    public static boolean checkTaskExist(ArrayList<Task> lt, String taskTypeId, String requirementName,
                                         String date, String planFrom, String planTo, String assign, String reviewer) {
        for (Task task : lt) {
            if (
                    (taskTypeId.equalsIgnoreCase(task.getTaskTypeId())
                            && requirementName.equalsIgnoreCase(task.getRequirementName())
                            && date.equalsIgnoreCase(task.getDate())
                            && planFrom.equalsIgnoreCase(task.getPlanFrom())
                            && planTo.equalsIgnoreCase(task.getPlanTo())
                            && assign.equalsIgnoreCase(task.getAssign())
                            && reviewer.equalsIgnoreCase(task.getReviewer())
                    )) {
                return false;
            }
        }
        return true;
    }


    static boolean checkInsertionTime(ArrayList<Task> lt, String requirementName, String taskType, String assign, String reviewer, String date, String planFrom, String planTo) {
        for (Task task : lt) {
            if (date.equalsIgnoreCase(task.getDate()) && (Double.parseDouble(planFrom) <= Double.parseDouble(task.getPlanFrom())
                    && (Double.parseDouble(planTo) >= Double.parseDouble(task.getPlanFrom()) && Double.parseDouble(planTo) <= Double.parseDouble(task.getPlanTo())))) {
                return false;
            }


            if (date.equalsIgnoreCase(task.getDate()) && (  Double.parseDouble(planTo) >= Double.parseDouble(task.getPlanTo())
                    && (Double.parseDouble(planFrom) >= Double.parseDouble(task.getPlanFrom()) && Double.parseDouble(planFrom) <= Double.parseDouble(task.getPlanTo())))) {
                return false;
            }
//            if (requirementName.equalsIgnoreCase(task.getRequirementName()) && assign.equalsIgnoreCase(task.getAssign()) && reviewer.equalsIgnoreCase(task.getReviewer()) &&
//                    taskType.equalsIgnoreCase(task.getTaskTypeId()) && date.equalsIgnoreCase(task.getDate()) && (Double.parseDouble(planFrom) <= Double.parseDouble(task.getPlanFrom())
//                    && (Double.parseDouble(planTo) >= Double.parseDouble(task.getPlanFrom()) && Double.parseDouble(planTo) <= Double.parseDouble(task.getPlanTo())))) {
//                return false;
//            }
//
//
//            if (requirementName.equalsIgnoreCase(task.getRequirementName()) && assign.equalsIgnoreCase(task.getAssign()) && reviewer.equalsIgnoreCase(task.getReviewer())
//                    && taskType.equalsIgnoreCase(task.getTaskTypeId()) && date.equalsIgnoreCase(task.getDate()) && (Double.parseDouble(planTo) >= Double.parseDouble(task.getPlanTo())
//                    && (Double.parseDouble(planFrom) >= Double.parseDouble(task.getPlanFrom()) && Double.parseDouble(planFrom) <= Double.parseDouble(task.getPlanTo())))) {
//                return false;
//            }
        }
        return true;
    }


    // add one Task
    static void addTask(ArrayList<Task> lt, int id) {
        while (true) {
            System.out.print("Requirement Name: ");
            String requirementName = checkInputString();
            System.out.print("Task Type: ");
            String taskType = checkInputTaskTypeId();
            System.out.print("Date: ");
            String date = inputDate("Enter Date: ");
            System.out.print("From: ");
            String planFrom = checkInputPlanFrom();
            System.out.print("To: ");
            String planTo = checkInputPlanto(planFrom);
            System.out.print("Enter Assignee: ");
            String assign = checkInputString();
            System.out.print("Enter Reviewer: ");
            String reviewer = checkInputString();
            if (!checkTaskExist(lt, taskType, requirementName, date, planFrom, planTo, assign, reviewer)) {
                System.out.println("Duplicate !!! ");
                System.out.println("");
            } else if (!checkTaskExist(lt, requirementName, taskType, assign, reviewer, date, planFrom, planTo)) {
                System.out.println("Timeline Insertion");
                System.out.println("");
            } else {
                lt.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assign, reviewer));
                System.out.println("Add Task Successful !!!.");
                System.out.println("");
                return;
            }


        }
    }


    private static int findTaskExist(ArrayList<Task> lt) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                return i;
            }
        }
        System.out.println("Not found.");
        return -1;
    }


    private static void deleteTask(ArrayList<Task> lt, int id) {
        if (lt.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        int findId = findTaskExist(lt);
        if (findId != -1) {
            lt.remove(findId);
//            for (int i = findId; i < lt.size(); i++) {
//                lt.get(i).setId(lt.get(i).getId() - 1);
//            }
            System.out.println("Delete successful !!!.");
        }
        System.out.println("");
    }


    private static void print(ArrayList<Task> lt) throws ParseException {
        if (lt.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getAssign(),
                    lt.get(i).getReviewer()
            );
        }
        System.out.println("");
    }
}
