package service;

import data.entitis.Contact;

import java.util.ArrayList;

public interface IContactService {
    public ArrayList<Contact> displayContact();
    public void addContact();
    public void deleteContact();
    public void searchContact();
    public void updateContact();

}
