package com.example.androidunittest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BMICategoryTest {

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