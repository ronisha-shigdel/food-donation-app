package model.interfaces;

public interface DonationInterface {
    void registerDonation(String foodType, double quantity, String unit, String expirationDate);
    void viewAvailableDonations();
    void updateDonationStatus(int donationId, String status);
}