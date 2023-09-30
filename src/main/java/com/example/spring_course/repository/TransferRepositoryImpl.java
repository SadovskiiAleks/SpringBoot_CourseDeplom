package com.example.spring_course.repository;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.UserOfBank;
import com.example.spring_course.model.transfer.Transfer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Data

public class TransferRepositoryImpl implements TransferRepository {

    private final Map<Long, UserOfBank> mapOfUserOfBank = new ConcurrentHashMap<>();
    private final Map<Integer, Transfer> transferMap = new ConcurrentHashMap<>();

    private int operationId = 0;

    //Почему то тут не получилось через RequiredArgsConstructor
    @Autowired
    private ValidationTransfer validationTransfer;

    public TransferRepositoryImpl() {
        UserOfBank user1 = new UserOfBank(1111000011110001l,
                10, 26, 555, BigDecimal.valueOf(50000), 0000);
        mapOfUserOfBank.put(user1.getCardNumber(), user1);
        UserOfBank user2 = new UserOfBank(1111000011110002l,
                10, 29, 555, BigDecimal.valueOf(50000), 0000);
        mapOfUserOfBank.put(user2.getCardNumber(), user2);
        UserOfBank user3 = new UserOfBank(1111000011110003l,
                10, 29, 555, BigDecimal.valueOf(50000), 0000);
        mapOfUserOfBank.put(user3.getCardNumber(), user3);
    }

    public int rememberTransaction(Transfer transfer) {
        operationId++;
        transferMap.put(operationId, transfer);
        return operationId;
    }

    public boolean transaction(Transfer transfer) {
        Long cardFromNumber = Long.parseLong(transfer.cardFromNumber());
        Long cardToNumber = Long.parseLong(transfer.cardToNumber());

        if (!mapOfUserOfBank.containsKey(cardFromNumber)) {
            return false;
        }
        if (!mapOfUserOfBank.containsKey(cardToNumber)) {
            return false;
        }
        if (mapOfUserOfBank.get(cardFromNumber)
                .takeMoneyFromUser(transfer.amount().value())
        ) {
            mapOfUserOfBank.get(cardToNumber).addMoneyToUser(
                    transfer.amount().value()
            );
            return true;
        } else {
            return false;
        }
    }

    public boolean cardIsValid(Transfer transfer) {
        return validationTransfer.cardIsValid(transfer, mapOfUserOfBank);
    }

    public boolean isHaveCardToAddMoney(Transfer transfer) {
        return validationTransfer.isHaveCardToAddMoney(transfer, mapOfUserOfBank);
    }

    public boolean checkConfirmOperation(ConfirmOperation confirmOperation) {
        return validationTransfer.checkConfirmOperation(confirmOperation, mapOfUserOfBank, transferMap);
    }
}
