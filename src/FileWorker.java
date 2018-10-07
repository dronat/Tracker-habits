import java.io.*;
import java.util.*;

public class FileWorker {


    public static void DirectoryStartChecker() {
        File dirCheck = new File("C:/ProgramData/Tracker Habits");
        boolean dirBool = dirCheck.isDirectory();
        if (dirBool) {
        } else {
            DirectoryCreator();
        }
    }


    public static void DirectoryCreator() {
        File dir = new File("C:/ProgramData/Tracker Habits");
        boolean created = dir.mkdir();
        if (created) {
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
                General.HabitList.add(new ArrayList<>());
                General.HabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'Binary.txt'");
        }
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\CompleteDays.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.HabitList.get(n1).add(ReadText);
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
                General.HabitList.get(n1).add(ReadText);
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
            while (WriteString < General.HabitList.size()) {
                bwHabitListFile.write(General.HabitList.get(WriteString).get(0));
                bwCompleteDaysFile.write(General.HabitList.get(WriteString).get(1));
                bwMissedDaysFile.write(General.HabitList.get(WriteString).get(2));
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


    public static void IsFileEmpty() {
        try {
            FileWorker.DirectoryStartChecker();
            FileWorker.FileExistStartCheck();
            File file = new File("C:\\ProgramData\\Tracker Habits\\HabitsList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            if (bufferedReader.readLine() != null) {
                General.IsFileEmpty = false;
            } else {
                General.IsFileEmpty = true;
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ArraySizeCalculation() ERROR");
        }

    }


    public static void CreatingTheFirstHabit() {
        System.out.println("Здравствуйте Екатерина!\nУ вас ещё нет ни одной привычки, давайте исправим это! \nКак хотите назвать первую привычку?");
        Scanner scan1 = new Scanner(System.in);
        String scanResult = scan1.nextLine();
        General.HabitList.add(new ArrayList<>());
        General.HabitList.get(0).add(scanResult);
        General.HabitList.get(0).add("0");
        General.HabitList.get(0).add("0");
        FileWriter();
    }
}

