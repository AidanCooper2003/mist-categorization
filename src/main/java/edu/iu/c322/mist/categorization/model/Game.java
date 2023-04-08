package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;


    @NotEmpty
    String title;

    @NotEmpty
    String releaseDate;

    @NotEmpty
    String description;

    @NotEmpty
    String studio;

    @NotEmpty
    Double price;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    List<Genre> genres;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && title.equals(game.title) && releaseDate.equals(game.releaseDate) && description.equals(game.description) && studio.equals(game.studio) && price.equals(game.price) && genres.equals(game.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, description, studio, price, genres);
    }
}
