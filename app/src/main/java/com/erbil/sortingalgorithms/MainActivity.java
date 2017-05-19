package com.erbil.sortingalgorithms;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.erbil.sortingalgorithms.sorts.SortFactory;
import com.erbil.sortingalgorithms.sorts.Sorting;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Button mSelectionSort;
    Button mBubbleSort;
    Button mInsertionSort;
    Button mRadixSort;
    Button mMergeSort;
    Button mHeapSort;
    Button mShellSort;
    Button mCombSort;
    Button mCountingSort;
    Button mBucketSort;

    BottomSheetDialog bottomSheetDialog;
    @BindView(R.id.show_algorithms_button)
    Button mShowAlgorithmsButton;
    @BindView(R.id.restart_button)
    Button mRestartButton;
    @BindView(R.id.sort_name)
    TextView mSortNameText;
    @BindView(R.id.numbers)
    TextView mNumbersText;
    @BindView(R.id.best_text)
    TextView mBestText;
    @BindView(R.id.average_text)
    TextView mAverageText;
    @BindView(R.id.worst_text)
    TextView mWorstText;
    @BindView(R.id.memory_text)
    TextView mMemoryText;
    @BindView(R.id.stable_text)
    TextView mStableText;
    @BindView(R.id.method_text)
    TextView mMethodText;
    @BindView(R.id.n2k_text)
    TextView mN2K;
    int mWidthScreen;
    int numbers[] = {3, 4, 12, 5, 7, 1, 15, 8};

    Sorting sorting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        mWidthScreen = display.getWidth();
        mRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumbers(numbers);
                buttonClick(numbers, "");
            }
        });

        mShowAlgorithmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                View parentView = getLayoutInflater().inflate(R.layout.activity_menu, null);
                bottomSheetDialog.setContentView(parentView);
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) parentView.getParent());

                bottomSheetBehavior.setPeekHeight((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics()));
                bottomSheetDialog.show();

                mSelectionSort = (Button) parentView.findViewById(R.id.selection_sort);
                mBubbleSort = (Button) parentView.findViewById(R.id.bubble_sort);
                mInsertionSort = (Button) parentView.findViewById(R.id.insertion_sort);
                mRadixSort = (Button) parentView.findViewById(R.id.radix_sort);
                mMergeSort = (Button) parentView.findViewById(R.id.merge_sort);
                mHeapSort = (Button) parentView.findViewById(R.id.heap_sort);
                mShellSort = (Button) parentView.findViewById(R.id.shell_sort);
                mCombSort = (Button) parentView.findViewById(R.id.comb_sort);
                mCountingSort = (Button) parentView.findViewById(R.id.counting_sort);
                mBucketSort = (Button) parentView.findViewById(R.id.bucket_sort);

                mBucketSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Bucket Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mCountingSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Counting Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mSelectionSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Selection Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mHeapSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Heap Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mBubbleSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Bubble Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mInsertionSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Insertion Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mRadixSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Radix Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mMergeSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Merge Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mShellSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Shell Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });

                mCombSort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sorting = (new SortFactory("Comb Sort", MainActivity.this, numbers)).getValues();
                        buttonClick(sorting.sort(), sorting.getSortName());
                        comparsion();
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bottomSheetDialog.isShowing())
            bottomSheetDialog.dismiss();
    }

    public void buttonClick(int[] numbers, String name) {
        String numbersString = "";

        for (int number : numbers) {
            numbersString += number + " ";
        }

        mSortNameText.setText(name);
        mNumbersText.setText(numbersString);

        int i = mRestartButton.getVisibility();
        if (i == View.VISIBLE) {
            mRestartButton.setVisibility(View.GONE);
            mShowAlgorithmsButton.setVisibility(View.VISIBLE);
            mBestText.setText("");
            mAverageText.setText("");
            mWorstText.setText("");
            mMemoryText.setText("");
            mStableText.setText("");
            mMethodText.setText("");
            mN2K.setText("");

        } else if (i == View.GONE) {
            bottomSheetDialog.hide();
            mRestartButton.setVisibility(View.VISIBLE);
            mShowAlgorithmsButton.setVisibility(View.GONE);

        }
    }

    public void randomNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(99);
        }
    }

    public void comparsion() {
        mBestText.setText(sorting.best());
        mAverageText.setText(sorting.average());
        mWorstText.setText(sorting.worst());
        mMemoryText.setText(sorting.memory());
        mStableText.setText(sorting.stable());
        mMethodText.setText(sorting.method());
        mN2K.setText(sorting.n2k());
    }
}
