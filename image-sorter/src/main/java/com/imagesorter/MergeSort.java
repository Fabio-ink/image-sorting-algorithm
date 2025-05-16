package com.imagesorter;

import java.util.List;
import java.util.ArrayList;

public class MergeSort {
    public static void sort(List<ImageData> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        List<ImageData> left = new ArrayList<>(list.subList(0, mid));
        List<ImageData> right = new ArrayList<>(list.subList(mid, list.size()));

        sort(left);
        sort(right);
        merge(list, left, right);
    }

    private static void merge(List<ImageData> result, List<ImageData> left, List<ImageData> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).creationTime.isBefore(right.get(j).creationTime)) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (
            i < left.size()) result.set(k++, left.get(i++)
        );
        while (
            j < right.size()) result.set(k++, right.get(j++)
        );
    }
}