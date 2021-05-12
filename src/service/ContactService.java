package service;

import data.ContactRepository;
import data.IContactRepository;
import data.entitis.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactService implements IContactService{
    IContactRepository contactRepository = new ContactRepository();

    public ContactService(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ArrayList<Contact> displayContact() {
        ArrayList<Contact> contacts = contactRepository.displayContact();
        for (Contact a : contacts
        ) {
            System.out.println(a);
        }
        return contacts;
    }
    public Contact writeContact(){
        Contact newContact = new Contact();
        newContact.setName(writeName());

        newContact.setAddress(writeAddress());

        newContact.setPhone(writePhone());

        newContact.setPhone(writeEmail());

        newContact.setFacebook(writeFaceBook());

        return newContact;
    }
    public void addContact(){
        contactRepository.addContact(writeContact());
    }
    public void updateContact(){
        Scanner sc = new Scanner(System.in);
        String phone;
        boolean check;
        do {
            System.out.println("Nhập số điện thoại: ");
            phone = sc.nextLine();
            check = contactRepository.checkInfo(phone) == null;
            if (check) System.err.println("Số điện thoại --- Vui lòng nhập lại: ");
        } while (check);
        System.out.println("Accept..!");
        contactRepository.updateContact(phone,writeContact());
    }
    public void deleteContact(){
        Scanner sc = new Scanner(System.in);
        String phone;
        boolean check;
        do {
            System.out.println("Nhập số điện thoại: ");
            phone = sc.nextLine();
            check = contactRepository.checkInfo(phone) == null;
            if (check) System.err.println("Số điện thoại --- Vui lòng nhập lại: ");
        } while (check);
        System.out.println("Accept..!");
        contactRepository.deleteContact(phone);

    }
    public void searchContact(){
        Contact [] listSearchContact;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhâp tên nhân hoặc số điện thoại: ");
            String info = sc.nextLine();
            listSearchContact = contactRepository.searchEmployee(info);
            if(listSearchContact.length == 0) System.err.println("Tên hoặc sdt không tồn tại..! - Vui lòng nhập lại: ");
        }  while(listSearchContact.length == 0);
        System.out.println("Tìm kiếm thành công..!");
        for (Contact c: listSearchContact
             ) {
            System.out.println(c);
        }
    }

    public boolean checkInvalidPhone(String phone) {
        final String phonePattenrn =  "^\\d{2}-\\d{3}-\\d{4}$";
        if (phone.matches(phonePattenrn)) {
            return true;
        }
        System.out.println(" Invalid data!!!!");
        return false;
    }

    public static boolean checkMail(String mail) {
        String mailPattern = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (mail.matches(mailPattern)) {
            return true;
        }
        System.out.println("Email fail -- Please enter again.");
        return false;
    }

    public String writeName() {
        Scanner sc = new Scanner(System.in);
        String name;
        do {
            System.out.println("Nhập tên : ");
            name = sc.nextLine();
            if (name.equals("")) {
                System.err.println("Không được để trống mục này..! --- Please enter: ");
            }
        }
            while (name.equals("")) ;
            return name;
    }

        public String writeAddress () {
            Scanner sc = new Scanner(System.in);
            String address;
            do {
                System.out.println("Nhập địa chỉ: ");
                address = sc.nextLine();
                if (address.equals("")) {
                    System.err.println("Không được để trống mục này..! --- Please enter: ");
                }
            } while (address.equals(""));
            return address;
        }


        public String writePhone () {
            Scanner sc = new Scanner(System.in);
            String phone;
            boolean checkRegexPhone;
            do {
                System.out.println("Nhập số điện thoại: ");
                System.out.println("Mẫu :// 85-990-8989");
                phone = sc.nextLine();
                checkRegexPhone = checkInvalidPhone(phone);
            } while ( !checkRegexPhone);
            return phone;
        }

    public String writeFaceBook () {
        Scanner sc = new Scanner(System.in);
        String address;
        do {
            System.out.println("Nhập Facebook: ");
            address = sc.nextLine();
            if (address.equals("")) {
                System.err.println("Không được để trống mục này..! --- Please enter: ");
            }
        } while (address.equals(""));
        return address;
    }

    public String writeEmail(){
        Scanner sc = new Scanner( System.in);
        boolean checkRegexEmail;
        String email;
        do {
            System.out.println("Nhập email: ");
            System.out.println("Mẫu :// demo@gmail.com ");
            email = sc.nextLine();
            checkRegexEmail = checkMail(email);
        } while (!checkRegexEmail);
        return email;
    }
}




