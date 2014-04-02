/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
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

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.HALF_UP);

        try {
            JSONObject arg_json = new JSONObject(args[0]);
        } catch (JSONException ex) {
            Logger.getLogger(GetInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("duplicate", "");
        hm.put("distributor", "//oshan" + "\n" + "//kapuhempala" + "\n\nArea: " + "//galle");
        hm.put("customer", "//owner" + "\n" + "//Agro" + "\n" + "//Agro add" + "\n" + "//0771894851");
        hm.put("invNo", "GSLTS" + String.format("%04d", Integer.parseInt("//100")));
        hm.put("invDate", "2014-01-10");
        hm.put("invCode", "300");

        double invoiceTotal = 500000;
        if (5 > 0) {//ShopDiscount
            double discountprice = (invoiceTotal * 99) / 100;//getShopDiscount()
            hm.put("invoiceDiscount", nf.format((invoiceTotal) * 99 / 100));//getRetail_discount()

        } else {
            hm.put("invoiceDiscount", "");
        }
        hm.put("gross_total", nf.format(invoiceTotal));
        hm.put("invoiceTotal", nf.format(((invoiceTotal) * (100 - 99) / 100)));//getRetail_discount()
        hm.put("salesPersonName", "rep");
        hm.put("salesPersonContactNo", "0772189584");

        JTable jTable1 = new JTable();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ITEMCODE", "DESCRIPTION", "QTY", "FREEQTY", "PRICE", "AMOUNT"
                }));

        String reportSource = "./ireports/invoice.jrxml";
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        try {
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            JasperPrint jp = JasperFillManager.fillReport(jr, hm, new JRTableModelDataSource(dtm));
            JasperPrintManager.printReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(GetInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("1");

    }

}
