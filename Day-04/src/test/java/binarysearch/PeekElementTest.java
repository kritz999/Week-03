package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeekElementTest {

    @Test
    void findPeakElement2(){

        int[] arr = {1, 3, 20, 4, 1, 0};
        int result = PeekElement.findPeakElement(arr);

        assertEquals(2,result);
    }


}