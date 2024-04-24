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

    @Column(nullable = false)
    private long businessHoursId;

    private OperationTimePerDay(Days days, OperationTime operationTime, long businessHoursId){
        validation(operationTime);
        this.days = days;
        this.operationTime = operationTime;
        this.businessHoursId = businessHoursId;
    }

//    public static OperationTimePerDay of(Days days, OperationTime operationTime){
//        return new OperationTimePerDay(days, operationTime);
//    }

    public static OperationTimePerDay of(Days days, OperationTime operationTime, long businessHoursId){
        return new OperationTimePerDay(days, operationTime, businessHoursId);
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
