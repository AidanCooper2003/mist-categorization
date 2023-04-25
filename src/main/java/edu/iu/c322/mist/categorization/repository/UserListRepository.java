package edu.iu.c322.mist.categorization.repository;

import edu.iu.c322.mist.categorization.model.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepository extends JpaRepository<CustomerProfile, Integer> {

}
