package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty
    String title;

    @NotEmpty
    @OneToMany
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
        Genre genre = (Genre) o;
        return id == genre.id && title.equals(genre.title) && games.equals(genre.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, games);
    }
}
