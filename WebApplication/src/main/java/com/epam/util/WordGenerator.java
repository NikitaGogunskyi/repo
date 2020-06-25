package com.epam.util;

import nl.captcha.text.producer.TextProducer;

import java.util.Random;

/**
 * Object of this class is used for generating random four-digit numerical values for captcha {@link nl.captcha.Captcha}
 */
public class WordGenerator implements TextProducer {

    @Override
    public String getText() {
        return generateKeyWord();
    }

    private String generateKeyWord() {
        Random random = new Random();
        String result;
        result = String.valueOf(1000 + random.nextInt(8999));
        return result;
    }
}

