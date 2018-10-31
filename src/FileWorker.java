import java.io.*;
import java.util.*;

public class FileWorker {


    public static void DirectoryStartChecker() { // Complete
        File dirCheck = new File("C:/ProgramData/Tracker Habits");
        boolean dirBool = dirCheck.isDirectory();
        if (dirBool) {
        } else {
            DirectoryCreator();
        }
    }


    public static void DirectoryCreator() { // Complete
        File dir = new File("C:/ProgramData/Tracker Habits");
        boolean created = dir.mkdir();
        if (created) {
        } else {
            System.out.println("\nDirectory create error");
        }
    }


    public static void FileExistStartCheck() { // Complete
        File HabitListFile = new File("C:/ProgramData/Tracker Habits", "HabitsList.txt");
        File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "CompleteDays.txt");
        File MissedDaysFile = new File("C:/ProgramData/Tracker Habits", "MissedDays.txt");
        File ArchiveHabitListFile = new File("C:/ProgramData/Tracker Habits", "ArchiveHabitsList.txt");
        File ArchiveCompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveCompleteDays.txt");
        File ArchiveMissedDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveMissedDays.txt");
        boolean HabitExist = HabitListFile.exists();
        boolean CompleteExist = CompleteDaysFile.exists();
        boolean MissedExist = MissedDaysFile.exists();
        boolean ArchiveHabitExist = ArchiveHabitListFile.exists();
        boolean ArchiveCompleteExist = ArchiveCompleteDaysFile.exists();
        boolean ArchiveMissedExist = ArchiveMissedDaysFile.exists();
        if (HabitExist && CompleteExist && MissedExist && ArchiveHabitExist && ArchiveCompleteExist && ArchiveMissedExist) {
        } else {
            FileCreator();
        }
    }


    public static void FileCreator() { // Complete
        File HabitListFile = new File("C:/ProgramData/Tracker Habits","HabitsList.txt");
        File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits","CompleteDays.txt");
        File MissedDaysFile = new File("C:/ProgramData/Tracker Habits","MissedDays.txt");
        File ArchiveHabitListFile = new File("C:/ProgramData/Tracker Habits", "ArchiveHabitsList.txt");
        File ArchiveCompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveCompleteDays.txt");
        File ArchiveMissedDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveMissedDays.txt");
        try {
            boolean HabitFileCreated = HabitListFile.createNewFile();
            boolean CompleteFileCreated = CompleteDaysFile.createNewFile();
            boolean MissedFileCreated = MissedDaysFile.createNewFile();
            boolean ArchiveHabitCreated = ArchiveHabitListFile.createNewFile();
            boolean ArchiveCompleteCreated = ArchiveCompleteDaysFile.createNewFile();
            boolean ArchiveMissedCreated = ArchiveMissedDaysFile.createNewFile();
            if(HabitFileCreated && CompleteFileCreated && MissedFileCreated && ArchiveHabitCreated && ArchiveCompleteCreated && ArchiveMissedCreated) {
            }
        } catch (IOException ex) {
            System.out.println("\nFile creation error");
        }
    }


    public static void ReadAllOfTheFiles() { // Complete
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
            System.out.println("FileReader ERROR 'HabitList.txt'");
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
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\ArchiveHabitsList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.ArchiveHabitList.add(new ArrayList<>());
                General.ArchiveHabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'ArchiveHabitList.txt'");
        }
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\ArchiveCompleteDays.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.ArchiveHabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'ArchiveCompletedDays.txt'");
        }
        try {
            File file = new File("C:\\ProgramData\\Tracker Habits\\ArchiveMissedDays.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.ArchiveHabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'ArchiveMissedDays.txt'");
        }
    }


    public static void SaveAllInFiles() { // Complete
        try {
            File HabitListFile = new File("C:/ProgramData/Tracker Habits", "HabitsList.txt");
            File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "CompleteDays.txt");
            File MissedDaysFile = new File("C:/ProgramData/Tracker Habits", "MissedDays.txt");
            File ArchiveHabitListFile = new File("C:/ProgramData/Tracker Habits", "ArchiveHabitsList.txt");
            File ArchiveCompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveCompleteDays.txt");
            File ArchiveMissedDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveMissedDays.txt");
            BufferedWriter bwHabitListFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HabitListFile), "UTF8"));
            BufferedWriter bwCompleteDaysFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(CompleteDaysFile), "UTF8"));
            BufferedWriter bwMissedDaysFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(MissedDaysFile), "UTF8"));
            BufferedWriter bwArchiveHabitListFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveHabitListFile), "UTF8"));
            BufferedWriter bwArchiveCompleteDaysFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveCompleteDaysFile), "UTF8"));
            BufferedWriter bwArchiveMissedDaysFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveMissedDaysFile), "UTF8"));
            int HabitWriteString = 0;
            while (HabitWriteString < General.HabitList.size()) {
                bwHabitListFile.write(General.HabitList.get(HabitWriteString).get(0));
                bwCompleteDaysFile.write(General.HabitList.get(HabitWriteString).get(1));
                bwMissedDaysFile.write(General.HabitList.get(HabitWriteString).get(2));
                bwHabitListFile.newLine();
                bwCompleteDaysFile.newLine();
                bwMissedDaysFile.newLine();
                bwHabitListFile.flush();
                bwCompleteDaysFile.flush();
                bwMissedDaysFile.flush();
                HabitWriteString++;
            }
            int ArchiveHabitWriteString = 0;
            while (ArchiveHabitWriteString < General.ArchiveHabitList.size()) {
                bwArchiveHabitListFile.write(General.ArchiveHabitList.get(ArchiveHabitWriteString).get(0));
                bwArchiveCompleteDaysFile.write(General.ArchiveHabitList.get(ArchiveHabitWriteString).get(1));
                bwArchiveMissedDaysFile.write(General.ArchiveHabitList.get(ArchiveHabitWriteString).get(2));
                bwArchiveHabitListFile.newLine();
                bwArchiveCompleteDaysFile.newLine();
                bwArchiveMissedDaysFile.newLine();
                bwArchiveHabitListFile.flush();
                bwArchiveCompleteDaysFile.flush();
                bwArchiveMissedDaysFile.flush();
                ArchiveHabitWriteString++;
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


    public static void IsHabitListFileEmpty() { // Complete
        try {
            FileWorker.DirectoryStartChecker();
            FileWorker.FileExistStartCheck();
            File file = new File("C:\\ProgramData\\Tracker Habits\\HabitsList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            if (bufferedReader.readLine() == null) {
                General.IsHabitListFileEmpty = true;
            } else {
                General.IsHabitListFileEmpty = false;
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("IsHabitListFileEmpty() ERROR");
        }

    }


    public static void IsArchiveHabittListFileEmpty() { // Complete
        try {
            FileWorker.DirectoryStartChecker();
            FileWorker.FileExistStartCheck();
            File file = new File("C:\\ProgramData\\Tracker Habits\\ArchiveHabitsList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            if (bufferedReader.readLine() == null) {
                General.IsArchiveHabitListFileEmpty = true;
            } else {
                General.IsArchiveHabitListFileEmpty = false;
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ArraySizeCalculation() ERROR");
        }

    }


    public static void CreatingTheFirstHabit() { // Complete
        System.out.println("Здравствуйте Екатерина!\nУ вас ещё нет ни одной привычки, давайте исправим это! \nКак хотите назвать первую привычку?");
        Scanner scan1 = new Scanner(System.in);
        String scanResult = scan1.nextLine();
        General.HabitList.add(new ArrayList<>());
        General.HabitList.get(0).add(scanResult);
        General.HabitList.get(0).add("0");
        General.HabitList.get(0).add("0");
        SaveAllInFiles();
    }
<<<<<<< HEAD



    public static void MissedDaysChecker() {
        for (int i1 = 0; i1 < General.HabitList.size(); i1++) {
            int missedDays = 0;
            int OldDate = Integer.parseInt(General.HabitList.get(i1).get(4));
            if (OldDate < General.NewDate){
                missedDays = (General.NewDate - 1) - OldDate;
                General.HabitList.get(i1).set(2, Integer.toString(missedDays));
                General.HabitList.get(i1).set(4, Integer.toString(General.NewDate));
            } else if (OldDate > General.NewDate) {
                missedDays = (365 - OldDate) + (General.NewDate - 1);
                General.HabitList.get(i1).set(2, Integer.toString(missedDays));
                General.HabitList.get(i1).set(4, Integer.toString(General.NewDate));
            } else if (OldDate == General.NewDate) {
            }
            SaveAllInFiles();
        }
    }
=======
>>>>>>> parent of 5fa0440... Добавлен функционал
}

