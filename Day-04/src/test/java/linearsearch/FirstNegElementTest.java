package linearsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNegElementTest {
    @Test
    void displayReturns5(){
 //      var FirstNegElement = new FirstNegElementTest();
//       int i=FirstNegElement.display(new int[]{1,2,3,4,5,-6});
//        assertEquals(5,FirstNegElement.display(new int[]{1,2,3,4,5,-6}));
//    }

     //ctrl+shift+t
    int [] array= {1,2,3,4,5,-6}  ;
    int result = FirstNegElement.display(array);

    assertEquals(5,result);


}

}