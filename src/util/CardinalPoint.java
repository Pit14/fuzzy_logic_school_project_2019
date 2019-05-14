package util;

import java.util.Random;

enum CardinalPoint { N, NE, E, SE, S, SW, W, NW;

public static CardinalPoint getRandomDirection(){
    Random rand = new Random();
    return values()[rand.nextInt(values().length)];
}
}

