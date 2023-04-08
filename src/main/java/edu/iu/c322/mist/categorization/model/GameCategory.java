package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class GameCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;

    @OneToMany(cascade = CascadeType.ALL)
    List<Game> games;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
