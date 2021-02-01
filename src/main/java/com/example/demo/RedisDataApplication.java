package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemsRepository;

@SpringBootApplication
public class RedisDataApplication implements CommandLineRunner{

	@Autowired
	ItemsRepository ir;
	
	public static void main(String[] args) {
		SpringApplication.run(RedisDataApplication.class, args);
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		//JedisConnectionFactory jf = new JedisConnectionFactory();
		//jf.setHostName("localhost");
		//jf.setPort(6379);
		//return jf;
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String,Object> redisTemplate(){
		RedisTemplate<String,Object> template = new RedisTemplate();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
		
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Saving");
//		Item i = new Item();
//		i.setItemId("id1");
//		i.setItemName("Chair");
//		i.setItemPrice(20.0);
//		i.setItemQty(2);
//		ir.save(i);
//		System.out.println("saved");
//		
		//Get the item
		Item iget = ir.findById("id1").get();
		System.out.println("getting item with name "+iget.getItemName());
		
//		//Update item
//		iget.setItemName("table");
//		ir.save(iget);
//		Item iafterUpdate = ir.findById("id1").get();
//		System.out.println("Item name after update is "+iafterUpdate.getItemName());
//		
//		//Delete item
//		ir.delete(iafterUpdate);
//		Item iafterDelete = ir.findById("id1").get();
//		System.out.println("item name after delete is "+iafterDelete.getItemName());
		
	}
}
