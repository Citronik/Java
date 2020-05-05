/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece.hlavne;

import java.util.Scanner;
import sk.clovece.Panacik;
import sk.clovece.Pohyb;

/**
 * 
 * @author Filip Perďoch
 */
public class Hrac {

    private final Panacik[] panaci;
    private String farba;
    private Scanner reader;
    private Pohyb pohyb;
    
    /**
     *
     * @param farba
     * @param pohyb
     */
    public Hrac(int farba, Pohyb pohyb) {
        this.reader = new Scanner(System.in);
        this.pohyb = pohyb;
        switch (farba) {
            case 0 :
                this.farba = ("Modra");
                break;
            case 1 :
                this.farba = ("Zlta");
                break;
            case 2 :
                this.farba = ("Zelena");
                break;
            case 3 :
                this.farba = ("Cervena");
                break;
        }
        this.panaci = new Panacik[4];
        for (int i = 0; i < 4; i++) {
            this.panaci[i] =  new Panacik(this.farba, i, pohyb);
            this.panaci[i].rozmiestniPanacikovDoDomceku();
        }
    }

    public String getFarba() {
        return this.farba;
    }
    
    public void tahSPanacikom(int oKolko) {
        int panacik = this.reader.nextInt();
        if (this.panaci[panacik].getVDomceku() && oKolko == 6) {
            this.panaci[panacik].posunNaStart();
            this.pohyb.nacitajPanacikov(this.panaci[panacik]);
            return;
        }
        if (!this.panaci[panacik].getVDomceku()) {
            this.panaci[panacik].skocSPanacikom(oKolko);            
            this.pohyb.nacitajPanacikov(this.panaci[panacik]);
        }
    }

    boolean skoncil() {
        for (Panacik panacik : this.panaci) {
            if (!panacik.jeVCieli()) {
                return false;
            }
        }
        return true;
    }
    
    
    
}
