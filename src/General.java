import java.util.*;

public class General {
    public static ArrayList<ArrayList<String>> HabitList = new ArrayList<>();
    public static ArrayList<ArrayList<String>> ArchiveHabitList = new ArrayList<>();
    public static boolean IsHabitListFileEmpty,IsArchiveHabitListFileEmpty;
    public static int NewDate;
    public static Calendar calendar = new GregorianCalendar();


    public static void main (String[] agrs){

        NewDate = calendar.get(Calendar.DAY_OF_YEAR);
        FileWorker.IsHabitListFileEmpty();
        FileWorker.IsArchiveHabitListFileEmpty();
        if (IsHabitListFileEmpty) {
            FileWorker.CreatingTheFirstHabit();
        } else {

            FileWorker.ReadAllOfTheFiles();
        }
        FileWorker.MissedDaysChecker();
        StarMenu();
    }

    public static void StarMenu() { // Complete
        System.out.println("\nДобро пожаловать, Екатерина. \nЧто вас интересует? \n1 - Увидить текущий список привычек.\n2 - Редактировать текущий список привычек.\n3 - Просмотр архивных привычек.");
        int select1 = SelectMenu(3);
        if (select1 == 1) {
            Menu2();
        } else if (select1 == 2) {
            Menu3();
        } else if (select1 == 3) {
            Menu4();
        }
    }


    public static void Menu1() { // Complete
        System.out.println("\nЖелаете что-то ещё?\n1 - Увидить текущий список привычек.\n2 - Редактировать текущий список привычек.\n3 - Просмотр архивных привычек.");
        int select1 = SelectMenu(3);
        if (select1 == 1) {
            Menu2();
        } else if (select1 == 2) {
            Menu3();
        } else if (select1 == 3) {
            Menu4();
        }
    }


    public static void Menu2() { // Complete
        HabitSeeAList();
        System.out.println("\nЧто желаете сделать дальше?\n1 - Подтверждение привычки.\n2 - Статистика привычек.\n3 - Изменение списка привычек.\n4 - Вернуться в главное меню.");
        int select1 = SelectMenu(4);
        if (select1 == 1) {
            HabitConfirmation();
        } else if (select1 == 2) {
            HabitStatistics();
            Menu1();
        } else if (select1 == 3) {
            Menu3();
        } else if (select1 == 4) {
            Menu1();
        }
    }


    public static void Menu3() { // Complete
        System.out.println("\nЧто желаете сделать?\n1 - Добавление привычки.\n2 - Удаление привычки.\n3 - Изменение архивной привычки.\n4 - Вернуться в главное меню.");
        int select1 = SelectMenu(4);
        if (select1 == 1) {
            HabitAdd();
        } else if (select1 == 2) {
            HabitDelete();
        } else if (select1 == 3) {
            Menu4();
        } else if (select1 == 4) {
            Menu1();
        }
    }


    public static void Menu4() { // In progress
        if (IsArchiveHabitListFileEmpty){
            ArchiveHabitSeeAList();
            System.out.println("\n Что желаете сделать?\n1 - Перенос актульной привычки в архив.\n2 - Вернуться в главное меню.");
            int select1 = SelectMenu(3);
            if (select1 == 1) {
                HabitsTransferringToArchive();
            } else if (select1 == 2) {
                Menu1();
            }
        } else {
            ArchiveHabitStatistics();
            System.out.println("\n Что желаете сделать?\n1 - Перенос актульной привычки в архив.\n2 - Восстановление привычки из архива.\n3 - Вернуться в главное меню.");
            int select1 = SelectMenu(3);
            if (select1 == 1) {
                HabitsTransferringToArchive();
            } else if (select1 == 2) {
                HabitsRestoringFromTheArchive();
            } else if (select1 == 3) {
                Menu1();
            }
        }
    }


