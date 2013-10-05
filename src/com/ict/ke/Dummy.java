package com.ict.ke;

import java.io.IOException;

import com.ict.ke.engine.Ingredient;
import com.ict.ke.engine.Parser;

public class Dummy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Parser.parseIngredient("data/ingredient.csv");
			for (Ingredient ingredient : Parser.listIngredients)
				ingredient.print();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally{
			System.out.println("Done");
		}
	}

}
