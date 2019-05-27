package com.itransition.webapp.repos;

import com.itransition.webapp.domain.Composition;
import com.itransition.webapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface CompositionRepo extends CrudRepository<Composition, Long> {


    Iterable<Composition> findAllByUserId(Long id);


}
