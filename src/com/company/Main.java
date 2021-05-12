package com.company;

import data.ContactRepository;
import data.IContactRepository;
import service.ContactService;
import service.IContactService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IContactRepository contactRepository = new ContactRepository();
        IContactService contactService = new ContactService(contactRepository);

	// write your code here
        while (true) {
            System.out.println("Menu Contact");
            System.out.println("Number 1: Hiển thị danh bạ.");
            System.out.println("Number 2: Thêm danh bạ.");
            System.out.println("Number 3: Cập nhật danh bạ.");
            System.out.println("Number 4: Xóa danh bạ.");
            System.out.println("Number 5: Tìm kiếm danh bạ.");
            System.out.println("Number 6: Đọc từ file.");
            System.out.println("Number 7: Ghi từ file.");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()){
                case 1:
                    contactService.displayContact();
                    break;
                case 2:
                    contactService.addContact();
                    break;
                case 3:
                    contactService.updateContact();
                    break;
                case 4:
                    contactService.deleteContact();
                    break;
                case 5:
                    contactService.searchContact();
                    break;
            }
        }
    }
}
