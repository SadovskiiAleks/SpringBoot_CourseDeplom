package com.example.spring_course.service;

import com.example.spring_course.model.Transfer;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LoggerMy {

    String fileWay = "log.txt";
    int id;

    public int loggerLog(Transfer transfer, boolean isConfirmedTransfer){
        StringBuilder stringBuilder = new StringBuilder();
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("'Date' yyyy.MM.dd 'time' hh:mm:ss a zzz");
        id++;

        stringBuilder.append("ID transfer: ");
        stringBuilder.append(id);
        stringBuilder.append(" ");
        stringBuilder.append(formatForDateNow.format((date)));
        stringBuilder.append(" Card of sender: ");
        stringBuilder.append(transfer.getCardFromNumber());
        stringBuilder.append(", card of recipient:");
        stringBuilder.append(transfer.getCardToNumber());
        stringBuilder.append(", amount of transfer:");
        stringBuilder.append(transfer.getAmount().getValue());
        stringBuilder.append(",  commission of transfer:");
        stringBuilder.append((transfer.getAmount().getValue()*10)/100);
        stringBuilder.append(", operation result: ");
        stringBuilder.append(isConfirmedTransfer);
        try(FileWriter writer = new FileWriter(fileWay, true)) {
            writer.write(stringBuilder.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
