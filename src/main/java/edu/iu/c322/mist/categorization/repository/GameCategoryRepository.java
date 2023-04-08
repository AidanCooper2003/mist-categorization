package edu.iu.c322.mist.categorization.repository;

import edu.iu.c322.mist.categorization.model.GameCategory;
import edu.iu.c322.mist.model.GameCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameCategoryRepository {

    public List<GameCategory> GameCategorys = new ArrayList<>();

    public List<GameCategory> findAll(){
        return GameCategorys;
    }

    public void update(GameCategory GameCategory, int id){
        GameCategory c = getById(id);
        if(c != null){
            c.setTitle(GameCategory.getTitle());
            c.setGames(GameCategory.getGames());
        } else {
            throw new IllegalStateException("GameCategory with this id was not found.");
        }
    }

    private GameCategory getByGenre(int id){
        GameCategory c = GameCategorys.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        return c;
    }

    public void delete(int id) {
        GameCategory c = getById(id);
        if(c != null){
            GameCategorys.remove(c);
        } else {
            throw new IllegalStateException("GameCategory with this id was not found.");
        }
    }


}