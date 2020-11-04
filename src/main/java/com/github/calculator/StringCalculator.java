package com.github.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
        
    public int add(String numbers) throws Exception {
    	List<String> delimiters = new ArrayList<>();
    	delimiters.add(",");delimiters.add("\n");
    	if(numbers.startsWith("//")) {
    		String delimiterString = numbers.substring(2, numbers.indexOf('\n'));
    		int start = -1, end = -1;
    		while( (start = delimiterString.indexOf('[', end + 1)) != -1 && (end = delimiterString.indexOf(']', end + 1)) != -1) {
    			delimiters.add(delimiterString.substring(start + 1, end));
    		}
    		numbers = numbers.substring(numbers.indexOf('\n') + 1 , numbers.length());
    	}
    	String replaceRegex = delimiters.stream().map(str -> "\\Q" + str + "\\E").reduce((a, b) -> a + "|" + b).get();
    	if(numbers.equals(""))
                return 0;
		if(delimiters.stream().anyMatch(numbers::contains)) {
                String delimiterSplit = replaceRegex;
                String[] split = numbers.split(delimiterSplit);
                Optional<Integer> sum = convertStringToInt(split).stream().reduce((a, b) -> a+b);
                return sum.get();
        }
        return Integer.parseInt(numbers);
    }
    
    private List<Integer> convertStringToInt(String[] numbers) throws Exception {
    	List<Integer> negativeNumbers = new ArrayList<>();
    	List<Integer> validNumbers = new ArrayList<>();
    	for (int i = 0; i < numbers.length; i++) {
			int num = Integer.parseInt(numbers[i]);
			if(num < 0)
				negativeNumbers.add(num);
			else if(num >= 0 && num <= 1000)
				validNumbers.add(num);
		}
    	if(!negativeNumbers.isEmpty()) throw new Exception("negatives not allowed " + negativeNumbers);
    	return validNumbers;
    }
}
