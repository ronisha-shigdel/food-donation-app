package manager;

import model.Donor;
import model.Recipient;
import model.User;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> users = new HashMap<>();

    public void signUp(String userType, String name, String contactInfo) {
        if (users.containsKey(name)) {
            System.out.println("User already exists. Please log in.");
            return;
        }

        if (userType.equalsIgnoreCase("donor")) {
            Donor donor = new Donor(name, contactInfo);
            users.put(name, donor);
            System.out.println("Donor profile created: " + name);
        } else if (userType.equalsIgnoreCase("recipient")) {
            Recipient recipient = new Recipient(name, contactInfo);
            users.put(name, recipient);
            System.out.println("Recipient profile created: " + name);
        } else {
            System.out.println("Invalid user type. Please try again.");
        }
    }

    public User login(String name) {
        if (!users.containsKey(name)) {
            System.out.println("No user found with that name. Please sign up.");
            return null;
        }
        return users.get(name);
    }

    public String getUserType(User user) {
        if (user instanceof Donor) {
            return "donor";
        } else if (user instanceof Recipient) {
            return "recipient";
        }
        return "unknown";
    }
}