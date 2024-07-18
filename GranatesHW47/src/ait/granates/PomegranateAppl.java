package ait.granates;

import ait.granates.model.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ait.granates.Constants.*;

public class PomegranateAppl {
    public static void main(String[] args) {
//        List<Box> boxes = new ArrayList<>();
//        for (int i = 0; i < new Random().nextInt(MIN_BOXES, MAX_BOXES); i++) {
//            boxes.add(new Box("NameBox" + (i)));
//        }
        List<Box> boxes = IntStream
                .range(0, new Random().nextInt(MIN_BOXES, MAX_BOXES))
                .mapToObj(b -> new Box("NameBox" + (b)))
                .collect(Collectors.toList());

        System.out.println("=== Calculate total seeds in all boxes ===");
        int total = boxes.stream()
                .mapToInt(Box::countSeeds)
                .sum();
        System.out.println("Total = " + total);

        System.out.println("=== Calculate maximum seeds in one box ===");
        int max = boxes.stream()
                .mapToInt(Box::countSeeds)
                .max()
                .orElse(0);
        System.out.println("Max = " + max);

        System.out.println("=== Find names of boxes with maximum seeds ===");
        List<String> boxesWithMaximumSeeds = boxes.stream()
                .filter(box -> box.countSeeds() == max)
                .map(Box::getName)
                .collect(Collectors.toList());
        boxesWithMaximumSeeds.forEach(System.out::println);
    }
}