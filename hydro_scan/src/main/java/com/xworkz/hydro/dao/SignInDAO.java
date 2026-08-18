package com.xworkz.hydro.dao;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.xworkz.hydro.entity.SignInEntity;

public interface SignInDAO {
    boolean save(SignInEntity signInEntity);

}
