package com.example.spring_course.repository;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.UserOfBank;
import com.example.spring_course.model.transfer.Transfer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ValidationTransferImpl implements ValidationTransfer {

    public ValidationTransferImpl() {
    }

    @Override
    public boolean cardIsValid(Transfer transfer, Map<Long, UserOfBank> mapOfUserOfBank) {
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

    @Override
    public boolean isHaveCardToAddMoney(Transfer transfer, Map<Long, UserOfBank> mapOfUserOfBank) {
        Long cardToNumber = Long.parseLong(transfer.cardToNumber());
        if (!mapOfUserOfBank.containsKey(cardToNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkConfirmOperation(ConfirmOperation confirmOperation, Map<Long, UserOfBank> mapOfUserOfBank, Map<Integer, Transfer> transferMap) {
        if (mapOfUserOfBank.get(
                Long.parseLong(transferMap.get(confirmOperation.getOperationId()).cardFromNumber())
        ).getVerificationCode() == Integer.parseInt(confirmOperation.code())) {
            return true;
        } else return false;
    }
}
