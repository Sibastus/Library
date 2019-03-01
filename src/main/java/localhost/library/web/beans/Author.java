package localhost.library.web.beans;

public class Author {

    private String name;
    private Long id;

    public Author () {

    }

    public Author(String name, long id) {

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
