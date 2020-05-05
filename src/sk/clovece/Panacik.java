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
public class Panacik {

    private boolean vDomceku;
    private boolean vCieli;
    private final String farba;
    private Pohyb pohyb;
    private int aktualnaPozicia;
    private final int poziciaStartu;
    
    
    public Panacik(String farba, int cisloPanacika, Pohyb pohyb) {
        this.vDomceku = true;
        this.vCieli = false;
        this.farba = farba;
        this.aktualnaPozicia = cisloPanacika;
        this.pohyb = pohyb;
        switch (this.farba) {
            case ("Zlta"):   
                this.poziciaStartu = 10;
                break;
            case ("Zelena"):    
                this.poziciaStartu = 20;
                break;
            case ("Cervena"):    
                this.poziciaStartu = 30;
                break;
            default:
                this.poziciaStartu = 0;
        }
    }

    public String getFarba() {
        return this.farba;
    }

    public boolean getVDomceku() {
        return this.vDomceku;
    }

    public int getAktualnaPozicia() {
        return this.aktualnaPozicia;
    }
    
    public void rozmiestniPanacikovDoDomceku() {
        int posun = this.pohyb.getPozicieDomceku(this.farba);
        this.aktualnaPozicia += posun;
    }
    
    public void skocSPanacikom(int oKolko) {
        if (this.pohyb.mozeSkakat(this, oKolko)) {
            this.aktualnaPozicia += oKolko;
            //System.out.format("%d%n", this.aktualnaPozicia);            
        }
    }

    public void posunNaStart() {
        this.vDomceku = false;
        this.aktualnaPozicia = this.poziciaStartu;
    }

    public boolean jeVCieli() {
        return this.aktualnaPozicia >= 39;
    }
    
}
