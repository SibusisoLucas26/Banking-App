package com.demo.bankDemo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {

    private String recipient;
    private String amount;
}
