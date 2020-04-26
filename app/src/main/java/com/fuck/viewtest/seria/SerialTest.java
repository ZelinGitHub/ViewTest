package com.fuck.viewtest.seria;

import com.fuck.viewtest.Bean.Wolf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialTest {
    public static void serial() {
        try {
            Wolf wolf = new Wolf();
            FileOutputStream fileOutputStream = new FileOutputStream("cache.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(wolf);
            outputStream.close();
        } catch (FileNotFoundException pE) {
            pE.printStackTrace();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    public static void deSerial() {
        try {
            FileInputStream fileInputStream = new FileInputStream("cache.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Wolf wolf = (Wolf) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException pE) {
            pE.printStackTrace();
        } catch (IOException pE) {
            pE.printStackTrace();
        } catch (ClassNotFoundException pE) {
            pE.printStackTrace();
        }
    }
}
