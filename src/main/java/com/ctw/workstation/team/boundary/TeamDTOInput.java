package com.ctw.workstation.team.boundary;

public class TeamDTOInput {

    private String name;
    private String defaultLocation;
    private String product;

    public TeamDTOInput(String name, String defaultLocation, String product) {
        this.name = name;
        this.defaultLocation = defaultLocation;
        this.product = product;
    }

    public TeamDTOInput() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "TeamDTOInput{" +
                "name='" + name + '\'' +
                ", defaultLocation='" + defaultLocation + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
