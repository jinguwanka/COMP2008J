package DealCard;
import java.util.ArrayList;
import java.util.List;

public enum CardColor {
    DarkBlue(),Brown,Utility,Green,Yellow,Red,Orange,Pink,LightBlue,Railroad,MultiColor;

    private List<Integer> rents = new ArrayList<>();

    private CardColor(int... rents) {
        for (int i : rents) {
            this.rents.add(i);
        }
    }
}
