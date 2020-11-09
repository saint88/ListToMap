package com.company;

//Необходимо написать метод, который на вход получит список объектов типа T (использовать java generics),
// а на выходе возвращает Map<T, Integer>, где ключ T - объект из Map, а значение ключа (Integer) - количество вхожений
// элемента в список. Так же Map, которая возвращается из метода необходимо отсортировать по возрастанию значений
// (числа вхождений элемента в список List). Алгоритм сортировки можно взять любой кроме "пузырька" и встроенные методы сортировки нельзя.

//search - метод получения количества вхождений объекта в список
//сортировка

import com.company.list.ListUtils;
import com.company.list.ListUtilsInt;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("3");
        list.add("3");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("4");

        Map<String, Integer> result = new HashMap<>();

        ListUtilsInt<String> listUtils = new ListUtils<>(list);

        while(!list.isEmpty()) {
            int number = listUtils.search(list.get(0));
            result.put(list.get(0), number);
            listUtils.remove(list.get(0));
        }

        List<Map.Entry<String, Integer>> map = result.entrySet().stream()
            .sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e2.getValue() - e1.getValue())
            .collect(Collectors.toList());

        for(Map.Entry<String, Integer> entry : map) {
            System.out.println(String.format("key=%s and value=%d", entry.getKey(), entry.getValue()));
        }

    }
}
