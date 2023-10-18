package com.br.findYourPet.enumerators;

public enum Size {
    Giant,
    Large,
    Medium,
    Small;

    @Override
    public String toString() {
        return this.name();
    }
}
