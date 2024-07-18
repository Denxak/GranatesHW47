package ait.granates;

import ait.granates.model.Box;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

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

        IntSummaryStatistics countSeeds = boxes.stream()
                .mapToInt(Box::countSeeds)
                .summaryStatistics();
        System.out.println("Total seeds in all boxes = " + countSeeds.getSum());

        System.out.println("Max seeds in one box = " + countSeeds.getMax());

        System.out.println("Min seeds in one box = " + countSeeds.getMin());

        DoubleSummaryStatistics totalWeight = boxes.stream()
                .mapToDouble(Box::totalWeight)
                .summaryStatistics();
        System.out.println("Max weight in one box = " + totalWeight.getMax());

        System.out.println("Min weight in one box = " + totalWeight.getMin());

        System.out.println("Total weight in all boxes= " + totalWeight.getSum());

        System.out.println("=== Find names of boxes with maximum seeds ===");
        StreamSupport.stream(boxes.spliterator(), false)
                .filter(box -> box.countSeeds() == countSeeds.getMax())
                .map(Box::getName)
                .forEach(System.out::println);

        System.out.println("=== Find names of boxes with minimum seeds ===");
        StreamSupport.stream(boxes.spliterator(), false)
                .filter(box -> box.countSeeds() == countSeeds.getMin())
                .map(Box::getName)
                .forEach(System.out::println);

        System.out.println("=== Find names of boxes with minimum weight ===");
        StreamSupport.stream(boxes.spliterator(), false)
                .filter(box -> box.totalWeight() == totalWeight.getMin())
                .map(Box::getName)
                .forEach(System.out::println);

        System.out.println("=== Find names of boxes with maximum weight ===");
        StreamSupport.stream(boxes.spliterator(), false)
                .filter(box -> box.totalWeight() == totalWeight.getMax())
                .map(Box::getName)
                .forEach(System.out::println);
    }
}
