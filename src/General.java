import java.io.File;
import java.util.*;

public class General {
    public static ArrayList<ArrayList<String>> HabitList = new ArrayList<>();
    public static boolean IsFileEmpty;

    public static void main (String[] agrs){
        FileWorker.IsFileEmpty();
        if (IsFileEmpty) {
            FileWorker.CreatingTheFirstHabit();
        } else {
            FileWorker.FileReader();
        }
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
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList.get(i1).get(0));
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
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList.get(i1).get(0));
        }
        int select = SelectMenu(HabitList.size()) - 1;
        int CompleteDays = Integer.parseInt(HabitList.get(select).get(1)) + 1;
        HabitList.get(select).set(1, Integer.toString(CompleteDays));
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
}


