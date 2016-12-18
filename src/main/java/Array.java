import java.util.stream.IntStream;

public class Array<T> implements IArray<T> {
    private Object [] vector;
    private int currentLength = 0;

    public Array(int n) {
        vector =  new Object[n];
    }

    public Array() {
        vector = new Object[DEFAULT_LENGTH];
    }
    public void addAll(T[] array) {
        for(T element : array) {
            add(element);
        }
    }
    @Override
    public void add(T element) {
        checkSize();
        vector[currentLength++] = element;
    }
    @Override
    public T getByIndex(int index){
        checkIndex(index);
        return (T) vector[index];
    }
    @Override
    public void addByIndex(T element, int index) {
        checkSize();
        checkIndexForSet(index);
        for(int i = currentLength + 1; i > index; i--) {
            vector[i] = vector[i -1];
        }
        vector[index] = element;
        currentLength++;
    }
    @Override
    public void removeByIndex(int index) {
        checkIndex(index);
        for(int i = index + 1; i < currentLength; i++) {
            vector[i - 1] = vector[i];
        }
        currentLength--;
    }
    @Override
    public int size() {
        return currentLength;
    }
    @Override
    public boolean isEmpty() {
        return currentLength == 0;
    }

    private void checkSize() {
        if(vector.length == 0) {
            vector = (T[]) new Object[1];
        }
        if(vector.length == currentLength) {
            T[] array = copy(vector, vector.length*2);
            vector = array;
        }
    }
    private void checkIndex(int index) {
        if(index < 0 || index > vector.length){
            throw new IllegalArgumentException("Incorrect index");
        }
    }
    private void checkIndexForSet(int index) {
        if(index < 0 || index > currentLength){
            throw new IllegalArgumentException("Incorrect index");
        }
    }
    private T[] copy(Object[] copyFrom, int length) {
        Object [] array = new Object[length];
        for (int i = 0; i < copyFrom.length; i++) {
            array[i] = vector[i];
        }
        return (T[])array;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, currentLength).forEach((i) -> stringBuilder.append(vector[i].toString() + " "));
        return stringBuilder.toString();
    }
}
