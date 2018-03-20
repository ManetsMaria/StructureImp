package main;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListImp <T> implements List<T> {

    private class Node{
        T object;
        Node next;
        Node previous;

        public Node(T obj){
            object = obj;
            previous = null;
            next = null;
        }
    }

    private int size;
    private Node head;
    private Node finish;

    public LinkedListImp(){
        size = 0;
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
        Node start = head;
        while (start != null && !start.object.equals(o)){
            start = start.next;
        }
        return start != null;
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
        if (head == null){
            head = new Node(t);
            finish = head;
        }
        else{
            Node curr = new Node(t);
            finish.next = curr;
            finish = finish.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node runner = head;
        int counter = 0;
        while (runner != null && !runner.object.equals(o)){
            runner = runner.next;
        }
        if (runner == null){
            return false;
        }
        Node previous = runner.previous;
        Node feature = runner.next;
        if (previous != null) {
            previous.next = feature;
            feature.previous = previous;
        }else{
            head = feature;
        }
        size--;
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
        Node runner = head;
        int counter = 0;
        while (counter < index){
            runner = runner.next;
            counter++;
        }
        return runner.object;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size){
            throw  new IndexOutOfBoundsException("size: "+size+" index: "+index);
        }
        Node start = head;
        int counter = 0;
        while (counter < index){
            counter++;
            start = start.next;
        }
        start.object = element;
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index > size){
            return;
        }
        Node curr = new Node(element);
        if (index == size){
            finish.next = curr;
            finish = finish.next;
        }
        Node runner = head;
        int counter = 0;
        while (counter < index - 1){
            runner = runner.next;
        }
        Node previous = runner;
        Node feature = previous.next;
        previous.next = curr;
        curr.previous = previous;
        curr.next = feature;
        feature.previous = curr;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size){
            return null;
        }
        Node runner = head;
        int counter = 0;
        while(counter < index){
            runner = runner.next;
        }
        Node forDeleting = runner;
        Node previous = forDeleting.previous;
        Node feature = forDeleting.next;
        previous.next = feature;
        feature.previous = previous;
        size--;
        return forDeleting.object;
    }

    @Override
    public String toString(){
        Node start = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(start != null){
            stringBuilder.append(start.object);
            stringBuilder.append(" ");
            start = start.next;
        }
        return stringBuilder.toString();
    }

    @Override
    public int indexOf(Object o) {
        Node start = head;
        int counter = 0;
        while (start != null && !start.object.equals(o)){
            start = start.next;
            counter++;
        }
        if (start == null){
            return -1;
        }
        return counter;
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
}
