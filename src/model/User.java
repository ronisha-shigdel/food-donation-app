package model;

public class User{
    protected String name;
    protected String contactInfo;

    public User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public void viewProfile() {
        System.out.println("User Profile: " + name + ", Contact Info: " + contactInfo);
    }

    public void updateProfile(String newContactInfo) {
        this.contactInfo = newContactInfo;
        System.out.println("Contact info updated to: " + contactInfo);
    }
}
