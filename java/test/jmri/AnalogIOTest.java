package jmri;

import jmri.implementation.AbstractNamedBean;
import org.junit.*;

/**
 * Tests for the Light class
 *
 * @author	Daniel Bergqvist Copyright (C) 2018
 */
public class AnalogIOTest {

    @Test
    public void testAnalogIO() throws JmriException {
        float min = (float) -1.0;
        float max = (float) 1.0;
        AnalogIO analogIO = new MyAnalogIO("Analog");
        analogIO.setCommandedAnalogValue(min);
        Assert.assertTrue("AnalogIO has value -1.0", analogIO.getCommandedAnalogValue() == min);
        analogIO.setCommandedAnalogValue(max);
        Assert.assertTrue("AnalogIO has value 1.0", analogIO.getCommandedAnalogValue() == max);
        analogIO.setCommandedAnalogValue(min);
        Assert.assertTrue("AnalogIO has value -1.0", analogIO.getKnownAnalogValue() == min);
        analogIO.setCommandedAnalogValue(max);
        Assert.assertTrue("AnalogIO has value 1.0", analogIO.getKnownAnalogValue() == max);
        
        Assert.assertTrue("String value is Absolute",
                "Absolute".equals(AnalogIO.AbsoluteOrRelative.ABSOLUTE.toString()));
        Assert.assertTrue("String value is Relative",
                "Relative".equals(AnalogIO.AbsoluteOrRelative.RELATIVE.toString()));
    }
    
    @Before
    public void setUp() {
          jmri.util.JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
          jmri.util.JUnitUtil.tearDown();
    }

    
    private class MyAnalogIO extends AbstractNamedBean implements AnalogIO {

        float _value = (float) 0.0;
        
        public MyAnalogIO(String sys) {
            super(sys);
        }
        
        @Override
        public void setState(int s) throws JmriException {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public int getState() {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public String getBeanType() {
            return "AnalogIO";
        }

        @Override
        public void setCommandedAnalogValue(float value) throws JmriException {
            _value = value;
        }

        @Override
        public float getCommandedAnalogValue() {
            return _value;
        }

        @Override
        public float getMin() {
            return Float.MIN_VALUE;
        }

        @Override
        public float getMax() {
            return Float.MAX_VALUE;
        }

        @Override
        public float getResolution() {
            return (float) 0.1;
        }

        @Override
        public AbsoluteOrRelative getAbsoluteOrRelative() {
            return AbsoluteOrRelative.ABSOLUTE;
        }
    
    }
    
}
