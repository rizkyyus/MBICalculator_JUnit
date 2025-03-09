package com.example.androidunittest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    /*
        Test case untuk menguji fungsionalitas MainActivity menggunakan Espresso (Instrumented Test):
        1. testCalculateBMI_ValidInput:
           - Memasukkan berat "70" dan tinggi "175", lalu mengecek apakah hasil BMI yang ditampilkan sesuai (22.86).
           - Contoh: Input valid → Hasil BMI "BMI Anda: 22.86".
        2. testCalculateBMI_InvalidInput:
           - Memasukkan berat "0" dan tinggi "0", lalu mengecek apakah pesan error "Data tidak valid" ditampilkan.
           - Contoh: Input tidak valid (berat atau tinggi ≤ 0) → Pesan error "Data tidak valid".
        3. testCalculateBMI_EmptyInput:
           - Membiarkan input berat dan tinggi kosong, lalu mengecek apakah pesan error "Masukkan berat dan tinggi yang valid" ditampilkan.
           - Contoh: Input kosong → Pesan error "Masukkan berat dan tinggi yang valid".
     */

    // Aturan untuk meluncurkan MainActivity sebelum setiap tes
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /* Test case 1: Menguji perhitungan BMI dengan input valid */
    @Test
    public void testCalculateBMI_ValidInput() {
        // Input berat dan tinggi
        onView(withId(R.id.etWeight)).perform(typeText("70"));
        onView(withId(R.id.etHeight)).perform(typeText("175"));

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa hasil BMI (sesuaikan dengan format yang ditampilkan di TextView)
        onView(withId(R.id.tvResult)).check(matches(withText("BMI Anda: 22.86")));
    }

    /* Test case 2: Menguji perhitungan BMI dengan input tidak valid */
    @Test
    public void testCalculateBMI_InvalidInput() {
        // Input berat dan tinggi tidak valid
        onView(withId(R.id.etWeight)).perform(typeText("0"));
        onView(withId(R.id.etHeight)).perform(typeText("0"));

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa pesan error
        onView(withId(R.id.tvResult)).check(matches(withText("Data tidak valid")));
    }

    /* Test case 3: Menguji perhitungan BMI dengan input kosong */
    @Test
    public void testCalculateBMI_EmptyInput() {
        // Biarkan input berat dan tinggi kosong

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa pesan error
        onView(withId(R.id.tvResult)).check(matches(withText("Masukkan berat dan tinggi yang valid")));
    }
}