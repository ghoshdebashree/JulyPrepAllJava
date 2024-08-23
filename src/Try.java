import java.util.HashMap;
import java.util.Map;

public class Try {

    //output: "SFO-PHX", "PHX-ORD", "ORD-JFK", "JFK-TOK"
    public static void main(String[] args) {
        String[] array = {"SFO-PHX", "JFK-TOK", "ORD-JFK", "PHX-ORD"};
        System.out.println(patternMethod(array));

    }

    private static String  patternMethod(String[] array) {
        Map<String, String> flightMap = new HashMap<>();
        Map<String, String> reverseMap = new HashMap<>();
        String start = null;
        for(String airports : array){
            String[] airport = airports.split("-");
            flightMap.put(airport[0], airport[1]);
            reverseMap.put(airport[1], airport[0]);
        }
        for(String a : flightMap.keySet()) {
            if (!reverseMap.containsKey(a)) {
                start = a;
                break;
            }
        }
            StringBuilder route = new StringBuilder();
            String currentAirport = start;
            while(currentAirport != null && flightMap.containsKey(currentAirport)){
                if(route.length() > 0 ){
                    route.append(", ");
                }
                route.append(currentAirport).append("-").append(flightMap.get(currentAirport));
                currentAirport = flightMap.get(currentAirport);
            }



    return route.toString();

    }
}



