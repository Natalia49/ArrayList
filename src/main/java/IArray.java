public interface IArray<T> {
    int DEFAULT_LENGTH = 10;

    void add(T element);
    void addAll(T[] array);
    void addByIndex(T element, int index);
    T getByIndex(int index);
    void removeByIndex(int index);
    int size();
    boolean isEmpty();
}
