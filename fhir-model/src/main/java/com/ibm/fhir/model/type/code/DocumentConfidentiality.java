/*
 * (C) Copyright IBM Corp. 2019, 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.model.type.code;

import com.ibm.fhir.model.annotation.System;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.String;

import java.util.Collection;
import java.util.Objects;

import javax.annotation.Generated;

@System("http://terminology.hl7.org/CodeSystem/v3-Confidentiality")
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class DocumentConfidentiality extends Code {
    public static final DocumentConfidentiality U = DocumentConfidentiality.builder().value(ValueSet.U).build();

    public static final DocumentConfidentiality L = DocumentConfidentiality.builder().value(ValueSet.L).build();

    public static final DocumentConfidentiality M = DocumentConfidentiality.builder().value(ValueSet.M).build();

    public static final DocumentConfidentiality N = DocumentConfidentiality.builder().value(ValueSet.N).build();

    public static final DocumentConfidentiality R = DocumentConfidentiality.builder().value(ValueSet.R).build();

    public static final DocumentConfidentiality V = DocumentConfidentiality.builder().value(ValueSet.V).build();

    private volatile int hashCode;

    private DocumentConfidentiality(Builder builder) {
        super(builder);
    }

    public ValueSet getValueAsEnumConstant() {
        return (value != null) ? ValueSet.from(value) : null;
    }

    /**
     * Factory method for creating DocumentConfidentiality objects from a passed enum value.
     */
    public static DocumentConfidentiality of(ValueSet value) {
        switch (value) {
        case U:
            return U;
        case L:
            return L;
        case M:
            return M;
        case N:
            return N;
        case R:
            return R;
        case V:
            return V;
        default:
            throw new IllegalStateException(value.name());
        }
    }

    /**
     * Factory method for creating DocumentConfidentiality objects from a passed string value.
     * 
     * @param value
     *     A string that matches one of the allowed code values
     * @throws IllegalArgumentException
     *     If the passed string cannot be parsed into an allowed code value
     */
    public static DocumentConfidentiality of(java.lang.String value) {
        return of(ValueSet.from(value));
    }

    /**
     * Inherited factory method for creating DocumentConfidentiality objects from a passed string value.
     * 
     * @param value
     *     A string that matches one of the allowed code values
     * @throws IllegalArgumentException
     *     If the passed string cannot be parsed into an allowed code value
     */
    public static String string(java.lang.String value) {
        return of(ValueSet.from(value));
    }

    /**
     * Inherited factory method for creating DocumentConfidentiality objects from a passed string value.
     * 
     * @param value
     *     A string that matches one of the allowed code values
     * @throws IllegalArgumentException
     *     If the passed string cannot be parsed into an allowed code value
     */
    public static Code code(java.lang.String value) {
        return of(ValueSet.from(value));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DocumentConfidentiality other = (DocumentConfidentiality) obj;
        return Objects.equals(id, other.id) && Objects.equals(extension, other.extension) && Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(id, extension, value);
            hashCode = result;
        }
        return result;
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.id(id);
        builder.extension(extension);
        builder.value(value);
        return builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Code.Builder {
        private Builder() {
            super();
        }

        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        @Override
        public Builder value(java.lang.String value) {
            return (value != null) ? (Builder) super.value(ValueSet.from(value).value()) : this;
        }

        public Builder value(ValueSet value) {
            return (value != null) ? (Builder) super.value(value.value()) : this;
        }

        @Override
        public DocumentConfidentiality build() {
            return new DocumentConfidentiality(this);
        }
    }

    public enum ValueSet {
        U("U"),

        L("L"),

        M("M"),

        N("N"),

        R("R"),

        V("V");

        private final java.lang.String value;

        ValueSet(java.lang.String value) {
            this.value = value;
        }

        /**
         * @return
         *     The java.lang.String value of the code represented by this enum
         */
        public java.lang.String value() {
            return value;
        }

        /**
         * Factory method for creating DocumentConfidentiality.ValueSet values from a passed string value.
         * 
         * @param value
         *     A string that matches one of the allowed code values
         * @throws IllegalArgumentException
         *     If the passed string cannot be parsed into an allowed code value
         */
        public static ValueSet from(java.lang.String value) {
            for (ValueSet c : ValueSet.values()) {
                if (c.value.equals(value)) {
                    return c;
                }
            }
            throw new IllegalArgumentException(value);
        }
    }
}
