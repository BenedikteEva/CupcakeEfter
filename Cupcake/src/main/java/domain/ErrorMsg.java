/*
 * BenedikteEva
 * CupCakeEfter
 */
package domain;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class ErrorMsg {

    String execute(HttpServletRequest request, HttpServletResponse response) throws MakingAnException {
       String errorMsg= "Ooops something went wrong!";
        return errorMsg;
    }
    
}
