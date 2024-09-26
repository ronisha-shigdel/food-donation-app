package manager;

import model.Recipient;
import model.Donation;
import model.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipientManager implements UserInterface {

    private HashMap<Recipient, List<Donation>> recipientClaims = new HashMap<>();
    private List<Donation> availableDonations = new ArrayList<>();

    // Constructor to initialize with available donations
    public RecipientManager(List<Donation> availableDonations) {
        this.availableDonations = availableDonations;
    }

    // Method to create a recipient profile
    @Override
    public void createProfile(String name, String contactInfo) {
        System.out.println("Recipient profile created: " + name + " (" + contactInfo + ")");
    }

    // Method to view a recipient's profile
    @Override
    public void viewProfile() {
        System.out.println("Viewing recipient profile...");
    }

    // Method to update recipient's profile
    @Override
    public void updateProfile(String newContactInfo) {
        System.out.println("Contact Info updated to: " + newContactInfo);
    }

    // Method to claim a donation
    public void claimDonation(Recipient recipient, String foodType) {
        Donation claimedDonation = null;
        for (Donation donation : availableDonations) {
            if (donation.getFoodType().equalsIgnoreCase(foodType)) {
                claimedDonation = donation;
                break;
            }
        }

        if (claimedDonation != null) {
            // Add claimed donation to recipient's list of claims
            recipientClaims.putIfAbsent(recipient, new ArrayList<>());
            recipientClaims.get(recipient).add(claimedDonation);

            // Remove the claimed donation from the available donations list
            availableDonations.remove(claimedDonation);
            System.out.println(recipient.getName() + " claimed the donation: " + claimedDonation.getFoodType());
        } else {
            System.out.println("No available donation for the specified food type.");
        }
    }

    // Method to view all donations claimed by a recipient
    public void viewClaims(Recipient recipient) {
        List<Donation> claimedDonations = recipientClaims.get(recipient);
        if (claimedDonations == null || claimedDonations.isEmpty()) {
            System.out.println(recipient.getName() + " has not claimed any donations.");
        } else {
            System.out.println(recipient.getName() + "'s Claimed Donations:");
            for (Donation donation : claimedDonations) {
                System.out.println(donation.getFoodType() + ": " + donation.getQuantity() + " " + donation.getUnit());
            }
        }
    }

    // Method to view available donations
    public void viewAvailableDonations() {
        if (availableDonations.isEmpty()) {
            System.out.println("No donations available.");
        } else {
            System.out.println("Available Donations:");
            for (Donation donation : availableDonations) {
                System.out.println(donation.getFoodType() + ": " + donation.getQuantity() + " " + donation.getUnit() + " (Expires on: " + donation.getExpirationDate() + ")");
            }
        }
    }
}