package me.bcof.canetop.menusystem;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {
    private Player owner;

    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
