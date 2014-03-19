package com.example.parsingjson.parsingjson_example;

import com.example.parsingjson.parsingjson_example.Person.PhoneNumber;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by arifsamin on 3/19/14.
 */
public class JsonUtil {

    public static String toJSon(Person person) {
        try {
            // Here we convert Java Object to JSON
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", person.getName()); // Set the first name/pair
            jsonObj.put("surname", person.getSurname());

            JSONObject jsonAdd = new JSONObject(); // we need another object to store the address
            jsonAdd.put("address", person.getAddress().getAddress());
            jsonAdd.put("city", person.getAddress().getCity());
            jsonAdd.put("state", person.getAddress().getState());

            // We add the object to the main object
            jsonObj.put("address", jsonAdd);

            // and finally we add the phone number
            // In this case we need a json array to hold the java list
            JSONArray jsonArr = new JSONArray();

            for (PhoneNumber pn : person.getPhoneList() ) {
                JSONObject pnObj = new JSONObject();
                pnObj.put("num", pn.getNumber());
                pnObj.put("type", pn.getType());
                jsonArr.put(pnObj);
            }

            jsonObj.put("phoneNumber", jsonArr);

            return jsonObj.toString();

        }
        catch(JSONException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
