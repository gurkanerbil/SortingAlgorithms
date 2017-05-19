package com.erbil.sortingalgorithms.sorts;

import android.content.Context;

class CountingSort extends Sorting {

    String sortName;
    int[] numbers;
    Context context;

    CountingSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.numbers = numbers;
        this.context = context;
    }

    public int[] sort() {
        int[] aux = new int[numbers.length];
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            } else if (numbers[i] > max) {
                max = numbers[i];
            }

        }
        int[] counts = new int[max - min + 1];

        for (int number : numbers) {
            counts[number - min]++;
        }
        counts[0]--;

        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            aux[counts[numbers[i] - min]--] = numbers[i];
        }
        return aux;
    }

    public String best() {
        return null;
    }

    public String worst() {
        return "n+r";
    }

    public String average() {
        return "n+r";
    }

    public String getSortName() {
        return sortName;
    }

    public String memory() {
        return "n+r";
    }

    public String stable() {
        return "Yes";
    }

    public String method() {
        return null;
    }

    public String n2k() {
        return "Yes";
    }
}

