package ru.job4j.profession;
/**
 * class Aviation.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Aviation {
    private String engineer, model;

    /**
     * constructor have two param.
     * @param engineer name type String
     * @param model helicopter type String
     */
    public Aviation(String engineer, String model) {
        this.engineer = engineer;
        this.model = model;
    }

    /**
     * method getEngineer.
     * @return engineer name type String.
     */
    public String getEngineer() {
        return engineer;
    }

    /**
     * method getModel.
     * @return model name type String.
     */
    public String getModel() {
        return model;
    }

    /**
     * method getAviation.
     * @return type String.
     */
    public String getAviation() {
        return String.format("Инженер %s разрабатывает %s", getEngineer(), getModel());
    }
}
