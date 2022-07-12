package homeWork1;

import java.lang.reflect.Array;
import java.util.*;

public class MyList<T extends Number> implements List<T> {
    private T array[];
    private int size = 0;

    public MyList(Class<T> tClass) {
        this.array = (T[]) Array.newInstance(tClass, 10);
    }


    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int x = 0;
        for (T t : array) {
            if (t == null) {
                continue;
            } else if (t.equals(o)) {
                x++;
            }
        }
        return x >= 2;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        if (size == 0) {
            array[size] = t;
            size++;
            return true;
        }

        T newArr[] = Arrays.copyOf(array, array.length);
        array[0] = t;
        for (int i = 1; i < array.length; i++) {
            array[i] = newArr[i - 1];
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;

        for (int i=0; i < array.length; i++) {
            if (array[i]==null){
                continue;
            }
            if (array[i].equals(o)) {
                result = true;
                if (i == size) {
                    array[i] = null;
                } else {
                    T[] firstPart = Arrays.copyOfRange(array, 0, i);
                    T[] secondPart = Arrays.copyOfRange(array, i+1, array.length);
                    for (int j = 0; j < firstPart.length; j++) {
                        array[j] = firstPart[j];
                    }
                    for (int j = 0; j < secondPart.length; j++) {
                        array[j + firstPart.length] = secondPart[j];
                    }
                    i--;
                }
                size--;
            }
        }

        return result;

    }

    @Override
    public boolean containsAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            SequentialAdd(t);
        }
        return true;

    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T t : c) {
            add(index,t);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            for (int i = 0; i < array.length; i++) {
                if (o.equals(array[i])) {
                    T[] firstPart = Arrays.copyOfRange(array, 0, i);
                    T[] secondPart = Arrays.copyOfRange(array, i+1, array.length);
                    for (int j = 0; j < firstPart.length; j++) {
                        array[j] = firstPart[j];
                    }
                    for (int j = 0; j < secondPart.length; j++) {
                        array[j + firstPart.length] = secondPart[j];
                    }
                    size--;
                }
            }
        }
        return true;

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Number newArr[]={};
        for (int i = 0; i < array.length; i++) {
            for (Object o : c) {
                if (o==null||array[i]==null){
                    continue;
                }
                if (array[i].equals(o)){
                    newArr=Arrays.copyOf(newArr,newArr.length+1);
                    newArr[newArr.length-1]=array[i];
                }

            }
        }
        array= (T[]) newArr;
        return true;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;

    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        array[index] = element;
        return array[index];
    }

    @Override
    public void add(int index, T element) {
        if (size >= array.length - 1) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        if (index == 0) {
            add(element);
            return;
        }
        T[] FirstPart = Arrays.copyOfRange(array, 0, index);
        T[] SecondPart = Arrays.copyOfRange(array, index, size +1);
        for (int i = 0; i < FirstPart.length; i++) {
            array[i] = FirstPart[i];
        }
        array[index] = element;
        size++;
        for (int i = 0; i < SecondPart.length; i++) {
            array[i + FirstPart.length + 1] = SecondPart[i];
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                res = i;
            }
        }
        if (res == 0) {
            return -1;
        }
        return res;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        T newarr[] = Arrays.copyOfRange(array, fromIndex, toIndex);
        return List.of(newarr);

    }

    @Override
    public String toString() {
        String result = "";
        for (T t : array) {
            if (t != null) {
                result += t + " ";
            }
        }

        return "MyList{" +
                "array=" + result +
                '}';
    }

    public double getDouble(int index) {
        return (double) array[index];
    }

    public int sumIntegers() {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            res += (int) array[i];
        }
        return res;
    }
    private boolean SequentialAdd(T t) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, ((int) (array.length * 1.5)));
        }

        array[size] = t;
        size++;
        return true;
    }
}
