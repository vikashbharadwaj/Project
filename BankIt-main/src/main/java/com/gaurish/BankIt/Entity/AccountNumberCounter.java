package com.gaurish.BankIt.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@Table(name = "Counter")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountNumberCounter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long counter;
    private Year prevYear;
}
