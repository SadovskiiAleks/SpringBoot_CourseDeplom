package com.example.spring_course.repository;

import com.example.spring_course.dto.ConfirmOperation;
import com.example.spring_course.model.UserOfBank;
import com.example.spring_course.model.transfer.Transfer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ValidationTransfer {


    boolean cardIsValid(Transfer transfer, Map<Long, UserOfBank> mapOfUserOfBank);

    boolean isHaveCardToAddMoney(Transfer transfer, Map<Long, UserOfBank> mapOfUserOfBank);

    boolean checkConfirmOperation(ConfirmOperation confirmOperation, Map<Long, UserOfBank> mapOfUserOfBank, Map<Integer, Transfer> transferMap);
}
