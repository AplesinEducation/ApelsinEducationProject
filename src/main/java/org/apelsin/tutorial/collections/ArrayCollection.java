package org.apelsin.tutorial.collections;

import java.util.Arrays;


import java.util.Objects;

public class ArrayCollection {
    private Object[] content;
    private int capacity = 10;

    public ArrayCollection(){
        content = new Object[capacity];
    }

    public ArrayCollection(int capacity){
        this.capacity = capacity;
        content = new Object[capacity];
    }

    public boolean add(Object obj) {
        Integer firstNullIndex = getFirstNullIndex();
        content[firstNullIndex] = obj;
        return true;
    }

    private int expandArray() {
        Object[] oldContent = Arrays.copyOf(content, content.length);
        content = new Object[content.length + content.length / 2 + 1];
        System.arraycopy(oldContent, 0, content, 0, oldContent.length);
        return oldContent.length;
    }

    public Integer getFirstNullIndex() {
        for (int i = 0; i < content.length; i++) {
            if (Objects.isNull(content[i])) return i;
        }
        return expandArray();

    public boolean contains(Object value) {
        for (int i = 0; i < capacity; i++) {
            if(value.hashCode() == content[i].hashCode() && Objects.equals(content[i], value) ) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Object[] values) {
        for (Object value : values) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    public void pushBack(Object item) {
        doubleContentLengthIfCapacityIsReached();
        content[capacity++] = item;
    }

    public void doubleContentLengthIfCapacityIsReached() {
        if (content.length == capacity) {
            Object[] newContent = new Object[capacity * 2];
            System.arraycopy(content, 0, newContent, 0, capacity);
            content = newContent;
        }
    }

}
