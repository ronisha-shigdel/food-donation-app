package app;

import manager.DonationManager;
import manager.UserManager;
import model.Donor;
import model.Recipient;
import model.User;

import java.util.Scanner;

public class FoodDonation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        DonationManager donationManager = new DonationManager();
        boolean running = true;

        System.out.println("Welcome to the Food Donation App!");

        while (running) {
            System.out.println("\nDo you want to log in or sign up? (Enter 'login' or 'signup'):");
            String action = scanner.nextLine();
            System.out.println("Are you a donor or recipient? (Enter 'donor' or 'recipient'):");
            String userType = scanner.nextLine();
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();
            System.out.println("Please enter your contact info:");
            String contactInfo = scanner.nextLine();

            User user = null;

            if (action.equalsIgnoreCase("signup")) {
                userManager.signUp(userType, name, contactInfo);
                user = userManager.login(name);
            } else if (action.equalsIgnoreCase("login")) {
                user = userManager.login(name);
                if (user == null) {
                    continue;
                }
            }

            if (userManager.getUserType(user).equals("donor")) {
                Donor donor = (Donor) user;

                boolean donorFlow = true;
                while (donorFlow) {
                    System.out.println("\nDonor Menu:");
                    System.out.println("1. Register Donation");
                    System.out.println("2. View My Donations");
                    System.out.println("3. Exit Donor Mode");
                    System.out.print("Choose an option: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter food type:");
                            String foodType = scanner.nextLine();
                            System.out.println("Enter quantity:");
                            double quantity = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Enter unit (KG, grams, liters):");
                            String unit = scanner.nextLine();
                            System.out.println("Enter expiration date (YYYY-MM-DD):");
                            String expirationDate = scanner.nextLine();

                            donationManager.registerDonation(donor, foodType, quantity, unit, expirationDate);
                            break;

                        case 2:
                            donationManager.viewDonorDonations(donor);
                            break;

                        case 3:
                            donorFlow = false;
                            System.out.println("Exiting donor mode...");
                            break;

                        default:
                            System.out.println("Invalid option. Please choose again.");
                    }
                }

            } else if (userManager.getUserType(user).equals("recipient")) {
                Recipient recipient = (Recipient) user;

                boolean recipientFlow = true;
                while (recipientFlow) {
                    System.out.println("\nRecipient Menu:");
                    System.out.println("1. View Available Donations");
                    System.out.println("2. Claim Donation");
                    System.out.println("3. View My Claims");
                    System.out.println("4. Exit Recipient Mode");
                    System.out.print("Choose an option: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            donationManager.viewAvailableDonations();
                            break;

                        case 2:
                            System.out.println("Enter the food type to claim:");
                            String foodType = scanner.nextLine();
                            donationManager.claimDonation(recipient, foodType);
                            break;

                        case 3:
                            donationManager.viewRecipientClaims(recipient);
                            break;

                        case 4:
                            recipientFlow = false;
                            System.out.println("Exiting recipient mode...");
                            break;

                        default:
                            System.out.println("Invalid option. Please choose again.");
                    }
                }
            }

            System.out.println("Do you want to switch to another flow or exit? (Enter 'switch' or 'exit'):");
            String nextAction = scanner.nextLine();
            if (nextAction.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Exiting the app. Goodbye!");
            }
        }

        scanner.close();
    }
}