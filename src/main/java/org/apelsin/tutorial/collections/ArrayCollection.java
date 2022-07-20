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

    public Object get(int i){
        Objects.checkIndex(i, capacity);
        return content[i];
    }

    public boolean isEmpty(){
        int length = 0;
        if(Objects.isNull(content)){
            return true;
        }
        for(int i=0; i < capacity; i++){
            if(content[i] == null){
                length++;
            }
        }
        return length == content.length;
    }

    public void clear(){
        this.content = null;
        capacity = 0;
    }

}
