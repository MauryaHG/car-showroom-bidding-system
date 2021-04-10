package edu.monash.fit2099.exceptions;

/**
 * displays exception
 * @author Maurya
 * @version 1.0.0
 * @see VehicleException
 *
 */
public class TruckException extends VehicleException{
    /**
     * @param message exception message
     */
    public TruckException(String message) {
        super(message);
    }
}
