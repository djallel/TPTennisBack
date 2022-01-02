package com.userfront.enumeration;

public enum TypeTournoiEnum {

    SIMPLE("Simple messieurs"),
    DOUBLE("Double messieurs"),
    QUALIFICATION("Qualification");

    public final String typeTournoi;

    TypeTournoiEnum(String typeTournoi) {
        this.typeTournoi = typeTournoi;
    }
}
