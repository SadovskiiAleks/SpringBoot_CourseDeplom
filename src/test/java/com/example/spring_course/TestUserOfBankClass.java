package com.example.spring_course;

import com.example.spring_course.model.UserOfBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestUserOfBankClass {
    UserOfBank userOfBank;

    @BeforeEach
    public void setUser() {
        userOfBank = new UserOfBank(1, 1, 1, 1, 100, 0000);
    }

    @Test
    public void takeMoneyFromUser() {
        assertTrue(userOfBank.takeMoneyFromUser(100));
    }

    @Test
    public void takeMoneyFromUser2() {

        assertFalse(userOfBank.takeMoneyFromUser(101));
    }

    @Test
    public void takeMoneyFromUser3() {

        assertTrue(userOfBank.takeMoneyFromUser(1));
    }
}
