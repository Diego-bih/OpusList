/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi;

import java.awt.image.BufferedImage;

/**
 *
 * @author DevMike
 */
public class Obra {

    public String getRegistre() {
        return registre;
    }

    public void setRegistre(String registre) {
        this.registre = registre;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }
    

    public Obra(String registre, String titol, int any, String format, String autor, String imatge) {
        this.registre = registre;
        this.titol = titol;
        this.any = any;
        this.format = format;
        this.autor = autor;
        this.imatge = imatge;
    }
    
    private String registre;
    private String titol;
    private int any;
    private String format;
    private String autor;
    private String imatge;
    

    @Override
    public String toString() {
        return registre + ": " + titol + ", " + any + " (" + format + "). " + autor + imatge; 
    }
    
    
}
