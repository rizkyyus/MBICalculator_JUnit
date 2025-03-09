package com.example.androidunittest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BMICalculatorTest {

    /*
        Test case untuk menguji validasi input pada class BMICalculator (Local Test):
        1. testInput_EmptyUsernameOrPassword:
           - Memeriksa apakah sistem mendeteksi input yang tidak valid ketika username atau password kosong.
           - Contoh: Username kosong ("") atau password kosong ("") → Input tidak valid.
        2. testInput_UsernameAlreadyTaken:
           - Memeriksa apakah sistem mendeteksi username yang sudah terdaftar.
           - Contoh: Username "existingUser" sudah terdaftar → Input tidak valid.
        3. testInput_ConfirmedPasswordMismatch:
           - Memeriksa apakah sistem mendeteksi ketidakcocokan antara password dan konfirmasi password.
           - Contoh: Password "password123" dan konfirmasi password "password321" → Input tidak valid.
        4. testInput_PasswordLessThanTwoDigits:
           - Memeriksa apakah sistem mendeteksi password yang kurang dari 2 digit angka.
           - Contoh: Password "passw0rd" (hanya 1 digit angka) → Input tidak valid.
        5. testInput_ValidData:
           - Memeriksa apakah sistem menerima input yang valid.
           - Contoh: Username "newUser", password "password12", dan konfirmasi password "password12" → Input valid.
     */

    @Test
    public void testInput_EmptyUsernameOrPassword() {
        assertFalse(BMICalculator.isInputValid("", "password123", "password123"));
        assertFalse(BMICalculator.isInputValid("username", "", "password123"));
    }

    @Test
    public void testInput_UsernameAlreadyTaken() {
        BMICalculator.addExistingUser("existingUser");
        assertFalse(BMICalculator.isInputValid("existingUser", "password123", "password123"));
    }

    @Test
    public void testInput_ConfirmedPasswordMismatch() {
        assertFalse(BMICalculator.isInputValid("username", "password123", "password321"));
    }

    @Test
    public void testInput_PasswordLessThanTwoDigits() {
        assertFalse(BMICalculator.isInputValid("username", "passw0rd", "passw0rd"));
    }

    @Test
    public void testInput_ValidData() {
        assertTrue(BMICalculator.isInputValid("newUser", "password12", "password12"));
    }
}
