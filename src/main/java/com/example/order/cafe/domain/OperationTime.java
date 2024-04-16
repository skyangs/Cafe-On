package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimeErrorMsg;
import com.example.order.global.common.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class OperationTime extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(unique = true)
    private final Time open;

    @OneToOne
    @JoinColumn(unique = true)
    private final Time close;

    @Transient
    public static final String DAY_OFF = "휴무";

    private OperationTime(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public static OperationTime of(Time open, Time close){
        return new OperationTime(open, close);
    }

    public boolean isOpen(Time open){
        return this.open.equals(open);
    }

    public boolean isClose(Time close){
        return this.close.equals(close);
    }

    public String makeOperationTimeList(){
        if(open.isThisTimeSameAsOtherTime(close)){
            return checkOpenTimeIsSameCloseTime();
        }

        if(open.isThisTimeAfterOtherTime(close)){
            throw new IllegalArgumentException(OperationTimeErrorMsg.OPEN_TIME_IS_FASTER_THAN_CLOSE_TIME_ERROR_MSG.getValue());
        }

        return formatOperationTime();
    }


    public String checkOpenTimeIsSameCloseTime(){
        return DAY_OFF;
    }


    public String formatOperationTime(){
        return this.open.formatHourAndMinute() + " - " + this.close.formatHourAndMinute();
    }

    public Time getOpen(){
        return open;
    }

    public Time getClose(){
        return close;
    }
}
