package io;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite<E> {
    public void write(File file, ArrayList<E> list) {
        try {
            FileOutputStream ketnoi = new FileOutputStream(file);
            ObjectOutputStream but = new ObjectOutputStream(ketnoi);
            but.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  ArrayList<E> read(File file) {
        try {
            FileInputStream ketnoi = new FileInputStream(file);
            ObjectInputStream but = new ObjectInputStream(ketnoi);
            return (ArrayList<E>) but.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
