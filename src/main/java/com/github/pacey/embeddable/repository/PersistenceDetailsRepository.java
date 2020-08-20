package com.github.pacey.embeddable.repository;

import com.github.pacey.embeddable.domain.PersistenceDetails;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface PersistenceDetailsRepository extends CrudRepository<PersistenceDetails, Long> {
}
