package com.demo.bankDemo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class BillPaymentRequest {
private String billType;
private String accountNumber;
private double amount;
}
