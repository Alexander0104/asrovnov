package ru.job4j.profession;
/**
 * class Healthcare.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Healthcare {
    private String pacient;
    private String doctor;

    /**
     * constructor have a variable number of parameters.
     * @param pacient type String
     */
    Healthcare(String doctor, String pacient) {
        this.doctor = doctor;
        this.pacient = pacient;
    }

    /**
     * method getPacient.
     * @return pacient type String.
     */
    public String getPacient() {
        return pacient;
    }

    /**
     * method getDoctor.
     * @return doctor name type String.
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * method getHealthcare.
     * @return type String.
     */
    public String getHealthcare() {
        return String.format("Доктор %s лечит %s", getDoctor(), getPacient());
    }
}
