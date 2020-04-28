package datastructure.set;

public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        //虚拟头结点
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 在链表的index位置添加新的元素
     * 在链表中不是一个常用操作，练习用
     * @param e
     * @param index
     */
    public void add(int index,E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }

            Node prev = dummyHead;
            for(int i = 0;i < index;i++) {
                prev = prev.next;
            }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e,prev.next);
            size++;

    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 往链表末尾添加新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得链表的第index个位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Illegal index");
        }

        Node cur = dummyHead.next;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }

        return cur.e;

    }

    /**
     * 获取链表第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 将链表第index位的元素赋予新值
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed.Illegal index");
        }

        Node cur = dummyHead.next;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 判断链表中是否含有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    /**
     * 删除链表第index位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Delete failed.Illegal index");
        }

        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;

    }

    /**
     * 删除链表第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){

        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL");

        return res.toString();
    }


}
