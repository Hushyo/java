package com.homework05;
import com.homework05.entity.*;
public class Test{
    public static User createUser(){
        Npc npc1 = new Npc("普通用户",1);
        Npc npc2 = new Npc("VIP",2);
        Game game1 = new Game(1,"魂斗罗");
        Game game2 = new Game(2,"超级马里奥");
        User user = new User(1,"Mike",npc2, new Game[]{game1, game2});
        return  user;
    }
    public static void listGames(User user){
        Game[] games = new Game[2];
        games = user.getGames();
        for(int i=0;i<games.length;i++) {
            System.out.println(games[i].getGameName());
        }
    }
    public static void main(String[] args){
        User user = createUser();
        listGames(user);
    }
}