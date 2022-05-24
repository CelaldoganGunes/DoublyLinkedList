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
            return;
        }
        //En sona ekleme
        if(tail.getData().getOgrenciNumarasi() < student.getOgrenciNumarasi()){
            Node newNode = new Node(tail,null,student);
            tail.setNextNode(newNode);
            tail = newNode;
            return;
        }

        //En başa ekleme

        if(head.getData().getOgrenciNumarasi() > student.getOgrenciNumarasi()){
            Node newNode = new Node(null,head,student);
            head.setPreviousNode(newNode);
            head = newNode;
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

        return;
    }

    public void print()
    {
        if(this.getHead() == null)
        {
            System.out.println("Liste boş");
            return;
        }

        System.out.println(" ");
        System.out.println("Düzgün Sayım");

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
            System.out.println("Liste boş");
            return;
        }

        System.out.println(" ");
        System.out.println("Tersine Sayım");

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
        System.out.println(ogrenciListesi);
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
                    head.setPreviousNode(null);
                }

                if(sonraki != null)
                {
                    sonraki.setPreviousNode(onceki);
                }
                else
                {
                    //Tail'in silinmesi
                    tail = simdikiNode.getPreviousNode();
                    tail.setNextNode(null);
                }

                simdikiNode = null;

                return;
            }
            simdikiNode = simdikiNode.getNextNode();
        }
    }
}