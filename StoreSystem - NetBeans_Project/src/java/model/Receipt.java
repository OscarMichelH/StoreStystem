/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author bmbrina
 */
public class Receipt {
    private int id;
    private Date date;
    private float total;
    private Product[] products;
    private String type;
    private String status;
    
}
