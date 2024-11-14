package com.example.task02;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SavedList<E extends Serializable> extends AbstractList<E> {

    private final File file;
    private List<E> list;


    public SavedList(File file) {
        this.file = file;
        if (file.exists()) {
            try (ObjectInputStream fis = new ObjectInputStream(new FileInputStream(file))) {
                list = (ArrayList<E>) fis.readObject();
            }catch (Exception ignored){}
        }
        else {
            list = new ArrayList<>();
        }
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public E set(int index, E element) {
        E old = list.set(index, element);
        this.write();
        return old;

    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(int index, E element) {
        list.add(index, element);
        this.write();
    }

    @Override
    public E remove(int index) {
        E e = list.remove(index);
        this.write();
        return e;

    }

    private void write() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(list);
        }catch (Exception ignored){}
    }
}
