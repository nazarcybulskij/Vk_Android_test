package nazar.optigra_vk_test.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by NAZAR on 26/06/2014.
 */
public class AvtorsList {
    @SerializedName("response")
    public ArrayList<Avtor> response=new ArrayList<Avtor>();

    public static class Avtor{
        @SerializedName("id")
        public String id;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("first_name")
        public String first_name;
    }


}
