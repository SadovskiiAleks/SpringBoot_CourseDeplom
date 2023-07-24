package com.example.spring_course;

import com.example.spring_course.model.transfer.Amount;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.repository.TransferRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class TestTransferRepository {
    TransferRepository transferRepository;

    @BeforeEach
    public void setTransferRepository() {
        transferRepository = new TransferRepository();
    }

    @Test
    public void testTransactionOne() {
        TransferRepository transferRepository = new TransferRepository();

        // Заглушка
        Transfer transfer = Mockito.mock(Transfer.class);
        when(transfer.getCardFromNumber()).thenReturn( 1111000011110001l);
        when(transfer.getCardToNumber()).thenReturn( 1111000011110002l);
        when(transfer.getCardFromCVV()).thenReturn(555);
        when(transfer.getCardFromValidTill()).thenReturn(new int[]{10,26});
        when(transfer.getAmount()).thenReturn(new Amount("RUR",10));

        assertTrue(transferRepository.transaction(transfer));
    }

    @Test
    public void testTransactionTwo() {
        Transfer transfer = new Transfer();

        assertFalse(transferRepository.transaction(transfer));
    }

    @Test
    public void testTransactionThree() {
        Transfer transfer = new Transfer();

        assertFalse(transferRepository.transaction(transfer));
    }


    @Test
    public void cardIsValid() {
        Transfer transfer = new Transfer();

        assertTrue(transferRepository.cardIsValid(transfer));
    }

    @Test
    public void cardIsValidTwo() {
        Transfer transfer = new Transfer();

        assertTrue(transferRepository.cardIsValid(transfer));
    }

    @Test
    public void cardIsValidThree() {
        Transfer transfer = new Transfer();

        assertTrue(transferRepository.cardIsValid(transfer));
    }


}
