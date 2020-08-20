package com.github.pacey.embeddable.domain;

import io.micronaut.data.annotation.Embeddable;

import java.util.Objects;

@Embeddable
public class PersistedObject {

    private final String bucket;
    private final String path;

    public PersistedObject(final String bucket, final String path) {
        this.bucket = bucket;
        this.path = path;
    }

    public String getBucket() {
        return bucket;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersistedObject that = (PersistedObject) o;
        return Objects.equals(bucket, that.bucket) &&
            Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucket, path);
    }
}
