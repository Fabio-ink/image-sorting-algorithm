package com.imagesorter;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ImageSorterMain {

    public static void main(String[] args) {
        Path folder = Paths.get("/home/fluxyfp/Downloads/PastaImagensAps/ISatelitales"); //Caminho da pasta com as imagens
        List<ImageData> images = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry) && isImage(entry)) {
                    BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                    images.add(new ImageData(entry, attrs.creationTime().toInstant()));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
            return;
        }

        System.out.println("Total de imagens encontradas: " + images.size());

        List<ImageData> imagesToSort = new ArrayList<>(images);

        long start = System.nanoTime();
        BubbleSort.sort(imagesToSort);
        //MergeSort.sort(imagesToSort);
        //QuickSort.sort(imagesToSort);
        long end = System.nanoTime();

        System.out.println("Tempo de ordenação: " + ((end - start) / 1_000_000) + " ms");

        //for (ImageData img : imagesToSort) {
            //System.out.println(img.creationTime + " - " + img.path.getFileName()); //mostrando que esta ordenando de forma correta
        //}

    }

    private static boolean isImage(Path path) {
        String name = path.getFileName().toString().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")
            || name.endsWith(".bmp") || name.endsWith(".gif");
    }
}