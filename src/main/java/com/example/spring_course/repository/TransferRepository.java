package com.example.spring_course.repository;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.UserOfBank;
import com.example.spring_course.model.transfer.Transfer;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class TransferRepository implements TransferRepositoryInterface {


    private final Map<Long, UserOfBank> mapOfUserOfBank = new HashMap<>();
    private final Map<Integer, Transfer> transferMap = new HashMap<>();
    private int operationId = 0;

    public TransferRepository() {
        UserOfBank user1 = new UserOfBank(1111000011110001l, 10, 26, 555, 5000, 0000);
        mapOfUserOfBank.put(user1.getCardNumber(), user1);
        UserOfBank user2 = new UserOfBank(1111000011110002l, 10, 29, 555, 5000, 0000);
        mapOfUserOfBank.put(user2.getCardNumber(), user2);
        UserOfBank user3 = new UserOfBank(1111000011110003l, 10, 29, 555, 5000, 0000);
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
        if (!mapOfUserOfBank.containsKey(Long.parseLong(transfer.cardFromNumber()))) {
            return false;
        } else if (mapOfUserOfBank.get(Long.parseLong(transfer.cardFromNumber())).getCVV() != Integer.parseInt(transfer.cardFromCVV())) {
            return false;
        } else if (mapOfUserOfBank.get(Long.parseLong(transfer.cardFromNumber())).getValidTillMonth() !=
                transfer.getCardFromValidTill()[0] |
                mapOfUserOfBank.get(Long.parseLong(transfer.cardFromNumber())).getValidTillYear() !=
                        transfer.getCardFromValidTill()[1]) {
            return false;
        }
        return true;
    }

    public boolean isHaveCardToAddMoney(Transfer transfer) {
        Long cardToNumber = Long.parseLong(transfer.cardToNumber());
        if (!mapOfUserOfBank.containsKey(cardToNumber)) {
            return false;
        }
        return true;
    }

    public boolean checkConfirmOperation(ConfirmOperation confirmOperation) {
        if (mapOfUserOfBank.get(
                Long.parseLong(transferMap.get(confirmOperation.getOperationId()).cardFromNumber())
        ).getVerificationCode() == Integer.parseInt(confirmOperation.code())) {
            return true;
        } else return false;
    }
}
