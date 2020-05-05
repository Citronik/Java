/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece;

/**
 *
 * @author Filip Perďoch
 */
public enum Farba {
    CERVENY("Cerveny"),
    MODRY("Modry"),
    ZELENY("Zeleny"),
    ZLTY("Zlty");
    
    private final String farba;

    Farba(String farba) {
        this.farba = farba;
    }

    public String getFarba() {
        return this.farba;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
