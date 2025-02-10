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
}
