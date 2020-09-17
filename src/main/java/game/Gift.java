package game;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Gift_table")
public class Gift {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rewardId;
    private Long walletId;
    private String status;

    @PostPersist
    public void onPostPersist(){
        Used used = new Used();
        BeanUtils.copyProperties(this, used);
        used.publishAfterCommit();

        Added added = new Added();
        BeanUtils.copyProperties(this, added);
        added.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        game.external.Account account = new game.external.Account();
        // mappings goes here
        GiftApplication.applicationContext.getBean(game.external.AccountService.class)
                .add(account);

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }
    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
