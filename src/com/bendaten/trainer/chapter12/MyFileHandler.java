package com.bendaten.trainer.chapter12;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class MyFileHandler {

    public static void writeTextToFile(String text, String filePath) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeUTF(text);
        }
    }

    public static void appendTextToFile(String text, String filePath) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath, true))) {
            dos.writeUTF(text);
        }
    }

    public static void serialize(Object obj, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
        }
    }

    public static Object deserialize(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            return ois.readObject();
        }
    }

    public static void serializeToXML(Object obj, String filePath) throws FileNotFoundException {
        try (XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)))) {
            xe.writeObject(obj);
        }
    }

    public static Object deserializeFromXML(String filePath) throws FileNotFoundException {
        try (XMLDecoder xd = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)))) {
            return xd.readObject();
        }
    }

    public static String readTextFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                sb.append(dis.readUTF());
            }
        } catch (EOFException e) {
            return sb.toString();
        }
    }
}
