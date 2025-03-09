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
public class BMICategoryInstrumentedTest {

    // Aturan untuk meluncurkan MainActivity sebelum setiap tes
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /*
        Test case untuk menguji validasi kategori BMI di MainActivity:
        1. testBMICategory_Underweight:
           - Memasukkan berat "50" dan tinggi "170", lalu mengecek apakah kategori BMI yang ditampilkan adalah "Underweight".
        2. testBMICategory_Normal:
           - Memasukkan berat "70" dan tinggi "175", lalu mengecek apakah kategori BMI yang ditampilkan adalah "Normal".
        3. testBMICategory_Overweight:
           - Memasukkan berat "80" dan tinggi "175", lalu mengecek apakah kategori BMI yang ditampilkan adalah "Overweight".
        4. testBMICategory_Obese:
           - Memasukkan berat "100" dan tinggi "175", lalu mengecek apakah kategori BMI yang ditampilkan adalah "Obese".
     */

    /* Test case 1: Menguji kategori Underweight */
    @Test
    public void testBMICategory_Underweight() {
        // Input berat dan tinggi
        onView(withId(R.id.etWeight)).perform(typeText("50"));
        onView(withId(R.id.etHeight)).perform(typeText("170"));

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa kategori BMI
        onView(withId(R.id.tvResult)).check(matches(withText("BMI Anda: 17.30 (Underweight)")));
    }

    /* Test case 2: Menguji kategori Normal */
    @Test
    public void testBMICategory_Normal() {
        // Input berat dan tinggi
        onView(withId(R.id.etWeight)).perform(typeText("70"));
        onView(withId(R.id.etHeight)).perform(typeText("175"));

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa kategori BMI
        onView(withId(R.id.tvResult)).check(matches(withText("BMI Anda: 22.86 (Normal)")));
    }

    /* Test case 3: Menguji kategori Overweight */
    @Test
    public void testBMICategory_Overweight() {
        // Input berat dan tinggi
        onView(withId(R.id.etWeight)).perform(typeText("80"));
        onView(withId(R.id.etHeight)).perform(typeText("175"));

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa kategori BMI
        onView(withId(R.id.tvResult)).check(matches(withText("BMI Anda: 26.12 (Overweight)")));
    }

    /* Test case 4: Menguji kategori Obese */
    @Test
    public void testBMICategory_Obese() {
        // Input berat dan tinggi
        onView(withId(R.id.etWeight)).perform(typeText("100"));
        onView(withId(R.id.etHeight)).perform(typeText("175"));

        // Klik tombol hitung
        onView(withId(R.id.btnCalculate)).perform(click());

        // Periksa kategori BMI
        onView(withId(R.id.tvResult)).check(matches(withText("BMI Anda: 32.65 (Obese)")));
    }
}