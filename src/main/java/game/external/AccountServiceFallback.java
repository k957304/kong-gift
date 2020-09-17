package game.external;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceFallback implements AccountService{

    @Override
    public void add(Account account) {
        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }

}
