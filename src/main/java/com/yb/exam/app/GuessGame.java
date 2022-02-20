package com.yb.exam.app;

import com.yb.exam.bean.Player;
import com.yb.exam.constants.GameConstant;
import com.yb.exam.service.GameActivityImpl;
import com.yb.exam.service.IGameActivity;
import java.util.Map;
import java.util.Scanner;

/**
 *1. Your application should have 5 players. Player names should be entered.
 * 2. Your application should have 5 rounds of number guessing game
 * 3. Each player should be able to input a number for each round; number should be between 1-10
 * 4. A player will win the round if he guessed the random number correctly
 * 5. System will display all results after all rounds. Results should include winner of each round,
 * player history with score, and overall winner of the entire game.
 * 6. Try again feature is required
 * 7. Error handling is optional
 */
public class GuessGame {

    //game starter
    public void start() {
        Scanner scan=new Scanner(System.in);
        IGameActivity iGameActivity = new GameActivityImpl();
        int[] targetNumArr = new int[GameConstant.ROUND];
        //1. enter the player name
        Map<String, Player> players = iGameActivity.registerPlayer(scan);
        System.out.println("###############################");
        //2. for every round generate num and player guess the number
        for(int i = 1 ; i<= GameConstant.ROUND; i++){
            System.out.println("Round "+i);
            int targetNum = iGameActivity.randomNumber(GameConstant.HIHG_RANGE);
            System.out.println("target:" + targetNum);
            targetNumArr[i-1] = targetNum;
            iGameActivity.guessAndCheck(players,scan,targetNum);
        }
        //3. print the round result
        iGameActivity.showRoundResult(players,targetNumArr);
        System.out.println("###############################");
        //4. print the player result
        iGameActivity.showPlayerResult(players,targetNumArr);
    }
    //enter
    public static void main(String[] args) {
        new GuessGame().start();
    }
}
