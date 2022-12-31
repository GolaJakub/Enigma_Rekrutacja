package Main.model.Tree;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@ToString
@Getter
public abstract class Tree {
    private Trunk trunk;
    private List<Branch> branches;
    private List<Root> roots;


    private void growBranches() {
        for (Branch branch: branches) {
            branch.setLength(branch.getLength()+3);
            branch.setLeavesAmount(branch.getLeavesAmount()+4);
        }
        branches.add(new Branch(1,0));
    }

    private void growRoots() {
        for (Root root: roots) {
            root.setLength(root.getLength()+5);
        }
        roots.add(new Root(1));
    }

    private void growTrunk() {
        trunk.setHeight(trunk.getHeight()+2);
    }

    public void grow(){
        growBranches();
        growRoots();
        growTrunk();
    }
    //TODO rozne tempo wzrostu drzew

    public String introduceYourself(){
        return "I am Tree";
    }
}
