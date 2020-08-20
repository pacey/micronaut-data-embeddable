package com.github.pacey.embeddable.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.annotation.Nullable;
import java.util.Objects;

@MappedEntity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    @Relation(Relation.Kind.MANY_TO_ONE)
    @Nullable
    private final PersistenceDetails persistenceDetails;

    public Parent(final @Id Long id, final @Nullable PersistenceDetails persistenceDetails) {
        this.id = id;
        this.persistenceDetails = persistenceDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public PersistenceDetails getPersistenceDetails() {
        return persistenceDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(id, parent.id) &&
            Objects.equals(persistenceDetails, parent.persistenceDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, persistenceDetails);
    }
}
