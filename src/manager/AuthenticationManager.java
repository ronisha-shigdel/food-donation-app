package manager;

import model.Donor;
import model.Recipient;

public class AuthenticationManager {

    public Object authenticateUser(String userType, String name, String contactInfo) {
        if (userType.equalsIgnoreCase("donor")) {
            Donor donor = new Donor(name, contactInfo);
            System.out.println("Donor authenticated: " + name);
            return donor;
        } else if (userType.equalsIgnoreCase("recipient")) {
            Recipient recipient = new Recipient(name, contactInfo);
            System.out.println("Recipient authenticated: " + name);
            return recipient;
        } else {
            System.out.println("Invalid user type");
            return null;
        }
    }
}
