package com.mycompany.guitest;


public class StockClass {

    private String item_id_table;
    private String item_name_table;
    private String category_table;
    private String quantity_table;
    private String price_table;
    private String supp_id_table;

    // Constructor
    public void StockClassEntry(String item_id_table, String item_name_table, String category_table, String quantity_table,String price_table,
                                  String supp_id_table) {
        this.item_id_table = item_id_table;
        this.item_name_table = item_name_table;
        this.category_table = category_table;
        this.quantity_table = quantity_table;
        this.price_table = price_table;
        this.supp_id_table = supp_id_table;
    }

    // Getters for all fields
    public String getItemID() {
        return item_id_table;
    }

    public String getItemName() {
        return item_name_table;
    }

    public String getCategory() {
        return category_table;
    }

    public String getQuantity() {
        return quantity_table;
    }

    public String getPrice() {
        return price_table;
    }

    public String getSupplierID() {
        return supp_id_table;
    }
}
