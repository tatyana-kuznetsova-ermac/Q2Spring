package mappers.weather;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mappers.weather.model.MainWeather;
import mappers.weather.model.Response;
import mappers.weather.model.Weather;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private String country;
    private String city;
    private Response response;
    private Weather weather;
    private MainWeather mainWeather;


    @Given("country: (.*)")
    public void set_country(String country) {
        this.country = country;
    }

    @Given("city: (.*)")
    public void set_city(String city) {
        this.city = city;

    }

    @When("we are requesting weather data")
    public void request_weather() throws IOException {
        WeatherRequester weatherRequester = new WeatherRequester();
        response = weatherRequester.requestWeather(country, city);


    }

    @Then("lon is (.*)")
    public void check_lon(Double lon) {
        assertEquals(lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(Double lat) {
        assertEquals(lat, response.getCoord().getLat());

    }

    @Then("weather data is:")
    public void check_weather(Map<String, String> data) {
        Weather weather = response.getWeathers().get(0);

        assertEquals(Integer.valueOf(data.get("id")), weather.getId());
        assertEquals(data.get("main"), weather.getMain());
        assertEquals(data.get("description"), weather.getDescription());
        assertEquals(data.get("icon"), weather.getIcon());


    }

    @Then("base is (.*)")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase());
    }

    @Then("main data is:")
    public void check_main(Map<String, String> data) {

        Assertions.assertEquals(Double.valueOf(data.get("temp")), response.getMainWeather().getTemp());
        Assertions.assertEquals(Double.valueOf(data.get("pressure")), response.getMainWeather().getPressure());
        Assertions.assertEquals(Double.valueOf(data.get("humidity")), response.getMainWeather().getHumidity());
        Assertions.assertEquals(Double.valueOf(data.get("temp_min")), response.getMainWeather().getTemp_min());
        Assertions.assertEquals(Double.valueOf(data.get("temp_max")), response.getMainWeather().getTemp_max());

    }

    @Then("visibility is (.*)")
    public void check_visibility(Double visibility) {
        Assertions.assertEquals(visibility, response.getVisibility());
    }

    @Then("wind is:")
    public void check_wind(Map< String, String> wind) {
        Assertions.assertEquals(Double.valueOf(wind.get("speed")), response.getWind().getSpeed());
        Assertions.assertEquals(Double.valueOf(wind.get("deg")), response.getWind().getDeg());
    }

    @Then("clouds is :")
    public void chech_clouds(Map<String, String> clouds){
        Assertions.assertEquals(Double.valueOf(clouds.get("all")), response.getClouds().getAll()) ;

    }

    @Then("dt is (.*)")
    public void check_dt (Double dt){
        Assertions.assertEquals(dt, response.getDt());
    }

}
