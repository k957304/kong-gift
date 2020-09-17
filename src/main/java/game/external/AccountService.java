
package game.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="payment", url="http://payment:8080")
@FeignClient(name="gift", url="${api.url.payment}", fallback = AccountServiceFallback.class)
public interface AccountService {

    @RequestMapping(method= RequestMethod.POST, path="/accounts")
    public void add(@RequestBody Account account);

}