package com.sgcib;

public class Association {

    private final Person from;

    private final Person to;

    public Association(Person from, Person to) {
        this.from = from;
        this.to = to;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Association that = (Association) o;

        if (from != null ? !(from == (that.from)) : that.from != null) return false;
        if (to != null ? !(to == (that.to)) : that.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}
