package com.itransition.webapp.repos;

import com.itransition.webapp.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findById(String id);
    User findByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update usr u set u.status = ? where u.username = ?", nativeQuery = true)
    int updateUsrSetStatusForUsername(Boolean status, String username);

    @Transactional
    int deleteByUsername(String username);

}


