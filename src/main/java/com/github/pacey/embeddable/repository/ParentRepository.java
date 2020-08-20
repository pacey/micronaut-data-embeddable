package com.github.pacey.embeddable.repository;

import com.github.pacey.embeddable.domain.Parent;
import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.H2)
public interface ParentRepository extends CrudRepository<Parent, Long> {

    @NonNull
    @Override
    @Join(value = "persistenceDetails", type = Join.Type.LEFT_FETCH)
    Optional<Parent> findById(@NonNull @NotNull Long aLong);
}
