package com.pierzchala.springfive.adam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RecruitmentTask {

    private static final Integer MAX_BALLS = 100;

    public static void main(String[] args) {

        System.out.println("Podaj liczbę kul (maksymalna ilość " + MAX_BALLS + "): ");
        int numberOfElements = getNumber();
        System.out.println("Ilość kul " + numberOfElements);

        List<Integer> ballsList = new LinkedList<>();
        System.out.println("Wczytywanie wartości liczbowej każdej kuli:");
        for (int i = 0; i < numberOfElements; i++) {
            System.out.println("Podaj wartość liczbową kuli numer " + (i + 1));
            ballsList.add(getNumber());
        }
        System.out.println("Tablica Twoich kul: " + ballsList.toString());

        // sprawdzenie warunku
        List<Integer> rightOrder = new LinkedList<>();
        boolean canWeSortBallsInRightOrder = true;

        for (int i = 0; i < numberOfElements; i++) {

            if (ballsList.contains(i)) {
                rightOrder.add(i);
                ballsList.set(ballsList.indexOf(i), MAX_BALLS + 1);
                continue;
            }
            if (ballsList.contains(numberOfElements - (i + 1))) {
                rightOrder.add(numberOfElements - (i + 1));
                ballsList.set(ballsList.indexOf(numberOfElements - (i + 1)), MAX_BALLS + 1);
                continue;
            }
            canWeSortBallsInRightOrder = false;
        }

        System.out.println("Czy można ułożyć kule w żądanej kolejności: " + (canWeSortBallsInRightOrder ? "TAK" : "NIE"));
        if (canWeSortBallsInRightOrder) {
            System.out.println("Prawidłowa kolejność: " + rightOrder.toString());
        }
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Podaj liczbę: ");
        }
        int value = scanner.nextInt();
        while (value > MAX_BALLS) {
            System.out.println("Podaj liczbę kul (maksymalna ilość " + MAX_BALLS + "): ");
            value = getNumber();
        }
        return value;
    }
}
