package game;

public class Created  extends AbstractEvent{

    private Long id;
    private Long giftId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    public Long getGiftId() { return giftId; }

    public void setGiftId(Long giftId) { this.giftId = giftId; }

}
