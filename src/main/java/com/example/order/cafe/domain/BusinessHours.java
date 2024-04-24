package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.BusinessHoursErrorMsg;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Embeddable
public class BusinessHours {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private final List<OperationTimePerDay> operationTimePerDayList ;

    @Transient
    public static final int DISTINCT_DAY_SIZE = 7;

    private BusinessHours(List<OperationTimePerDay> operationTimePerDayList){
        validation(operationTimePerDayList);
        this.operationTimePerDayList = new ArrayList<>(operationTimePerDayList);
    }

    public static BusinessHours of(List<OperationTimePerDay> operationTimeList){
        return new BusinessHours(operationTimeList);
    }

    public void validation(List<OperationTimePerDay> operationTimePerDay){

        checkLengthOfOperationTimeList(getDistinctDays(operationTimePerDay));

    }

    public List<Days> getDistinctDays(List<OperationTimePerDay> operationTimePerDay){

        return operationTimePerDay.stream()
                .map(OperationTimePerDay::getDays)
                .distinct()
                .toList();

    }

    public void checkLengthOfOperationTimeList(List<Days> daysList){
        if(daysList.size() != DISTINCT_DAY_SIZE){
            throw new IllegalArgumentException(BusinessHoursErrorMsg.OPERATION_TIME_PER_DAY_LIST_LENGTH_ERROR_MSG.getValue());
        }
    }

    public List<OperationTimePerDay> getOperationTimeList(){
        return List.copyOf(operationTimePerDayList);
    }

    public String getTimePerDay(Days day){
        return operationTimePerDayList.get(day.ordinal()).getOperationTime().makeOperationTimeList();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessHours businessHours = (BusinessHours) o;
        return Objects.equals(operationTimePerDayList, businessHours.operationTimePerDayList);
    }

}