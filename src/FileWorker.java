import java.io.*;
import java.util.Scanner;

public class FileWorker {


    public static void DirectoryStartChecker() {
        File dirCheck = new File("C:/ProgramData/Tracker Habits");
        boolean dirBool = dirCheck.isDirectory();
        if (dirBool) {
            //System.out.println("Directory exist");
        } else {
            //System.out.println("Directory not exist");
            DirectoryCreator();
        }
    }


    public static void DirectoryCreator() {
        File dir = new File("C:/ProgramData/Tracker Habits");
        boolean created = dir.mkdir();
        if (created) {
            //System.out.println("Created new directory");
        } else {
            System.out.println("\nDirectory create error");
        }
    }


    public static void FileExistStartCheck() {
        File HabitListFile = new File("C:/ProgramData/Tracker Habits", "HabitsList.txt");
        File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "CompleteDays.txt");
        File MissedDaysFile = new File("C:/ProgramData/Tracker Habits", "MissedDays.txt");
        boolean HabitExist = HabitListFile.exists();
        boolean CompleteExist = CompleteDaysFile.exists();
        boolean MissedExist = MissedDaysFile.exists();
        if (HabitExist) {
            if (CompleteExist) {
                if (MissedExist) {
                    //System.out.println("Files successfully created");
                } else {
                    FileCreator();
                }
            } else {
                FileCreator();
            }
        } else {
            FileCreator();
        }
    }


    public static void FileReader() {
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\HabitsList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.HabitList[n1][0] = ReadText;
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'Binary.txt'");
        }
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\CompletedDays.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.HabitList[n1][1] = ReadText;
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'CompletedDays.txt'");
        }
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\MissedDays.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.HabitList[n1][2] = ReadText;
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'MissedDays.txt'");
        }
    }


    public static void FileCreator() {
        File HabitListFile = new File("C:/ProgramData/Tracker Habits","HabitsList.txt");
        File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits","CompleteDays.txt");
        File MissedDaysFile = new File("C:/ProgramData/Tracker Habits","MissedDays.txt");
        try {
            boolean HabitFileCreated = HabitListFile.createNewFile();
            boolean CompleteFileCreated = CompleteDaysFile.createNewFile();
            boolean MissedFileCreated = MissedDaysFile.createNewFile();
            if(HabitFileCreated && CompleteFileCreated && MissedFileCreated) {
                //System.out.println("File's has been created");
            }
        } catch (IOException ex) {
            System.out.println("\nFile creation error");
        }
    }



    public static void FileWriter() {
        try {
            File HabitListFile = new File("C:/ProgramData/Tracker Habits", "HabitsList.txt");
            File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "CompleteDays.txt");
            File MissedDaysFile = new File("C:/ProgramData/Tracker Habits", "MissedDays.txt");
            BufferedWriter bwHabitListFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HabitListFile), "UTF8"));
            BufferedWriter bwCompleteDaysFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(CompleteDaysFile), "UTF8"));
            BufferedWriter bwMissedDaysFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(MissedDaysFile), "UTF8"));
            int WriteString = 0;
            while (WriteString < General.ArrayLineNumber) {
                bwHabitListFile.write(General.HabitList[WriteString][0]);
                bwCompleteDaysFile.write(General.HabitList[WriteString][1]);
                bwMissedDaysFile.write(General.HabitList[WriteString][2]);
                bwHabitListFile.newLine();
                bwCompleteDaysFile.newLine();
                bwMissedDaysFile.newLine();
                bwHabitListFile.flush();
                bwCompleteDaysFile.flush();
                bwMissedDaysFile.flush();
                WriteString++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found Error");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Encoding Error");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Write Error");
        }
    }


    public static int ArraySizeCalculation() {
        int x = 0;
        try {
            FileWorker.DirectoryStartChecker();
            FileWorker.FileExistStartCheck();
            File file = new File("C:\\ProgramData\\Tracker Habits\\HabitsList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            if (bufferedReader.readLine() != null) {
                General.IsFileEmpty = false;
                while (bufferedReader.readLine() != null) {
                    x++;
                }
            } else {
                General.IsFileEmpty = true;
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ArraySizeCalculation() ERROR");
        }
        return x;
    }


    public static void CreatingTheFirstHabit() {
        System.out.println("Здравствуйте Екатерина!\nУ вас ещё нет ни одной привычки, давайте исправим это! \nКак хотите назвать первую привычку?");
        Scanner scan1 = new Scanner(System.in);
        String scanResult = scan1.nextLine();
        General.HabitList = new String [1][3];
        General.HabitList [0][0] = scanResult;
        General.HabitList [0][1] = "0";
        General.HabitList [0][2] = "0";
        General.ArrayLineNumber++;
        FileWriter();
    }
}

