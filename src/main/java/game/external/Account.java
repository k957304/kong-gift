package game.external;

public class Account {

    private Long id;
    private Long giftId;
    private String giftStatus;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getGiftId() {
        return giftId;
    }
    public void setGiftId(Long giftId) {
        this.giftId = giftId;
    }

    public String getGiftStatus() {
        return giftStatus;
    }

    public void setGiftStatus(String giftStatus) {
        this.giftStatus = giftStatus;
    }
}
