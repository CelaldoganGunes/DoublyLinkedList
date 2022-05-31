import java.util.ArrayList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    
    /*
    
    Node sınıfı, listenin bir parçası olduğundan ve 
    başka sınıfta kullanılmayacağından 
    iç sınıf olarak yazmayı tercih ettik.
    
    */
    public class Node
    {
        private Node previousNode;
        private Node nextNode;
        private Student data;

        public Node()
        {
            this.setPreviousNode(null);
            this.setNextNode(null);
            this.setData(null);
        }

        public Node(Node previousNode, Node nextNode, Student data)
        {
            this.setPreviousNode(previousNode);
            this.setNextNode(nextNode);
            this.setData(data);
        }

        //region Get Set Metodları
        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Student getData() {
            return data;
        }

        public void setData(Student data) {
            this.data = data;
        }
        //endregion


        @Override
        public String toString() {
            return data.toString();
        }
    }

    
    /*
    
    Node sınıfı biraz arada kaldı ve gözükmesi zor.
    Bu yüzden bu açıklama blokları eklendi.
    
    */
    public DoublyLinkedList()
    {
        this.setHead(null);
        this.setTail(null);
    }

    public void insertToList(Student student)
    {

        //Liste boş ise ekleme kısmı
        if (this.getHead() == null) {
            Node newNode = new Node(null,null,student);
            this.setHead(newNode);
            this.setTail(newNode);
            System.out.println("Öğrenci başarıyla eklendi.");
            return;
        }
        //En sona ekleme
        if(tail.getData().getOgrenciNumarasi() < student.getOgrenciNumarasi()){
            Node newNode = new Node(tail,null,student);
            tail.setNextNode(newNode);
            tail = newNode;
            System.out.println("Öğrenci başarıyla eklendi.");
            return;
        }

        //En başa ekleme

        if(head.getData().getOgrenciNumarasi() > student.getOgrenciNumarasi()){
            Node newNode = new Node(null,head,student);
            head.setPreviousNode(newNode);
            head = newNode;
            System.out.println("Öğrenci başarıyla eklendi.");
            return;
        }

        //Araya ekleme

        Node siradakiNode = head;
        Node oncekiNode = null;

        while (student.getOgrenciNumarasi() > siradakiNode.getData().getOgrenciNumarasi())
        {
            if (siradakiNode.nextNode != null)
            {
                oncekiNode = siradakiNode;
                siradakiNode = siradakiNode.getNextNode();
            }
        }

        Node newNode = new Node(oncekiNode,siradakiNode,student);
        oncekiNode.setNextNode(newNode);
        siradakiNode.setPreviousNode(newNode);
        System.out.println("Öğrenci başarıyla eklendi.");

        return;
    }

    public void print()
    {
        if(this.getHead() == null)
        {
            System.out.println("Öğrenci listesi boş.");
            return;
        }

        System.out.println(" ");
        System.out.println("Öğrenci Listesi (Numaralar Küçükten Büyüğe)");

        Node siradakiNode = head;

        while (siradakiNode != null)
        {
            System.out.println(siradakiNode);
            siradakiNode = siradakiNode.getNextNode();
        }

    }

    public void printReverse()
    {
        if(this.getTail() == null)
        {
            System.out.println("Öğrenci listesi boş.");
            return;
        }

        System.out.println(" ");
        System.out.println("Öğrenci Listesi (Numaralar Büyükten Küçüğe)");

        Node siradakiNode = tail;

        while (siradakiNode != null)
        {
            System.out.println(siradakiNode);
            siradakiNode = siradakiNode.getPreviousNode();
        }

    }


    public void searchByName(String oAdSoyad)
    {
        Node siradakiNode = head;
        ArrayList<Student> ogrenciListesi = new ArrayList<Student>();
        while (siradakiNode != null)
        {
            if (siradakiNode.getData().getAdSoyad().equals(oAdSoyad))
            {
                ogrenciListesi.add(siradakiNode.getData());
            }
            siradakiNode = siradakiNode.getNextNode();
        }

        if(ogrenciListesi.isEmpty())
        {
            System.out.println("Öğrenci bulunamadı.");
            return;
        }

        System.out.println("");
        System.out.println("Bulunan Öğrenciler: ");
        for(Student student: ogrenciListesi){
            System.out.println(student.toString());
        }
    }

    public void deleteByNumber(int oOgrenciNo)
    {

        Node simdikiNode = head;
        Node onceki = null;
        Node sonraki = null;

        while (simdikiNode != null)
        {
            if (simdikiNode.getData().getOgrenciNumarasi() == oOgrenciNo)
            {
                onceki = simdikiNode.getPreviousNode();
                sonraki = simdikiNode.getNextNode();

                
                if (onceki != null)
                {
                    onceki.setNextNode(sonraki);
                }
                else
                {
                    //Head'in silinmesi
                    head = simdikiNode.getNextNode();
                    
                    /*
                    
                    Listede kalan son objeyi sildiysek head null oluyor. 
                    Bunun dışında head silinirse yeni head'in previous referansı null yapılıyor.
                    
                    */
                    if (head != null) 
                    {
                        head.setPreviousNode(null);
                    }
                }

                if(sonraki != null)
                {
                    sonraki.setPreviousNode(onceki);
                }
                else
                {
                    //Tail'in silinmesi
                    tail = simdikiNode.getPreviousNode();
                                        
                    /*
                    
                    Listede kalan son objeyi sildiysek tail null oluyor. 
                    Bunun dışında head silinirse yeni tail'in next referansı null yapılıyor.
                    
                    */
                    if (tail != null) 
                    {
                        tail.setNextNode(null);
                    }
                    
                }

                simdikiNode = null;

                System.out.println("");
                System.out.println("Öğrenci başarıyla silindi.");
                return;
            }
            simdikiNode = simdikiNode.getNextNode();
        }

        System.out.println("Öğrenci bulunamadı.");
    }
}