package com.imagesorter;

import java.nio.file.Path;
import java.time.Instant;

public class ImageData {
    public Path path;
    public Instant creationTime;

    public ImageData(Path path, Instant creationTime) {
        this.path = path;
        this.creationTime = creationTime;
    }
}

//extrai os metadados da imagem, no caso a data de criação da imagem e define o caminho onde estão localizados as imagens.