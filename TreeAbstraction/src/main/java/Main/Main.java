package Main;


import Main.Seasons.Seasons;
import Main.model.Tree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static Seasons CURRENT_SEASON = Seasons.SPRING;

    private final static List<Branch> BRANCHES = new ArrayList<>(Arrays.asList(new Branch(4,5), new Branch(5,4)));
    private final static List<Root> ROOTS = new ArrayList<>(Arrays.asList(new Root(5),new Root(3),new Root(2)));
    private static final Tree CONIFER = ConiferousTree.builder().branches(BRANCHES).trunk(new Trunk(5)).roots(ROOTS).build();
    private static final Tree DECIDUOUS = DeciduousTree.builder().branches(BRANCHES).trunk(new Trunk(3)).roots(ROOTS).build();

    public static List<Tree> trees = new ArrayList<>();
    public static void main(String[] args) {
        trees.add(CONIFER);
        trees.add(DECIDUOUS);
        CURRENT_SEASON.changeSeason();
    }
}
