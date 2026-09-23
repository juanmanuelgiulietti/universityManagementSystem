package io.github.juanmanuelgiulietti.ums.exception;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String resource, String field, String value) {
        super(resource + " with " + field + "='" + value + "' already exists");
    }
}
