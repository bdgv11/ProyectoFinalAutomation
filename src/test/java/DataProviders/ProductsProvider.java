package DataProviders;

import Pojo.Products;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ProductsProvider {

    @DataProvider(name = "getSearchDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/JsonData/product.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<Products> testData = new Gson().fromJson(dataSet, new TypeToken<List<Products>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
