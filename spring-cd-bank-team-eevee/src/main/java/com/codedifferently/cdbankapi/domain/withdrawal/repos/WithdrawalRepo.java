package com.codedifferently.cdbankapi.domain.withdrawal.repos;

import com.codedifferently.cdbankapi.domain.withdrawal.models.Withdrawal;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is our Withdrawal DAO,
 * responsible for handling data access and database ops
 * pertaining to the Withdrawal Model/Entity
 *
 * @Repository - marks this interface as a Spring Data Repository in the application, making it a spring bean.
 *               Then during the app startup, Spring will scan this annotation and know how to deal with it.
 *               Spring will then generate the implementations for the repository methods.
 *
 * All custom methods return an optional in the case that the method might return a null/empty value.
 */
@Repository
public interface WithdrawalRepo extends JpaRepository<Withdrawal, Long> {
    Optional<List<Withdrawal>> findByDate(Date date);
    Optional<List<Withdrawal>> findByType(String type);
}
