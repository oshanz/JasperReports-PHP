/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author trisquel
 */
public class GetInvoice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            JSONObject arg_json = new JSONObject(args[0]);
        } catch (JSONException ex) {
            Logger.getLogger(GetInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
