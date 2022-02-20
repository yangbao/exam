package com.yb.exam.bean;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Player {

    private String playName;
    private List<Integer> guessNum = new ArrayList<>();
    private int store;

    public int addStore(){
        return store++;
    }
}
