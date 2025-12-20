package com.java.version.eight.streams.level.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Top3FrequentWords {
    public static void main(String[] args) {
    //Q. find the 3 most frequent words in a paragraph
        String paragraph ="Java is great. Java is object oriented. Java Streams are powerful, and Java is fun!";

        Map<String, Long> map = Arrays.stream(
                paragraph.toLowerCase()
                        .replaceAll("[^a-z\\s]", "")
                        .split(" ")
        ).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    //{java=4, powerful=1, are=1, and=1, streams=1, is=3, oriented=1, great=1, fun=1, object=1}

        List<Map.Entry<String, Long>> out = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .toList();
        System.out.println(out);//[java=4, is=3, powerful=1] //why powerful only are=1 streams=1 oriented=1, great=1, fun=1, object=1

        //alternate way
        List<Map.Entry<String, Long>> sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .toList();
        System.out.println(sorted);
        //[java=4, is=3, powerful=1, are=1, and=1, streams=1, oriented=1, great=1, fun=1, object=1]

        List<Long> top3Frequencies = sorted.stream()
                .map(Map.Entry::getValue)
                .distinct()
                .limit(3)
                .toList();
        System.out.println(top3Frequencies); //[4, 3, 1]

        List<Map.Entry<String, Long>> top3Words = sorted.stream()
                .filter(e -> top3Frequencies.contains(e.getValue()))
                .toList();
        System.out.println(top3Words);
        //[java=4, is=3, powerful=1, are=1, and=1, streams=1, oriented=1, great=1, fun=1, object=1]
    }
}
