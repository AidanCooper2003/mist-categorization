package edu.iu.c322.mist.categorization.repository;

import edu.iu.c322.mist.categorization.model.CustomerProfile;
import edu.iu.c322.mist.categorization.model.GameCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepository extends JpaRepository<CustomerProfile, Integer> {
    CustomerProfile getCustomerProfileByUsernameEquals(String username);
}
