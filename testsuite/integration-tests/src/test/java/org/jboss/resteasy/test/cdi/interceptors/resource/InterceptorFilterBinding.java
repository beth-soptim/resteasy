package org.jboss.resteasy.test.cdi.interceptors.resource;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

@NameBinding
@Target({ TYPE, METHOD })
@Retention(value = RUNTIME)
public @interface InterceptorFilterBinding {
}
