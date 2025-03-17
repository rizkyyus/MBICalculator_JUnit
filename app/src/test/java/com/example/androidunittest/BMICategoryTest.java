package com.example.androidunittest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BMICategoryTest {
     /*
        Test case untuk menguji kategori BMI pada class BMICategory:
        1. testBMICategory_Underweight:
           - Memeriksa apakah kategori BMI "Underweight" dikembalikan untuk nilai BMI di bawah 18.5.
           - Contoh: BMI = 17.5 → Kategori "Underweight".
        2. testBMICategory_Normal:
           - Memeriksa apakah kategori BMI "Normal" dikembalikan untuk nilai BMI antara 18.5 dan 24.9.
           - Contoh: BMI = 22.0 → Kategori "Normal".
        3. testBMICategory_Overweight:
           - Memeriksa apakah kategori BMI "Overweight" dikembalikan untuk nilai BMI antara 25 dan 29.9.
           - Contoh: BMI = 27.5 → Kategori "Overweight".
        4. testBMICategory_Obese:
           - Memeriksa apakah kategori BMI "Obese" dikembalikan untuk nilai BMI 30 atau lebih.
           - Contoh: BMI = 32.0 → Kategori "Obese".
        5. testBMICategory_InvalidBMI:
           - Memeriksa apakah kategori BMI "Invalid" dikembalikan untuk nilai BMI yang tidak valid (≤ 0).
           - Contoh: BMI = -1 → Kategori "Invalid".
    */

    @Test
    public void testBMICategory_Underweight() {
        BMICategory bmiCategory = new BMICategory();
        String category = bmiCategory.getBMICategory(17.5);
        assertEquals("Underweight", category);
    }

    @Test
    public void testBMICategory_Normal() {
        BMICategory bmiCategory = new BMICategory();
        String category = bmiCategory.getBMICategory(22.0);
        assertEquals("Normal", category);
    }

    @Test
    public void testBMICategory_Overweight() {
        BMICategory bmiCategory = new BMICategory();
        String category = bmiCategory.getBMICategory(27.5);
        assertEquals("Overweight", category);
    }

    @Test
    public void testBMICategory_Obese() {
        BMICategory bmiCategory = new BMICategory();
        String category = bmiCategory.getBMICategory(32.0);
        assertEquals("Obese", category);
    }

    @Test
    public void testBMICategory_InvalidBMI() {
        BMICategory bmiCategory = new BMICategory();
        String category = bmiCategory.getBMICategory(-1);
        assertEquals("Invalid", category); // Tambahkan assertEquals untuk memverifikasi hasil
    }
}