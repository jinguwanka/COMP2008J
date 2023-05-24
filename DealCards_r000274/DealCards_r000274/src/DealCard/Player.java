package DealCard;

import java.util.*;

import view.Gui;
import view.PlayerPanel;

public class Player {

    private Bank bank;
    protected PlayPile playPile;
    private Map<CardColor, PropertyCards> propertyMap;
    private List<Wildcard> wildcards;
    private List<Player> players;

    public DealCardGame dealCardGame;
    private PlayerPanel playerPanel;

    private String name;
    private Gui gui;
    private Observer observer;

    public Player(String name) {
        this.name = name;
        bank = new Bank();
        playPile = new PlayPile();
        propertyMap = new LinkedHashMap<>();
        wildcards = new ArrayList<>();
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setPlayerPanel(PlayerPanel playerPanel) {
        this.playerPanel = playerPanel;
    }

    public Player rndPlayer() {
        Random random = new Random();
        ArrayList<Player> arrayList = new ArrayList<>(players);
        arrayList.remove(this);
        return arrayList.get(random.nextInt(arrayList.size()));
    }

    public PropertyCards getPropertyCards(Card card) {
        if (!(card instanceof RentCard)) {
            return null;
        }
        if (card.getCardColor() == CardColor.MultiColor) {
            ArrayList<PropertyCards> arrayList = new ArrayList<>(propertyMap.values());
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        }
        if (propertyMap.containsKey(card.getCardColor())) {
            return propertyMap.get(card.cardColor);
        } else if (propertyMap.containsKey(card.getSecondCardColor())) {
            return propertyMap.get(card.getSecondCardColor());
        }
        return null;
    }



    public boolean iswin() {
        int num = 0;
        for (PropertyCards propertyCards : propertyMap.values()) {
            if (propertyCards.isFull()) {
                num++;
            }
        }
        return num >= 3;
    }

    public Map<CardColor, PropertyCards> getPropertyMap() {
        return propertyMap;
    }

    private void dealbreaker(Card card) {
        Player player = rndPlayer();
        ArrayList<PropertyCards> arrayList = new ArrayList<>(player.getPropertyMap().values());
        player.getPropertyMap().clear();
        for (PropertyCards propertyCards : arrayList) {
            List<Card> cards = propertyCards.getCards();
            for (Card card1 : cards) {
                addCard(card1);
            }
        }
        observer.update(this, String.format(" %s dealbreaker for %s", card.getName(), player.getName()));
    }

    private void justsayno(Card card) {

    }



    private void debtcollector(Card card) {
        Player player = rndPlayer();
        List<Card> cards = player.getBank().getMoney(5);
        for (Card card2 : cards) {
            addCard(card2);
        }
        observer.update(this, String.format(" %s debtcollector for %s", card.getName(), player.getName()));
    }

    private void mybirthday(Card card) {
        ArrayList<Player> arrayList = new ArrayList<>(players);
        arrayList.remove(this);
        for (Player player : arrayList) {
            List<Card> list = player.getBank().getMoney(2);
            for (Card card1 : list) {
                addCard(card1);
            }
        }
        observer.update(this, String.format(" %s forcedeal for %s", card.getName(), "All players"));
    }

    public void action(Card card) {
        if (card instanceof RentCard) {
            rent(card);
        } else if (card instanceof ActionCard) {
            if (card.getName().equals("dealbreaker")) {
                dealbreaker(card);
            } else if (card.getName().equals("justsayno")) {
                justsayno(card);
            } else if (card.getName().equals("slydeal")) {
                slydeal(card);
            } else if (card.getName().equals("forcedeal")) {
                forcedeal(card);
            } else if (card.getName().equals("debtcollector")) {
                debtcollector(card);
            } else if (card.getName().equals("mybirthday")) {
                mybirthday(card);
            }
        }

    }

    public void action() {

    }

    public void getCardsFromDrawpile() {
        int n = 2;
        if (playPile.getActionCards().size() == 0) {
            n = 5;
        }
        for (int i = 0; i < n; i++) {
            addCard(dealCardGame.getDrawpile().popCard());
        }
    }

    public void nextPlayer() {
        dealCardGame.turn();
        playerPanel.display();
        if (dealCardGame.getDrawpile().getRubbishPeek() == null) {
            return;
        }
        gui.setRubbishImage(dealCardGame.getDrawpile().getRubbishPeek().imageString());

    }

    public void setDealCardGame(DealCardGame dealCardGame) {
        this.dealCardGame = dealCardGame;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<PropertyCards> propertyCards() {
        return new ArrayList<>(propertyMap.values());
    }

    public PlayPile getPlayPile() {
        return playPile;
    }

    public void dealCard(Card card) {
        action(card);
        playPile.remove(card);
        dealCardGame.getDrawpile().addRubbish(card);
        displayCards();
    }





    public PropertyCards maxNumPropertyCards() {
        PropertyCards maxCards = null;
        for (PropertyCards propertyCards : propertyMap.values()) {
            if (maxCards == null) {
                maxCards = propertyCards;
            } else {
                if (maxCards.propertyNum() < propertyCards.propertyNum()) {
                    maxCards = propertyCards;
                }
            }
        }
        return maxCards;
    }

    public Bank getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }
}
