package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.PhoneNumber;
import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PhoneNumberService {
    //POST /phoneNumber/add Call addPhoneNumber
    public PhoneNumber addPhoneNumber(PhoneNumberCreateRequest requestObj){
        if(requestObj == null || requestObj.getPhoneNumber() == null){
            return new PhoneNumber();
        }
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(UUID.randomUUID());
        phoneNumber.setIsActive(Boolean.TRUE);
        phoneNumber.setCreatedDate(new Date());
        phoneNumber.setCountryCode(requestObj.getCountryCode());
        phoneNumber.setPhoneNumber(requestObj.getPhoneNumber());
        DemoApplication.PhoneNumber_List.add(phoneNumber);
        return phoneNumber;
    }

    //GET /phoneNumber/getById?uuid= Call getPhoneNumberById
    public PhoneNumber getPhoneNumberById(String uuid) {
        for (PhoneNumber phone : DemoApplication.PhoneNumber_List) {
            if (phone.getId().toString().equals(uuid) && phone.getIsActive() != false) {
                return phone;
            }
        }
        return new PhoneNumber();
    }

    //GET /phoneNumber/getAll Call getAllPhoneNumbers
    public List<PhoneNumber> getAllPhoneNumbers() {
        List<PhoneNumber> resultList = new ArrayList<>();
        for (PhoneNumber phone : DemoApplication.PhoneNumber_List) {
            if (phone.getIsActive()) {
                resultList.add(phone);
            }
        }
        return resultList;
    }

    //PUT /phoneNumber/update Call updatePhoneNumber
    public PhoneNumber updatePerson(PhoneNumberUpdateRequest updateObj) {
        PhoneNumber phone = getPhoneNumberById(updateObj.getUuid());
        if (phone == null || phone.getId() == null || !phone.getIsActive()) {
            return phone;
        }
        DemoApplication.PhoneNumber_List.remove(phone);

        phone.setCountryCode(HelperUtils.compare(phone.getCountryCode(), updateObj.getCountryCodeToUpdate()));
        phone.setPhoneNumber(HelperUtils.compare(phone.getPhoneNumber(), updateObj.getPhoneNumberToUpdate()));
        phone.setUpdatedDate(new Date());

        DemoApplication.PhoneNumber_List.add(phone);
        return phone;
    }

    //DELETE /phoneNumber/deleteById?id= Call deleteById
    public Boolean deleteById(String uuid) {
        PhoneNumber phoneNumber = getPhoneNumberById(uuid);
        if (phoneNumber == null || phoneNumber.getId() == null || phoneNumber.getIsActive() != true) {
            return false;
        } else {
            DemoApplication.PhoneNumber_List.remove(phoneNumber);
            phoneNumber.setIsActive(false);
            DemoApplication.PhoneNumber_List.add(phoneNumber);
            return true;
        }
    }
}
