/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece;

import java.util.Random;
import sk.clovece.hlavne.Hrac;

/**
 *
 * @author Filip Perďoch
 */
public class Kocka {



    public Kocka() {
        
    }
    
    public int getHod() {
        int kocka = new Random().nextInt(6);
        int cislo = kocka + 1;
        return cislo;
    }
    
}
