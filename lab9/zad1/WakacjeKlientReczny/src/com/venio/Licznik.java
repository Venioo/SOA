package com.venio;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Licznik {
    @WebMethod
    public Long odlicz();
}
