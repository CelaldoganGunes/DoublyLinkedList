import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        DoublyLinkedList liste = new DoublyLinkedList();

        liste.print();


        ArrayList<String> numaraListesi = new ArrayList<String>();
        numaraListesi.add("0123456789");
        Student ogrenci1 = new Student(1,"birNolu",numaraListesi);
        numaraListesi.add("123456789");
        Student ogrenci2 = new Student(2,"ikiNolu",numaraListesi);
        Student ogrenci3 = new Student(3,"üçNolu",numaraListesi);
        Student ogrenci4 = new Student(4,"birNolu",numaraListesi);
        Student ogrenci5 = new Student(5,"beşNolu",numaraListesi);

        System.out.println(" ");
        System.out.println("birinci ekleniyor.");
        liste.insertToList(ogrenci1);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("ikinci ekleniyor.");
        liste.insertToList(ogrenci2);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("beşinci ekleniyor.");
        liste.insertToList(ogrenci5);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("dört ekleniyor.");
        liste.insertToList(ogrenci4);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("üçüncü ekleniyor.");
        liste.insertToList(ogrenci3);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("Öğrenci aranıyor");
        liste.searchByName("beşNolu");

        System.out.println(" ");
        System.out.println("Öğrenci 4 siliniyor");
        liste.deleteByNumber(4);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("Öğrenci 5 siliniyor");
        liste.deleteByNumber(5);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("Öğrenci 1 siliniyor");
        liste.deleteByNumber(1);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("altinci ekleniyor.");
        Student ogrenci6 = new Student(6,"altiNolu",numaraListesi);
        liste.insertToList(ogrenci6);
        liste.print();
        liste.printReverse();

        System.out.println(" ");
        System.out.println("birinci ekleniyor.");
        liste.insertToList(ogrenci1);
        liste.print();
        liste.printReverse();

    }
}
