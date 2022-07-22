package org.apelsin.tutorial.collections;

import java.util.Objects;

public class ArrayCollection {
    private Object[] content;
    private int capacity = 10;
    private int size;

    public ArrayCollection(){
        content=new Object[capacity];
    }

    public ArrayCollection(int capacity){
        this.capacity = capacity;
        content=new Object[capacity];
    }

    public Object get(int i){
        Objects.checkIndex(i, capacity);
        return content[i];
    }

    public boolean isEmpty(){
        if(Objects.isNull(content)){
            return true;
        }
        return size == 0;
    }

    public void clear(){
        capacity = 10;
        size = 0;
        this.content = new Object[capacity];
    }

}
