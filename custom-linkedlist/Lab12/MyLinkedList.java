public class MyLinkedList<E> implements GenericList<E>
{
    private Node<E> head;
    
    public MyLinkedList()
    {
        head = new Node<E>(null);
    }
    
    public int size()
    {
        int count = 0;
        Node<E> n = head.getNext();
        while(n != null)
        {
            count++;
            n = n.getNext();
        }
        return count;
    }
    
    private int indexOf(E obj)
    {
        int spot = 0;
        Node<E> n = head.getNext();
        while(n != null && !n.getValue().equals(obj))
        {
            spot++;
            n = n.getNext();
        }
        if (n == null)
        {
            return -1;
        }
        return spot;
        
    }
    
    private Node<E> getNode(int index)
    {
        Node<E> n = head.getNext();
        int i = 0;
        while(n != null && i < index)
        {
            i++;
            n = n.getNext();
        }
        return n;
    }
    class Node<E>
    {
        E value;
        Node<E> next;
        
        Node(E value)
        {
            this.value = value;
        }
        public E getValue()
        {
            return value;
        }
        public E setValule(E data)
        {
            E ret = value;
            value = data;
            return ret;
        }
        public Node<E> getNext()
        {
            return next;
        }
        public Node<E> setNext(Node<E> node)
        {
            Node<E> ret = next;
            next = node;
            return ret;
        }
    }
}

