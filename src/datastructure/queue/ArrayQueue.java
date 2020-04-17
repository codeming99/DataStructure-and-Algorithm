package datastructure.queue;

import datastructure.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }


    /**
     * 获取队列中元素个数
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }


    /**
     * 获取队列容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 元素入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 元素出队
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0;i < array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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
