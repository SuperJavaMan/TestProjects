package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
            // analyze if an expression contains bracket and call to needed method
    public StringBuilder analyzeExpression(StringBuilder string){

        while (string.indexOf("(") >= 0){
            removeBrackets(string);      // remove all brackets and calculate expression
        }
        string.replace(0, string.length(), calculateExpression(string.toString())); // just remove old string and write a new calculated one

        return string; // return calculated string to display
    }

        // parse string for sight and number, and return string array of these
    private List<String> parsedStringArray(String string){
        List<String> elements = new ArrayList<>();

        Pattern pattern = Pattern.compile("[+\\-*/]?[\\d]+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()){
            elements.add(string.substring(matcher.start(), matcher.end()));
        }
        return elements;
    }
        // search first ")" from last "("
        // and rewrite string do not including last finding brackets
        // and call to calculating method with expression inside brackets
        private void removeBrackets(StringBuilder string) {
            int openBracketIndex = string.lastIndexOf("(");
            if (string.indexOf(")") < 0) {
                string.replace(openBracketIndex, string.length(), calculateExpression(string.substring(openBracketIndex)));
            } else {
                string.replace(openBracketIndex, string.indexOf(")", openBracketIndex), calculateExpression(string.substring(openBracketIndex, string.indexOf(")", openBracketIndex))));
            }
        }

    // analyze array with parsed expressions.
    // if expression has "* or /" neighborhood expressions
    // multiplied||divided without "*/" and
    // they removed from array
    // if expression does not contain *||/, all elements of the array just += with next element
    public String calculateExpression(String expression){

        List<String> collection = parsedStringArray(expression);
        String multiply;
        String divide;
        double result = 0;

        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).contains("*")){
                multiply = String.valueOf(Double.parseDouble(collection.get(i-1))*Double.parseDouble(collection.get(i).substring(1)));
                collection.set(i-1, multiply);
                collection.remove(i);
                --i;

            } else if (collection.get(i).contains("/")){
                divide = String.valueOf(Double.parseDouble(collection.get(i-1))/Double.parseDouble(collection.get(i).substring(1)));
                collection.set(i-1, divide);
                collection.remove(i);
                --i;
            }
        }
        for (String str : collection) {
            result += Double.parseDouble(str);
            }
        collection.clear();

        return String.valueOf(result);
    }
}

