package com.yb.exam;

import static org.hamcrest.MatcherAssert.assertThat;

import com.yb.exam.bean.Player;
import com.yb.exam.constants.GameConstant;
import com.yb.exam.service.GameActivityImpl;
import com.yb.exam.service.IGameActivity;
import java.util.Map;
import java.util.Scanner;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class GameActivityImplTest {

    @Test
    public void randomNumber() {
        IGameActivity gameActivity  = new GameActivityImpl();
        int i = 100;
        while (i>0){
            int num = gameActivity.randomNumber(GameConstant.HIHG_RANGE);
            System.out.println(num);
            assertThat(num, greaterThan(0));
            assertThat(num, lessThan(11) );
            i--;
        }
    }

    @Test
    public void compare() {
    }
    @Test
    public void registerPlayer() {
        IGameActivity gameActivity  = new GameActivityImpl();
        Map<String, Player> players = gameActivity.registerPlayer(new Scanner(System.in));
        players.forEach((playName,player)->{
            System.out.println(playName+"--"+player);
        });
    }
}