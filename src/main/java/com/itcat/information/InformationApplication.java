package com.itcat.information;

import com.itcat.information.model.СredentialsEntity;
import com.itcat.information.model.OrganizationEntity;
import com.itcat.information.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InformationApplication {

	public static void main(String[] args)
	{
		OrganizationEntity organization = OrganizationEntity.builder()
				.name("Водоканал4")
				.build();
		OrganizationEntity organization1 = new OrganizationEntity();
		organization1.setName("SomeName2");
		СredentialsEntity mainInfo = СredentialsEntity.builder()
				.login("test1")
				.password("testpwd2")
				//.description("desc")
				.organization(organization1)
				.build();

		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory())
		{
			Session session1 = sessionFactory.openSession();

			СredentialsEntity mainInfo1 = СredentialsEntity.builder()
					.login("login111")
					.password("testpwd3")
					//.description("desc")
					.organization(session1.getReference(OrganizationEntity.class, 2L))
					.build();


			try (session1)
			{
				Transaction transaction = session1.beginTransaction();

				//session1.persist(organization1);
				session1.persist(mainInfo1);

				session1.getTransaction().commit();
			}
		}


		//SpringApplication.run(InformationApplication.class, args);
		//Session session = HibernateUtil.getSessionFactory().openSession();

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
//		session.close();
//		HibernateUtil.close();
	}

}
