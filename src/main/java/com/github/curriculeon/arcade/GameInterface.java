package com.github.curriculeon.arcade;

import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    default void add(PlayerInterface player) {
        getPlayerList().add(player);
    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    default void remove(PlayerInterface player) {
        getPlayerList().add(player);
    }

    /**
     * specifies how the game will run
     */
    default void run() {
        do {
            for(PlayerInterface playerInterface : getPlayerList()) {
                evaluatePlayer(playerInterface);
            }
        } while(isGameRunning());
    }

    void evaluatePlayer(PlayerInterface playerInterface);

    boolean isGameRunning();

    List<PlayerInterface> getPlayerList();
}
