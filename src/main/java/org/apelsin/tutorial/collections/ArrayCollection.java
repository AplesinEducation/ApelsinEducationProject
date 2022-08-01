package org.apelsin.tutorial.collections;

import javax.management.InstanceNotFoundException;
import java.util.Collection;
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

    public Object remove(int index) throws InstanceNotFoundException {
        if (index < 0 || index >= content.length)
            throw new InstanceNotFoundException();
        Object oldValue = content[index];
        Object[] temp = new Object[content.length - 1];

        for (int i = 0, j = 0; i < content.length; i++) {
            if (i != index)
                temp[j++] = content[i];
        }

        content = temp;
        return oldValue;
    }

    public Object remove(Object value){
        boolean found = false;
        int indexOfValue = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i].equals(value)){
                found = true;
                indexOfValue = i;
                break;
            }
        }
        if (found){
            Object[] temp = new Object[content.length - 1];
            for (int i = 0, j = 0; i < content.length; i++) {
                if (i != indexOfValue)
                    temp[j++] = content[i];
            }
            content = temp;
        }
        return found;
    }
}
