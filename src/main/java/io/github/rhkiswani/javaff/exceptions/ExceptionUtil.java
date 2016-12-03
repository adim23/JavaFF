/*
 * Copyright 2016 Mohamed Kiswani.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.rhkiswani.javaff.exceptions;

import io.github.rhkiswani.javaff.lang.exceptions.IllegalParamException;

/**
 * @author Mohamed Kiswani
 * @since 0.0.1
 *
 */
public class ExceptionUtil {

    public static void handle(Throwable t){
        if (t == null){
            throw new IllegalParamException(SmartException.NULL_VAL, "Exception");
        }
        ExceptionHandlersFactory.getExceptionHandler(t.getClass()).handle(t);
    }

    public static Throwable getRootCause(Throwable throwable) {
        if (throwable == null) {
            return null;
        }

        Throwable cause = throwable;
        Throwable rootCause;
        while ((rootCause = cause.getCause()) != null) {
            cause = rootCause;
        }

        return cause;
    }
}
