package com.java.problems;

import java.util.ArrayList;
import java.util.Scanner;

public class EncryptionDecryptionOfEnigmaMachine {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        ArrayList<char[]> rotorCharArray = new ArrayList<>();
        ArrayList<int[]> decodeRotorCharArray = new ArrayList<>();
        int pseudoRandomNumber = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            String rotor = in.nextLine();
            char[] rotorChar = rotor.toCharArray();
            rotorCharArray.add(rotorChar);
            int[] decodeRotorChar = new int[rotorChar.length];
            for (int j = 0; j < rotorChar.length; j++) {
                decodeRotorChar[rotorChar[j]-'A'] = j;
            }
            decodeRotorCharArray.add(decodeRotorChar);
        }
        String message = in.nextLine();
        switch (operation) {
            case "ENCODE": {
                char[] messageArray = message.toCharArray();
                for(int i = 0; i < messageArray.length; i++) {
                    messageArray[i] = (char) ((pseudoRandomNumber + messageArray[i] - 'A' + i)%26 + 'A');
                }
                for (char[] rotorChar : rotorCharArray) {
                    for (int j = 0; j < messageArray.length; j++) {
                        messageArray[j] = rotorChar[messageArray[j] - 'A'];
                    }
                }
                message = new String(messageArray);
            }
            break;
            case "DECODE": {
                char[] messageArray = message.toCharArray();
                for (int i = decodeRotorCharArray.size() - 1; i >= 0; i--) {
                    int[] decodeRotorChar = decodeRotorCharArray.get(i);
                    for (int j = 0; j < messageArray.length; j++) {
                        messageArray[j] = (char) (decodeRotorChar[messageArray[j] - 'A'] + 'A');
                    }
                    System.out.println(messageArray);
                }
                for(int i = 0; i < messageArray.length; i++) {
                    messageArray[i] = (char) ((26 - (pseudoRandomNumber+i) %26 + messageArray[i] - 'A')%26 + 'A');
                }
                message = new String(messageArray);
            }
            break;
        }

        System.out.println(message);
    }
}
