/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece.hlavne;

import sk.clovece.Pohyb;
import sk.clovece.hraciadoska.Stvorec;

/**
 *
 * @author Filip Perďoch
 */
public class HraciaPlocha {

    private final Pohyb pohyb;
    private int[][] hraciaPlocha;
    private Stvorec[][] policka;

    
    public HraciaPlocha(Pohyb pohyb) {
        this.pohyb = pohyb;
        this.hraciaPlocha = this.pohyb.getPLOCHA();
        this.policka = new Stvorec[this.hraciaPlocha.length][this.hraciaPlocha.length];
    }

    void vykresliHraciuPlochu() {
        
        for (int i = 0; i < this.hraciaPlocha.length; i++) {
            for (int j = 0; j < this.hraciaPlocha.length; j++) {
                this.vykrasliHraciePolicka(i, j);
                this.vykresliDomceky(i, j);
            }
        }
    }

    private void vykrasliHraciePolicka(int i, int j) {
        if (this.hraciaPlocha[i][j] >= 0 && this.hraciaPlocha[i][j] <= 39) {
            this.policka[i][j] = new Stvorec();
            this.policka[i][j].posunNa(i * 32 + 32, j * 32 + 32);
            this.policka[i][j].zmenFarbu("white");
            this.policka[i][j].zobraz();
        }
    }

    private void vykresliDomceky(int i, int j) {
        if (this.hraciaPlocha[i][j] >= 110 && this.hraciaPlocha[i][j] <= 143) {
            this.policka[i][j] = new Stvorec();
            this.policka[i][j].posunNa(i * 32 + 32, j * 32 + 32);
            this.policka[i][j].zmenFarbu("white");
            this.policka[i][j].zobraz();
        }
    }
    
}
