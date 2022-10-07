package com.example.assignment_2_part_a;

public class User {
    public int id;
    public String name;
    public String username;
    public String email;

    public static class Address{
        public static String street;
        public static String suite;
        public static String city;
        public static int zipcode;

        public static class Geo{
            public static double lat;
            public static double lng;
        }
    }

    public String phone;
    public String website;

    public static class Company{
        public static String companyName;
        public static String catchPhrase;
        public static String bs;
    }

    public User(String username) {
        this.username = username;
    }

    public User(int id, String name, String username, String email,
                String street,String suite,String city,int zipcode,double lat,double lng,
                String phone, String website, String companyName,String catchPhrase,String bs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        Address.street = street;
        Address.suite = suite;
        Address.city = city;
        Address.zipcode =zipcode;
        Address.Geo.lat = lat;
        Address.Geo.lng = lng;
        this.phone =phone;
        this.website = website;
        Company.companyName = companyName;
        Company.catchPhrase = catchPhrase;
        Company.bs = bs;
    }

}
