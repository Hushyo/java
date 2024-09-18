package com.homework05.entity;
public class Npc{
    private String npcName;
    private int npcId;

    public String getNpcName() {
        return npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public int getNpcId() {
        return npcId;
    }

    public void setNpcId(int npcId) {
        this.npcId = npcId;
    }

    public Npc(String npcName, int npcId) {
        this.npcName = npcName;
        this.npcId = npcId;
    }
}