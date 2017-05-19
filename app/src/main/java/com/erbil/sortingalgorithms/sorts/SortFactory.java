package com.erbil.sortingalgorithms.sorts;

import android.content.Context;

public class SortFactory {
    String sortName;
    Context context;
    int[] numbers;

    public SortFactory(String sortName, Context context, int[] numbers) {
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }

    public Sorting getValues() {
        switch (sortName) {
            case ("Bubble Sort"):
                return new BubbleSort(sortName, context, numbers);
            case ("Merge Sort"):
                return new MergeSort(sortName, context, numbers);
            case ("Selection Sort"):
                return new SelectionSort(sortName, context, numbers);
            case ("Heap Sort"):
                return new HeapSort(sortName, context, numbers);
            case ("Insertion Sort"):
                return new InsertionSort(sortName, context, numbers);
            case ("Radix Sort"):
                return new RadixSort(sortName, context, numbers);
            case ("Shell Sort"):
                return new ShellSort(sortName, context, numbers);
            case ("Comb Sort"):
                return new CombSort(sortName, context, numbers);
            case ("Counting Sort"):
                return new CountingSort(sortName, context, numbers);
            case ("Bucket Sort"):
                return new BucketSort(sortName, context, numbers);
            default:
                break;
        }
        return null;
    }
}
