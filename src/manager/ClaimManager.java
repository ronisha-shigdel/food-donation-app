package manager;

import model.Claim;
import model.interfaces.ClaimInterface;

import java.util.ArrayList;
import java.util.List;

public class ClaimManager implements ClaimInterface {
    private List<Claim> claims = new ArrayList<>();

    @Override
    public void claimDonation(int donationId, int recipientId) {
        Claim claim = new Claim(claims.size() + 1, donationId, recipientId);
        claims.add(claim);
        System.out.println("Donation claimed with ID: " + donationId);
    }

    @Override
    public void viewClaimsByRecipient(int recipientId) {
        System.out.println("Claims for recipient ID: " + recipientId);
        for (Claim claim : claims) {
            if (claim.getRecipientId() == recipientId) {
                System.out.println("Claim ID: " + claim.getClaimId() + ", Donation ID: " + claim.getDonationId() +
                        ", Status: " + claim.getClaimStatus());
            }
        }
    }

    @Override
    public void cancelClaim(int claimId) {
        for (Claim claim : claims) {
            if (claim.getClaimId() == claimId) {
                claims.remove(claim);
                System.out.println("Claim ID " + claimId + " has been canceled");
                break;
            }
        }
    }
}