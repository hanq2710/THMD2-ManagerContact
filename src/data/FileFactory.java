package data;


import java.io.*;
import java.util.ArrayList;


public class FileFactory<E>  {
    // Đọc File
    public ArrayList<E> readContact(String path) {
        File file = new File(path);
        ArrayList<E> arrayList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            if(!file.exists()) file.createNewFile();
            if(file.length()>0){
                fileInputStream = new  FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                arrayList = (ArrayList<E>) objectInputStream.readObject();
            }
            else{
                arrayList = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (objectInputStream!=null){
                try {
                    objectInputStream.close();
                    fileInputStream.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return arrayList;
    }
    // Ghi File
    public void writeContact(String path, ArrayList<E> arrayList){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
