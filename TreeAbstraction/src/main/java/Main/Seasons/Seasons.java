package Main.Seasons;

import java.util.concurrent.TimeUnit;

import static Main.Main.CURRENT_SEASON;
import static Main.Main.trees;

public enum Seasons {
    SPRING, SUMMER, AUTUMN, WINTER;

    public void changeSeason() {
        while (true) {
            System.out.println("Current season is: " + CURRENT_SEASON);
            trees.forEach(tree -> {
                System.out.println(tree.introduceYourself());
                tree.grow();
            });
            CURRENT_SEASON = switch (CURRENT_SEASON) {
                case SPRING -> Seasons.SUMMER;
                case SUMMER -> Seasons.AUTUMN;
                case AUTUMN -> Seasons.WINTER;
                case WINTER -> Seasons.SPRING;
            };

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }
}
