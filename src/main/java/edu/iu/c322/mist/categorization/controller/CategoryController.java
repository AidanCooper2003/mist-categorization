package edu.iu.c322.mist.categorization.controller;

import edu.iu.c322.mist.categorization.repository.GameCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.c322.mist.repository.CategoryRepository;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/Categorys")
public class CategoryController {

    private GameCategoryRepository repository;

    public CategoryController(GameCategoryRepository repository) {
        this.repository = repository;
    }

    // Get https:localhost:8080/Categorys
    @GetMapping
    public List<GameCategory> findAll(){
        return repository.findAll();
    }




}