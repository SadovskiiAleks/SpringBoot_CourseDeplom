package com.example.spring_course;

import com.example.spring_course.model.transfer.Amount;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.repository.TransferRepository;
import com.example.spring_course.repository.TransferRepositoryImpl;
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
        transferRepository = new TransferRepositoryImpl();
    }

    @Test
    public void testTransactionOne() {
        TransferRepository transferRepository = new TransferRepositoryImpl();

        // Правильно ли я использую заглушку для данного  проекта ? Или я, что то не то тестирую.
        // Просто данный объект я могу создать отдельно, без заглушки ?

        Transfer transfer = Mockito.mock(Transfer.class);
        when(transfer.cardFromNumber()).thenReturn("1111000011110001");
        when(transfer.cardToNumber()).thenReturn("1111000011110002");
        when(transfer.cardFromCVV()).thenReturn("555");
        when(transfer.getCardFromValidTill()).thenReturn(new int[]{10, 26});
        when(transfer.amount()).thenReturn(new Amount(10, "RUR"));

        assertTrue(transferRepository.transaction(transfer));
    }

//    @Test
//    public void testTransactionTwo() {
//        //Transfer transfer = new Transfer();
//
//        assertFalse(transferRepository.transaction(transfer));
//    }
//
//    @Test
//    public void testTransactionThree() {
//        //Transfer transfer = new Transfer();
//
//        assertFalse(transferRepository.transaction(transfer));
//    }
//
//
//    @Test
//    public void cardIsValid() {
//        Transfer transfer = new Transfer();
//
//        assertTrue(transferRepository.cardIsValid(transfer));
//    }
//
//    @Test
//    public void cardIsValidTwo() {
//        Transfer transfer = new Transfer();
//
//        assertTrue(transferRepository.cardIsValid(transfer));
//    }
//
//    @Test
//    public void cardIsValidThree() {
//        Transfer transfer = new Transfer();
//
//        assertTrue(transferRepository.cardIsValid(transfer));
//    }


}
