package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {


            Proverka Calculator = new Proverka();// Создаем оьъект Calculator класса Proverka
            int probel = 0;
            String MyString; // массив String;
            System.out.print("input " + "\n");
            Scanner reader = new Scanner(System.in); //  создаем Сканер

            MyString = reader.nextLine(); // Записываем в MyString всю введенную строку
            reader.close(); // закрываем сканер
            char[] under_char = new char[MyString.length()];//Создаем массив char с количеством MyString
            char operator; // оператор действия
            int colchar = under_char.length;// размер массива
            // считаем пробелы в массиве который сделали из строки MyString
            for (int i = 0; i < colchar; i++) {
                under_char[i] = MyString.charAt(i);
            }
            for (int f = 0; f < colchar; f++) {
                if (under_char[f] == ' ') {

                    probel++;// Сделаем исключение если более 2х
                }
            }


            String[] words = MyString.split(" ");//использование сплит
            int d = 0;
            for (String word : words) //  Пока не увидели пробел
            {
                if(d>2) throw new ArithmeticException();// исключение

                Calculator.numr1[d] = word;//Записываем строку в  одномерный массив с номером d
                d++;// увеличиваем d на 1
            }
            if(Calculator.numr1[1]==null) throw new ArithmeticException();// исключение
            if(Calculator.numr1[0]==null) throw new ArithmeticException();// исключение
            operator = Calculator.numr1[1].charAt(0); // прсваеваем оператору значение извлекаем из стрингого массива переменную char
            Calculator.op = operator;
            if(!Calculator.ProverkaDeystvie()) throw new ArithmeticException();// исключение
            // Если обе римские цифры то выводим результат
            if (Calculator.ProverkaRim()) {

                Calculator.PerevodisRimvArabik();
                Calculator.VivodNaEcran();
            }
            // Если обе арабские цифры то выводим результат
            if (Calculator.ProverkaArabica()) {

                Calculator.PerevodisRimvArabik();
                Calculator.VivodNaEcran();
            }
            if(probel>2 || Calculator.numr1[2]==null) throw new ArithmeticException();// исключение


        }
        catch(ArithmeticException errow){

            System.out.println("throws Exception");

        }
    }

}

