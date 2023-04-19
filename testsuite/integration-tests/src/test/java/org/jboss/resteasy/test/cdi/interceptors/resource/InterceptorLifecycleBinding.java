package org.jboss.resteasy.test.cdi.interceptors.resource;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Target(TYPE)
@Retention(value = RUNTIME)
public @interface InterceptorLifecycleBinding {
}
