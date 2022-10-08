package com.example.assignment_2_part_a;

public class User {

    public class Address{
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;

        public Address()
        {
            this.geo = new Geo();
        }

        public class Geo{
            public String lat;
            public String lng;
        }
    }

    public class Company{
        public String companyName;
        public String catchPhrase;
        public String bs;
    }

    public int id;
    public String name;
    public String username;
    public String email;
    public String phone;
    public String website;
    public Address address;
    public Company company;

    public User(String username) {
        this.username = username;
    }

    public User(int id, String name, String username, String email,
                String street,String suite,String city,String zipcode,String lat,String lng,
                String phone, String website, String companyName,String catchPhrase,String bs) {
        this.address = new Address();
        this.company = new Company();

        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address.street = street;
        this.address.suite = suite;
        this.address.city = city;
        this.address.zipcode =zipcode;
        this.address.geo.lat = lat;
        this.address.geo.lng = lng;
        this.phone =phone;
        this.website = website;
        this.company.companyName = companyName;
        this.company.catchPhrase = catchPhrase;
        this.company.bs = bs;
    }

}
