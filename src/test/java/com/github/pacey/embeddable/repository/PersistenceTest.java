package com.github.pacey.embeddable.repository;

import com.github.pacey.embeddable.domain.Parent;
import com.github.pacey.embeddable.domain.PersistedObject;
import com.github.pacey.embeddable.domain.PersistenceDetails;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@MicronautTest
class PersistenceTest {

    @Inject
    private ParentRepository parentRepository;
    @Inject
    private PersistenceDetailsRepository persistenceDetailsRepository;

    @Test
    void canReadAndWriteData() {

        // Given: A parent and persistence details instance
        var persistenceDetails = new PersistenceDetails(
            null,
            new PersistedObject("bucket", "first.txt"),
            new PersistedObject("bucket", "second.txt")
        );
        var parent = new Parent(
            null,
            persistenceDetails
        );

        // When: The instances are persisted in the repositories
        persistenceDetailsRepository.save(persistenceDetails);
        parent = parentRepository.save(parent);

        // Then: The parent with it's children can be retrieved by its identifier
        var actualParent = parentRepository.findById(parent.getId());
        assertThat(actualParent).hasValue(parent);
    }
}
