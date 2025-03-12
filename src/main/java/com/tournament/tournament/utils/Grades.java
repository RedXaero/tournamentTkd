package com.tournament.tournament.utils;

public enum Grades {
    CINTA_BLANCA(1),
    CINTA_AMARILLA(2),
    CINTA_AMARILLA_AVANZADA(3),
    CINTA_VERDE(4),
    CINTA_VERDE_AVANZADA(5),
    CINTA_AZUL(6),
    CINTA_AZUL_AVANZADA(7),
    CINTA_ROJA(8),
    CINTA_ROJA_AVANZADA(9),
    CINTA_NEGRA(10),
    PRIMER_DAN(11),
    SEGUNDO_DAN(12),
    TERCER_DAN(13),
    CUARTO_DAN(14),
    QUINTO_DAN(15),
    SEXTO_DAN(16),
    SEPTIMO_DAN(17),
    OCTAVO_DAN(18),
    NOVENO_DAN(19);

    private final int nivel;

    Grades(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return name().replace('_', ' ').replace("AVANZADA", "Avanzada") + " (Nivel " + nivel + ")";
    }
}
