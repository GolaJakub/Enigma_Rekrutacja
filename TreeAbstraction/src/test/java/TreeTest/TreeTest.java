package TreeTest;

import Main.model.Tree.Branch;
import Main.model.Tree.Root;
import Main.model.Tree.Tree;
import Main.model.Tree.Trunk;
import org.junit.Assert;
import org.junit.Test;
import Main.model.Tree.ConiferousTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTest {


    private final static List<Branch> BRANCHES = new ArrayList<>(Arrays.asList(new Branch(4,5), new Branch(5,4)));
    private final static List<Root> ROOTS = new ArrayList<>(Arrays.asList(new Root(5),new Root(3),new Root(2)));
    private static final Tree CONIFER = ConiferousTree.builder().branches(BRANCHES).trunk(new Trunk(5)).roots(ROOTS).build();


    @Test
    public void isTreeGrowingCorrectly(){
        Assert.assertEquals(BRANCHES.size(),2);
        Assert.assertEquals(ROOTS.size(),3);
        Assert.assertEquals(CONIFER.getTrunk().getHeight(),5);

        CONIFER.grow();
        Assert.assertEquals(BRANCHES.size(),3);
        Assert.assertEquals(ROOTS.size(),4);
        Assert.assertEquals(CONIFER.getTrunk().getHeight(),7);

        CONIFER.grow();
        Assert.assertEquals(BRANCHES.size(),4);
        Assert.assertEquals(ROOTS.size(),5);
        Assert.assertEquals(CONIFER.getTrunk().getHeight(),9);
    }

    @Test
    public void isIntroducingDependsOnTreeType(){
        Assert.assertEquals("I am conifer and I have needles!\tTree(trunk=Trunk(height=5), branches=[Branch(length=4, leavesAmount=5), Branch(length=5, leavesAmount=4)], roots=[Root(length=5), Root(length=3), Root(length=2)])", CONIFER.introduceYourself());
    }


}
