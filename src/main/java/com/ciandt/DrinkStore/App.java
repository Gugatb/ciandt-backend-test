package com.ciandt.DrinkStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching
public class App {
	/**
	 * Contrutor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pArguments os argumentos
	 */
	public static void main(String[] pArguments) {
//		Mongo mongo = new Mongo();
//		mongo.createCollection("drink_type");
		
//		Document document = new Document();
//		document.put("Test", "Value");
//		document.put("Test2", "Value 2");
//		mongo.insert("drink_type", document);
//		
//		Document dd = mongo.find("drink_type", "Test2", "Value 2");
//		System.err.println(dd.get("_id"));
		
//		Drink d = new Drink();
//		d.setDate(new Date());
//		d.setName("Teste");
//		d.setPrice(10.0d);
//		d.setType("Tipo");
//		mongo.insert(Collection.DRINK.getValue(), d.get());
		
//		Document dd = mongo.find(Collection.DRINK.getValue(), "name", "Teste");
//		System.out.println(dd.toJson());
//		
//		Drink ee = new Drink();
//		ee.set(dd);
//		System.out.println(ee.getId());
//		Document tt = mongo.find(Collection.DRINK.getValue(), ee.getName());
//		System.out.println(tt.toJson());
		
//		mongo.update(Collection.DRINK.getValue(), "Teste", "name", "Teste 2");
//		mongo.delete(Collection.DRINK.getValue(), "Teste 2");
		
		
		System.setProperty("spring.profiles.default", "dev");
		SpringApplication.run(App.class, pArguments);
	}
}
