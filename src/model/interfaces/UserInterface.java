package model.interfaces;

public interface UserInterface {
    void createProfile(String name, String contactInfo);
    void viewProfile();
    void updateProfile(String newContactInfo);
}