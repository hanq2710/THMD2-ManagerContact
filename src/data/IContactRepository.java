package data;

import data.entitis.Contact;

import java.util.ArrayList;

public interface IContactRepository {
    public void addContact(Contact contact);
    public Contact checkInfo(String info);
    public void updateContact(String phone, Contact contact);
    public void deleteContact(String phone);
    public Contact[] searchEmployee(String info);
    public ArrayList<Contact> displayContact();

}
