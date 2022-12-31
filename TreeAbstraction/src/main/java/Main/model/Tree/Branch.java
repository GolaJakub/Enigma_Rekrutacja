package Main.model.Tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Branch {
    private int length;
    private int leavesAmount;
}
