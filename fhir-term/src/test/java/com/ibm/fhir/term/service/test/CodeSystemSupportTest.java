/*
 * (C) Copyright IBM Corp. 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.term.service.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.fhir.model.resource.CodeSystem;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.term.util.CodeSystemSupport;

public class CodeSystemSupportTest {
    @Test
    public void testGetAncestorsAndSelf1() {
        CodeSystem codeSystem = CodeSystemSupport.getCodeSystem("http://ibm.com/fhir/CodeSystem/cs5|1.0.0");
        Set<String> actual = CodeSystemSupport.getAncestorsAndSelf(codeSystem, Code.of("r"));
        Set<String> expected = new HashSet<>(Arrays.asList("r", "p", "m"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetAncestorsAndSelf2() {
        // hierarchy meaning is not defined for this code system
        CodeSystem codeSystem = CodeSystemSupport.getCodeSystem("http://terminology.hl7.org/CodeSystem/condition-clinical");
        Set<String> actual = CodeSystemSupport.getAncestorsAndSelf(codeSystem, Code.of("relapse"));
        Set<String> expected = new HashSet<>(Arrays.asList("relapse", "active"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescendantsAndSelf1() {
        CodeSystem codeSystem = CodeSystemSupport.getCodeSystem("http://ibm.com/fhir/CodeSystem/cs5|1.0.0");
        Set<String> actual = CodeSystemSupport.getDescendantsAndSelf(codeSystem, Code.of("m"));
        Set<String> expected = new HashSet<>(Arrays.asList("m", "p", "q", "r"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescendantsAndSelf2() {
        // hierarchy meaning is not defined for this code system
        CodeSystem codeSystem = CodeSystemSupport.getCodeSystem("http://terminology.hl7.org/CodeSystem/condition-clinical");
        Set<String> actual = CodeSystemSupport.getDescendantsAndSelf(codeSystem, Code.of("active"));
        Set<String> expected = new HashSet<>(Arrays.asList("active", "recurrence", "relapse"));
        Assert.assertEquals(actual, expected);
    }
}
