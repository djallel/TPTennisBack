package com.userfront.enumeration;

public enum CategorieBilletEnum {

    BILLET_GRAND_PUBLIC_LICENCIE("Billet grand public licencié"),
    BILLET_GRAND_PUBLIC_NON_LICENCIE("Billet grand public non licencié"),
    BILLET_BIG_MATCH_LICENCIE("Billet big match licencié"),
    BILLET_BIG_MATCH_NON_LICENCIE("Billet big match non licencié");

    public final String categorieBillet;

    CategorieBilletEnum(String categorieBillet) {
        this.categorieBillet = categorieBillet;
    }
}
