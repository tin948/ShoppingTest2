package lib;

import java.util.ArrayList;

public class ShoppingCartManualTest {
  public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); //ซื้อขนมปัง2ก้อน=50บาท
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));  //ซื้อนม1กล้อง=15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
        
        // Test 4: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> bogoCart = new ArrayList<>();
        bogoCart.add(new CartItem("BOGO", "Bread", 25.0, 2)); //ซื้อขนมปัง2ก้อนจ่าย1=25บาท
        bogoCart.add(new CartItem("BOGO", "Milk", 15.0, 1));  //ซื้อนม1กล้อง=15
        double total4= ShoppingCartCalculator.calculateTotalPrice(bogoCart);
        if (total4 == 40.0) {
            System.out.println("PASSED: Simple cart total is correct (40.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 40.0 but got " + total4);
            failedCount++;
        }
         // Test 5: คำนวณแบบ มีส่วนลด BULK
         ArrayList<CartItem> bulkCart = new ArrayList<>();
         bulkCart.add(new CartItem("BULK", "Bread", 25.0, 10)); // ซื้อขนมปัง10ก้อน 250ลด10% = 225
         bulkCart.add(new CartItem("BULK", "Milk", 15.0, 2));      //ซื้อนม2กล้อง= 30
         double total5 = ShoppingCartCalculator.calculateTotalPrice(bulkCart);
         if (total5 == 255.0) {
             System.out.println("PASSED: BULK cart total is correct (255.0)");
             passedCount++;
         } else {
             System.out.println("FAILED: BULK cart total expected 255.0 but got " + total5);
             failedCount++;
         }



        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }  
}
