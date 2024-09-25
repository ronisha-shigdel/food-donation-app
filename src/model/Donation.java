package model;

public class Donation {
    private static int donationCounter = 0;
    private int donationId;
    private String foodType;
    private double quantity;
    private String unit;
    private String expirationDate;
    private String status;

    public Donation(String foodType, double quantity, String unit, String expirationDate) {
        this.donationId = ++donationCounter;
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
        this.status = "available";
    }

    public int getDonationId() {
        return donationId;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}