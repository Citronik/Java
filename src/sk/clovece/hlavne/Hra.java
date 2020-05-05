/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece.hlavne;

import java.util.Random;
import java.util.Scanner;
import sk.clovece.Kocka;
import sk.clovece.Pohyb;


/**
 *
 * @author Filip Perďoch
 */
public class Hra {

    private Hrac[] hraci;
    private int naTahu;
    private Kocka kocka;
    private final Scanner reader;
    private int pocetHracov;
    private final Pohyb pohyb;
    private final HraciaPlocha hraciaPlocha;

    

    public Hra() {
        this.naTahu = 4; //prvy tah nahodny
        this.kocka = new Kocka();
        this.pohyb = new Pohyb();
        this.hraciaPlocha = new HraciaPlocha(this.pohyb);
        this.reader = new Scanner(System.in);
        //this.hraciaPlocha.vykresliHraciuPlochu();
    }
    
    public void rozhodHracov() {
        this.hraci = new Hrac[4];
        System.out.println("Zadaj pocet hracov");
        this.pocetHracov = this.reader.nextInt();
        if (this.pocetHracov >= 5 || this.pocetHracov <= 1) {
            this.pocetHracov = 4;
        }
        for (int i = 0; i < this.pocetHracov; i++) {
            this.hraci[i] = new Hrac(i, this.pohyb);
        }
    }
    
    public void hracNaTahu() {
        if (this.hraci == null) {
            this.rozhodHracov();
        }
        if (this.naTahu == 4) {
            this.naTahu = new Random().nextInt(this.pocetHracov);              
        }      
        System.out.format("Na tahu je %s %n", this.hraci[this.naTahu].getFarba());
        this.naTahu++;    
        if (this.naTahu >= this.pocetHracov) {
            this.naTahu = 0;
        }
    }
    
    public int getHodKockou() {
        int cislo = this.kocka.getHod();
        System.out.format("Padla %d%n", cislo);
        return cislo;
    }
    
    public void tahHracov() {
        if (this.hraci == null) {
            this.rozhodHracov();
        }
        do {
            System.out.println("skap");
            this.hracNaTahu();
            int hodil = this.getHodKockou();
            this.hraci[this.naTahu].tahSPanacikom(hodil);
        } while (!this.hraSkoncila());
    }

    private boolean hraSkoncila() {
        int skoncenyHraci = 0;
        for (int i = 0; i < this.pocetHracov; i++ ) {
            if (this.hraci[i].skoncil()) {
                skoncenyHraci++;
            }
        }
        return skoncenyHraci >= this.pocetHracov - 1;
    }
}
