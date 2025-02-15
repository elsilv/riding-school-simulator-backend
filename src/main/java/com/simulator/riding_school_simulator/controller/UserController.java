package com.simulator.riding_school_simulator.controller;

import com.simulator.riding_school_simulator.model.Horse;
import com.simulator.riding_school_simulator.model.User;
import com.simulator.riding_school_simulator.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/{id}/buy-horse")
    public ResponseEntity<String> buyHorse(@PathVariable Long id, @RequestBody Horse horse) {
        Optional<Horse> purchasedHorse = userService.buyHorse(id, horse);
        if (purchasedHorse.isPresent()) {
            return ResponseEntity.ok("Horse purchased successfully!");
        } else {
            return ResponseEntity.badRequest().body("Insufficient balance or user not found.");
        }
    }

    @PutMapping("/{userId}/buy-stall")
    public ResponseEntity<?> buyStall(@PathVariable Long userId) {
        Optional<User> updatedUserOpt = userService.buyStall(userId);

        if (updatedUserOpt.isPresent()) {
            User updatedUser = updatedUserOpt.get();
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.badRequest().body("Insufficient balance or user not found.");
        }
    }
}
