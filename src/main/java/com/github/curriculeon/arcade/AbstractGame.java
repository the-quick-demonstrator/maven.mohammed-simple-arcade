package com.github.curriculeon.arcade;

import java.util.ArrayList;
import java.util.List;

/**
 * the purpose of an abstract class is to couple construction / state
 */
abstract public class AbstractGame implements GameInterface {
    private final List<PlayerInterface> players;

    public AbstractGame() {
        this(new ArrayList<>());
    }

    public AbstractGame(List<PlayerInterface> players) {
        this.players = players;
    }

    @Override
    public List<PlayerInterface> getPlayerList() {
        return players;
    }
}
