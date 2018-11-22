package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Counter {

    String numbers = "-3*33/95+75.356+95+23.2345+89-89+52-3/33*95";


    public String parsingString(String parsingString){
        String multiply = "";
        String divide = "";
        double result = 0;
        ArrayList<String> elements = new ArrayList<>();

        Pattern pattern = Pattern.compile("[+\\-*/]?[\\d]+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(parsingString);

        while (matcher.find()){
            String string = parsingString.substring(matcher.start(), matcher.end());
            elements.add(string);
        }

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).indexOf("*") != -1){
                multiply = String.valueOf(Double.parseDouble(elements.get(i-1))*Double.parseDouble(elements.get(i).substring(1)));
                elements.set(i-1, multiply);
                elements.remove(i);
                --i;

            } else if (elements.get(i).indexOf("/") != -1){
                divide = String.valueOf(Double.parseDouble(elements.get(i-1))/Double.parseDouble(elements.get(i).substring(1)));
                elements.set(i-1, divide);
                elements.remove(i);
                --i;
            }
        }
        for (String str : elements) {
            result += Double.parseDouble(str);

        }
        elements.clear();

        return String.valueOf(result);
//        return elements.toString();
//        return elements.get(0);

    }

    public String brakets(String expression){
        String removeBrakets = "Don't work";
        String minusBraket = "1";
        String result = "Don't work";

        while (expression.indexOf("(") != -1) {
            Pattern pattern = Pattern.compile("[(]{1}?[\\-\\d.+\\-*/]*?[)]{1}?");
            Matcher matcher = pattern.matcher(expression);

            while (matcher.find( )) {
                removeBrakets = expression.substring(matcher.start( ), matcher.end( ));
            }
            minusBraket = removeBrakets.substring(1, removeBrakets.length( ) - 1);
//            result = parsingString(minusBraket);
            expression = matcher.replaceAll(parsingString(minusBraket));
        }
//        return minusBraket;
        return parsingString(expression);
    }

}
