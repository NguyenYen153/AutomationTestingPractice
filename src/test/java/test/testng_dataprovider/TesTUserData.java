package test.testng_dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.User;
import utils.data.DataObjectBuilder;

public class TesTUserData {

    @Test(dataProvider = "userData")//Interable collection
    public void tesstUserDataCollection(User userData){
        Assert.assertTrue(userData.getName().startsWith("Y"), "[ERR] Name is not start with Y");
        Assert.assertTrue(userData.getAge() >=18, "[ERR] Age is less than 18");
    }
    @DataProvider()// Khac method name nhung @Dataprovider (name = <name_dataprovider>) van dc
    public User[] userData(){
        String jsonFileLocation = "/src/test/resources/test-data/User.json";
        return DataObjectBuilder.buildDataObjectFrom(jsonFileLocation, User[].class);
    }
}
