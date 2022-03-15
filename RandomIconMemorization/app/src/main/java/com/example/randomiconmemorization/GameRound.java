package com.example.randomiconmemorization;
import java.util.ArrayList;
import java.util.Random;
/*
Game Round Object
Use this to create the game
Holds a list of all the icons
Array to store order of icons
randomly selects one of the five icons stored
 */
public class GameRound {
    private ArrayList<Icon> iconList;
    private  ArrayList<Icon> order;
    //private Icon[] iconList;
    //private Icon[] order = new Icon[0];

    public GameRound() {
        iconList = new ArrayList<Icon>();
        iconList.add(new Icon("Red"));
        iconList.add(new Icon("Blue"));
        iconList.add(new Icon("Green"));
        iconList.add(new Icon("Orange"));
        iconList.add(new Icon("Purple"));
        iconList.add(new Icon("Brown"));
        nextLevel();

    //{new Icon("Red"), new Icon("Blue"),new Icon("Green"), new Icon("Orange"), new Icon("Purple"), new Icon("Brown")};
    }

    public ArrayList<Icon> getOrder() {
        return order;
    }

    public int getOrderLength(){
        return order.size();
    }

    /*
    Randomly selects and adds Icon
     */
    public void nextLevel(){
        int rnd = new Random().nextInt(iconList.size());
        order.add(iconList.get(rnd));
    }

    /*
    Checks Position if icon matches
     */
    public boolean checkCorrect(String name, int orderNumber){
        boolean correct;
        if (order.get(orderNumber).getName().equals(name)){
            correct = true;
        }else{
            correct = false;
        }

        return correct;
    }
}
