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

        IntSummaryStatistics intCountSeeds = boxes.stream()
                .mapToInt(Box::countSeeds)
                .summaryStatistics();
        System.out.println("Total seeds in all boxes = " + intCountSeeds.getSum());

        System.out.println("Max seeds in one box = " + intCountSeeds.getMax());

        System.out.println("Min seeds in one box = " + intCountSeeds.getMin());

        DoubleSummaryStatistics doubleTotalWeight = boxes.stream()
                .mapToDouble(Box::totalWeight)
                .summaryStatistics();
        System.out.println("Max weight in one box = " + doubleTotalWeight.getMax());

        System.out.println("Min weight in one box = " + doubleTotalWeight.getMin());

        System.out.println("Total weight in all boxes= " + doubleTotalWeight.getSum());

        System.out.println("=== Find names of boxes with maximum seeds ===");
        Iterable<Box> boxesSeeds = boxes.stream()
                .collect(Collectors.toList());
        StreamSupport.stream(boxesSeeds.spliterator(), false)
                .filter(box -> box.countSeeds() == intCountSeeds.getMax())
                .map(Box::getName)
                .forEach(System.out::println);

        System.out.println("=== Find names of boxes with minimum weight ===");
        Iterable<Box> boxesWeight = boxes.stream()
                .collect(Collectors.toList());
        StreamSupport.stream(boxesWeight.spliterator(), false)
                .filter(box -> box.totalWeight() == doubleTotalWeight.getMin())
                .map(Box::getName)
                .forEach(System.out::println);
    }
}
