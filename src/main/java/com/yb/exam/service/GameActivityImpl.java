package com.yb.exam.service;

import com.yb.exam.bean.Player;
import com.yb.exam.constants.GameConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GameActivityImpl implements IGameActivity {


    @Override
    public int randomNumber(int range) {
        return new Random().nextInt(range)+1;
    }

    @Override
    public int compare(int targetNum, int inputNum) {
        return 0;
    }

    @Override
    public Map<String,Player> registerPlayer(Scanner scan) {
        Map<String, Player> players = new HashMap<>();
        Set<String> playerNames = players.keySet();
        while(players.size() < GameConstant.PLAYER_NUMBER){
            System.out.println("please enter player name: ");
            String name = scan.next();
            if(playerNames.contains(name)){
                System.out.println("The name is repeated, please change to another one....");
            }else {
                Player player = new Player();
                player.setPlayName(name);
                players.put(name,player);
            }
        }
        return players;
    }

    @Override
    public void guessAndCheck(Map<String, Player> players, Scanner scan, int targetNum) {
        for(String playerName : players.keySet()){
            System.out.print("Please enter your guess player: "+playerName+" ");
            try {
                int guessNum = scan.nextInt();
                if(guessNum>GameConstant.LOW_RANGE &&guessNum<=GameConstant.HIHG_RANGE){
                    Player player= players.get(playerName);
                    player.getGuessNum().add(guessNum);
                    if(guessNum == targetNum){
                        player.addStore();
                    }
                }
            } catch (Exception e) {
                System.out.println("please enter num from"+ GameConstant.LOW_RANGE +"to "+GameConstant.HIHG_RANGE);
                System.exit(-1);
            }
        }
    }

    @Override
    public void showRoundResult(Map<String, Player> players, int[] targetNumArr) {
       for(int i =1; i<= GameConstant.ROUND; i++){
           StringBuilder winners = new StringBuilder();
           System.out.println("Guess the number for the Round "+i +" : "+targetNumArr[i-1]);
          for(String playerName : players.keySet()){
                  if(players.get(playerName).getGuessNum().get(i-1) == targetNumArr[i-1]){
                    winners.append("Player: "+playerName+"\n");
                  }
          }
          if("".equals(winners.toString())){
              winners.append("No Winner");
          }else{
              System.out.println("Winner/s");
          }
           System.out.println(winners.toString());
        }
    }

    @Override
    public void showPlayerResult(Map<String, Player> players, int[] targetNumArr) {
        int maxScore = 0;
        for(String playerName : players.keySet()){
            System.out.println("Player Name: " +playerName);
            for(int i =1; i<= GameConstant.ROUND; i++){
                System.out.println("Round "+i+"Guess value: "+players.get(playerName).getGuessNum().get(i-1)+
                    " correct value: "+targetNumArr[i-1]);
            }
            int score = players.get(playerName).getStore();
            System.out.println("Your socre is "+score);
            maxScore = maxScore > score ? maxScore : score;
        }
        getOverallWinner(players,maxScore);
    }

    private void getOverallWinner(Map<String, Player> players,int maxScore) {
        System.out.println("The overall Winners: ");
        StringBuilder stringBuilder = new StringBuilder();
        players.forEach((name,player)->{
            if(player.getStore() == maxScore){
                stringBuilder.append(name+"\n");
            }
        });
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
//        IGameActivity iGameActivity  = new GameActivityImpl();
//        Scanner scan=new Scanner(System.in);
//        Map<String, Player> players = iGameActivity.registerPlayer(scan);
//        for(int i = 0 ; i< GameConstant.ROUND; i++){
//            System.out.println("Round "+i);
//            int targetNum = iGameActivity.randomNumber(GameConstant.HIHG_RANGE);
//            System.out.println("targetNum: "+targetNum);
//            iGameActivity.guessAndCheck(players,scan,targetNum);
//        }
//        players.forEach((playName,player)->{
//            System.out.println(playName+"--"+player);
//        });
        StringBuilder winners = new StringBuilder();
        System.out.println(winners.toString().equals(""));
        System.out.println(winners.toString());
    }
}
