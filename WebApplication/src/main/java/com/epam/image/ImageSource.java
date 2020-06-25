package com.epam.image;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ImageSource {
    private String repository;

    public ImageSource(String repository) {
        this.repository = repository;
    }

    public void writeImage(BufferedImage image, String name) throws IOException {
        File file = new File(repository, String.format("%s.%s", name, "jpg"));
        ImageIO.write(image, "jpg", file);
    }

    public BufferedImage readImage(String name) throws IOException {
        File file = new File(repository, String.format("%s.%s", name, "jpg"));
        return ImageIO.read(file);
    }

    public void sendImage(BufferedImage image, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "private,no-cache,no-store");
        response.setContentType("image/jpeg");
        OutputStream responseStream = response.getOutputStream();
        ImageIO.write(image, "jpg", responseStream);
    }
}
