package edu.iu.c322.mist.categorization.repository;

import edu.iu.c322.mist.categorization.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<Game, Integer> {

}
