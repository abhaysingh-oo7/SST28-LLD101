import java.util.*;

class City {
    private String cityId;
    private String name;
    private List<Theater> theaters;

    public City(String cityId, String name) {
        this.cityId = cityId;
        this.name = name;
        this.theaters = new ArrayList<>();
    }

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public String getName() {
        return name;
    }
}