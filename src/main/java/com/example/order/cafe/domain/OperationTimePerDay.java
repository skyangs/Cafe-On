package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.OperationTimePerDayErrorMsg;
import com.example.order.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class OperationTimePerDay extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private final Days days;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private final OperationTime operationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BusinessHoursId")
    private BusinessHours businessHours;

    private OperationTimePerDay(Days days, OperationTime operationTime){
        validation(operationTime);
        this.days = days;
        this.operationTime = operationTime;
    }

    private OperationTimePerDay(Days days, OperationTime operationTime, BusinessHours businessHours){
        validation(operationTime);
        this.days = days;
        this.operationTime = operationTime;
        this.businessHours = businessHours;
    }

    public static OperationTimePerDay of(Days days, OperationTime operationTime){
        return new OperationTimePerDay(days, operationTime);
    }

    public static OperationTimePerDay of(Days days, OperationTime operationTime, BusinessHours businessHours){
        return new OperationTimePerDay(days, operationTime, businessHours);
    }

    public void validation(OperationTime operationTime){
        if(operationTime == null){
            throw new IllegalArgumentException(OperationTimePerDayErrorMsg.OPERATION_TIME_NON_NULL_ERROR_MSG.getValue());
        }
    }

    public Days getDays(){
        return days;
    }

    public OperationTime getOperationTime(){
        return operationTime;
    }
}
