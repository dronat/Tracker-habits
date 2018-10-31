import java.io.*;
import java.util.*;

public class FileWorker {

    public static File HabitListFile = new File("C:/ProgramData/Tracker Habits", "HabitsList.txt");
    public static File CompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "CompleteDays.txt");
    public static File MissedDaysFile = new File("C:/ProgramData/Tracker Habits", "MissedDays.txt");
    public static File NumberOfDaysFile = new File("C:/ProgramData/Tracker Habits", "NumberOfDays.txt");
    public static File LastConfirmationFile = new File("C:/ProgramData/Tracker Habits", "LastConfirmation.txt");
    public static File ArchiveHabitListFile = new File("C:/ProgramData/Tracker Habits", "ArchiveHabitsList.txt");
    public static File ArchiveCompleteDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveCompleteDays.txt");
    public static File ArchiveMissedDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveMissedDays.txt");
    public static File ArchiveNumberOfDaysFile = new File("C:/ProgramData/Tracker Habits", "ArchiveNumberOfDays.txt");


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
        boolean HabitExist = HabitListFile.exists();
        boolean CompleteExist = CompleteDaysFile.exists();
        boolean MissedExist = MissedDaysFile.exists();
        boolean NumberOfDaysExist = NumberOfDaysFile.exists();
        boolean ArchiveHabitExist = ArchiveHabitListFile.exists();
        boolean ArchiveCompleteExist = ArchiveCompleteDaysFile.exists();
        boolean ArchiveMissedExist = ArchiveMissedDaysFile.exists();
        boolean ArchiveNumberOfDaysExist = ArchiveNumberOfDaysFile.exists();
        boolean LastConfirmationExist = LastConfirmationFile.exists();
        if (HabitExist && CompleteExist && MissedExist && NumberOfDaysExist && LastConfirmationExist && ArchiveHabitExist && ArchiveCompleteExist && ArchiveMissedExist && ArchiveNumberOfDaysExist) {
        } else {
            FileCreator();
        }
    }


    public static void FileCreator() { // Complete
        try {
            boolean HabitFileCreated = HabitListFile.createNewFile();
            boolean CompleteFileCreated = CompleteDaysFile.createNewFile();
            boolean MissedFileCreated = MissedDaysFile.createNewFile();
            boolean NumberOfDaysCreated = NumberOfDaysFile.createNewFile();
            boolean LastConfirmationCreated = LastConfirmationFile.createNewFile();
            boolean ArchiveHabitCreated = ArchiveHabitListFile.createNewFile();
            boolean ArchiveCompleteCreated = ArchiveCompleteDaysFile.createNewFile();
            boolean ArchiveMissedCreated = ArchiveMissedDaysFile.createNewFile();
            boolean ArchiveNumberOfDaysCreated = ArchiveNumberOfDaysFile.createNewFile();
            if(HabitFileCreated && CompleteFileCreated && MissedFileCreated && NumberOfDaysCreated && LastConfirmationCreated && ArchiveHabitCreated && ArchiveCompleteCreated && ArchiveMissedCreated && ArchiveNumberOfDaysCreated) {
            }
        } catch (IOException ex) {
            System.out.println("\nFile creation error");
        }
    }


    public static void ReadAllOfTheFiles() { // Complete
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(HabitListFile), "UTF8"));
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(CompleteDaysFile), "UTF8"));
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(MissedDaysFile), "UTF8"));
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(NumberOfDaysFile), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.HabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'NumberOfDays.txt'");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(LastConfirmationFile), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.HabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'LastConfirmation.txt'");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ArchiveHabitListFile), "UTF8"));
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ArchiveCompleteDaysFile), "UTF8"));
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ArchiveMissedDaysFile), "UTF8"));
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
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ArchiveNumberOfDaysFile), "UTF8"));
            String ReadText;
            int n1 = 0;
            while ((ReadText = bufferedReader.readLine()) != null) {
                General.ArchiveHabitList.get(n1).add(ReadText);
                n1++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FileReader ERROR 'ArchiveNumberOfDays.txt'");
        }
    }


    public static void SaveAllInFiles() { // Complete
        try {
            BufferedWriter bwHabitList = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HabitListFile), "UTF8"));
            BufferedWriter bwCompleteDays = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(CompleteDaysFile), "UTF8"));
            BufferedWriter bwMissedDays = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(MissedDaysFile), "UTF8"));
            BufferedWriter bwNumberOfDays = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NumberOfDaysFile), "UTF8"));
            BufferedWriter bwLastConfirmation = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LastConfirmationFile), "UTF8"));
            BufferedWriter bwArchiveHabitList = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveHabitListFile), "UTF8"));
            BufferedWriter bwArchiveCompleteDays = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveCompleteDaysFile), "UTF8"));
            BufferedWriter bwArchiveMissedDays = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveMissedDaysFile), "UTF8"));
            BufferedWriter bwArchiveNumberOfDays = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ArchiveNumberOfDaysFile), "UTF8"));
            int HabitWriteString = 0;
            while (HabitWriteString < General.HabitList.size()) {
                bwHabitList.write(General.HabitList.get(HabitWriteString).get(0));
                bwCompleteDays.write(General.HabitList.get(HabitWriteString).get(1));
                bwMissedDays.write(General.HabitList.get(HabitWriteString).get(2));
                bwNumberOfDays.write(General.HabitList.get(HabitWriteString).get(3));
                bwLastConfirmation.write(General.HabitList.get(HabitWriteString).get(4));
                bwHabitList.newLine();
                bwCompleteDays.newLine();
                bwMissedDays.newLine();
                bwNumberOfDays.newLine();
                bwLastConfirmation.newLine();
                bwHabitList.flush();
                bwCompleteDays.flush();
                bwMissedDays.flush();
                bwNumberOfDays.flush();
                bwLastConfirmation.flush();
                HabitWriteString++;
            }
            int ArchiveHabitWriteString = 0;
            while (ArchiveHabitWriteString < General.ArchiveHabitList.size()) {
                bwArchiveHabitList.write(General.ArchiveHabitList.get(ArchiveHabitWriteString).get(0));
                bwArchiveCompleteDays.write(General.ArchiveHabitList.get(ArchiveHabitWriteString).get(1));
                bwArchiveMissedDays.write(General.ArchiveHabitList.get(ArchiveHabitWriteString).get(2));
                bwArchiveNumberOfDays.write(General.ArchiveHabitList.get(HabitWriteString).get(3));
                bwArchiveHabitList.newLine();
                bwArchiveCompleteDays.newLine();
                bwArchiveMissedDays.newLine();
                bwArchiveNumberOfDays.newLine();
                bwArchiveHabitList.flush();
                bwArchiveCompleteDays.flush();
                bwArchiveMissedDays.flush();
                bwArchiveNumberOfDays.flush();
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
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(HabitListFile), "UTF8"));
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


    public static void IsArchiveHabitListFileEmpty() { // Complete
        try {
            FileWorker.DirectoryStartChecker();
            FileWorker.FileExistStartCheck();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ArchiveHabitListFile), "UTF8"));
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
        String scanResult1 = scan1.nextLine();
        General.HabitList.add(new ArrayList<>());
        General.HabitList.get(0).add(scanResult1);
        General.HabitList.get(0).add("0");
        General.HabitList.get(0).add("0");
        System.out.println("Через сколько дней ваша привычка будет считаться выполненной?");
        int select1 = General.SelectMenu(2147483640);
        String scanResult2 = Integer.toString(select1);
        General.HabitList.get(0).add(scanResult2);
        General.HabitList.get(0).add(Integer.toString(General.NewDate));
        SaveAllInFiles();
    }



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
}

