package com.erbil.sortingalgorithms.sorts;

import android.content.Context;

class CombSort extends Sorting {

    String sortName;
    int[] numbers;
    Context context;

    CombSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.numbers = numbers;
        this.context = context;
    }

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public int[] sort() {
        int n = numbers.length;
        int gap = n;

        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (numbers[i] > numbers[i + gap]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + gap];
                    numbers[i + gap] = temp;

                    swapped = true;
                }
            }
        }
        return numbers;
    }

    public String best() {
        return "n logn";
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
        return "Exchanging";
    }

    public String n2k() {
        return null;
    }
}

