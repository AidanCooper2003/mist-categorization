package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class GameCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty
    String title;

    int placement;

    @OneToMany(cascade = CascadeType.ALL)
    List<Game> games;

    public int getId(){
        return id;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCategory that = (GameCategory) o;
        return id == that.id && title.equals(that.title) && games.equals(that.games) && placement == that.placement;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, games);
    }
}
