package com.erbil.sortingalgorithms.sorts;

import android.content.Context;
import android.widget.Toast;

class HeapSort extends Sorting {
    String sortName;
    Context context;
    int[] numbers;
    private int N;

    HeapSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }

    public int[] sort() {

        heapify(numbers);

        for (int i = N; i > 0; i--) {
            swap(numbers, 0, i);
            N = N - 1;
            maxheap(numbers, 0);
        }

        return numbers;
    }

    private void heapify(int arr[]) {
        N = arr.length - 1;

        for (int i = N / 2; i >= 0; i--)
            maxheap(arr, i);
    }

    private void maxheap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;

        if (left <= N && arr[left] > arr[i])
            max = left;

        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }

        String numbersString = "";

        for (int number : arr) {
            numbersString += number + " ";
        }

        Toast.makeText(context, numbersString, Toast.LENGTH_SHORT).show();
    }

    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
