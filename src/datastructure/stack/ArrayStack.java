package datastructure.stack;

import datastructure.array.Array;

public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    /**
     * 获取栈中元素个数
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    /**
     * 获取栈的容量
     * @return
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 将元素压入栈
     * @param e
     */
    @Override
    public void push(E e){
        array.addLast(e);
    }

    /**
     * 元素出栈
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0;i < array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }

        res.append("] top");
        return res.toString();
    }
}
