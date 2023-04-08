package edu.iu.c322.mist.categorization.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String username;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    List<Game> ownedGames;

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
}
