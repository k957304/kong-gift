package game;

public class Added extends AbstractEvent {

    private Long id;

    public Added(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
