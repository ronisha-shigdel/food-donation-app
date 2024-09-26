package manager;

import model.Donor;
import model.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class DonorManager implements UserInterface {

    private List<Donor> donors = new ArrayList<>();
    private Donor donor;

    public DonorManager(Donor donor) {
        this.donor = donor;
    }

    @Override
    public void createProfile(String name, String contactInfo) {
        donor.setContactInfo(contactInfo);
        System.out.println("Donor profile created for: " + name);
        donors.add(donor);
    }

    @Override
    public void viewProfile() {
        System.out.println("Donor Profile: Name - " + donor.getName() + ", Contact Info - " + donor.getContactInfo());
    }

    @Override
    public void updateProfile(String newContactInfo) {
        donor.setContactInfo(newContactInfo);
        System.out.println("Donor contact info updated to: " + newContactInfo);
    }

    public void viewAllDonors() {
        for (Donor donor : donors) {
            System.out.println("Donor Name: " + donor.getName() + ", Contact Info: " + donor.getContactInfo());
        }
    }
}
