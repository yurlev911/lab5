import java.io.*;
import java.util.Scanner;

//В исходном файле содержится произвольное количество чисел типа int.
// В результирующий файл переписать только четные числа.
public class var1 {

    public static void main(String[] args) {
        try{
// Создание исходного файла numIsh.txt и запись в него чисел типа float

            File f1=new File("C:\\Var1z5\\numIsh.txt");
            f1.createNewFile();

            Scanner sc = new Scanner(System.in, "cp1251");

            DataOutputStream wr =
                    new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));

            System.out.println("Scolko veshestvenix chisel zapisat v fail?");
            int count = sc.nextInt();

            System.out.println("Vvedite chisla:");
            for (int i = 0; i < count; i++)
                wr.writeInt(sc.nextInt());

            wr.flush();
            wr.close();
// Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
            File f2=new File("C:\\Var1z5\\numChet.txt");
            f2.createNewFile();
            // поток для чтения из исходного файла numIsh.txt
            DataInputStream rd =
                    new DataInputStream(new FileInputStream(f1.getAbsolutePath()));

            // поток для записи в результирующий файл numRez.txt
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            try{
                while(true) {
                    int number = rd.readInt();

                    if (number% 2 == 0) {
                        wr.writeInt(number);
                    }


                    DataInputStream sx =
                            new DataInputStream(new FileInputStream(f2.getAbsolutePath()));
                    while(true) {
                        int chn = sx.readInt();
                        System.out.println("Chislo " + chn);

                    }
                }
            }catch(EOFException e){}
            wr.flush();
            wr.close();
            rd.close();
            System.out.println("net chetnix chisel");
        }catch(IOException e){
            System.out.println("End of file");
        }
    }}
