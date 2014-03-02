package org.momentumjs.gradle.jsengine

import static org.junit.Assert.*

import org.junit.Test

class JsEngineDescriptorTest {

    @Test(expected = IllegalArgumentException)
    public void nameCannotBeNull() {
        new JsEngineDescriptor(null, "2", "3");
    }

    @Test(expected = IllegalArgumentException)
    public void versionCannotBeNull() {
        new JsEngineDescriptor("1", null, "3");
    }

    @Test
    public void ecmaCanBeNullOrMissingFromConstructor() {
        assertEquals(new JsEngineDescriptor("1", "2"), new JsEngineDescriptor("1", "2", null));
    }

    @Test
    public void ordering() {
        JsEngineDescriptor a2 = new JsEngineDescriptor("A", "2");
        JsEngineDescriptor a3 = new JsEngineDescriptor("A", "3");
        JsEngineDescriptor a3again = new JsEngineDescriptor("A", "3");
        JsEngineDescriptor a4 = new JsEngineDescriptor("A", "4");
        JsEngineDescriptor a4_5 = new JsEngineDescriptor("A", "4", "5");
        JsEngineDescriptor a2_5_1 = new JsEngineDescriptor("A", "2", "5.1");

        assertTrue(a2.compareTo(a3) < 0);
        assertEquals(a3, a3);
        assertEquals(a3, a3again);
        assertTrue(a3.compareTo(a3) == 0);
        assertTrue(a3.compareTo(a3again) == 0);
        assertTrue(a3.compareTo(a4) < 0);
        assertTrue(a4.compareTo(a4_5) < 0);
        assertTrue(a4_5.compareTo(a2_5_1) < 0);
    }
}
