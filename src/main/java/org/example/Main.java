package org.example;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();


        service.addProduct(new Product("Asus ZenBook 14", "Laptop", "Table", 2025));
        service.addProduct(new Product("Dell Inspiron 15", "Laptop", "Office", 2026));
        service.addProduct(new Product("HP LaserJet Pro M15", "Printer", "Store Room", 2027));
        service.addProduct(new Product("Lenovo ThinkCentre M720", "Desktop", "Lab", 2023));
        service.addProduct(new Product("Acer Nitro VG240Y", "Monitor", "Office", 2025));
        service.addProduct(new Product("Samsung Galaxy S21", "Phone", "Drawer", 2023));
        service.addProduct(new Product("Apple iPad Pro", "Tablet", "Table", 2025));
        service.addProduct(new Product("Sony Alpha A6400", "Camera", "Cabinet", 2021));
        service.addProduct(new Product("LG CineBeam PH550", "Projector", "Conference Room", 2018));
        service.addProduct(new Product("Canon Pixma G2020", "Printer", "Office", 2025));
        service.addProduct(new Product("Microsoft Surface Pro 8", "Tablet", "Table", 2023));
        service.addProduct(new Product("OnePlus Nord CE 3", "Phone", "Drawer", 2022));
        service.addProduct(new Product("Xiaomi Mi Band 7", "Smartwatch", "Table", 2027));
        service.addProduct(new Product("Philips BT3900", "Speaker", "Lab", 2021));
        service.addProduct(new Product("Panasonic Viera TH-40HS", "TV", "Lounge", 2026));
        service.addProduct(new Product("Nikon D5600", "Camera", "Cabinet", 2020));
        service.addProduct(new Product("Realme Buds Air 3", "Earbuds", "Drawer", 2024));
        service.addProduct(new Product("Oppo Reno 8 Pro", "Phone", "Office", 2023));
        service.addProduct(new Product("Boat Rockerz 550", "Headphones", "Table", 2028));
        service.addProduct(new Product("Zebronics Max Plus", "Keyboard", "Lab", 2022));

        //get all products
        List<Product> products = service.getAllProduct();
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("=========================================");
        //get products by name
        Product p = service.getProductByName("OnePlus Nord CE 3");
        System.out.println(p);
        System.out.println("=========================================");

        //get products by text
        List<Product> products1 = service.getProductByText("pro");
        for (Product pro : products1) {
            System.out.println(pro);
        }
        System.out.println("=========================================");

        //get products by text using stream api
        List<Product> products2 = service.getProductWithText("pro");
        for (Product pro : products2) {
            System.out.println(pro);
        }
        //get products by place
        List<Product> products3 = service.getProductWithPlace("Room");
        for (Product pro : products3) {
            System.out.println(pro);
        }
        System.out.println("=========================================");

        //get products by warranty
        List<Product> products4 = service.getProductOutOfWarranty(LocalDate.now().getYear());
        for (Product pro : products4) {
            System.out.println(pro);
        }


    }
}