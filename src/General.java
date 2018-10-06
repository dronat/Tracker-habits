import java.io.File;
import java.util.*;

public class General {
    public static int ArrayLineNumber = FileWorker.ArraySizeCalculation();
    public static String[][] HabitList = new String[ArrayLineNumber][3];
    public static boolean IsFileEmpty;

    public static void main (String[] agrs){
        if (IsFileEmpty) {
            FileWorker.CreatingTheFirstHabit();
        }
        FileWorker.FileReader();
        StarMenu();
    }

    public static void StarMenu() {
        System.out.println("\nДобро пожаловать, Екатерина. \nЧто вас интересует? \n1 - Увидить текущий список привычек.\n2 - Редактировать текущий список привычек.");
        int select = SelectMenu(2);
        if (select == 1) {
            SeeAList();
        } else if (select == 2) {
            //Написать выполнение второго метода
        }
    }


    public static void Menu1() {
        System.out.println("\nЖелаете что-то ещё?\n1 - Увидить текущий список привычек.\n2 - Редактировать текущий список привычек.");
        int select = SelectMenu(2);
        if (select == 1) {
            SeeAList();
        } else if (select == 2) {
            //Написать выполнение второго метода
        }
    }


    public static void SeeAList() {
        System.out.println("\nВаш список привычек:");
        /*for (int i1 = 0; i1 < HabitList.length; i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList[i1][0]);*/
        for (int i1 = 0; i1 < HabitList.length; i1++) {
            System.out.println(" - " + HabitList[i1][0]);
        }
        System.out.println("\nЧто желаете сделать дальше?\n1 - Подтверждение привычки.\n2 - Статистика привычки.\n3 - Изменение списка привычек.");
        int select = SelectMenu(3);
        if (select == 1) {
            HabitConfirmation();
        } else if (select == 2) {
            HabitStatistics();
        } else if (select == 3) {
            // Написать выполнение третьего пункта
        }
    }


    public static void HabitConfirmation() {
        System.out.println("Какую привычку вы выполнили сегодня?");
        for (int i1 = 0; i1 < HabitList.length; i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList[i1][0]);
        }
        int select = SelectMenu(HabitList.length) - 1;
        int CompleteDays = Integer.parseInt(HabitList[select][1]) + 1;
        HabitList[select][1] = Integer.toString(CompleteDays);
        FileWorker.FileWriter();
        Menu1();
    }


    public static void HabitStatistics() {
        // Написать выполнение метода по показу статистики!
    }


    public static int SelectMenu (int r) {
        boolean CorrectValue;
        int result = 0;
        do {
            try {
                CorrectValue = true;
                Scanner scan1 = new Scanner(System.in);
                int select2 = scan1.nextInt();
                if (select2 < 1 | select2 > r) {
                    System.out.println("Вы ввели неверную цифру, попробуйте ещё раз.");
                    CorrectValue = false;
                } else {
                    result = select2;
                }
            } catch (InputMismatchException e) {
                CorrectValue = false;
                System.out.println("Вводить необходимо только цифры! \nПопробуйте ещё раз.");
            }
        } while (!CorrectValue);
        return result;
    }
    /*public static int SelectMenu2Numbers () {
        boolean CorrectValue;
        int select1 = 0;
        do {
            try {
                CorrectValue = true;
                Scanner scan1 = new Scanner(System.in);
                int select2 = scan1.nextInt();
                if (select2 != 1 & select2 != 2) {
                    System.out.println("Вы ввели неверную цифру, попробуйте ещё раз.");
                    CorrectValue = false;
                } else {
                    select1 = select2;
                }
            }catch (InputMismatchException e) {
                CorrectValue = false;
                System.out.println("Вводить необходиму только цифры! \nПопробуйте ещё раз");
            }
        } while (!CorrectValue);
        return select1;
    }


    public static int SelectMenu3Numbers () {
        boolean CorrectValue;
        int select1 = 0;
        do {
            try {
                CorrectValue = true;
                Scanner scan1 = new Scanner(System.in);
                int select2 = scan1.nextInt();
                if (select2 != 1 & select2 != 2 & select2 != 3) {
                    System.out.println("Вы ввели неверную цифру, попробуйте ещё раз.");
                    CorrectValue = false;
                } else {
                    select1 = select2;
                }
            }catch (InputMismatchException e) {
                CorrectValue = false;
                System.out.println("Вводить необходиму только цифры! \nПопробуйте ещё раз");
            }
        } while (!CorrectValue);
        return select1;
    }*/
}


