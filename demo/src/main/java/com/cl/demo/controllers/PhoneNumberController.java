package com.cl.demo.controllers;

import com.cl.demo.requestobjects.PhoneNumberCreateRequest;
import com.cl.demo.requestobjects.PhoneNumberUpdateRequest;
import com.cl.demo.responseobjects.PhoneNumberCreateResponse;
import com.cl.demo.responseobjects.PhoneNumberUpdateResponse;
import com.cl.demo.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phoneNumber")
public class PhoneNumberController {
    @Autowired
    public PhoneNumberService phoneNumberService;

    @PostMapping("add")
    public PhoneNumberCreateResponse addPhoneNumber(@RequestBody PhoneNumberCreateRequest phone) {
        return PhoneNumberCreateResponse.convert(phoneNumberService.addPhoneNumber(phone));
    }

    @GetMapping("getById?uuid")
    public PhoneNumberCreateResponse getPhoneNumberById(@RequestParam String uuid) {
        return PhoneNumberCreateResponse.convert(phoneNumberService.getPhoneNumberById(uuid));
    }

    @GetMapping("getAll")
    public List<PhoneNumberCreateResponse> getAllPhoneNumbers() {
        return PhoneNumberCreateResponse.convert(phoneNumberService.getAllPhoneNumbers());
    }

    @PutMapping("update")
    public PhoneNumberUpdateResponse updatePerson(@RequestBody PhoneNumberUpdateRequest updateObj) {
        return PhoneNumberUpdateResponse.convert(phoneNumberService.updatePerson(updateObj));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam String id) {
        return phoneNumberService.deleteById(id);
    }
}
