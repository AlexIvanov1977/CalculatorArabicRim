package com.company;

public class Proverka {

    public   int num1,num2,ans;
    public char op;
    public String [] numr1= new String[3];

    String[] str = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };



    //----------Проверка на правильность действия
    boolean ProverkaDeystvie() {
        boolean gh=false;
        char[] i = {'+', '-', '*', '/'};
        for (int v = 0; v < 4; v++)
        {
            if (i[v] == op) {
                gh=true;
                break;



            }

        }
        return gh;
    }
    //------------Проверка на арабские числа(чтоб два числа были арабские)
    boolean ProverkaArabica() {
        boolean g1=false;
        boolean g2=false;
        String[] i = {"1","2","3","4","5","6","7","8","9","10"};
        for (int f = 0; f < 10; f++) {
            if (i[f].equals(numr1[0])) {

                num1 = f + 1;
                g1 = true;
                break;
            }
        }
        for (int g = 0; g < 10; g++)
        {
            if (i[g].equals(numr1[2])) {
                num2=g+1;
                g2 = true;
                break;
            }
        }
        if((g1 && !g2) || (!g1 && g2)) throw new ArithmeticException();// исключение

        if(g1 && g2)
            return (true);
        else return (false);
    }

    //----------Проверка на римские числа( чтоб два числа были римские)
    boolean ProverkaRim() {
        boolean g1=false;
        boolean g2=false;


        for (int f = 1; f < 11; f++)
        {
            if (str[f].equals(numr1[0])) {
                g1 = true;
                break;
            }
        }
        for (int g = 1; g < 11; g++) {
            if (str[g].equals(numr1[2]))
            {

                g2 = true;
                break;
            }
        }
        if((g1 && !g2) || (!g1 && g2)) throw new ArithmeticException();// исключение

        if( g1 && g2)
            return (true);
        else return (false);
    }
    //----------При римских числах присваивание значения переменной num1,num2
    void PerevodisRimvArabik()
    {
        for(int u=1;u<11;u++)
        {
            if(numr1[0].equals(str[u])) {
                num1 = u;
                break;
            }
        }
        for(int t=1;t<11;t++)
        {
            if(numr1[2].equals(str[t])) {
                num2 = t;
                break;
            }
        }


    }
//--------------Функция вывод на экран(Сначала считает) потом при необходимости выводит на экран римское число макс 100


    void VivodNaEcran()
    {
        switch (op) {
            case '+' -> ans = num1 + num2;
            case '-' -> ans = num1 - num2;
            case '*' -> ans = num1 * num2;
            case '/' -> ans = num1 / num2;

        }
        if(ProverkaRim()) {
            if(ans<0) throw new ArithmeticException();// исключение
            System.out.println("output" + "\n" + str[ans]);
        }
        if(ProverkaArabica())

            System.out.println("output" + "\n" +  ans );

    }
}

