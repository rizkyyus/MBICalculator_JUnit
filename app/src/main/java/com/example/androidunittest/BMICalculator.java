package com.example.androidunittest;

import java.util.HashSet;
import java.util.Set;

public class BMICalculator {

    private static final Set<String> existingUsers = new HashSet<>();

    public double calculateBMI(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            return -1; // Data tidak valid
        }
        return weight / (height * height);
    }

    public static void addExistingUser(String username) {
        existingUsers.add(username);
    }

    public static boolean isInputValid(String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty()) {
            return false; // Username atau password kosong
        }
        if (existingUsers.contains(username)) {
            return false; // Username sudah terdaftar
        }
        if (!password.equals(confirmPassword)) {
            return false; // Konfirmasi password tidak sesuai
        }
        if (password.chars().filter(Character::isDigit).count() < 2) {
            return false; // Password kurang dari 2 digit angka
        }
        return true; // Data valid
    }
}
