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
    }

}
