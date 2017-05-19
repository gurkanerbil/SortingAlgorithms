package com.erbil.sortingalgorithms.sorts;

import android.content.Context;

class BucketSort extends Sorting {
    String sortName;
    Context context;
    int[] numbers;

    BucketSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }


    public int[] sort() {
        int[] bucket = new int[100];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int number : numbers) {
            bucket[number]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                numbers[outPos++] = i;
            }
        }
        return numbers;
    }

    public String best() {
        return null;
    }

    public String worst() {
        return "Uniform keys:(n^2)k\nInteger keys:n+r";
    }

    public String average() {
        return "Uniform keys:n+k \n Integer keys:n+r";
    }

    public String getSortName() {
        return sortName;
    }

    public String memory() {
        return "Uniform keys:nk\nInteger keys:n+r";
    }

    public String stable() {
        return "Yes";
    }

    public String method() {
        return null;
    }

    public String n2k() {
        return "Uniform keys:No\nInteger keys:Yes";
    }
}
