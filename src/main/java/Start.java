
public class Start {
    public static void main(String[] args) {
        Integer [] mass = {5, 8, 3, 9, 0, 7};
        Array<Integer> array = new Array<>(0);
        array.addAll(mass);
        System.out.println(array.toString());
        System.out.println(array.getByIndex(2));
        array.addByIndex(10, 0);
        System.out.println(array.toString());
        System.out.println(array.getByIndex(3));
        System.out.println(array.isEmpty());



    }
}
