package id.sharetea.sharetea;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Startup on 5/30/17.
 */

public class Product {

    public String uid;
    public String name;
    public String image;

    public Product()
    {}

    public Product(String uid, String name, String image) {
        this.uid=uid;
        this.name=name;
        this.image=image;
    }



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}