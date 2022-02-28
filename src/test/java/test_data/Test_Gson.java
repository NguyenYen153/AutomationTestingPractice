package test_data;

import com.google.gson.Gson;
import utils.data.DataObjectBuilder;

public class Test_Gson {
    public static void main(String[] args) {
        testFromJsonToObject();
        //testFromObjectToJson();
    }

    private static void testFromJsonToObject() {
        String jsonFileLocation = "/src/test/resources/test-data/User.json";
        User[] users = DataObjectBuilder.buildDataObjectFrom(jsonFileLocation, User[].class);

        for(User user: users){
         System.out.println(user);
        }

    }

    private static void testFromObjectToJson() {
        User user = new User ("Yen", 20);
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));

    }
}
