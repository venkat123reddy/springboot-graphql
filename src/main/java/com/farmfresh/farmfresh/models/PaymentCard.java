package com.farmfresh.farmfresh.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentCard {
    private String cardNumber;
    private String cardName;
    private String cardCVV;
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date cardDate;
}
