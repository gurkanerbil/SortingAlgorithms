package com.erbil.sortingalgorithms.sorts;

import android.content.Context;
import android.widget.Toast;

class RadixSort extends Sorting {
    String sortName;
    Context context;
    int[] numbers;

    RadixSort(String sortName, Context context, int[] numbers) {
        super(sortName, context, numbers);
        this.sortName = sortName;
        this.context = context;
        this.numbers = numbers;
    }

    public int[] sort() {
        int[][] np = new int[numbers.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f;

        for (k = 0; k < 4; k++) {

            for (i = 0; i < (np.length - 1); i++)
                np[i][1] = i + 1;
            np[i][1] = -1;

            for (i = 0; i < q.length; i++)
                q[i] = -1;

            for (f = i = 0; i < numbers.length; i++) {
                j = ((0xFF << (k << 3)) & numbers[i]) >> (k << 3);

                if (q[j] == -1)
                    l = q[j] = f;
                else {
                    l = q[j];

                    while (np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                }

                f = np[f][1];
                np[l][0] = numbers[i];
                np[l][1] = -1;
            }

            for (l = q[i = j = 0]; i < 0x100; i++)

                for (l = q[i]; l != -1; l = np[l][1]) {
                    numbers[j++] = np[l][0];
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
        return "n.(k/d)";
    }

    public String worst() {
        return "n.(k/d)";
    }

    public String average() {
        return "n+2^d";
    }

    public String getSortName() {
        return sortName;
    }

    public String memory() {
        return "n + 2^d";
    }

    public String stable() {
        return "Yes";
    }

    public String method() {
        return null;
    }

    public String n2k() {
        return "No";
    }
}
