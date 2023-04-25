package edu.iu.c322.mist.categorization.controller;

import edu.iu.c322.mist.categorization.model.CategoryDescription;
import edu.iu.c322.mist.categorization.model.CustomerProfile;
import edu.iu.c322.mist.categorization.model.Game;
import edu.iu.c322.mist.categorization.model.GameCategory;
import edu.iu.c322.mist.categorization.repository.GameListRepository;
import edu.iu.c322.mist.categorization.repository.UserListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/download")
public class CategorizationController {
    private UserListRepository userRepository;
    private GameListRepository gameRepository;

    public CategorizationController(UserListRepository userRepository, GameListRepository gameRepository){
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/{username}")
    public List<GameCategory> getCategories(@PathVariable String username){
        return userRepository
                .getCustomerProfileByUsernameEquals(username)
                .getCustomCategories();
    }

    @GetMapping("/{username}/{categoryId}")
    public GameCategory getCategory(@PathVariable String username, @PathVariable int categoryId){
        CustomerProfile user = userRepository.getCustomerProfileByUsernameEquals(username);
        for (GameCategory category : user.getCustomCategories()) {
            if (category.getId() == categoryId){
                return category;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category of this ID does not exist for this user.");
    }

    @PostMapping("/{username}")
    public void createCategory(@PathVariable String username, @RequestBody CategoryDescription category){
        CustomerProfile user = userRepository.getCustomerProfileByUsernameEquals(username);
        List<GameCategory> categories = user.getCustomCategories();
        GameCategory newCategory = new GameCategory();
        if (newCategory.getTitle().equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category title can not be empty");
        }
        if (newCategory.getPlacement() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category placement can not be below 1");
        }
        newCategory.setTitle(category.title());
        newCategory.setPlacement(category.placement());
        newCategory.setGames(new ArrayList<>());
        categories.add(newCategory);
        user.setCustomCategories(categories);
        userRepository.save(user);
    }

    @DeleteMapping("/{username}/{categoryId}")
    public void deleteCategory(@PathVariable String username, @PathVariable int categoryId){
        CustomerProfile user = userRepository.getCustomerProfileByUsernameEquals(username);
        GameCategory category = null;
        for (GameCategory c : user.getCustomCategories()) {
            if (c.getId() == categoryId){
                category = c;
                break;
            }
        }
        if (category == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category of this ID does not exist for this user.");
        }
        user.getCustomCategories().remove(category);
        userRepository.save(user);
    }


    // NOTE: This is unfinished, request body will be sent with IDs, not instances
    // of games.
    @PutMapping("/{username}")
    public void modifyCategory(@PathVariable String username, @RequestBody GameCategory newCategory){
        CustomerProfile user = userRepository.getCustomerProfileByUsernameEquals(username);
        GameCategory category = null;
        for (GameCategory c : user.getCustomCategories()) {
            if (c.getId() == newCategory.getId()){
                category = c;
                break;
            }
        }
        if (category == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category of this ID does not exist for this user.");
        }
        category.setPlacement(newCategory.getPlacement());
        category.setTitle(newCategory.getTitle());
        category.setGames(newCategory.getGames());
        userRepository.save(user);
    }
}
