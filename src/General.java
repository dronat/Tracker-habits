import java.util.*;

public class General {
    public static int ArrayLineNumber = FileWorker.ArraySizeCalculation();
    public static String[][] HabitList = new String[ArrayLineNumber][3];
    public static boolean IsFileEmpty;

    public static void main (String[] agrs){
        if (IsFileEmpty) {
            FileWorker.CreatingTheFirstHabit();
        }
        StarMenu();
    }


    public static void SeeAList() {
        //дописать метод!
    }


    public static void StarMenu() {
        System.out.println("\nДобро пожаловать, Екатерина. \nЧто вас интересует? \n1 - Увидить текущий список привычек\n2 - Редактировать текущий список привычек");
        int select1 = SelectMenu2();
        if (select1 == 1) {
            SeeAList();
        } else if (select1 == 2) {
            //Написать выполнение второго метода
        }
    }



    public static int SelectMenu2 () {
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
}


