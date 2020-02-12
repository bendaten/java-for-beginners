package com.bendaten.trainer.chapter11;

public class CloneDemo {
    private CopyDemo cd;

    public CloneDemo(CopyDemo cd) {
        this.cd = new CopyDemo(cd);  // deep copy
    }

    public CloneDemo(CloneDemo that) {
        this.cd = new CopyDemo(that.cd);
    }

    public CopyDemo getCd() {
        return this.cd;
    }

    @Override
    public String toString() {
        return String.format("CloneDemo {cd = %s}", this.cd.toString());
    }
}
