package com.tsi.AnimalKingdom.spring;

import com.google.gson.Gson;
import com.tsi.AnimalKingdom.animals.Animal;
import com.tsi.AnimalKingdom.animals.birds.Pigeon;
import com.tsi.AnimalKingdom.zoo.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * A structure of the animal kingdom implemented into a Zoo-like springboot application.
 * The application creates a small zoo where animals can rest and breed.
 * In addition, the zookeeper can request specific details for each animal in the zoo.
 * Currently, the Zoo database is an arraylist with the index acting as the animal's unique key, it kind of works like
 * a no-sql database.
 */
@SpringBootApplication
@RestController
public class AnimalKingdomApplication {

	/**
	 * HOW TO USE:
	 * 	Select animal with /animals/?id=id
	 *
	 * @param args
	 */

	static Zoo zoo = new Zoo();
	public static void main(String[] args) {
		SpringApplication.run(AnimalKingdomApplication.class, args);

		Gson g = new Gson();

		zoo.populateZoo();

	}


/*		TODO: Get method
//		- [ ] Get animal id
			- [x] Create arraylist of animals
			- [x] Populate arraylist with 5 animals
				Pigeon
				Cat
				Cat
				Pigeon
				Penguin
			- [ ] Create a mapping /animals/{data}
			- [ ] Implement get method
				- [ ] Import Gson
 */

	@GetMapping(path = {"/animals/all"})
	@ResponseBody
	public String showAllAnimals() {
		return zoo.toString();
	}


	@GetMapping(path = {"/animals", "/animals/{data}"})
	public Map<String, String> getAnimals (
			@PathVariable(required=false,name="data") String data,
			@RequestParam(required=false) Map<String,String> qparams
	) {

		HashMap<Object, Object> response = new HashMap<>();
		String animalIdString = qparams.get("id");



		try {
			int animalId = Integer.parseInt(animalIdString);
			Animal animal = zoo.getAnimal(animalId);
			System.out.println(animalIdString);
			System.out.println(animal);
//			response.put("Status",400);
//			response.
			response.put("Animal",animal.getName());
		} catch (Exception e){
//			response.put("status",400);
			response.put("Animal","Animal not found");
		}

		return new HashMap();
	}


	@GetMapping(path = {"/hello", "/user/{data}"})
	public Map<String, String> getMethod(
		@PathVariable(required=false,name="data") String data,
		@RequestParam(required=false) Map<String,String> qparams
	) {

	String ret = qparams.get("world");

		qparams.forEach((a,b) -> {
			System.out.println(String.format("%s -> %s",a,b));
		});

		if (data != null) {
			System.out.println(data);
		}

		HashMap<String, String> map = new HashMap<>();

		map.put("hello",ret);
		return map;
	}

	@PutMapping(path = {"/insertPigeon"})
	public String insertAnimal(
			@PathVariable(required=false,name="data") String data,
			@RequestParam(required=false) Map<String,String> qparams
	) {
		Pigeon p = new Pigeon();
		zoo.insertAnimal(p);

		return "Animal added";
	}


}
