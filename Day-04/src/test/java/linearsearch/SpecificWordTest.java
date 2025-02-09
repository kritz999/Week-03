package linearsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificWordTest {

    @Test
    void wordmynameis(){
        String[] array ={"hello ", "my name is", "vinayak"};
        String word ="my";
        String result =SpecificWord.Word(array,word);

        assertEquals("my name is",result);
    }

}