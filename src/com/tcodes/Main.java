package com.tcodes;


import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean hasAllAlphabets = checkStringForAlphabets(scanner.nextLine());
        if(hasAllAlphabets){
            System.out.println("Given String has all alphabets from a-z");
        }
        else {
            System.out.println("Given String doesn't have all alphabets from a-z");
        }
    }

    private static  boolean checkStringForAlphabets(String stringToCheck)
    {
        // length check
        if(stringToCheck.length() < 26)
            return false;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        HashMap<Character, Boolean> alphabetCheck = getMarkedAlphabetMap(stringToCheck, alphabet);

        // map checking
        for (Character ch :
                alphabetCheck.keySet()) {
            if (!alphabetCheck.get(ch))
                return false;
        }

        return true;
    }

    private static HashMap<Character, Boolean> getMarkedAlphabetMap(String stringToCheck, String alphabet)
    {

        HashMap<Character, Boolean> markAlphabet = new HashMap<>();

        // initialize hashmap
        for (int i = 0; i < alphabet.length(); i++) {
            markAlphabet.put(alphabet.charAt(i), false);
        }

        for (int i = 0; i < stringToCheck.length(); i++) {
            // Lower case for case-insenstive marking
            char currChar = Character.toLowerCase(stringToCheck.charAt(i));
            if(Character.isLetter(currChar)){
                markAlphabet.put(currChar, true);
            }
        }

        return markAlphabet;
    }
}
