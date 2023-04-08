package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class GameCategory {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCategory that = (GameCategory) o;
        return id == that.id && title.equals(that.title) && games.equals(that.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, games);
    }
}
