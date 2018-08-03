/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesExceptions;

/**
 *
 * @author dionm
 */
public class NovoImovelException extends Exception {

    public NovoImovelException() {
        super("Matricula já usada");
    }
}
