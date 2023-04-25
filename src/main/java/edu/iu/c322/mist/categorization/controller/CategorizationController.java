package edu.iu.c322.mist.categorization.controller;

import edu.iu.c322.mist.categorization.model.CustomerProfile;
import edu.iu.c322.mist.categorization.model.GameCategory;
import edu.iu.c322.mist.categorization.repository.GameListRepository;
import edu.iu.c322.mist.categorization.repository.UserListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
}
