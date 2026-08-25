package com.cl.demo.responseobjects;

import com.cl.demo.entities.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PhoneNumberCreateResponse {
    String phoneNumberId;
    String countryCode;
    String phoneNumber;

    public static PhoneNumberCreateResponse convert(PhoneNumber phoneNumber) {
        PhoneNumberCreateResponse response = new PhoneNumberCreateResponse();
        if(phoneNumber != null && phoneNumber.getId() != null){
            response.setPhoneNumberId(phoneNumber.getId().toString());
            response.setCountryCode(phoneNumber.getCountryCode());
            if(phoneNumber.getPhoneNumber() != null){
                response.setPhoneNumber(phoneNumber.getPhoneNumber().toString());
            }
        }
        return response;
    }

    public static List<PhoneNumberCreateResponse> convert(List<PhoneNumber> phoneNumberList) {
        List<PhoneNumberCreateResponse> responseList = new ArrayList<>();
        if(phoneNumberList != null ){
            for (PhoneNumber phone : phoneNumberList) {
                if(phone != null && Boolean.TRUE.equals(phone.getIsActive())){
                    responseList.add(convert(phone));
                }
            }
        }
        return responseList;
    }
}
