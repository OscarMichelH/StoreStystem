package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Bill {

    private int id;
    private Date date;
    private Calendar time;
    private List<Product> products;
    private Float total;
    private List<Integer> quantities;

    public Bill(int id) {
        this.date = new Date();
        this.time = Calendar.getInstance();
        this.products = new ArrayList<Product>();
        this.quantities = new ArrayList<Integer>();
        this.id = id;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Calendar getTime() {
        return time;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Float getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    //Esta funcion regresa una cadena de los ID's de los productos de la factura.
    public String getIdProducts() {
        String IDs = "";
        for (int i = 0; i < products.size(); i++) {
            IDs += products.get(i).getId();
            IDs += " ";
        }
        return IDs;
    }
    //Esta funcion regresa una cadena de los ID's de los productos de la factura.

    public String getQuantityProducts() {
        String Q = "";
        for (int i = 0; i < quantities.size(); i++) {
            Q += quantities.get(i);
            Q += " ";
        }
        return Q;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", date=" + date + ", time=" + time + ", products=" + products + ", total=" + total + ", quantities=" + quantities + '}';
    }

}
