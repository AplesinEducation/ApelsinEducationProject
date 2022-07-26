package org.apelsin.tutorial.collections;

import java.util.Objects;

public class ArrayCollection {
    private Object[] content;
    private int capacity = 10;

    public ArrayCollection(){
        content=new Object[capacity];
    }

    public ArrayCollection(int capacity){
        this.capacity = capacity;
        content=new Object[capacity];
    }

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
