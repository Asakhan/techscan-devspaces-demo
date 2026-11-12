package egovframework.example.cmmn.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MaskingUtilTest {

    @Test
    void masksMiddleDigits() {
        assertEquals("110-***-***789", MaskingUtil.maskAccountNo("110-123-456789"));
        assertEquals("333-**-****789", MaskingUtil.maskAccountNo("333-12-3456789"));
    }

    @Test
    void nullSafe() {
        assertNull(MaskingUtil.maskAccountNo(null));
    }
}
