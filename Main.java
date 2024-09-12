package org.example;

import java.util.Scanner;

class Luke_Number{
    //Клас, що представляє число Люка
    private int index;
    private int value;

    //конструктор класу
    public Luke_Number(int index, int value){
        this.index = index;
        this.value = value;
    }

    //Геттери
    public int getIndex() {return index;}
    public int getValue() {return value;}

    //Функція, що перевіряє чи відповідає число формулі
    public boolean isSuitable(){
        int possible = (int) Math.round(Math.cbrt(this.value - 1));
        return Math.pow(possible, 3) + 1 == this.value;
    }

    //Перезапис функції виведення на екран
    @Override
    public String toString() {
        return "Число з індексом " + (index + 1) + "(" + value + ")";
    }
}

//Основний клас
public class Main{

    //Головна функція
    public static void main(String[] args){
        System.out.println("Введіть кількість чисел: ");

        //Введення числа через клавіатуру
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        //Масив об'єктів класу
        Luke_Number[] Luke_nums = new Luke_Number[N];

        //Виклик функції генерування чисел Люка
        Generate(N, Luke_nums);

        //Виведення чисел на екран
        System.out.println("\nЗгенеровані числа Люка: ");
        for(Luke_Number luke : Luke_nums){
            System.out.print(luke.getValue() + " ");
        }
        System.out.println("\nЗагальна кількість чисел, що відповідають формулі: " + count(Luke_nums));
    }

    //Функція генерування
    public static void Generate(int N, Luke_Number[] Luke_nums) {
        if (N >= 1) Luke_nums[0] = new Luke_Number(0, 2);
        if (N >= 2) Luke_nums[1] = new Luke_Number(1, 1);

        for (int i = 2; i < N; i++) {
            int value = Luke_nums[i - 1].getValue() + Luke_nums[i - 2].getValue();
            Luke_nums[i] = new Luke_Number(i, value);
        }
    }

    /*Функція обчислення загальної кількості
      чисел, що відповідають формулі w^3 + 1
     */
    public static int count(Luke_Number[] Luke_nums){
        int count = 0;
        for (int i = 0; i < Luke_nums.length; i++){
            if (Luke_nums[i].isSuitable()){
                System.out.println("\n" + Luke_nums[i] + " Відповідає формулі w^3 + 1");
                count++;
            }
        }
        return count;
    }
};
