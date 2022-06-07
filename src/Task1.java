import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) throws IOException {

        File data = new File("./src/data.txt");
        FileWriter fw = new FileWriter(data);
        char ch;

        System.out.println("Введите символ: ");
        ch = (char) System.in.read();
        fw.write(ch);
        if(ch == 'q'){
            System.out.println("Конец!");
        }else {
            while (ch != 'q') {
                ch = (char) System.in.read();
                fw.write(ch);
            }
        }
        System.out.println("Выход!");
        fw.close();
    }
}
