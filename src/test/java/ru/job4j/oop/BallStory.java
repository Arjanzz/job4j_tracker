package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball scaredBall = new Ball();
        Wolf hungryWolf = new Wolf();
        Fox slyFox = new Fox();
        Hare whiteHare = new Hare();
        whiteHare.tryEat(scaredBall);
        scaredBall.tryRun(false);
        hungryWolf.tryEat(scaredBall);
        scaredBall.tryRun(false);
        slyFox.tryEat(scaredBall);
        scaredBall.tryRun(true);
    }
}
