package jmri.implementation.configurexml;

import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * DoubleTurnoutSignalHeadXmlTest.java
 *
 * Description: tests for the DoubleTurnoutSignalHeadXml class
 *
 * @author   Paul Bender  Copyright (C) 2016
 */
public class DoubleTurnoutSignalHeadXmlTest {

    @Test
    public void testCtor(){
      Assert.assertNotNull("DoubleTurnoutSignalHeadXml constructor",new DoubleTurnoutSignalHeadXml());
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

}

