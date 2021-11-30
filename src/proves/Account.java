package proves;

/*
 * AccountIntial.java
 *
 * This is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation v3.
 *
 * @see <a href="http://www.gnu.org/licenses/gpl.html">GNU License</a> for more information.
 *
 * Copyright (c) Joan Sèculi <a href="mailto:jseculi@escoladeltreball.org">Joan Sèculi</a>
 */

import java.text.NumberFormat;

/**
 * Enter a description
 *
 * @author <a href="mailto:jseculi@escoladeltreball.org">Joan Sèculi</a>
 * @version 1.0
 * @see <a href="http://www.gnu.org/licenses/gpl.html">GNU License</a> for more information.
 * @since 10/11/2021
 * <p>
 * <p>
 * This is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation v3.
 */
public class Account {
    private NumberFormat fmt = NumberFormat.getCurrencyInstance();

    private final float annualInterest = 0.1f;  // interest rate of 10%

    private long acctNumber;
    private float balance;
    public final String name;


    public Account(String owner, long account, float initial) {
        name = owner;
        acctNumber = account;
        balance = initial;
    }


    public boolean deposit(float amount) {
        boolean result = true;
        // Check the amount is a valid amount
        if (amount < 0) {
            result = false;
        } else {
            balance = balance + amount;
        }

        return result;
    }


    public boolean withdraw(float amount, float comission) {
        // check parameters
        if (isValidWithdraw(amount, comission)) {
            amount += comission;
            balance = balance - amount;
        }
        return isValidWithdraw(amount, comission);
    }

    private boolean isValidWithdraw(float amount, float comission) {
        //Check if there is enough money in the account
        return amount >= 0 && comission >= 0 && amount <= balance;

    }


    private void addAnnualInterest() {
        balance += (balance + annualInterest);

    }


    public float getBalance() {
        return balance;
    }


    public long getAccountNumber() {
        return acctNumber;
    }


    public String toString() {
        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
    }


}