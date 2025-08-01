package com.ctw.workstation.simple;

import org.jboss.logging.Logger;

public class ExternalMessageServiceImpl implements ExternalMessageService {

    Logger logger = Logger.getLogger(ExternalMessageServiceImpl.class);


    @Override
    public String sayHelloFromOuterSpace(String name) {
        return "Hello from outer space" + name;
    }

    @Override
    public String sayHelloFromOuterSpace() {
        return "Hello from outer space";
    }

    @Override
    public void fazAlgo() {
        throw new IllegalStateException("Can't be executed");
    }

}

