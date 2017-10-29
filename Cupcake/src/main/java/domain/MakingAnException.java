package domain;

/**
 * The purpose of this is come up with an errormessage if there is an exception somewhere in the system
 * @author BenedikteEva
 */
public class MakingAnException extends Exception {

    public MakingAnException(String errormsg) {
        super(errormsg);
    }
    

}
