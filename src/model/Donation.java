package model;

public class Donation {
    private String foodType;
    private double quantity;
    private String unit;
    private String expirationDate;

    public Donation(String foodType, double quantity, String unit, String expirationDate) {
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
