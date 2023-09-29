package com.codedifferently.cdbankapi.domain.account.repos;

import com.codedifferently.cdbankapi.domain.account.models.Account;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is our Account DAO,
 * responsible for handling data access and database ops
 * pertaining to the Account Model/Entity
 *
 * @Repository - marks this interface as a Spring Data Repository in the application, making it a spring bean.
 *               Then during the app startup, Spring will scan this annotation and know how to deal with it.
 *               Spring will then generate the implementations for the repository methods.
 *
 * All custom methods return an optional in the case that the method might return a null/empty value.
 *
 * Data injection: To be injected in the services layer to let the service have access to the data access layer
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    Optional<List<Account>> findByType(String type);
    Optional<List<Account>> findByNickname(String nickname);
}
