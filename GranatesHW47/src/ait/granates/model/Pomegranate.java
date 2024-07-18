package ait.granates.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ait.granates.Constants.*;

public class Pomegranate implements Iterable<Seed> {
    private List<Seed> seeds;

    public Pomegranate() {
//        this.seeds = new ArrayList<>();
//        for (int i = 0; i < new Random().nextInt(MIN_SEEDS, MAX_SEEDS); i++) {
//            addSeed(new Seed(SEED_WEIGHT));
//        }
        this.seeds = IntStream
                .range(0, new Random().nextInt(MIN_SEEDS, MAX_SEEDS))
                .mapToObj(p -> new Seed(SEED_WEIGHT))
                .collect(Collectors.toList());
    }

    public void addSeed(Seed seed) {
        seeds.add(seed);
    }

    public int countSeeds() {
        return seeds.size();
    }

    public double totalWeightSeeds() {
        double totalWeight = 0.0;
        for (Seed seed : seeds) {
            totalWeight += seed.getWeight();
        }
        return totalWeight;
//      return seeds.stream()
//                .mapToDouble(Seed::getWeight)
//                .sum();
    }

    @Override
    public Iterator<Seed> iterator() {
        return seeds.iterator();
    }
}
