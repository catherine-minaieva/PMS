package ua.goit.model;

import java.io.Serializable;

@FunctionalInterface
public interface BaseEntity <ID> extends Serializable {
    ID getID();
}
