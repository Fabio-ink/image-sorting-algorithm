package com.imagesorter;

import java.util.List;

public class BubbleSort {
    public static void sort(List<ImageData> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).creationTime.isAfter(list.get(j + 1).creationTime)) {
                    ImageData temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}