package Main.model.Tree;

import Main.Seasons.Seasons;
import lombok.experimental.SuperBuilder;

import static Main.Main.CURRENT_SEASON;

@SuperBuilder
public class DeciduousTree extends Tree {
    @Override
    public String introduceYourself() {
        if (CURRENT_SEASON.equals(Seasons.WINTER)) {
            dropLeaves();
            return "I am deciduous tree and I've had leaves but now it's winter!\t" + this.toString();
        }
        return "I am deciduous tree and I have leaves!\t" + this.toString();
    }

    public void dropLeaves() {
        this.getBranches().forEach(branch -> branch.setLeavesAmount(0));
    }
}
