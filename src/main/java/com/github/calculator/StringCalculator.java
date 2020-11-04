package com.github.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
        
    public int add(String numbers) throws Exception {
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
                Optional<Integer> sum = convertStringToInt(split).stream().reduce((a, b) -> a+b);
                return sum.get();
        }
        return Integer.parseInt(numbers);
    }
    
    public List<Integer> convertStringToInt(String[] numbers) throws Exception {
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
