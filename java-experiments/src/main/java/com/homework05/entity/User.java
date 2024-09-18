package com.homework05.entity;
public class User {
    private int id;
    private String name;
    private Npc npc;
    private Game[] games;
    public User(int id, String name, Npc npc, Game[] games) {
        this.id = id;
        this.name = name;
        this.npc = npc;
        this.games = games;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }
}