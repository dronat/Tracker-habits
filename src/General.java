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

    public static void StarMenu() { // In progress
        System.out.println("\nДобро пожаловать, Екатерина. \nЧто вас интересует? \n1 - Увидить текущий список привычек.\n2 - Редактировать текущий список привычек.");
        int select = SelectMenu(2);
        if (select == 1) {
            SeeAList();
        } else if (select == 2) {
            Menu2();
        }
    }


    public static void Menu1() { // In progress
        System.out.println("\nЖелаете что-то ещё?\n1 - Увидить текущий список привычек.\n2 - Редактировать текущий список привычек.");
        int select = SelectMenu(2);
        if (select == 1) {
            SeeAList();
        } else if (select == 2) {
            Menu2();
        }
    }


    public static void Menu2() { // In progress
        System.out.println("\nЧто желаете сделать?\n1 - Добавление привычки.\n2 - Удаление привычки.\n3 - Перенос актуальной привычки в архив.");
        int select = SelectMenu(3);
        if (select == 1) {
            AddHabit();
        } else if (select == 2) {
            DeleteHabit();
        } else if (select == 3) {
            // Написать выполнение третьего пункта
        }
    }


    public static void AddHabit() { // In progress
        System.out.println("\nКак желаете назвать новую привычку?");
        Scanner scan1 = new Scanner(System.in);
        String InputTXT = scan1.nextLine();
        int HabitListSize = HabitList.size();
        HabitList.add(new ArrayList<>());
        HabitList.get(HabitListSize).add(InputTXT);
        HabitList.get(HabitListSize).add("0");
        HabitList.get(HabitListSize).add("0");
        FileWorker.FileWriter();
        System.out.println("\nПривычка '" + HabitList.get(HabitListSize).get(0) + "' успешно создана.");
        Menu1();
    }


    public static void DeleteHabit() {
        System.out.println("\nКакую привычку желаете удалить?");
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList.get(i1).get(0));
        }
        int select = SelectMenu(HabitList.size()) - 1;
        String removedHabit = HabitList.get(select).get(0);
        HabitList.remove(select);
        FileWorker.FileWriter();
        System.out.println("\nПривычка '" + removedHabit + "' успешно удалена.");
        Menu1();
    }


    public static void SeeAList() { // Complete
        System.out.println("\nВаш список привычек:");
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList.get(i1).get(0));
        }
        System.out.println("\nЧто желаете сделать дальше?\n1 - Подтверждение привычки.\n2 - Статистика привычек.\n3 - Изменение списка привычек.");
        int select = SelectMenu(3);
        if (select == 1) {
            HabitConfirmation();
        } else if (select == 2) {
            HabitStatistics();
        } else if (select == 3) {
            Menu2();
        }
    }


    public static void HabitConfirmation() { // Complete
        System.out.println("Какую привычку вы выполнили сегодня?");
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList.get(i1).get(0));
        }
        int select = SelectMenu(HabitList.size()) - 1;
        int CompleteDays = Integer.parseInt(HabitList.get(select).get(1)) + 1;
        HabitList.get(select).set(1, Integer.toString(CompleteDays));
        FileWorker.FileWriter();
        System.out.println("Молодец! Продолжай в том же духе!\n- " + HabitList.get(select).get(0) +
                " | Выполнено дней: " + HabitList.get(select).get(1) +
                " | Пропущено дней: " + HabitList.get(select).get(2) +
                "\n\nЧто желаете сделать дальше?" +
                "\n1 - Продолжить подтверждение выполненных привычек." +
                "\n2 - Вернуться в главное меню.");
        int select1 = SelectMenu(3);
        if (select1 == 1) {
            HabitConfirmation();
        } else if (select1 == 2) {
            Menu1();
        }
    }


    public static void HabitStatistics() { // Complete
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println( i2 + " - " + HabitList.get(i1).get(0) + " | Выполнено дней: " + HabitList.get(i1).get(1) +
                    " | Пропущено дней: " + HabitList.get(i1).get(2));
        }
        Menu1();
    }


    public static int SelectMenu (int r) { // Complete
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


// Попробовать реализовать чтобы программа работала с календарём!!!

