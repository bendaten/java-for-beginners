package com.bendaten.trainer.chapter12;

import java.io.Serializable;

public class ToSerialize implements Serializable {
    private int id;
    private String name;

    public ToSerialize(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s {id = %d, name = '%s'}", this.getClass().getSimpleName(), this.id, this.name);
    }
}
