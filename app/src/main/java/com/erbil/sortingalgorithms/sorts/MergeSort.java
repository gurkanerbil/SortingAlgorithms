package com.erbil.sortingalgorithms.sorts;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

class MergeSort extends Sorting {
    String sortName;
    Context context;
    int[] numbers;

    MergeSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }

    public int[] sort() {
        return mergeSort(0, numbers.length - 1);
    }

    private int[] tmpNumbers = new int[8];

    private int[] mergeSort(int first, int last) {
        int[] _numbers = new int[8];

        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            _numbers = merge(first, middle + 1, last);
        }
        return _numbers;
    }

    private int[] merge(int first, int middle, int last) {
        int firstIndex = first;
        int lastIndex = middle - 1;
        int index = last - first + 1;

        while ((first <= lastIndex) && (middle <= last)) {

            if (numbers[first] <= numbers[middle]) {
                tmpNumbers[firstIndex] = numbers[first];
                firstIndex++;
                first++;
            } else {
                tmpNumbers[firstIndex] = numbers[middle];
                firstIndex++;
                middle++;
            }
        }

        while (first <= lastIndex) {
            tmpNumbers[firstIndex] = numbers[first];
            first++;
            firstIndex++;
        }

        while (middle <= last) {
            tmpNumbers[firstIndex] = numbers[middle];
            middle++;
            firstIndex++;
        }

        for (int i = 0; i < index; i++) {
            numbers[last] = tmpNumbers[last];
            last--;
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
        return "n logn";
    }

    public String worst() {
        return "n logn";
    }

    public String average() {
        return "n logn";
    }

    public String getSortName() {
        return sortName;
    }

    public String memory() {
        return "n";
    }

    public String stable() {
        return "Yes";
    }

    public String method() {
        return "Merging";
    }

    public String n2k() {
        return null;
    }
}
