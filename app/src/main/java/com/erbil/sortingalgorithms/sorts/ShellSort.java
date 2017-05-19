package com.erbil.sortingalgorithms.sorts;

import android.content.Context;
import android.widget.Toast;

class ShellSort extends Sorting {
    String sortName;
    int[] numbers;
    Context context;

    ShellSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.numbers = numbers;
        this.context = context;
    }

    public int[] sort() {
        int inner, outer;
        int temp;

        int h = 1;
        while (h <= numbers.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < numbers.length; outer++) {
                temp = numbers[outer];
                inner = outer;

                while (inner > h - 1 && numbers[inner - h] >= temp) {
                    numbers[inner] = numbers[inner - h];
                    inner -= h;
                }
                numbers[inner] = temp;
                String numbersString = "";

                for (int number : numbers) {
                    numbersString += number + " ";
                }
                Toast.makeText(context, numbersString, Toast.LENGTH_SHORT).show();
            }
            h = (h - 1) / 3;
        }
        return numbers;
    }

    public String best() {
        return "n logn";
    }

    public String worst() {
        return "n log^2 n";
    }

    public String average() {
        return "(n log^2 n) or (n^(5/4))";
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
        return "Insertion";
    }

    public String n2k() {
        return null;
    }
}
