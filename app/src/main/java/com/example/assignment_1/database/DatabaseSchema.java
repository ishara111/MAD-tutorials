package com.example.assignment_1.database;

public class DatabaseSchema
{
    public static class ItemTable {
        public static final String NAME = "items";

        public static class Cols {
            public static final String NAME = "name";
            public static final String IMAGE = "image";
            public static final String RESTAURANT = "restaurant";
            public static final String PRICE = "price";
            //public static final String TOTPRICE = "totprice";
        }
    }
    public static class RestaurantTable {
        public static final String NAME = "restaurants";

        public static class Cols {
            public static final String NAME = "name";
            public static final String IMAGE = "image";
        }
    }

    public static class UsersTable {
        public static final String NAME = "users";

        public static class Cols {
            public static final String ID = "ID";
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
        }
    }

    public static class OrdersTable {
        public static final String NAME = "orders";

        public static class Cols {
            public static final String ITEM_ID = "id";
            public static final String ITEM_NAME = "name";
            public static final String ITEM_PRICE = "price";
            public static final String ITEM_TOTAL_PRICE = "tot_price";
            public static final String ITEM_AMOUNT = "amount";
            public static final String ITEM_IMG = "img";
            public static final String ITEM_RESTAURANT = "restaurant";
            public static final String USERNAME = "username";
        }
    }
}
