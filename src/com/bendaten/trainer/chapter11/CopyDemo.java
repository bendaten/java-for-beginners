package com.bendaten.trainer.chapter11;

public class CopyDemo implements Cloneable {

    private int id;
    private String name;

    public CopyDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CopyDemo(CopyDemo that) {
        this.id = that.id;
        this.name = that.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("CopyDemo {id = %d, name = '%s'}", id, name);
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (that == null || that.getClass() != this.getClass()) {
            return false;
        }
        CopyDemo cd = (CopyDemo)that;
        return this.id == cd.id && this.name.equals(cd.name);
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + id;
        return result;
    }
}
