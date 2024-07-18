package ait.granates.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ait.granates.Constants.*;

public class Box implements Iterable<Pomegranate> {
    private String name;
    private List<Pomegranate> granates;

    public Box(String name) {
        this.name = name;
//        this.granates = new ArrayList<>();
//        for (int i = 0; i < new Random().nextInt(MIN_POMEGRANATES, MAX_POMEGRANATES); i++) {
//            addPomegranate(new Pomegranate());
//        }
        this.granates = IntStream
                .range(0, new Random().nextInt(MIN_POMEGRANATES, MAX_POMEGRANATES))
                .mapToObj(p -> new Pomegranate())
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void addPomegranate(Pomegranate pomegranate) {
        granates.add(pomegranate);
    }

    public int countSeeds() {
        int totalCount = 0;
        for (Pomegranate pomegranate : granates) {
            totalCount += pomegranate.countSeeds();
        }
        return totalCount;
//        return granates.stream()
//                .mapToInt(Pomegranate::countSeeds)
//                .sum();
    }

    public double totalWeight() {
        double totalWeight = 0.0;
        for (Pomegranate pomegranate : granates) {
            totalWeight += pomegranate.totalWeightSeeds();
        }
        return totalWeight;
//        return granates.stream()
//                .mapToDouble(Pomegranate::totalWeightSeeds)
//                .sum();
    }

    @Override
    public Iterator<Pomegranate> iterator() {
        return granates.iterator();
    }
}
