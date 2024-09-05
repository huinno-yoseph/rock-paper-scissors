package com.example.game;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final String[] choices = {"rock", "paper", "scissors"};

    @GetMapping("/{userChoice}")
    public String playGame(@PathVariable String userChoice) {
        String computerChoice = getRandomChoice();
        String result = determineWinner(userChoice.toLowerCase(), computerChoice);
        return String.format("You chose %s, Computer chose %s. Result: %s", userChoice, computerChoice, result);
    }

    private String getRandomChoice() {
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a draw!";
        }

        switch (userChoice) {
            case "rock":
                return computerChoice.equals("scissors") ? "You win!" : "You lose!";
            case "paper":
                return computerChoice.equals("rock") ? "You win!" : "You lose!";
            case "scissors":
                return computerChoice.equals("paper") ? "You win!" : "You lose!";
            default:
                return "Invalid choice!";
        }
    }
}