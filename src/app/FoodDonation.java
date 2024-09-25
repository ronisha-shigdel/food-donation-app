package app;

import manager.DonationManager;
import manager.AuthenticationManager;

import java.util.Scanner;

public class FoodDonation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthenticationManager authManager = new AuthenticationManager();
        DonationManager donationManager = new DonationManager();

        System.out.println("Welcome to the Food Donation App!");

        System.out.println("Are you a donor or recipient? (Enter 'donor' or 'recipient'):");
        String userType = scanner.nextLine();
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your contact info:");
        String contactInfo = scanner.nextLine();


        authManager.authenticateUser(userType, name, contactInfo);

        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register Donation");
            System.out.println("2. View Available Donations");
            System.out.println("3. Exit");
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

                    donationManager.registerDonation(foodType, quantity, unit, expirationDate);
                    break;

                case 2:
                    donationManager.viewAvailableDonations();
                    break;

                case 3:
                    System.out.println("Exiting the app. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
