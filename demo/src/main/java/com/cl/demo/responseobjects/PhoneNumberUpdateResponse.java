package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PhoneNumberUpdateResponse {
    String phoneNumberId;
    String countryCode;
    String phoneNumber;

    public static PhoneNumberUpdateResponse convert(PhoneNumber phoneNumber) {
        PhoneNumberUpdateResponse response = new PhoneNumberUpdateResponse();
        if(phoneNumber != null && phoneNumber.getId() != null){
            response.setPhoneNumberId(phoneNumber.getId().toString());
            response.setCountryCode(phoneNumber.getCountryCode());
            if(phoneNumber.getPhoneNumber() != null){
                response.setPhoneNumber(phoneNumber.getPhoneNumber().toString());
            }
        }
        return response;
    }

    public static List<PhoneNumberUpdateResponse> convert(List<PhoneNumber> phoneNumberList) {
        List<PhoneNumberUpdateResponse> responseList = new ArrayList<>();
        if(phoneNumberList != null){
            for (PhoneNumber phone : phoneNumberList) {
                if(phone != null && Boolean.TRUE.equals(phone.getIsActive())){
                    responseList.add(convert(phone));
                }
            }
        }
        return responseList;
    }
}
