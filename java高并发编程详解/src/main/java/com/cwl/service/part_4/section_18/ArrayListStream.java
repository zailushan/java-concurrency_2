package com.cwl.service.part_4.section_18;

import java.util.Arrays;
import java.util.List;

/**
 * @author cwl
 * @description: TODO
 * @date 2019/12/2819:16
 */
public class ArrayListStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Thread", "Concurrentcy", "Scala", "Clojure");

        list.parallelStream().map(String::toUpperCase).forEach(System.out::println);
        list.forEach(System.out::println);
    }
}
