package com.example.androidunittest;

public class BMICategory {
    public String getBMICategory(double bmi) {
        if (bmi <= 0) {
            return "Invalid"; // Nilai BMI tidak valid
        } else if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}