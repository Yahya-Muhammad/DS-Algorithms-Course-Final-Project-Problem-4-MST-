class LinkedList<T> {
    public Node<T> head;

    public void insertAtBeginning(LinkedList<T> list, T data) {
        Node<T> node = new Node<>(data);
        if (list == null)
            list = new LinkedList<>();
        node.next = list.head;
        list.head = node;
    }

    public void insertEnd(LinkedList<T> list, T data) {
        Node<T> node = new Node<>(data);
        Node<T> iteratorNode = list.head;
        if (iteratorNode == null) {
            insertAtBeginning(list, data);
            return;
        }
        Node<T> lastNode = getLastNode(list);
        if (lastNode != null)
            lastNode.next = node;
        else insertAtBeginning(list, data);
    }

    public void deleteFirst(LinkedList<T> list) {
        list.head = list.head.next;
    }

    public void delete(LinkedList<T> list, T data) {
        Node<T> iteratorNode = list.head;
        if (iteratorNode.data == data) {
            deleteFirst(list);
            return;
        }
        while (iteratorNode.next != null && iteratorNode.next.data != data)
            iteratorNode = iteratorNode.next;
        if (iteratorNode.next != null)
            iteratorNode.next = iteratorNode.next.next;
    }

    public LinkedList<T> mergeLists(LinkedList<T> firstList, LinkedList<T> secondList) {
        Node<T> lastNode = getLastNode((firstList));
        lastNode.next = secondList.head;
        return firstList;
    }

    public Node<T> getLastNode(LinkedList<T> list) {
        Node<T> iteratorNode = list.head;
        while (iteratorNode != null && iteratorNode.next != null)
            iteratorNode = iteratorNode.next;
        return iteratorNode;
    }

    public boolean notContains(LinkedList<T> list, T data) {
        Node<T> iteratorNode = list.head;
        while (iteratorNode != null) {
            if (iteratorNode.data == data)
                return false;
            iteratorNode = iteratorNode.next;
        }
        return true;
    }
}
