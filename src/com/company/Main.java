package com.company;

import javax.xml.transform.sax.SAXResult;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //guessNumber();
        guessWords();


    }

    public static void guessNumber(){
        Scanner sc = new Scanner(System.in);

        int answer;
        int userAnswer = -1;
        int countTries;
        boolean repeat = true;

        while (repeat) {
            countTries = 3;
            answer = new Random().nextInt(10);
            while (countTries > 0) {
                System.out.println("Введите число от 0 до 9");
                userAnswer = sc.nextInt();
                if (userAnswer == answer) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (userAnswer > answer) {
                    System.out.println("Вы ввели слишком большое число");
                } else {
                    System.out.println("Вы ввели слишком маленькое число");
                }
                countTries--;
                if (countTries > 0) System.out.println("Попыток осталось: " + countTries);

            }

            if (userAnswer != answer)
                System.out.println("Вы проиграли! Загаданное число: " + answer + ".\nПовторить игру еще раз? 1 – да / 0 – нет");
            else System.out.println("Поздравляю, вы выиграли!\nПовторить игру еще раз? 1 – да / 0 – нет");

            repeat = sc.nextInt() == 1;
        }
        sc.close();
    }

    public static void guessWords(){

        Scanner sc = new Scanner(System.in);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String userAnswer;
        String hint = "###############";
        int charIndex;

        int rnd = new Random().nextInt(25);
        String answer = words[rnd];

        do {
            System.out.println("Угадайте слово из списка: apple, orange, lemon, banana, apricot, avocado, \nbroccoli, carrot, cherry, garlic, grape, melon, leak, kiwi, mango, \nmushroom, nut, olive, pea, peanut, pear, pepper, pineapple, pumpkin, potato");
            userAnswer = sc.next();
            if (userAnswer.equals(answer)){
                System.out.println("Поздравляю, вы угадали!");
                break;
            } else {
                charIndex = 0;
                while (charIndex < userAnswer.length() && charIndex < answer.length() && charIndex < hint.length()) {
                    if (userAnswer.charAt(charIndex) == answer.charAt(charIndex))
                        hint = replaceCharacterInStringAtPosition(hint, charIndex, userAnswer.charAt(charIndex));
                    charIndex++;
                }

            }
            System.out.println("Подсказка: "+hint);
        } while (true);
        sc.close();
    }

    public static String replaceCharacterInStringAtPosition(String str, int position, char replacingChar){
        if (position == 0){
            return replacingChar + str.substring(1);
        } else if (position == str.length()) {
            return str.substring(0,str.length()) + replacingChar;
        } else {
            return str.substring(0,position) + replacingChar + str.substring(position+1);
        }

    }
}
