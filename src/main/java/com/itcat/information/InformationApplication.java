package com.itcat.information;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InformationApplication {

	public static void main(String[] args)
	{
		//SpringApplication.run(InformationApplication.class, args);
		Session session = HibernateUtil.getSessionFactory().openSession();
//		session.getTransaction().begin();
//
//		Product product = new Product();
//		product.setName("Product 16");
//		product.setCategory("Category 4");
//		product.setDescription("Product 16 (Category 4)");
//		product.setPrice(30L);
//
//		session.persist(product);
//
//		session.getTransaction().commit();
		session.close();
		HibernateUtil.close();
	}

}
