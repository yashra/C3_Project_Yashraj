import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        for (Restaurant restaurant : restaurants){
            if (restaurant.getName().equals(restaurantName)){
                return restaurant;
            }
        }
        throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // Implemented code for TDD Testing

    /*//Failed Implementation
    public double getTotalValue(){
        double sum = 0.0;

        return sum;
    }*/

    public double getTotalValue(List<String> itemsSelected, String resturantName) throws restaurantNotFoundException {
        Restaurant restaurant = findRestaurantByName(resturantName);
        double sum = 0.0;
        for (String s : itemsSelected) {
            Item getItem = restaurant.findItemByName(s);
            if(getItem != null) sum += getItem.getPrice();
        }
        return sum;
    }
}
