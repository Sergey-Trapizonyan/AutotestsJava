import org.json.JSONArray;
import org.json.JSONObject;

public class BodyClass {
    private JSONObject category = new JSONObject();
    private JSONArray photoUrls = new JSONArray();
    private JSONObject tag = new JSONObject();
    JSONObject tags = new JSONObject();
    private JSONArray tagArray = new JSONArray();
    public JSONObject requestBody = new JSONObject();

    public BodyClass(){
        //Заполнение Body
        category.put("id", 0);
        category.put("name", "string");

        photoUrls.put("string");

        tag.put("id", 0);
        tag.put("name", "string");

        tagArray.put(tag);

        tags.put("tag",tagArray);

        requestBody.put("id", 123);
        requestBody.put("name", "doggie");
        requestBody.put("status", "available");
        requestBody.put("category", category);
        requestBody.put("photoUrls", photoUrls);
        requestBody.put("tags",tagArray);
    }
}
