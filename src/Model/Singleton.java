/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nuria
 */
public class Singleton {
    //Un objeto de clase, privado y constante
    private static final Singleton instance = new Singleton();
    
    //Constructor privado, para evitar que 
    private Singleton(){}
    
    //Metodo de clase publico q devuelve la intancia
    public static Singleton getInstance(){
        return instance;
    }
    
}
