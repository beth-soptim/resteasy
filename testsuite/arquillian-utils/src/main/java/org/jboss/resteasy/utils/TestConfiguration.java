/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2024 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.resteasy.utils;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class TestConfiguration {

    /**
     * Checks if the security manager was enabled for the test suite.
     *
     * @return {@code true} if the security manager was enabled, otherwise {@code false}
     */
    public static boolean isSecurityManagerEnabled() {
        final String value = System.getProperty("security.manager");
        if (value == null) {
            return false;
        }
        return value.isBlank() || value.equalsIgnoreCase("true");
    }
}
