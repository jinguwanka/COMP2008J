package DealCard;

public class ActionCard extends Card {

    private String name;

    public ActionCard(String name, int value, int maxNum) {
        super(null, value, maxNum);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Returns the image path for the ActionCard
    // The image is assumed to be located in the "ActionCards" directory
    // with a file name based on the card's name
    public String imageString() {
        return "ActionCards/" + name + ".jpg";
    }
}
