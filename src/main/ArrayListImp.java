package main;

import java.util.*;

public class ArrayListImp <T> implements List<T> {

    private int size;
    private int capability;
    private Object[] mainArr;

    public ArrayListImp(){
        size = 0;
        capability = 10;
        mainArr = new Object[capability];
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
        for (int i = 0; i < size; i++){
            if (mainArr[i].equals(o)){
                return true;
            }
        }
        return false;
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
    public boolean add(T o) {
        resize();
        mainArr[size] = o;
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)){
            return false;
        }
        int index = indexOf(o);
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if (index >= size){
            throw  new IndexOutOfBoundsException("size: "+size+" index: "+index);
        }
        return (T) mainArr[index];
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        T previous = get(index);
        mainArr[index] = element;
        return previous;
    }

    @Override
    public void add(int index, T element) {
        resize();
        if (index > size){
            throw  new IndexOutOfBoundsException("size: "+size+" index: "+index);
        }
        T current = element;
        T previous = get(index);
        for (int i = index + 1; i <= size; i++){
            mainArr[i - 1] = current;
            current = previous;
            previous = (T) mainArr[i];
        }
        mainArr[size] = previous;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size){
            throw  new IndexOutOfBoundsException("size: "+size+" index: "+index);
        }
        T element = (T) mainArr[index];
        size--;
        for (int i = index; i < size; i++){
            mainArr[i] = mainArr[i + 1];
        }
        return element;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++){
            if (mainArr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
        return null;
    }

    private void resize(){
        if (size == capability - 2){
            capability = capability*2;
            Object[] temp = new Object[capability];
            for (int i = 0; i < size; i++){
                temp[i] = mainArr[i];
            }
            mainArr = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++){
            stringBuilder.append(mainArr[i]+"; ");
        }
        return stringBuilder.toString();
    }
}
