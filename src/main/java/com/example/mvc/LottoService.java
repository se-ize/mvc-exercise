package com.example.mvc;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.random.RandomGenerator;

@Service
public class LottoService {
    private int hits = 0;
    private final List<List<Integer>> history = new ArrayList<>();

    //누군가 방문했을때 호출하는 메소드
    public int addHit() {
        hits++;
        return hits;
    }

    //Lotto 메소드
    public List<Integer> nextWinningNumber() {
        List<Integer> winningNums = new ArrayList<>();
        RandomGenerator random = new Random();
        for (int i = 0; i < 6; i++) {
            winningNums.add(random.nextInt(1, 46));
        }
        history.add(winningNums);
        return winningNums;
    }

    //history 메소드
    public List<List<Integer>> getHistory() {
        return this.history;
    }
}
