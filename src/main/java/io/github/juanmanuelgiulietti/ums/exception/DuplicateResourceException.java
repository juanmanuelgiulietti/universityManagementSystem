package io.github.juanmanuelgiulietti.ums.exception;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String resource, String campo, String valor) {
        super(resource + " with " + campo + "='" + valor + "' already exists");
    }
}
    