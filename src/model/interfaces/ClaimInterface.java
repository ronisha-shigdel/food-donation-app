package model.interfaces;

public interface ClaimInterface {
    void claimDonation(int donationId, int recipientId);
    void viewClaimsByRecipient(int recipientId);
    void cancelClaim(int claimId);
}