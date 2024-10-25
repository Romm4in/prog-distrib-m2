package com.example.commande;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Commande {
   @GetMapping("/prix")
   public int price() {
      return 10;
   }
}