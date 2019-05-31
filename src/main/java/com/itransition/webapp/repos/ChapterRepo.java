package com.itransition.webapp.repos;

import com.itransition.webapp.domain.Chapter;
import com.itransition.webapp.domain.Composition;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepo extends CrudRepository<Chapter, Long> {
    Iterable<Chapter> findAllByComposition(Composition composition);
    Integer countChaptersByComposition(Composition composition);
}
