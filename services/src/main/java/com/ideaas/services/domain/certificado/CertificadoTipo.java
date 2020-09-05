package com.ideaas.services.domain.certificado;

public enum CertificadoTipo {

    Art("ART", "art"),
    CitacionDeAutoridadCompetente("Citación De Autoridad Competente", "citacionDeAutoridadCompetente"),
    DonacionDeSangre("Donación de sangre", "donacionSangre"),
    Enfermedad("Enfermedad", "enfermedad"),
    EnfermedadContratado("Enfermedad - Contratado", "enfermedadContradado"),
    EnfermedadFamiliarACargo("Enfermedad familiar a cargo", "enfermedadFamiliarACargo"),
    Examen("Exámen", "examen"),
    FallecimientoDeFamiliares("Fallecimiento de familiares", "fallecimientoDeFamiliares"),
    MaternidadExcedencia("Maternidad/Excedencia", "maternidadExcedencia"),
    MaternidadPaternidad("Maternidad/Paternidad", "maternidadPaternidad"),
    Matrimonio("Matrimonio", "matrimonio"),
    Mudanza("Mudanza", "mudanza"),
    Nacimiento("Nacimiento", "nacimiento"),
    OtroMotivo("Otro motivo", "otroMotivo"),
    Reconocimiento("Reconocimiento", "reconocimiento"),
    Sancion("Sanción", "sancion"),
    Vacaciones("Vacaciones", "vacaciones");

    private final String displayName;
    private final String shortName;

    CertificadoTipo(String displayName, String shortName) {
        this.displayName = displayName;
        this.shortName = shortName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getShortName() {
        return shortName;
    }
}
