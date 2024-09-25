package manager;

import model.Donor;
import model.Recipient;

public class AuthenticationManager {

    public void authenticateUser(String userType, String name, String contactInfo) {
        if (userType.equalsIgnoreCase("donor")) {
            Donor donor = new Donor(name, contactInfo);
            donor.createProfile(name, contactInfo);
        } else if (userType.equalsIgnoreCase("recipient")) {
            Recipient recipient = new Recipient(name, contactInfo);
            recipient.createProfile(name, contactInfo);
        } else {
            System.out.println("Invalid user type");
        }
    }
}