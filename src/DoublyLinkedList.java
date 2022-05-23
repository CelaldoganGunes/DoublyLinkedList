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

        return;
    }

}
