package com.erbil.sortingalgorithms.sorts;

import android.content.Context;
import android.widget.Toast;

class BubbleSort extends Sorting {

    String sortName;
    Context context;
    int[] numbers;

    BubbleSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }

    public int[] sort() {

        int temp;

        for (int i = 1; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length - i; j++) {

                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }

                String numbersString = "";

                for (int number : numbers) {
                    numbersString += number + " ";
                }

                Toast.makeText(context, numbersString, Toast.LENGTH_SHORT).show();
            }
        }
        return numbers;
    }

    public String best() {
        return "n";
    }

    public String worst() {
        return "n^2";
    }

    public String average() {
        return "n^2";
    }

    public String getSortName() {
        return sortName;
    }

    public String memory() {
        return "1";
    }

    public String stable() {
        return "Yes";
    }

    public String method() {
        return "Exchanging";
    }

    public String n2k() {
        return null;
    }
}

