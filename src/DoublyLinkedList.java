public class DoublyLinkedList {

    private Node head;
    private Node tail;

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




}
