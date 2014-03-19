package com.example.parsingjson.parsingjson_example;

import com.example.parsingjson.parsingjson_example.Person.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arifsamin on 3/19/14.
 */
public class PersonObject {

    public static Person create() {

        Person person = new Person();
        person.setName("Arif");
        person.setSurname("Samin");

        Person.Address address = person.new Address();
        address.setAddress("Lot 82-1 Batu 4 1/2 Permatang Duyong");
        address.setCity("Melaka");
        address.setState("Melaka");

        person.setAddress(address);

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("0134567890");
        phoneNumber.setType("Mobile");

        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

        phoneNumbers.add(phoneNumber);

        phoneNumber.setNumber("0136434733");
        phoneNumber.setType("Home");

        phoneNumbers.add(phoneNumber);

        person.setPhoneList(phoneNumbers);

        return person;
    }
}
