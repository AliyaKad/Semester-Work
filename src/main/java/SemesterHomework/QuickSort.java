package SemesterHomework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    static int i = 0;
    public static void main (String[]args){
        List<int[]> arraysList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("TestFile.txt"));) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbersStr = line.split(" ");
                int[] arr = new int[numbersStr.length];
                for (int i = 0; i < numbersStr.length; i++) {
                    arr[i] = Integer.parseInt(numbersStr[i]);
                }
                arraysList.add(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int number = 1;

        for (int[] arr : arraysList) {

            double start = System.nanoTime();
            quicksort(arr, 0, arr.length - 1);
            double finish = System.nanoTime();

            System.out.println("набор номер : " + number + " время выполнения : " + (finish - start)/1000000 + " количество итераций : " +i);
            i = 0;
            number = number + 1;

            for (int num : arr) {
                System.out.print(num + " ");
            }
           System.out.println();
        }
    }

    public static void quicksort(int[] arr, int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr, from, to);
            quicksort(arr, from, divideIndex - 1);
            quicksort(arr, divideIndex, to);
            i++;
        }
    }
    public static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from];
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
                i++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
                i++;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
                i++;
            }
        }
        return leftIndex;
    }

    public static void swap(int[] arr, int rightIndex, int leftIndex) {
        int i = arr[rightIndex];
        arr[rightIndex] = arr[leftIndex];
        arr[leftIndex] = i;
    }
}

