package com.epam.image;

import com.epam.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.epam.constant.Attribute.USER;
import static com.epam.constant.Parameter.AVATARS_SOURCE;
import static com.epam.constant.Parameter.REPOSITORY_PATH;

@WebServlet("/avatar")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);
        ImageSource imageSource = new ImageSource(REPOSITORY_PATH + AVATARS_SOURCE);
        BufferedImage image = imageSource.readImage(String.valueOf(user.getId()));
        imageSource.sendImage(image, response);
    }
}
