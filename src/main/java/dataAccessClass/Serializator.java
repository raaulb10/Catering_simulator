package dataAccessClass;

import java.io.*;

public class Serializator<T> {

    public void writeFile(T obj, String fileName) {
        FileOutputStream fileOut = null;
        try {

            fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T readFile(String fileName) {
        FileInputStream file;
        ObjectInputStream in;
        T temp = null;
        try {
            File file2 = new File(fileName);
            if (file2.exists()) {
                file = new FileInputStream(file2);
                in = new ObjectInputStream(file);
                temp = (T) in.readObject();
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + fileName + " doesn't exist -----");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
