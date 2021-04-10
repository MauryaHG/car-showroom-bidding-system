package edu.monash.fit2099.exceptions;

/**
 * displays exception
 * @author Maurya
 * @version 1.0.0
 * @see Exception
 * @see SedanException
 * @see TruckException
 *
 */
public class VehicleException extends Exception{
    /**
     * @param message exception message
     */
    public VehicleException(String message) {
        super(message);
    }
}
