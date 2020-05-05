/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece;

import java.util.HashMap;

/**
 *
 * @author Filip Perďoch
 */
public class Pohyb {
    private final static int[][] PLOCHA = {{100,100,100,100,8,9,10,100,100,100,100},{100,110,111,100,7,50,11,100,120,121,100}, 
                                           {100,112,113,51,6,51,12,100,122,123,100},{100,100,100,100,5,52,13,100,100,100,100}, 
                                           {0,1,2,3,4,53,14,15,16,17,18},{39,40,41,42,43,100,63,62,61,60,29}, 
                                           {38,37,36,35,34,63,24,23,22,21,20},{100,100,100,100,33,62,13,100,100,100,100}, 
                                           {100,130,131,100,32,61,26,100,140,141,100},{100,132,133,100,31,60,27,100,142,143,100}, 
                                           {100,100,100,100,30,29,28,100,100,100,100}}; 
    private final HashMap<Integer, Panacik> policka;
    public Pohyb() {
        this.policka = new HashMap<Integer, Panacik>();
    }
    
    public void nacitajPanacikov(Panacik panak) {
        this.policka.put(panak.getAktualnaPozicia(), panak);
        System.out.println("" + panak.getAktualnaPozicia());
    }
    
    boolean mozeSkakat(Panacik panak, int oKolko) {
        if (panak.getVDomceku()) {
            return false;
        }
        return panak.getAktualnaPozicia() + oKolko >= 43;
    }

    public int getPozicieDomceku(String farba) {
        switch (farba) {
            case ("Modra"):
                return 110;
            case ("Zlta"):
                return 120;
            case ("Zelena"):
                return 130;
            case ("Cervena"):
                return 140;
        }
        return 110;
    }

    public int[][] getPLOCHA() {
        return PLOCHA;
    }
    
    
    
}
