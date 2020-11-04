package com.github.calculator;

import java.util.Arrays;
import java.util.Optional;

public class StringCalculator {
        
        public int add(String numbers) {
                if(numbers.equals(""))
                        return 0;
                if(numbers.contains(",")) {
                        String[] split = numbers.split(",");
                        Optional<Integer> sum = Arrays.stream(split).map(Integer::parseInt).reduce((a, b) -> a+b);
                        return sum.get();
                }
                return Integer.parseInt(numbers);
        }
}
