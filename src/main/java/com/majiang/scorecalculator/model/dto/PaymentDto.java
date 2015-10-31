package com.majiang.scorecalculator.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Created by xiaomingniu on 31/10/15.
 */
public class PaymentDto {

    @JsonIgnore
    private List<Integer> payment;

    public PaymentDto(List<Integer> payment) {
        this.payment = payment;
    }

    public int getTotalPayment() {
        return payment.stream().mapToInt(p->p).sum();
    }

    public List<Integer> getPayments() {
        return payment;
    }

}
