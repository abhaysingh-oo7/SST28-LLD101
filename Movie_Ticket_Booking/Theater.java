import java.util.*;

class Theater {
    private String theaterId;
    private String name;
    private City city;
    private List<Screen> screens;

    public Theater(String theaterId, String name, City city) {
        this.theaterId = theaterId;
        this.name = name;
        this.city = city;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getName() {
        return name;
    }
}