package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Balance;
import com.simulator.riding_school_simulator.model.Horse;
import com.simulator.riding_school_simulator.model.User;
import com.simulator.riding_school_simulator.repository.HorseRepository;
import com.simulator.riding_school_simulator.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final HorseRepository horseRepository;

    public UserService(UserRepository userRepository, HorseRepository horseRepository) {
        this.userRepository = userRepository;
        this.horseRepository = horseRepository;
    }

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {

        if (user.getBalance() == null) {
            Balance balance = new Balance();
            balance.setAmount(BigDecimal.valueOf(1000));
            user.setBalance(balance);
        }
        return userRepository.save(user);
    }

    public Optional<Horse> buyHorse(Long userId, Horse horse) {
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Balance balance = user.getBalance();

            BigDecimal horsePrice = BigDecimal.valueOf(horse.getPrice());
            if (balance.getAmount().compareTo(horsePrice) >= 0) {
                balance.setAmount(balance.getAmount().subtract(horsePrice));
                horse.setOwner(user);
                horseRepository.save(horse);
                userRepository.save(user);
                return Optional.of(horse);
            }
        }
        return Optional.empty();
    }

    public Optional<User> buyStall(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Balance balance = user.getBalance();

            int stallCost = 500;
            if (balance.getAmount().compareTo(BigDecimal.valueOf(stallCost)) >= 0) {
                user.setStallLimit(user.getStallLimit() + 1);
                balance.setAmount(balance.getAmount().subtract(BigDecimal.valueOf(stallCost)));
                userRepository.save(user);
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
