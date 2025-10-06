package com.example.madt_lab2_rimantek;

import android.content.Context;
import android.widget.Toast;

public class TextCounting {
    public static int countCharacters(Context context, String input) {
        if (input == null) {
            Toast.makeText(context, "bing bong", Toast.LENGTH_LONG).show();
            return 0;
        }
        return input.length();
    }

    public static int countWords(Context context, String input) {
        if (input == null || input.trim().isEmpty()) {
            Toast.makeText(context, "bing bong bing bong", Toast.LENGTH_LONG).show();
            return 0;
        }
        String[] words = input.trim().split("[, .\\s]+");

        return words.length;
    }

    public static int countNumbers(Context context, String input) {
        if (input == null || input.trim().isEmpty()) {
            Toast.makeText(context, "bing bong bing bong bing bong", Toast.LENGTH_LONG).show();
            return 0;
        }
        String[] numbers = input.trim().split("[^0-9]+");
        int count = 0;
        for (String num : numbers) {
            if (!num.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static int countSentences(Context context, String input) {
        if (input == null || input.trim().isEmpty()) {
            Toast.makeText(context, "bing bong bing bong bing bong bing bong", Toast.LENGTH_LONG).show();
            return 0;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.' || c == '!' || c == '?' || c == ',' || c == ';' || c == ':' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '-' || c == '_') {
                count++;
            }
        }
        return count;
    }
}