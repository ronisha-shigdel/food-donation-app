package manager;

import java.util.ArrayList;
import java.util.List;

import model.Donation;
import model.interfaces.DonationInterface;

public class DonationManager implements DonationInterface {
    private List<Donation> donations = new ArrayList<>();

    @Override
    public void registerDonation(String foodType, double quantity, String unit, String expirationDate) {
        Donation donation = new Donation(foodType, quantity, unit, expirationDate);
        donations.add(donation);
        System.out.println("Donation registered: " + donation.getFoodType());
    }

    @Override
    public void viewAvailableDonations() {
        System.out.println("Available Donations:");
        for (Donation donation : donations) {
            if (donation.getStatus().equals("available")) {
                System.out.println("ID: " + donation.getDonationId() + ", Food: " + donation.getFoodType() +
                        ", Quantity: " + donation.getQuantity() + " " + donation.getUnit() +
                        ", Expiration: " + donation.getExpirationDate());
            }
        }
    }

    @Override
    public void updateDonationStatus(int donationId, String status) {
        for (Donation donation : donations) {
            if (donation.getDonationId() == donationId) {
                donation.setStatus(status);
                System.out.println("Donation ID " + donationId + " updated to: " + status);
                break;
            }
        }
    }
}