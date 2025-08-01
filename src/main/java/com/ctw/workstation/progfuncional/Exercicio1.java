package com.ctw.workstation.progfuncional;

import org.hibernate.boot.model.internal.StrictIdGeneratorResolverSecondPass;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Exercicio1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "FS", "Academy", "CTW", "BMW", "/", "-");

        List<String> filteredWords = words.stream()
                .filter(word -> word.matches("^[A-Za-z]+$"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Exercicio 1 - " + filteredWords);

/// ///////////////////////////////////////////////////////
        
        List<String> numbers = Arrays.asList("43", "21", "54", "89", "137", "142", "751", "89", "137");

        Set<Integer> filteredNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Map<String, Integer> groupedNumbers = filteredNumbers.stream()
                        .collect(Collectors.groupingBy(
                                num -> (num % 2 == 0) ? "even" : "odd",
                                Collectors.summingInt(Integer::intValue)
                        ));

        System.out.println("Exercicio 2 - " + groupedNumbers);
        
        /// //////////////////////////////////////////////////
        
        String newVariable = "This is my variable";
        Optional<String> newOptional = Optional.of(newVariable);
        Optional<String> nullOptional = Optional.ofNullable(null);
        Optional<Integer> newOptionalLength = Optional.ofNullable(newVariable.length());

        if (!newOptional.isEmpty())
            System.out.println("Exercicio 3 - " + newOptional);
        else
            System.out.println("Exercicio 3 - " + "newOptional failed");
        newOptional.ifPresent(System.out::println);

        if (!nullOptional.isEmpty())
            System.out.println("Exercicio 3 - " + nullOptional);
        else
            System.out.println("Exercicio 3 - " + "nullOptional failed");
        nullOptional.ifPresent(System.out::println);
        nullOptional.ifPresentOrElse(System.out::println, () -> System.out.println("It's empty"));

        if (!newOptionalLength.isEmpty())
            System.out.println("Exercicio 3 - " + newOptionalLength);
        else
            System.out.println("Exercicio 3 - " + "newOptionalLength failed");
        newOptionalLength.ifPresent(System.out::println);

        /// ////////////////////////////////////////////////

        Function<List<String>, List<String>> filterOutNonAlphabetic = list -> list.stream()
                .filter(word -> word.matches("^[A-Za-z]+$"))
                .collect(Collectors.toList());

        Predicate<String> filterNonAlphabetic = word -> word.matches("^[A-Za-z]+$");

        Function<List<String>, List<String>> convertToUppercase = list -> list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        UnaryOperator<String> toUppercase = word -> word.toUpperCase();

        Function<List<String>, List<String>> getLengthOfWord = list -> list.stream()
                .map(word -> String.valueOf(word.length()))
                .collect(Collectors.toList());

        Function<String, Integer> length = word -> word.length();

        Function<List<String>, List<String>> addBrackets = list -> list.stream()
                .map(word -> "(" + word + ")")
                .collect(Collectors.toList());

        Function<Integer, String> insideParethesis = lengthVar -> "(" + lengthVar + ")";

        Function<List<String>, List<String>> chainedFunction = filterOutNonAlphabetic
                .andThen(convertToUppercase)
                .andThen(getLengthOfWord)
                .andThen(addBrackets);

        var composition = toUppercase.andThen(length.andThen(insideParethesis));
        var transformedList = words.stream()
                        .filter(filterNonAlphabetic)
                        .map(composition)
                        .collect(Collectors.toList());

        System.out.println("Exercicio 4 - " + transformedList);

        /// ////////////////////////////////
        List<String> numbers2 = Arrays.asList("43", "21", "54", "89", "137", "142", "751", "89", "137");

        Function<List<String>, List<Integer>> convertToInt = list -> list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<Function<List<String>, List<Integer>>, List<Integer>> squareList = function -> function.apply(numbers2)
                .stream().map(newNumber -> newNumber * newNumber)
                .collect(Collectors.toList());

        Function<String, Integer> toInt = Integer::parseInt;
        Function<Integer, Integer> square = number -> number * number;

        var composedFunction = toInt.andThen(square);
        var squareNumbers = numbers2.stream()
                .map(number ->composedFunction.apply(number))
                .collect(Collectors.toList());

        System.out.println("Exercicio 5 - " + squareNumbers);
    }
}
