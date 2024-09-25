package model;

public class Claim {
    private int claimId;
    private int donationId;
    private int recipientId;
    private String claimStatus;

    public Claim(int claimId, int donationId, int recipientId) {
        this.claimId = claimId;
        this.donationId = donationId;
        this.recipientId = recipientId;
        this.claimStatus = "pending";
    }

    public int getClaimId() {
        return claimId;
    }

    public int getDonationId() {
        return donationId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}