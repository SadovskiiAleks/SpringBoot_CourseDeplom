package com.example.spring_course.repository;

import com.example.spring_course.model.ConfirmOperation;
import com.example.spring_course.model.transfer.Transfer;
import com.example.spring_course.model.UserOfBank;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class TransferRepository {


     Map<Long, UserOfBank> mapOfUserOfBank = new HashMap<>();
     Map<Integer,Transfer> transferMap = new HashMap<>();
     private int operationId = 0;

     public TransferRepository(){
         UserOfBank user1 = new UserOfBank(1111000011110001l, 10,26,555,5000,0000);
         mapOfUserOfBank.put(user1.getCardNumber(),user1);
         UserOfBank user2 = new UserOfBank(1111000011110002l, 10,29,555,5000,0000);
         mapOfUserOfBank.put(user2.getCardNumber(),user2);
         UserOfBank user3 = new UserOfBank(1111000011110003l, 10,29,555,5000,0000);
         mapOfUserOfBank.put(user3.getCardNumber(),user3);
     }

     public int rememberTransaction(Transfer transfer){
         operationId++;
         transferMap.put(operationId,transfer);
         return operationId;
     }
     public boolean transaction(Transfer transfer){
         if (!mapOfUserOfBank.containsKey(transfer.getCardFromNumber())){
             return false;
         }
         if (!mapOfUserOfBank.containsKey(transfer.getCardToNumber())){
             return false;
         }
         if (mapOfUserOfBank.get(transfer.getCardFromNumber())
                 .takeMoneyFromUser(transfer.getAmount().getValue())
         ) {
             mapOfUserOfBank.get(transfer.getCardToNumber()).addMoneyToUser(
                     transfer.getAmount().getValue()
             );
             return true;
         } else {
             return false;
         }
     }

     public boolean cardIsValid(Transfer transfer){
         if (!mapOfUserOfBank.containsKey(transfer.getCardFromNumber())){
             return false;
         } else if (mapOfUserOfBank.get(transfer.getCardFromNumber()).getCVV() != transfer.getCardFromCVV().intValue()){
             return false;
         } else if (mapOfUserOfBank.get(transfer.getCardFromNumber()).getValidTillMonth() !=
                 transfer.getCardFromValidTill()[0] |
                 mapOfUserOfBank.get(transfer.getCardFromNumber()).getValidTillYear() !=
                 transfer.getCardFromValidTill()[1]) {
             return false;
         }
         return true;
     }

     public boolean isHaveCardToAddMoney(Transfer transfer){
         if (!mapOfUserOfBank.containsKey(transfer.getCardToNumber())){
             return false;
         }
         return true;
     }

    public boolean checkConfirmOperation(ConfirmOperation confirmOperation) {
        if(mapOfUserOfBank.get(
                transferMap.get(confirmOperation.getOperationId()).getCardFromNumber()
        ).getVerificationCode() == Integer.parseInt(confirmOperation.getCode()) ) {
            return true;
        } else return false;
    }
}
