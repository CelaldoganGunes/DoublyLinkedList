import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static DoublyLinkedList liste;
    public static void main(String[] args) {
	// write your code here

        liste = new DoublyLinkedList();

        arayuz(); //Algoritma 1 dersinden alışkanlık oldğu için ayrıca metod olarak oluşturduk.
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
            createStudentNode(word);
        }
        
        fileIN.close();
    }

    public static void importStudent()
    {
        System.out.println("Öğrenci numarası, Öğrenci adı soyadı, Telefon numarası 1, Telefon numarası 2, ...");
        System.out.println("Eklemek istediğiniz öğrenci bilgilerini yukarıdaki şekildeki gibi giriniz:");

        Scanner keyboard = new Scanner(System.in);
        String studentInformation = keyboard.nextLine();
        createStudentNode(studentInformation);
    }

    public static void createStudentNode(String studentInformation)
    {
        String[] kisiBilgileri = studentInformation.split(",");

        /*
        
        Virgül olan yerlerden girilen metni bölüyoruz.
        Bu sayede
        ilk sırada okul numarası
        ikinci sırada kişinin adı ve soyadı
        geri kalan kısımlarda ise telefon numaraları oluyor.
        
        */
        int studentNumber = Integer.parseInt(kisiBilgileri[0]);

        //Aynı numaraya ait biri var ise o öğrenciyi listeye eklemeden işlemi durdurma kısmı

        DoublyLinkedList.Node simdikiNode = liste.getHead();
        while (simdikiNode != null)
        {
            if (simdikiNode.getData().getOgrenciNumarasi() == studentNumber)
            {
                System.out.println("Öğrenci listeye eklenirken aynı numaraya sahip öğrenci bulundu.");
                System.out.println("Öğrenci atlandı.");
                return;
            }
            simdikiNode = simdikiNode.getNextNode();
        }

        //Üstte sıkıntı yoksa öğrenciyi listeye ekleyen kısım
        String studentName = kisiBilgileri[1];
        ArrayList<String> numberList = new ArrayList<String>();

        /*
        
        Dizide 2. indeksten itibaren telefon numaraları oluyor.
        Bunları arrayliste ekliyoruz.
        
        */
        for(int i=2;i<kisiBilgileri.length; i++)
        {
            String phoneNumber = kisiBilgileri[i];
            numberList.add(phoneNumber);
        }

        Student ogrenci = new Student(studentNumber,studentName,numberList);
        liste.insertToList(ogrenci);
    }

    public static void studentSearch()
    {
        System.out.println("Bilgilerini bulmak istediğiniz öğrencinin adı soyadını giriniz:");

        Scanner keyboard = new Scanner(System.in);
        String studentInformation = keyboard.nextLine();
        liste.searchByName(studentInformation);
    }

    public static void studentDelete()
    {
        System.out.println("Bilgilerini silmek istediğiniz öğrencinin okul numarasını giriniz:");

        Scanner keyboard = new Scanner(System.in);
        try
        {
            int studentNumber = keyboard.nextInt();
            liste.deleteByNumber(studentNumber);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Hatalı giriş.");
        }

    }

    public static void arayuz()
    {
        boolean cikisYap = false;
        while(cikisYap == false)
        {

            System.out.println("");
            System.out.println("---------------------------------------------------");
            System.out.println("Öğrenci Bilgileri Programı");
            System.out.println("");
            System.out.println("1- ogrenciler.txt dosyasından öğrenci bilgilerini programa aktar.");
            System.out.println("2- Listeye öğrenci ekle.");
            System.out.println("3- Adı soyadı girilen öğrenci/öğrencileri bul.");
            System.out.println("4- Numarası girilen öğrenciyi listeden sil.");
            System.out.println("5- Küçük öğrenci numarsından büyüğe sırala");
            System.out.println("6- Büyük öğrenci numarasından küçüğe sırala.");
            System.out.println("7- Programı kapat.");
            System.out.println("Ne yapmak istiyorsanız numarasını girin:");
            System.out.println("---------------------------------------------------");

            Scanner keyboard = new Scanner(System.in);
            String process = keyboard.nextLine();

            if (process.equals("1"))
            {
                importData();
            }
            else if (process.equals("2"))
            {
                importStudent();
            }
            else if (process.equals("3"))
            {
                studentSearch();
            }
            else if (process.equals("4"))
            {
                studentDelete();
            }
            else if (process.equals("5"))
            {
                liste.print();
            }
            else if (process.equals("6"))
            {
                liste.printReverse();
            }
            else if (process.equals("7"))
            {
                //Döngüden çıkartıyoruz. Bu sayede program kapanıyor.
                //cikisYap = true;
                System.exit(0);
            }
            else
            {
                //Hatalı giriş
                System.out.println("Hatalı giriş yaptınız.");
            }
        }

    }


}
