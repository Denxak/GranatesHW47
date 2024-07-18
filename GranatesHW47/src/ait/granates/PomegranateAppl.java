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
        int totalSeedsAll = boxes.stream()
                .mapToInt(Box::countSeeds)
                .sum();
        System.out.println("Total = " + totalSeedsAll);

        System.out.println("=== Calculate maximum seeds in one box ===");
        int maxSeedsOneBox = boxes.stream()
                .mapToInt(Box::countSeeds)
                .max()
                .orElse(0);
        System.out.println("Max = " + maxSeedsOneBox);

        System.out.println("=== Calculate minimum seeds in one box ===");
        int minSeedsOneBox = boxes.stream()
                .mapToInt(Box::countSeeds)
                .min()
                .orElse(0);
        System.out.println("Max = " + minSeedsOneBox);

        System.out.println("=== Calculate maximum weight in one box ===");
        double totalMaxWeightOneBox = boxes.stream()
                .mapToDouble(Box::totalWeight)
                .max()
                .orElse(0);
        System.out.println("Max = " + totalMaxWeightOneBox);

        System.out.println("=== Calculate minimum weight in one box ===");
        double totalMinWeightOneBox = boxes.stream()
                .mapToDouble(Box::totalWeight)
                .min()
                .orElse(0);
        System.out.println("Max = " + totalMinWeightOneBox);

        System.out.println("=== Calculate total weight in all boxes ===");
        double totalWeidhtAll = boxes.stream()
                .mapToDouble(Box::totalWeight)
                .sum();
        System.out.println("Total = " + totalWeidhtAll);

        System.out.println("=== Find names of boxes with maximum seeds ===");
        List<String> boxesWithMaxSeeds = boxes.stream()
                .filter(box -> box.countSeeds() == maxSeedsOneBox)
                .map(Box::getName)
                .collect(Collectors.toList());
        boxesWithMaxSeeds.forEach(System.out::println);

        System.out.println("=== Find names of boxes with minimum weight ===");
        List<String> boxesWithMimWeight = boxes.stream()
                .filter(box -> box.totalWeight() == totalMinWeightOneBox)
                .map(Box::getName)
                .collect(Collectors.toList());
        boxesWithMimWeight.forEach(System.out::println);
    }
}
