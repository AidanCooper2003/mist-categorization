package edu.iu.c322.mist.categorization.controller;

import edu.iu.c322.mist.categorization.repository.GameListRepository;
import edu.iu.c322.mist.categorization.repository.UserListRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class CategorizationController {
    private UserListRepository userRepository;
    private GameListRepository gameRepository;

    public CategorizationController(UserListRepository userRepository, GameListRepository gameRepository){
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }
}
