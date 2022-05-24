import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static DoublyLinkedList liste;
    public static void main(String[] args) {
	// write your code here

        liste = new DoublyLinkedList();
        importData();
    }

    public static void importData()
    {
        Scanner fileIN = null;
        try {
             fileIN = new Scanner(new FileInputStream("ogrenciler.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
            return;
        }

        while (fileIN.hasNextLine())
        {
            String word;
            word = fileIN.nextLine();

            String kisiBilgileri[] = word.split(",");

            int studentNumber = Integer.parseInt(kisiBilgileri[0]);
            String studentName = kisiBilgileri[1];
            ArrayList<String> numberList = new ArrayList<String>();

            for(int i=2;i<kisiBilgileri.length; i++)
            {
                String phoneNumber = kisiBilgileri[i];
                numberList.add(phoneNumber);
            }

            Student ogrenci = new Student(studentNumber,studentName,numberList);
            liste.insertToList(ogrenci);
            liste.print();
            System.out.println("");
        }
    }

    public static void importStudent()
    {
        System.out.println("Öğrenci Bil");
    }
}
