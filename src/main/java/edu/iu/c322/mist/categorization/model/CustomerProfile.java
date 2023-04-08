package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    List<Game> ownedGames;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL)
    List<GameCategory> customCategories;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Game> getOwnedGames() {
        return ownedGames;
    }

    public void setOwnedGames(List<Game> ownedGames) {
        this.ownedGames = ownedGames;
    }

    public List<GameCategory> getCustomCategories() {
        return customCategories;
    }

    public void setCustomCategories(List<GameCategory> customCategories) {
        this.customCategories = customCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerProfile that = (CustomerProfile) o;
        return id == that.id && username.equals(that.username) && email.equals(that.email) && password.equals(that.password) && ownedGames.equals(that.ownedGames) && customCategories.equals(that.customCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, ownedGames, customCategories);
    }
}
