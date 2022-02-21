package test_data;

import com.google.gson.Gson;

public class Test_Gson {
    public static void main(String[] args) {
        testFromJsonToObject();
        //testFromObjectToJson();
    }

    private static void testFromJsonToObject() {
        String userJSONObject = "{\n" +
                "  \"name\": \"Yen\",\n" +
                "  \"age\": 15\n" +
                "}";
        User user;
        Gson gson = new Gson();

        user = gson.fromJson(userJSONObject, User.class);
        System.out.println(user);
    }

    private static void testFromObjectToJson() {
        User user = new User ("Yen", 20);
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));

    }
}
