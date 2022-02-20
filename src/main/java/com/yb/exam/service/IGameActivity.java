package com.yb.exam.service;

import com.yb.exam.bean.Player;
import java.util.Map;
import java.util.Scanner;

public interface IGameActivity {

    //generate random number
    int randomNumber(int number);

    //compare the input and random number
    int compare(int targetNum, int inputNum);
    //input player name
    Map<String, Player> registerPlayer(Scanner scan);

    void guessAndCheck(Map<String, Player> players, Scanner scan,int targetNum);

    void showRoundResult(Map<String, Player> players, int[] targetNumArr);

    void showPlayerResult(Map<String, Player> players, int[] targetNumArr);
}
