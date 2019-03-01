package localhost.library.web.beans;

public class Genre {

    private Long id;
    private String name;

    public Genre() {

    }

    public Genre(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
