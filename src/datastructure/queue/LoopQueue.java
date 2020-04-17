package datastructure.queue;


/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 获取循环队列容量
     * @return
     */
    public int getCapacity(){
        //有一个空间是浪费的
        return data.length - 1;
    }

    /**
     * 判断循环队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    /**
     * 获取循环队列元素个数
     * @return
     */
    @Override
    public int getSize(){
        return size;
    }

    /**
     * 循环队列入队操作
     * @param e
     */
    @Override
    public void enqueue(E e){

        //如果队列为空，则扩容
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 循环队列出队操作
     * @return
     */
    @Override
    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        E ret = data[front];
        //别忘记队首置为空
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //元素个数占队列的1/4，则缩减队列容量
        if(size == getCapacity() /  4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    /**
     * 获取循环队列队首元素
     * @return
     */
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");

        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0;i < size;i++){
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for(int i = front;i != tail;i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(", ");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