    public static void HabitAdd() { // Complete
        System.out.println("\nКак желаете назвать новую привычку?");
        Scanner scan1 = new Scanner(System.in);
        String InputTXT = scan1.nextLine();
        int HabitListSize = HabitList.size();
        HabitList.add(new ArrayList<>());
        HabitList.get(HabitListSize).add(InputTXT);
        HabitList.get(HabitListSize).add("0");
        HabitList.get(HabitListSize).add("0");
        System.out.println("Через сколько дней ваша привычка будет считаться выполненной?");
        int select1 = General.SelectMenu(2147483640);
        String scanResult2 = Integer.toString(select1);
        General.HabitList.get(0).add(scanResult2);
        General.HabitList.get(0).add(Integer.toString(General.NewDate));
        FileWorker.SaveAllInFiles();
        System.out.println("\nПривычка '" + HabitList.get(HabitListSize).get(0) + "' успешно создана.");
        Menu1();
    }


    public static void HabitDelete() { // Complete
        System.out.println("\nКакую привычку желаете удалить?");
        HabitSeeAList();
        int select1 = SelectMenu(HabitList.size()) - 1;
        String removedHabit = HabitList.get(select1).get(0);
        HabitList.remove(select1);
        FileWorker.SaveAllInFiles();
        System.out.println("\nПривычка '" + removedHabit + "' успешно удалена.");
        Menu1();
    }


    public static void HabitsTransferringToArchive() { // In progress
        System.out.println("\nКакую привычку желаете переместить в архив?");
        HabitSeeAList();
        int select1 = SelectMenu(HabitList.size()) - 1;
        String HabitName = HabitList.get(select1).get(0);
        String HabitCompleteDays = HabitList.get(select1).get(1);
        String HabitMissedDays = HabitList.get(select1).get(2);
        String NumberOfDays = HabitList.get(select1).get(3);
        ArchiveHabitList.add(new ArrayList<>());
        ArchiveHabitList.get(ArchiveHabitList.size() - 1).add(HabitName);
        ArchiveHabitList.get(ArchiveHabitList.size() - 1).add(HabitCompleteDays);
        ArchiveHabitList.get(ArchiveHabitList.size() - 1).add(HabitMissedDays);
        ArchiveHabitList.get(ArchiveHabitList.size() - 1).add(NumberOfDays);
        HabitList.remove(select1);
        System.out.println("\nПривычка '" + ArchiveHabitList.get(ArchiveHabitList.size() - 1).get(0) + "' успешно перенесена в архив.");
        FileWorker.SaveAllInFiles();
        FileWorker.IsArchiveHabitListFileEmpty();
        Menu1();
    }


    public static void  HabitsRestoringFromTheArchive() {
        System.out.println("\nКакую привычку желаете восстановить из архива?");
        ArchiveHabitSeeAList();
        int select1 = SelectMenu(ArchiveHabitList.size()) - 1;
        String ArchiveHabitName = ArchiveHabitList.get(select1).get(0);
        String ArchiveHabitCompleteDays = ArchiveHabitList.get(select1).get(1);
        String ArchiveHabitMissedDays = ArchiveHabitList.get(select1).get(2);
        String ArchiveNumberOfDays = ArchiveHabitList.get(select1).get(3);
        HabitList.add(new ArrayList<>());
        HabitList.get(HabitList.size() - 1).add(ArchiveHabitName);
        HabitList.get(HabitList.size() - 1).add(ArchiveHabitCompleteDays);
        HabitList.get(HabitList.size() - 1).add(ArchiveHabitMissedDays);
        HabitList.get(HabitList.size() - 1).add(ArchiveNumberOfDays);
        HabitList.get(HabitList.size() - 1).add(Integer.toString(NewDate));
        ArchiveHabitList.remove(select1);
        System.out.println("\nПривычка '" + HabitList.get(HabitList.size() - 1).get(0) + "' успешно восстановлена из архива.");
        FileWorker.SaveAllInFiles();
        FileWorker.IsArchiveHabitListFileEmpty();
        Menu1();
    }


