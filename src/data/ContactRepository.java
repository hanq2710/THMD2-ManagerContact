package data;

import data.entitis.Contact;
import java.util.ArrayList;

public class ContactRepository {
    FileFactory fileFactory;
    ArrayList<Contact> arrayList;
    public ContactRepository(){
    fileFactory = new FileFactory();
    arrayList = fileFactory.readContact("Contact.csv");
    }
    public ArrayList<Contact> displayContact(){
        ArrayList<Contact> disArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            disArrayList.add(arrayList.get(i));
        }
        return arrayList;
    }
    public void addContact(Contact contact){
    arrayList.add(contact);
    fileFactory.writeContact("Contact.csv", arrayList);
        System.out.println("Thêm thành công ..!");
    }

    public Contact checkInfo(String info){
    return arrayList.stream().filter(
            o -> info.equals(o.getPhone())).findFirst().orElse(null);
    }
    public void updateContact(String phone, Contact contact){
        for (int i = 0; i < arrayList.size(); i++) {
            if(phone.equals(arrayList.get(i).getPhone())){
                arrayList.set(i,contact);
                fileFactory.writeContact("Contact.csv",arrayList);
                System.out.println("Câp nhật thành công");
            }
        }
    }
    public void deleteContact(String phone) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (phone.equals(arrayList.get(i).getPhone())) {
            arrayList.remove(i);
            fileFactory.writeContact("Contact.csv",arrayList);
                System.out.println("Xóa thành công..!");
            }
        }
    }
    public Contact[] searchEmployee(String info){
        return arrayList.stream().filter(
                o -> info.equals(o.getName()) || info.equals(o.getPhone())).toArray(Contact[]::new);
    }
}
