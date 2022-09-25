package com.example.assignment_1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment_1.models.FoodItem;
import com.example.assignment_1.R;
import com.example.assignment_1.models.ResDB;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "flash_delivery.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.ItemTable.NAME+"("+ DatabaseSchema.ItemTable.Cols.NAME+" TEXT, "
                + DatabaseSchema.ItemTable.Cols.IMAGE+" INTEGER, "
                + DatabaseSchema.ItemTable.Cols.RESTAURANT+" TEXT, "
                + DatabaseSchema.ItemTable.Cols.PRICE+" DOUBLE);");

        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.RestaurantTable.NAME+"("+ DatabaseSchema.RestaurantTable.Cols.NAME+" TEXT, "
                + DatabaseSchema.RestaurantTable.Cols.IMAGE+" INTEGER);");


        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.UsersTable.NAME+"("+ DatabaseSchema.UsersTable.Cols.ID+" TEXT, "
                + DatabaseSchema.UsersTable.Cols.EMAIL+" TEXT, "
                + DatabaseSchema.UsersTable.Cols.PASSWORD+" TEXT);");

        sqLiteDatabase.execSQL("create table "+ DatabaseSchema.OrdersTable.NAME+"("+ DatabaseSchema.OrdersTable.Cols.ITEM_ID+" INTEGER, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_NAME+" TEXT, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_PRICE+" DOUBLE, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_TOTAL_PRICE+" DOUBLE,"
                + DatabaseSchema.OrdersTable.Cols.ITEM_AMOUNT+" INTEGER, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_IMG+" INTEGER, "
                + DatabaseSchema.OrdersTable.Cols.ITEM_RESTAURANT+" TEXT, "
                + DatabaseSchema.OrdersTable.Cols.USERNAME+" TEXT);");

        addItemsDB(sqLiteDatabase);
        addRestaurantsDB(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addItemsDB(SQLiteDatabase db)
    {
        ArrayList<FoodItem> genItems = new ArrayList<FoodItem>();
        genItems.add(new FoodItem("Big Mac", R.drawable.burger4,"MC Donald's",8.99));
            genItems.add(new FoodItem("McFries", R.drawable.mcfries,"MC Donald's",2.99));
        genItems.add(new FoodItem("McNugget", R.drawable.nuggets2,"MC Donald's",4.99));
        genItems.add(new FoodItem("McWings", R.drawable.wings4,"MC Donald's",3.99));
        genItems.add(new FoodItem("McSpicy", R.drawable.burger10,"MC Donald's",7.99));
        genItems.add(new FoodItem("McWrap", R.drawable.wrap,"MC Donald's",6.99));
        genItems.add(new FoodItem("Veg Burger", R.drawable.burger2,"MC Donald's",5.69));
        genItems.add(new FoodItem("McRice", R.drawable.rice,"MC Donald's",3.49));
        genItems.add(new FoodItem("McFlurry", R.drawable.icecream2,"MC Donald's",4.99));
        genItems.add(new FoodItem("McSmoothie", R.drawable.smoothie,"MC Donald's",7.99));

        genItems.add(new FoodItem("Bucket 8pcs", R.drawable.wings3,"KFC",7.99));
        genItems.add(new FoodItem("Bucket 10pcs", R.drawable.wings3,"KFC",12.99));
        genItems.add(new FoodItem("Bucket 12pcs", R.drawable.wings3,"KFC",16.26));
        genItems.add(new FoodItem("Fries", R.drawable.fries4,"KFC",3.55));
        genItems.add(new FoodItem("Wings", R.drawable.wings1,"KFC",4.99));
        genItems.add(new FoodItem("Nuggets", R.drawable.nuggets,"KFC",7.99));
        genItems.add(new FoodItem("KFC Rice", R.drawable.rice2,"KFC",5.99));

        genItems.add(new FoodItem("Chicken Pizza", R.drawable.pizza1,"Pizza Hut",8.99));
        genItems.add(new FoodItem("Hawaiian Pizza", R.drawable.pizza2,"Pizza Hut",7.99));
        genItems.add(new FoodItem("BBQ Pizza", R.drawable.pizza3,"Pizza Hut",10.99));
        genItems.add(new FoodItem("Cheese Pizza", R.drawable.pizza4,"Pizza Hut",6.99));
        genItems.add(new FoodItem("Tomato Pizza", R.drawable.pizza5,"Pizza Hut",2.99));
        genItems.add(new FoodItem("Sausage Pizza", R.drawable.pizza6,"Pizza Hut",5.99));
        genItems.add(new FoodItem("Bacon Pizza", R.drawable.pizza7,"Pizza Hut",6.99));

        genItems.add(new FoodItem("Chicken Burger", R.drawable.burger1,"Burger King",9.99));
        genItems.add(new FoodItem("Cheese Burger", R.drawable.burger6,"Burger King",8.99));
        genItems.add(new FoodItem("Double Burger", R.drawable.burger9,"Burger King",12.99));
        genItems.add(new FoodItem("Veg Burger", R.drawable.burger2,"Burger King",11.99));
        genItems.add(new FoodItem("Chicken Wings", R.drawable.wings2,"Burger King",4.99));
        genItems.add(new FoodItem("Buffalo Wings", R.drawable.wings1,"Burger King",5.99));
        genItems.add(new FoodItem("Fries", R.drawable.fries3,"Burger King",2.99));

        genItems.add(new FoodItem("Soft Taco", R.drawable.tacos2,"Taco Bell",7.99));
        genItems.add(new FoodItem("Hard Taco", R.drawable.tacos4,"Taco Bell",6.99));
        genItems.add(new FoodItem("Crispy Taco", R.drawable.tacos3,"Taco Bell",5.99));
        genItems.add(new FoodItem("Burrito", R.drawable.burrito,"Taco Bell",12.99));
        genItems.add(new FoodItem("Cheese Nachos", R.drawable.nachos2,"Taco Bell",9.99));
        genItems.add(new FoodItem("Spicy Nachos", R.drawable.nachos1,"Taco Bell",4.99));
        genItems.add(new FoodItem("Quesadillas", R.drawable.quesadilla,"Taco Bell",3.99));

        genItems.add(new FoodItem("Pepperoni Pizza", R.drawable.pizza9,"Dominos pizza",9.99));
        genItems.add(new FoodItem("Stuffed Pizza", R.drawable.pizza10,"Dominos pizza",8.99));
        genItems.add(new FoodItem("Combo Pizza", R.drawable.pizza1,"Dominos pizza",11.99));
        genItems.add(new FoodItem("Meat Pizza", R.drawable.pizza3,"Dominos pizza",14.99));

        genItems.add(new FoodItem("Chicken 2pcs", R.drawable.wings3,"Pop Eyes",3.99));
        genItems.add(new FoodItem("Chicken 4pcs", R.drawable.wings3,"Pop Eyes",5.99));
        genItems.add(new FoodItem("Chicken 6pcs", R.drawable.wings3,"Pop Eyes",7.99));
        genItems.add(new FoodItem("Chicken 8pcs", R.drawable.wings3,"Pop Eyes",9.99));
        genItems.add(new FoodItem("Chicken 10pcs", R.drawable.wings3,"Pop Eyes",14.99));

        genItems.add(new FoodItem("Chicken Burger", R.drawable.burger5,"In N Out",7.99));
        genItems.add(new FoodItem("Cheese Burger", R.drawable.burger3,"In N Out",9.99));
        genItems.add(new FoodItem("Beef Burger", R.drawable.burger7,"In N Out",8.99));
        genItems.add(new FoodItem("Double Burger", R.drawable.burger11,"In N Out",12.99));
        genItems.add(new FoodItem("Combo Burger", R.drawable.burger8,"In N Out",16.99));

        genItems.add(new FoodItem("Submarine 1ft", R.drawable.submarine1,"Subway",4.99));
        genItems.add(new FoodItem("Submarine 2ft", R.drawable.submarine2,"Subway",9.99));
        genItems.add(new FoodItem("Fries", R.drawable.fries2,"Subway",3.99));
        genItems.add(new FoodItem("Ice Cream", R.drawable.icecream,"Subway",2.99));

        genItems.add(new FoodItem("Ice Cone", R.drawable.icecream,"Baskin Robins",2.99));
        genItems.add(new FoodItem("Ice cream Mix", R.drawable.icecream3,"Baskin Robins",3.99));
        genItems.add(new FoodItem("Sundae", R.drawable.icecream4,"Baskin Robins",6.99));
        genItems.add(new FoodItem("Ice Combo", R.drawable.icecream5,"Baskin Robins",9.99));

        for (FoodItem f:genItems) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseSchema.ItemTable.Cols.NAME, f.name);
            cv.put(DatabaseSchema.ItemTable.Cols.IMAGE, f.img);
            cv.put(DatabaseSchema.ItemTable.Cols.RESTAURANT, f.restaurant);
            cv.put(DatabaseSchema.ItemTable.Cols.PRICE, f.price);
            db.insert(DatabaseSchema.ItemTable.NAME, null, cv);
        }
    }

    public void addRestaurantsDB(SQLiteDatabase db)
    {
        ArrayList<ResDB> genRestaurants = new ArrayList<ResDB>();
        genRestaurants.add(new ResDB("MC Donald's",R.drawable.mcdonalds));
        genRestaurants.add(new ResDB("KFC",R.drawable.kfc));
        genRestaurants.add(new ResDB("Pizza Hut",R.drawable.pizzahut));
        genRestaurants.add(new ResDB("Burger King",R.drawable.burgerking));
        genRestaurants.add(new ResDB("Taco Bell",R.drawable.tacos1));
        genRestaurants.add(new ResDB("Dominos pizza",R.drawable.dominos));
        genRestaurants.add(new ResDB("Pop Eyes",R.drawable.burgerking));
        genRestaurants.add(new ResDB("In N Out",R.drawable.in_n_out));
        genRestaurants.add(new ResDB("Subway",R.drawable.subway));
        genRestaurants.add(new ResDB("Baskin Robins",R.drawable.baskinrobins));

        for (ResDB r:genRestaurants) {
            ContentValues cv = new ContentValues();
            cv.put(DatabaseSchema.RestaurantTable.Cols.NAME, r.name);
            cv.put(DatabaseSchema.RestaurantTable.Cols.IMAGE, r.img);
            db.insert(DatabaseSchema.RestaurantTable.NAME, null, cv);
        }
    }

    /**
     * ALL IMAGE REFERENECES
     *
     * mcdonalds.jpg : https://pixabay.com/photos/donalds-mc-signs-signage-board-387237/
     *
     * kfc.jpg : https://pixabay.com/illustrations/poster-kfc-advertising-neon-sign-1049571/
     *
     * pizzahut.jpg : https://unsplash.com/photos/XWvqV3AwXVs
     *
     * burgerking.jpg : https://unsplash.com/photos/rsNbV-PiCHc
     *
     * dominos.jpg : https://unsplash.com/photos/MvtY-vo1lwk
     *
     * baskinrobins.jpg : Photo by Teejay: https://www.pexels.com/photo/two-ice-cream-cups-1362534/
     *
     * in_n_out.jpg : https://pixabay.com/photos/restaurant-in-n-out-burger-night-5467806/
     *
     * subway.jpg : Photo by Rajesh TP: https://www.pexels.com/photo/sandwich-and-slice-of-lemons-1603901/
     *
     * mcfries.jpg : Photo by Polina Tankilevitch: https://www.pexels.com/photo/mcdonalds-fries-on-white-surface-4109241/
     *
     * nuggets.jpg : Photo by Meggy Kadam Aryanto: https://www.pexels.com/photo/close-up-of-chicken-nuggets-7375449/
     *
     * wings1.jpg : Photo by Kai-Chieh Chan: https://www.pexels.com/photo/fried-chicken-on-a-wooden-cutting-board-5652260/
     *
     * wings2.jpg : Photo by Pixabay: https://www.pexels.com/photo/close-up-photo-of-fried-chicken-60616/
     *
     * wings3.jpg : Photo by Terrance Barksdale: https://www.pexels.com/photo/fried-chicken-on-paper-towel-9872916/
     *
     * wings4.jpg : Photo by Gonzalo Ruiz: https://www.pexels.com/photo/close-up-photo-of-fried-chicken-and-french-fries-on-yellow-background-12118979/
     *
     * icecream.jpg : Photo by Sittisak C: https://www.pexels.com/photo/photo-of-person-holding-ice-cream-1739347/
     *
     * nuggets2.jpg : Photo by jianwei zhu: https://www.pexels.com/photo/deep-fried-food-with-sauce-served-in-a-restaurant-8463469/
     *
     * rice.jpg : Photo by Trista Chen: https://www.pexels.com/photo/cooked-rice-on-black-ceramic-plate-723198/
     *
     * rice2.jpg : Photo by Anna Tarazevich: https://www.pexels.com/photo/cooked-fried-rice-in-a-pan-6937455/
     *
     * pizza1.jpg : Photo by Dominika Roseclay: https://www.pexels.com/photo/tasty-pizza-with-chicken-near-fresh-basil-leaves-4288047/
     *
     * pizza2.jpg : Photo by Engin Akyurt: https://www.pexels.com/photo/food-photography-of-pizza-1552635/
     *
     * pizza3.jpg : Photo by Pablo  Macedo: https://www.pexels.com/photo/pepperoni-pizza-with-eggs-845802/
     *
     * pizza4.jpg : Photo by ahmad nawawi: https://www.pexels.com/photo/pizza-on-food-tray-2714722/
     *
     * pizza5.jpg : Photo by Brett Jordan: https://www.pexels.com/photo/pizza-on-brown-wooden-board-825661/
     *
     * piza6.jpg : Photo by Polina Tankilevitch: https://www.pexels.com/photo/person-holding-a-slice-of-pizza-4109111/
     *
     * pizza7.jpg : Photo by Engin Akyurt: https://www.pexels.com/photo/close-up-photo-of-pizza-2619970/
     *
     * pizza8.jpg : Photo by Jonathan Petersson: https://www.pexels.com/photo/close-up-photography-of-pizza-1166120/
     *
     * pizza9.jpg : Photo by Edward Eyer: https://www.pexels.com/photo/pizza-with-red-pepper-and-cheese-1049620/
     *
     * pizza10.jpg : Photo by Sean M.: https://www.pexels.com/photo/brown-and-red-pepperoni-pizza-166451/
     *
     * burger1.jpg : Photo by ENESFİLM: https://www.pexels.com/photo/person-holding-crispy-chicken-burger-with-cheese-8130752/
     *
     * burger2.jpg : Photo by Rajesh TP: https://www.pexels.com/photo/burger-on-top-of-wooden-board-near-two-red-chili-1633528/
     *
     * burger3.jpg : Photo by Valeria Boltneva: https://www.pexels.com/photo/ham-burger-with-vegetables-1639557/
     *
     * burger4.jpg : Photo by Jonathan Borba: https://www.pexels.com/photo/hamburger-and-fries-photo-2983101/
     *
     * burger5.jpg : Photo by Anna Tukhfatullina Food Photographer/Stylist: https://www.pexels.com/photo/burger-with-sliced-vegetables-close-up-photography-2702674/
     *
     * burger6.jpg : Photo by Jonathan Borba: https://www.pexels.com/photo/ham-and-bacon-burger-2983098/
     *
     * burger7.jpg : Photo by Engin Akyurt: https://www.pexels.com/photo/shallow-focus-photo-of-hamburger-2282532/
     *
     * burger8.jpg : Photo by Lucas Andrade: https://www.pexels.com/photo/cooked-food-on-the-table-12577527/
     *
     * burger9.jpg : Photo by Israel Albornoz: https://www.pexels.com/photo/close-up-of-a-hamburger-on-black-background-12034622/
     *
     * burger10.jpg : Photo by Isaac Taylor: https://www.pexels.com/photo/photo-of-cheeseburger-and-french-fries-2119758/
     *
     * burger11.jpg : Photo by Tioroshi Lazaro: https://www.pexels.com/photo/close-up-photo-of-burger-2874990/
     *
     * taco1.jpg : Photo by Geraud pfeiffer: https://www.pexels.com/photo/delicious-taco-with-slice-of-lime-on-wooden-board-6605212/
     *
     * taco2.jpg : Photo by Israel Albornoz: https://www.pexels.com/photo/close-up-of-a-taco-in-a-hand-12034452/
     *
     * tacos3.jpg : Photo by Vinícius Caricatte: https://www.pexels.com/photo/person-showing-taco-with-parsley-on-top-2338015/
     *
     * tacos4.jpg : Photo by Chitokan: https://www.pexels.com/photo/close-up-photo-of-rice-and-tacos-2087748/
     *
     * nachos1.jpg : Photo by Dayvison de Oliveira Silva: https://www.pexels.com/photo/bowl-with-guacamole-between-nachos-on-plate-5696562/
     *
     * nachos2.jpg : Photo by Alejandro Aznar: https://www.pexels.com/photo/nachos-on-checkered-wax-paper-12557544/
     *
     * icecream2.jpg : Photo by Cheresha: https://www.pexels.com/photo/white-container-filled-with-chocolate-assorted-color-chocolate-chips-and-one-waffle-1200034/
     *
     * icecream3.jpg : Photo by George  Stremplis: https://www.pexels.com/photo/ice-cream-on-cone-with-crushed-peanuts-and-brownies-1006190/
     *
     * icecream4.jpg : Photo by Layyana Sheridean: https://www.pexels.com/photo/close-up-photo-of-ice-cream-dessert-2846337/
     *
     * icecream5.jpg : Photo by Kristina Paukshtite: https://www.pexels.com/photo/sundae-in-shallow-photo-1146758/
     *
     * fries2.jpg : Photo by Valeria Boltneva: https://www.pexels.com/photo/fries-and-dipping-sauce-1893555/
     *
     * fries3.jpg : Photo by Marco Fischer: https://www.pexels.com/photo/french-fries-with-red-sauce-115740/
     *
     * fries4.jpg : Photo by KALZ📸🇺🇬: https://www.pexels.com/photo/fries-on-plate-2498440/
     *
     * submarine1.jpg : Photo by Pixabay: https://www.pexels.com/photo/bread-breakfast-bun-close-up-461382/
     *
     * submarine2.jpg : Photo by Rajesh TP: https://www.pexels.com/photo/white-cream-on-white-bowl-1633525/
     *
     * quesadilla.jpg : Photo by ROMAN ODINTSOV: https://www.pexels.com/photo/quesadillas-on-a-brown-wooden-board-with-sliced-limes-4955213/
     *
     * burrito.jpg : Photo by Pixabay: https://www.pexels.com/photo/close-up-photo-of-a-burrito-461198/
     *
     * wrap.jpg : Photo by bam awey: https://www.pexels.com/photo/meats-and-vegetables-on-black-oval-sizzling-plate-2015191/
     *
     * smoothie.jpg : Photo by Josh Sorenson: https://www.pexels.com/photo/shake-in-a-glass-990439/
     */

}
