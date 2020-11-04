package com.github.calculator;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {
        
        public int add(String numbers) {
        	String delimiter = "";
        	if(numbers.startsWith("//")) {
        		delimiter = numbers.substring(0, numbers.indexOf('\n')).replace("//", "");
        		numbers = numbers.substring(numbers.indexOf('\n') + 1 , numbers.length());
        	}
            if(numbers.equals(""))
                    return 0;
            if(numbers.contains(",") || numbers.contains("\n") || numbers.contains(delimiter)) {
                    String delimiterSplit = "[,\n" + delimiter + "]";
                    String[] split = numbers.split(delimiterSplit);
                    Optional<Integer> sum = Arrays.stream(split).map(Integer::parseInt).reduce((a, b) -> a+b);
                    return sum.get();
            }
            return Integer.parseInt(numbers);
        }
}
