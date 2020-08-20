package com.github.pacey.embeddable.domain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

import javax.annotation.Nullable;
import java.util.Objects;

@MappedEntity
@Introspected
public class PersistenceDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Nullable
    @Relation(Relation.Kind.EMBEDDED)
    private final PersistedObject first;

    @Nullable
    @Relation(Relation.Kind.EMBEDDED)
    private final PersistedObject second;

    public PersistenceDetails(final @Id Long id, final @Nullable PersistedObject first, final @Nullable PersistedObject second) {
        this.id = id;
        this.first = first;
        this.second = second;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public PersistedObject getFirst() {
        return first;
    }

    @Nullable
    public PersistedObject getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersistenceDetails that = (PersistenceDetails) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(first, that.first) &&
            Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first, second);
    }
}