    public static void HabitConfirmation() { // Complete
        System.out.println("Какую привычку вы выполнили сегодня?");
        HabitSeeAList();
        int select1 = SelectMenu(HabitList.size()) - 1;
        int CompleteDays = Integer.parseInt(HabitList.get(select1).get(1)) + 1;
        HabitList.get(select1).set(1, Integer.toString(CompleteDays));
        FileWorker.SaveAllInFiles();
        System.out.println("Молодец! Продолжай в том же духе!\n- " + HabitList.get(select1).get(0) +
                " | Выполнено дней: " + HabitList.get(select1).get(1) +
                " | Пропущено дней: " + HabitList.get(select1).get(2) +
                "\n\nЧто желаете сделать дальше?" +
                "\n1 - Продолжить подтверждение выполненных привычек." +
                "\n2 - Вернуться в главное меню.");
        int select2 = SelectMenu(3);
        if (select2 == 1) {
            HabitConfirmation();
        } else if (select2 == 2) {
            Menu1();
        }
    }


    public static void HabitStatistics() { // Complete
        System.out.println("\nСтатистика ваших привычек:");
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;

            int HabitAllDays = Integer.parseInt(HabitList.get(i1).get(1)) + Integer.parseInt(HabitList.get(i1).get(2));
            System.out.println( i2 + " - " + HabitList.get(i1).get(0) + " | Всего дней: " + HabitAllDays + " / " + HabitList.get(i1).get(3) + " | Выполнено дней: " + HabitList.get(i1).get(1) +
                    " | Пропущено дней: " + HabitList.get(i1).get(2));
        }
    }


    public static void ArchiveHabitStatistics() { // Complete
        System.out.println("\nВаш список архивных привычек:");
        for (int i1 = 0; i1 < ArchiveHabitList.size(); i1++) {
            int i2 = i1 + 1;
            int ArchiveHabitAllDays = Integer.parseInt(ArchiveHabitList.get(i1).get(1)) + Integer.parseInt(ArchiveHabitList.get(i1).get(2));
            System.out.println( i2 + " - " + ArchiveHabitList.get(i1).get(0) + " | Всего дней: " + ArchiveHabitAllDays + " / " + ArchiveHabitList.get(i1).get(3) +  " | Выполнено дней: " + ArchiveHabitList.get(i1).get(1) +
                    " | Пропущено дней: " + ArchiveHabitList.get(i1).get(2));
        }
    }


    public static void HabitSeeAList() { // Complete
        System.out.println("\nВаш список привычек:");
        for (int i1 = 0; i1 < HabitList.size(); i1++) {
            int i2 = i1 + 1;
            System.out.println(i2 + " - " + HabitList.get(i1).get(0));
        }
    }


    public static void ArchiveHabitSeeAList() { // Complete
        if (IsArchiveHabitListFileEmpty) {
            System.out.println("\nСписок архивных привычек пуст.");
        } else {
            System.out.println("\nВаш список архивных привычек:");
            for (int i1 = 0; i1 < ArchiveHabitList.size(); i1++) {
                int i2 = i1 + 1;
                System.out.println(i2 + " - " + ArchiveHabitList.get(i1).get(0));
            }
        }
    }



    public static int SelectMenu (int r) { // Complete
        boolean CorrectValue;
        int result = 0;
        do {
            try {
                CorrectValue = true;
                Scanner scan1 = new Scanner(System.in);
                int select1 = scan1.nextInt();
                if (select1 < 1 | select1 > r) {
                    System.out.println("Вы ввели неверную цифру, попробуйте ещё раз.");
                    CorrectValue = false;
                } else {
                    result = select1;
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
// 0 - имя, 1 - выполненные дни, 2 - пропущенные дни, 3 - количество дней до окончания, 4 - Последне выполнение.
