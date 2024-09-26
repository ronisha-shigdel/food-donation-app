package manager;

import model.Donation;
import model.Donor;
import model.Recipient;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DonationManager {
    private HashMap<Donor, List<Donation>> donorDonations = new HashMap<>();
    private HashMap<Recipient, List<Donation>> recipientClaims = new HashMap<>();
    private List<Donation> donations = new ArrayList<>();
    
    public void registerDonation(Donor donor, String foodType, double quantity, String unit, String expirationDate) {
        Donation donation = new Donation(foodType, quantity, unit, expirationDate);
        donations.add(donation);

        donorDonations.putIfAbsent(donor, new ArrayList<>());
        donorDonations.get(donor).add(donation);

        System.out.println("Donation registered by " + donor.getName() + ": " + foodType);
    }

    public void viewAvailableDonations() {
        if (donations.isEmpty()) {
            System.out.println("No donations available.");
        } else {
            System.out.println("Available Donations:");
            for (Donation donation : donations) {
                System.out.println("Food: " + donation.getFoodType() + ", Quantity: " + donation.getQuantity() + " " + donation.getUnit() + ", Expires on: " + donation.getExpirationDate());
            }
        }
    }

    public void claimDonation(Recipient recipient, String foodType) {
        for (Donation donation : donations) {
            if (donation.getFoodType().equalsIgnoreCase(foodType)) {
                recipientClaims.putIfAbsent(recipient, new ArrayList<>());
                recipientClaims.get(recipient).add(donation);

                donations.remove(donation);
                System.out.println(recipient.getName() + " claimed the donation: " + foodType);
                return;
            }
        }
        System.out.println("No donation available for the specified food type.");
    }

    public void viewDonorDonations(Donor donor) {
        List<Donation> donorDonationList = donorDonations.get(donor);
        if (donorDonationList == null || donorDonationList.isEmpty()) {
            System.out.println("No donations made by " + donor.getName());
        } else {
            System.out.println(donor.getName() + "'s Donations:");
            for (Donation donation : donorDonationList) {
                System.out.println(donation.getFoodType() + ": " + donation.getQuantity() + " " + donation.getUnit());
            }
        }
    }

    public void viewRecipientClaims(Recipient recipient) {
        List<Donation> recipientClaimList = recipientClaims.get(recipient);
        if (recipientClaimList == null || recipientClaimList.isEmpty()) {
            System.out.println(recipient.getName() + " has not claimed any donations.");
        } else {
            System.out.println(recipient.getName() + "'s Claims:");
            for (Donation donation : recipientClaimList) {
                System.out.println(donation.getFoodType() + ": " + donation.getQuantity() + " " + donation.getUnit());
            }
        }
    }
}