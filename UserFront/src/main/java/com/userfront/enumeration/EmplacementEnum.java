package com.userfront.enumeration;

public enum EmplacementEnum {

    COURT_ANNEXE("court annexe"),
    COURT_CENTRAL("court central");

    public final String emplacement;

    EmplacementEnum(String emplacement) {
        this.emplacement = emplacement;
    }
}
