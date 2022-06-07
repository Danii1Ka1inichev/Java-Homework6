import javax.swing.*;
import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException {

        saveData("Дмитрий", "Баженов", "26", "84951520202");
        saveData("Алексей", "Крючко", "50", "84956581201");
        saveData("Никита", "Цветов", "30", "84951478509");
        saveData("Алина", "Власова", "20", "84956985201");
        saveData("Екатерина", "Сокол", "80", "84956985201");
        readData("./src/person.CSV");

    }


    //метод для записи данных в CSV файл
    public static void saveData(String name, String lastname, String age, String tel){

        try {
            FileWriter fw = new FileWriter("./src/person.CSV", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(name+","+lastname+","+age+","+tel);
            pw.flush();
            pw.close();

        }catch (Exception e){

        }


    }

    //метод для чтения и вывода в массив из CSV файла
    public static void readData(String name) throws IOException {

        String line = "";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(name));
            while ((line = reader.readLine()) != null){
                String[] row = line.split(",");
                for(String index: row){
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("File Not Found!");
        }finally {
            reader.close();
        }
    }
}
