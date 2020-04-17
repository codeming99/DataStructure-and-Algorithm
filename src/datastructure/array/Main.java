package datastructure.array;

public class Main {
    public static void main(String[] args) {

        //泛型中不支持基本数据类型（可以写成包装类）
        Array<Integer> arr = new Array<>();

        for(int i = 0;i < 10;i++){
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(4,100);
        System.out.println(arr);


        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        arr.removeElement(6);
        arr.removeFirst();

        System.out.println(arr);


    }
}
