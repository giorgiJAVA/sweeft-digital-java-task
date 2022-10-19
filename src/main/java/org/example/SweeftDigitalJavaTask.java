package org.example;


import java.util.Arrays;

public class SweeftDigitalJavaTask {


    //Task 1
    boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

    //Task 2
    int minSplit(int amount) {
        int amountOfCoins = amount / 50;
        int amountOfCoins2 = (amount % 50) / 20;
        int amountOfCoins3 = ((amount % 50) % 20) / 10;
        int amountOfCoins4 = (((amount % 50) % 20) % 10) / 5;
        int amountOfCoins5 = ((((amount % 50) % 20) % 10) % 5);
        return amountOfCoins + amountOfCoins2 + amountOfCoins3 + amountOfCoins4 + amountOfCoins5;
    }

    //Task 3
    int notContains(int[] array) {
        Arrays.sort(array);
        int minimum = 1;
        for (int j : array) {
            if (j == minimum) {
                minimum++;
            }
        }
        return minimum;
    }

    //Task 4
    boolean isProperly(String sequence) {
        int counter = 0;
        if (null == sequence || ((sequence.length() % 2) != 0)) {
            return false;
        }
        for (char c : sequence.toCharArray()) {
            if (c == '(') {
                counter++;
            } else {
                counter--;
            }
            if (counter < 0) return false;
        }

        return counter == 0;
    }

    //Task 5
    int countVariants(int stearsCount) {
        if (stearsCount == 1 || stearsCount == 0)
            return 1;
        else if (stearsCount == 2)
            return 2;

        else
            return countVariants(stearsCount - 2) + countVariants(stearsCount - 1);
    }

    //Task 6
    static class MyStack<T> {

        private int capacity = 10;
        private int length;
        private T[] array = (T[]) new Object[capacity];


        public int size() {
            return length;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public void add(T t) {

            array[length] = t;
            length++;

            if (length * 2 > capacity) {
                capacity *= 2;
                T[] newArray = (T[]) new Object[capacity];
                System.arraycopy(array, 0, newArray, 0, length);
                array = newArray;
            }
        }

        public T get(int index) {
            if (index < length) {
                return array[index];
            }
            return null;
        }

        public void remove(Object o) {
            if (array.length != 0 && array[length - 1] == o) {
                array[length - 1] = null;
                length--;
            }
        }

    }


}