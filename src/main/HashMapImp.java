package main;

import sun.awt.image.ImageWatched;

import java.util.*;

public class HashMapImp <T, E> implements Map<T, E> {

    private class Element{
        public Element(T key, E object){
            this.key = key;
            this.object = object;
        }

        T key;
        E object;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return Objects.equals(key, element.key) &&
                    Objects.equals(object, element.object);
        }

        @Override
        public String toString() {
            return "Element{" +
                    "key=" + key +
                    ", object=" + object +
                    '}';
        }
    }

    private LinkedListImp<Element> hashTable[];
    private int size;
    private int capacity;

    public HashMapImp(){
        capacity = 100;
        hashTable = new LinkedListImp[capacity];
        for (int i = 0; i < capacity; i++){
            hashTable[i] = new LinkedListImp<>();
        }
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
    public boolean containsKey(Object key) {
        int hash = key.hashCode();
        int index = hash%capacity;
        LinkedListImp<Element> currentChain = hashTable[index];
        for (int i = 0; i < currentChain.size(); i++){
            Element element = currentChain.get(i);
            if (element.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++){
            LinkedListImp<Element> currentChain = hashTable[i];
            for (int j = 0; j < currentChain.size(); j++){
                Element element = currentChain.get(j);
                if (element.object.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(Object key) {
        int hash = key.hashCode();
        int index = hash%capacity;
        LinkedListImp<Element> currentChain = hashTable[index];
        for (int i = 0; i < currentChain.size(); i++){
            Element element = currentChain.get(i);
            if (element.key.equals(key)){
                return element.object;
            }
        }
        return null;
    }

    @Override
    public E put(T key, E value) {
        int hash = key.hashCode();
        int index = hash%capacity;
        LinkedListImp<Element> currentChain = hashTable[index];
        if (containsKey(key)){
            remove(key);
        }
        size++;
        Element element = new Element(key, value);
        currentChain.add(element);
        return value;
    }

    @Override
    public E remove(Object key) {
        if (!containsKey(key)) {
            return null;
        }
        int hash = key.hashCode();
        int index = hash%capacity;
        LinkedListImp<Element> currentChain = hashTable[index];
        E value = get(key);
        T keyType = (T) key;
        Element element = new Element(keyType, value);
        currentChain.remove(element);
        size--;
        return value;
    }

    @Override
    public void putAll(Map<? extends T, ? extends E> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<T> keySet() {
        return null;
    }

    @Override
    public Collection<E> values() {
        return null;
    }

    @Override
    public Set<Entry<T, E>> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < capacity; i++){
            LinkedListImp<Element> currentChain = hashTable[i];
            if (!currentChain.isEmpty()){
                stringBuilder.append(currentChain);
                stringBuilder.append(";");
            }
        }
        return stringBuilder.toString();
    }
}
