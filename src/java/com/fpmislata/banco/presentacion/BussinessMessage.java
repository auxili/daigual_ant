/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion;

import java.util.List;
import javax.validation.ConstraintViolation;

/**
 *
 * @author KiKe
 */
public class BussinessMessage {

    public void errorJavax() {
        try {
        } catch (javax.validation.ConstraintViolationException cve) {
            System.out.println("No se ha podido insertar la EntidadBancaria debido a los siguientes errores:");
            for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
                System.out.println("En el campo '" + constraintViolation.getPropertyPath() + "':" + constraintViolation.getMessage());
            }
        }
    }
}
