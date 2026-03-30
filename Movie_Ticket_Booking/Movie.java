class Movie {
    private String movieId;
    private String name;
    private int duration;
    private String language;

    public Movie(String movieId, String name, int duration, String language) {
        this.movieId = movieId;
        this.name = name;
        this.duration = duration;
        this.language = language;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }
}