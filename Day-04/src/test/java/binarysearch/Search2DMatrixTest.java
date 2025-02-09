package binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class Search2DMatrixTest {


    @Test
    void  searchMatrixtrue() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = Search2DMatrix.searchMatrix(matrix,target);

        assertEquals(true,result);

    }
}