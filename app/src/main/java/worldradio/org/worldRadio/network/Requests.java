package worldradio.org.worldRadio.network;

import java.net.MalformedURLException;


public class Requests {

    //The following String variables should be changed to your own API endpoints
    private static final String BASE_URL = "https://willshare.com/cs495/WRP/";
    private static final String GET_STATIONS = "GetAllApplicationData.php";
    private static final String POST_VOTE = "Vote.php";

    public static void getApplicationData(HttpClient.Callback callback) {
        try {
            HttpClient request = new HttpClient(BASE_URL, GET_STATIONS, callback);
            request.execute(HttpClient.GET);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
// Expects JSON that conforms to the following format:
// {
//            "status": 200,
//                "data": {
//            "active": [
//            {
//                "id": "106",
//                    "frequency": "91.3",
//                    "long_name": "WCRD Ball State U.",
//                    "short_name": "WCRD",
//                    "city": "Muncie",
//                    "state": "IN",
//                    "slogan": "Always Better Radio",
//                    "active": "1",
//                    "deleted": "0",
//                    "type": "College",
//                    "genre": "Variety",
//                    "stream": "http://someStream",
//                    "website": "http://wcrd.net/about/",
//                    "user_entered": "0",
//                    "first_station": "1"
//            },
        //]}}

    }

    public static void addVote(HttpClient.Callback callback, String id){
        try {
            HttpClient request = new HttpClient(BASE_URL, POST_VOTE, callback);
            request.setParamString(id);
            request.execute(HttpClient.POST);
        } catch (MalformedURLException e) {
            System.out.println("Error, bad URL");
            e.printStackTrace();
        }
    }
}
