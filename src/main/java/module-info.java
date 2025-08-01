module $MODULE_NAME$ {
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires io.smallrye.common.constraint;
    requires jakarta.cdi;
    requires jakarta.inject;
    requires jakarta.json;
    requires jakarta.persistence;
    requires jakarta.transaction;
    requires jakarta.validation;
    requires jakarta.ws.rs;
    requires java.sql;
    requires microprofile.rest.client.api;
    requires org.eclipse.microprofile.openapi;
    requires org.hibernate.orm.core;
    requires org.jboss.logging;
    requires org.mapstruct;
    requires quarkus.core;
    requires quarkus.hibernate.orm.panache;
    requires smallrye.config.core;
}