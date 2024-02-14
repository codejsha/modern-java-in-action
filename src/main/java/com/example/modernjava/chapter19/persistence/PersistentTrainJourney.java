package com.example.modernjava.chapter19.persistence;

import java.util.function.Consumer;

public class PersistentTrainJourney {
    /**
     * Append a train journey to another train journey.
     * This method is not pure, because it changes the state of the input parameter.
     *
     * @param a first train journey
     * @param b second train journey
     * @return the first train journey with the second train journey appended
     */
    public static TrainJourney link(TrainJourney a, TrainJourney b) {
        if (a == null) {
            return b;
        }
        TrainJourney t = a;
        while (t.onward != null) {
            t = t.onward;
        }
        t.onward = b;
        return a;
    }

    /**
     * Append a train journey to another train journey.
     * This method is pure, because it does not change the state of the input parameter.
     *
     * @param a first train journey
     * @param b second train journey
     * @return the first train journey with the second train journey appended
     */
    public static TrainJourney append(TrainJourney a, TrainJourney b) {
        return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
    }

    public static void visit(TrainJourney journey, Consumer<TrainJourney> c) {
        if (journey != null) {
            c.accept(journey);
            visit(journey.onward, c);
        }
    }

    /**
     * A train journey.
     */
    public static class TrainJourney {
        public int price;
        public TrainJourney onward;

        public TrainJourney(int p, TrainJourney t) {
            price = p;
            onward = t;
        }
    }
}
