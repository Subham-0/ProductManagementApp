package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ProductManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProductManagementApplication.class, args);

        ProductService service = context.getBean(ProductService.class);

        List<Product> products = service.getAllProduct();
        for(Product p :products){
            System.out.println(p);
        }

//		service.addProduct(new Product("Type-c Cable","Electronic","Drawer",2027));

//		Product p = service.getProductByName("Apple iPad Pro");
//		System.out.println(p);

//		List<Product> products = service.getProductByText("pro");
//		products.forEach(System.out::println);

//		List<Product> products = service.getProductWithPlace("table");
//		products.forEach(System.out::println);

//		List<Product> products = service.getProductOutOfWarranty(LocalDate.now().getYear());
//		products.forEach(System.out::println);

    }

}
