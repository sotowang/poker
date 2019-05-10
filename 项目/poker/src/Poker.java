import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://school.thoughtworks.cn/learn/program-center/subjectiveQuiz/index.html#/student/program/195/task/3110/assignment/4213/quiz/1299
 */
public class Poker{

    public String compare(String black, String white) {

        return null;
    }


    /**
     * 同花顺
     *
     * @return
     */
    private int straightFlush(String cards) {
        if (straight(cards) == 5 && flush(cards) == 6) {
            return 9;
        }
        return 0;
    }

    /**
     * 铁支
     * @param cards
     * @return
     */
    private int fourOfAKind(String cards) {
        List<Integer> cardNum = splitNum(cards);
        Collections.sort(cardNum);
        int count = 1;
        for (int i = 1; i < cardNum.size(); i++) {
            if (cardNum.get(i).equals(cardNum.get(i - 1))) {
                count++;
            } else {
                count = 1;
            }
            if (count >= 4) {
                return 8;
            }
        }


        return 0;
    }

    /**
     * 葫芦
     * @param cards
     * @return
     */
    private int fullHouse(String cards) {
        if (threeOfAKind(cards) + pair(cards) == 6) {
            return 7;
        }
        return 0;
    }

    /**
     * 同花
     * @param cards
     * @return
     */
    private int flush(String cards) {
        List<String> cardColor = splitColor(cards);
        for (int i = 1; i < cardColor.size(); i++) {
            if (!cardColor.get(i).equals(cardColor.get(i - 1))) {
                return 0;
            }
        }
        return 6;
    }

    /**
     * 顺子
     * @param cards
     * @return
     */
    private int straight(String cards) {
        List<Integer> cardNum = splitNum(cards);
        Collections.sort(cardNum);

        for (int i = 1; i < cardNum.size(); i++) {
            if (cardNum.get(i) - cardNum.get(i - 1) != 1) {
                return 0;
            }
        }
        return 5;
    }

    /**
     * 三条
     * @param cards
     * @return
     */
    private int threeOfAKind(String cards) {
        List<Integer> cardNum = splitNum(cards);
        Collections.sort(cardNum);
        int count = 1;
        for (int i = 1; i < cardNum.size(); i++) {
            if (cardNum.get(i).equals(cardNum.get(i - 1))) {
                count++;
            }else {
                count = 1;
            }
            if (count == 3) {
                return 4;
            }
        }

        return 0;
    }

    /**
     * 两对
     * @param cards
     * @return
     */
    private int twoPairs(String cards) {

        List<Integer> cardNum = splitNum(cards);
        Collections.sort(cardNum);
        int count = 0;
        int temp = 1;
        for (int i = 1; i < cardNum.size(); i++) {
            if (cardNum.get(i).equals(cardNum.get(i - 1))) {
                temp++;
            }else {
                temp = 1;
            }
            if (temp == 2) {
                i++;
                count++;
                temp = 1;
            }
        }
        if (count == 2) {
            return 3;
        }
        return 0;
    }

    /**
     * 对子
     * @param cards
     * @return
     */
    private int pair(String cards) {
        List<Integer> cardNum = splitNum(cards);
        Collections.sort(cardNum);
        int count = 1;
        for (int i = 1; i < cardNum.size(); i++) {
            if (cardNum.get(i).equals(cardNum.get(i - 1))) {
                return 2;
            }
        }

        return 0;
    }


    /**
     * 散牌
     * @param cards
     * @return
     */
    private int highCard(String cards) {
        if (straightFlush(cards) + fullHouse(cards) + fourOfAKind(cards) + flush(cards)
                + straight(cards) + threeOfAKind(cards) + twoPairs(cards) + pair(cards) == 0) {
            return 1;
        }
        return 0;
    }

    private static ArrayList<Integer> splitNum(String cards) {
        cards =  cards.replaceAll("T", "10");
        cards =  cards.replaceAll("J", "11");
        cards =  cards.replaceAll("Q", "12");
        cards =  cards.replaceAll("K", "13");
        cards =  cards.replaceAll("A", "14");
        ArrayList<Integer> cardList = new ArrayList<>();
        String[] cardSplits = cards.split(" ");
        for (String card : cardSplits
        ) {
            cardList.add(Integer.valueOf(card.substring(0,card.length()-1)));
        }
        return cardList;
    }
    private static ArrayList<String> splitColor(String cards) {
        ArrayList<String> cardList = new ArrayList<>();
        String[] cardSplits = cards.split(" ");
        for (String card : cardSplits
        ) {
            cardList.add(card.substring(card.length()-1,card.length()));
        }

        return cardList;
    }



    public static void main(String[] args) {
//        ArrayList<Integer> list = splitNum("2H JC TS");
//        ArrayList<String> color = splitColor("2H JC TS");
//        for (String a : color
//        ) {
//            System.out.println(a);
//        }

        Poker poker = new Poker();


//        System.out.println(poker.pair("2H 3H 3H 3H 2H"));
//        System.out.println(poker.twoPairs("2H 2H 2H 2H 5H"));
//        System.out.println(poker.threeOfAKind("2H 3H 3H 3H 2H"));
//        System.out.println(poker.straight("2H 1H 3H 4H 5H"));
//        System.out.println(poker.flush("2H 2H 2H 2H 2H"));
//        System.out.println(poker.fullHouse("3H 3H 3H 2H 2H"));
        System.out.println(poker.fourOfAKind("2H 2H 3H 2H 2H"));
    }

}
