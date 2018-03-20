package myProject.auto.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {
    private static String productCount = "1";
    private static String productName = "Blouse";
    private static String productPrice = "26,99 ₴";
    private final static String words = "йцукенгшлгшщпамитььтимсчывватвивпатаввяиаиаааааааа";
    private final static String wordsMail = "ghjsnsmyudhkjtymnmdsmnrshyjftyjfty";
    private final static String index = "11125";
    private final static String confirmOrderMessage = "\uE876ВАШ ЗАКАЗ ПОДТВЕРЖДЁН";
    private final static int countValue = 280;
    private static StringBuilder builder;

    public static int getCountValue() {
        return countValue;
    }

    public static String getConfirmOrderMessage() {
        return confirmOrderMessage;
    }

    public static String getIndex() {
        return index;
    }

    public static String randomStringEmail() {
        String s = genString(5);
        String sy = s + "@gmail.com";
        return sy;
    }

    public static String genString(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s = s + Character.toString((char) genInt(97, 120));
        }
        return s;
    }

    public static int genInt(int from, int to) {
        int value;
        value = (int) (from + Math.round((Math.random() * (to - from))));
        return value;
    }

    public static String genIntIndex(int from, int to) {
        int value;
        value = (int) (from + Math.round((Math.random() * (to - from))));
        return String.valueOf(value);
    }

    public static String randomStringSecondName() {
        Set<String> identifiers = new HashSet<>();
        Random rand = new Random();
        builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(words.charAt(rand.nextInt(words.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public static String randomStringFirstName() {
        Set<String> identifiers = new HashSet<>();
        Random rand = new Random();
        builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(wordsMail.charAt(rand.nextInt(wordsMail.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }

        }
        return builder.toString();
    }

    public static String getProductCount() {
        return productCount;
    }

    public static String getProductName() {
        return productName;
    }

    public static String getProductPrice() {
        return productPrice;
    }


    public static void main(String[] args) {
    }
}
