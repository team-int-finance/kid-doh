package com.dmarchante.kiddoh.models;

import java.math.BigDecimal;

public class DataPoint {
    private String label;
    private BigDecimal Y;

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public BigDecimal getY() {
        return Y;
    }
    public void setY(BigDecimal y) {
        Y = y;
    }
}
