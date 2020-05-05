/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.clovece;

import java.util.Scanner;
import sk.clovece.hlavne.Hra;

/**
 *
 * @author Filip Perďoch
 */
public class CloveceV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        Scanner scaner = new Scanner(System.in);
        hra.tahHracov();
    }
    
}
