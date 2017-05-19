package com.erbil.sortingalgorithms.sorts;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

class SelectionSort extends Sorting {

    String sortName;
    Context context;
    int[] numbers;

    SelectionSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }

    public int[] sort() {
        int tmp;
        int min;

        for (int i = 0; i < numbers.length - 1; i++) {
            min = i;

            for (int j = i; j < numbers.length; j++) {

                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            tmp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = tmp;
            String numbersString = "";

            for (int number : numbers) {
                numbersString += number + " ";
            }

            Log.d("Numbers: ", numbersString);
            Toast.makeText(context, numbersString, Toast.LENGTH_SHORT).show();
        }
        return numbers;
    }

    public String best() {
        return "n^2";
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
        return "No";
    }

    public String method() {
        return "Selection";
    }

    public String n2k() {
        return null;
    }
}
