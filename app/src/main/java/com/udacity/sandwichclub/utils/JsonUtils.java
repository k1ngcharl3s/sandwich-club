package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        // Create a brand new sandwich
        Sandwich sandwich = new Sandwich();
        // Creating the strings for all the items
        String mainName;
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> List_for_ingredients = new ArrayList<>();
        ArrayList<String> List_for_alsoKnownAs = new ArrayList<>();

        // Recover the arrays and strings

        if (json != null) {
            try {
                JSONObject sandwichJson = new JSONObject(json);
                JSONObject ObjectForName = sandwichJson.getJSONObject("name");

                mainName = ObjectForName.getString("mainName");
                placeOfOrigin = sandwichJson.getString("placeOfOrigin");
                description = sandwichJson.getString("description");
                image = sandwichJson.getString("image");
                // Grab the JSONArray and return the ingredients list and alsoKnowAs
                JSONArray alsoKnownAs = ObjectForName.getJSONArray("alsoKnownAs");
                for (int i = 0; i < alsoKnownAs.length(); i++) {
                    List_for_alsoKnownAs.add(alsoKnownAs.getString(i));
                }

                JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
                for (int i = 0; i < ingredients.length(); i++) {
                    List_for_ingredients.add(ingredients.getString(i));
                }

                // Insert each string inside of the sandwich item
                sandwich.setMainName(mainName);
                sandwich.setPlaceOfOrigin(placeOfOrigin);
                sandwich.setDescription(description);
                sandwich.setImage(image);
                sandwich.setIngredients(List_for_ingredients);
                sandwich.setAlsoKnownAs(List_for_alsoKnownAs);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return sandwich;
    }
}
