package com.imagesorter;

import java.util.List;

public class QuickSort {
    public static void sort(List<ImageData> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(List<ImageData> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static int partition(List<ImageData> list, int low, int high) {
        ImageData pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).creationTime.isBefore(pivot.creationTime)) {
                i++;
                ImageData temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        ImageData temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}