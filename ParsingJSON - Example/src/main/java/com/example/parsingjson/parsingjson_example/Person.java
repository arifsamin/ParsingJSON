package com.example.parsingjson.parsingjson_example;

import java.util.List;

/**
 * Created by arifsamin on 3/19/14.
 */
public class Person {

    private String name;
    private String surname;
    private Address address;
    private List<PhoneNumber> phoneList;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneList(List<PhoneNumber> phoneList) {
        this.phoneList = phoneList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }
    // get and set

    public class Address {
        private String address;
        private String city;
        private String state;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAddress() {

            return address;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }
// get and set
    }

    public static class PhoneNumber {
        private String type;
        private String number;

        // get and set

        public void setType(String type) {
            this.type = type;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getType() {
            return type;
        }

        public String getNumber() {
            return number;
        }
    }
}
