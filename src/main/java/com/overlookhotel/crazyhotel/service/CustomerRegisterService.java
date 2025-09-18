package com.overlookhotel.crazyhotel.service;

import com.overlookhotel.crazyhotel.dto.RegisterForm;

public interface CustomerRegisterService {
    void registerCustomer(RegisterForm form) throws Exception;
}

