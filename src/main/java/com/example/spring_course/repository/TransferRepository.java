package com.example.spring_course.repository;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.transfer.Transfer;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public interface TransferRepository {

    int rememberTransaction(Transfer transfer);

    boolean transaction(Transfer transfer) ;

    boolean cardIsValid(Transfer transfer);

    boolean isHaveCardToAddMoney(Transfer transfer);

    boolean checkConfirmOperation(ConfirmOperation confirmOperation);

    Map<Integer, Transfer> getTransferMap();
}
