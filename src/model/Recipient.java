package model;

import model.interfaces.UserInterface;

public class Recipient extends User implements UserInterface {

    public Recipient(String name, String contactInfo) {
        super(name, contactInfo);
    }

    @Override
    public void createProfile(String name, String contactInfo) {
        System.out.println("Recipient profile created: " + name);
    }

    @Override
    public void viewProfile() {
        System.out.println("Recipient Profile: " + name + ", Contact: " + contactInfo);
    }

    @Override
    public void updateProfile(String newContactInfo) {
        this.contactInfo = newContactInfo;
        System.out.println("Contact Info updated to: " + newContactInfo);
    }
}