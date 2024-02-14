package com.example.modernjava.chapter15.flow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ArithmeticCellExampleTest {
    @Mock
    private SimpleCell cell1;
    @Mock
    private SimpleCell cell2;
    @Mock
    private ArithmeticCell cell3;
    @Mock
    private SimpleCell cell4;
    @Mock
    private ArithmeticCell cell5;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testExercise1() {
        cell1 = spy(new SimpleCell("C1"));
        cell2 = spy(new SimpleCell("C2"));
        cell3 = spy(new ArithmeticCell("C3"));

        cell1.subscribe(cell3::setLeft);
        cell2.subscribe(cell3::setRight);

        cell1.onNext(10);
        verify(cell1, times(1)).onNext(anyInt());
        assertEquals(10, cell1.getValue());
        assertEquals(10, cell3.getValue());

        cell2.onNext(20);
        verify(cell2, times(1)).onNext(anyInt());
        assertEquals(20, cell2.getValue());
        assertEquals(30, cell3.getValue());

        cell1.onNext(15);
        verify(cell1, times(2)).onNext(anyInt());
        assertEquals(15, cell1.getValue());
        assertEquals(35, cell3.getValue());
    }

    @Test
    void testExercise2() {
        cell1 = spy(new SimpleCell("C1"));
        cell2 = spy(new SimpleCell("C2"));
        cell3 = spy(new ArithmeticCell("C3"));
        cell4 = spy(new SimpleCell("C4"));
        cell5 = spy(new ArithmeticCell("C5"));

        cell1.subscribe(cell3::setLeft);
        cell2.subscribe(cell3::setRight);
        cell3.subscribe(cell5::setLeft);
        cell4.subscribe(cell5::setRight);

        cell1.onNext(10);
        verify(cell1, times(1)).onNext(anyInt());
        verify(cell3, times(1)).onNext(anyInt());
        verify(cell5, times(1)).onNext(anyInt());
        assertEquals(10, cell1.getValue());
        assertEquals(10, cell3.getValue());
        assertEquals(10, cell5.getValue());

        cell2.onNext(20);
        verify(cell2, times(1)).onNext(anyInt());
        verify(cell3, times(2)).onNext(anyInt());
        verify(cell5, times(2)).onNext(anyInt());
        assertEquals(20, cell2.getValue());
        assertEquals(30, cell3.getValue());
        assertEquals(30, cell5.getValue());

        cell1.onNext(15);
        verify(cell1, times(2)).onNext(anyInt());
        verify(cell3, times(3)).onNext(anyInt());
        verify(cell5, times(3)).onNext(anyInt());
        assertEquals(15, cell1.getValue());
        assertEquals(35, cell3.getValue());
        assertEquals(35, cell5.getValue());

        cell4.onNext(1);
        verify(cell4, times(1)).onNext(anyInt());
        verify(cell5, times(4)).onNext(anyInt());
        assertEquals(1, cell4.getValue());
        assertEquals(36, cell5.getValue());

        cell4.onNext(3);
        verify(cell4, times(2)).onNext(anyInt());
        verify(cell5, times(5)).onNext(anyInt());
        assertEquals(3, cell4.getValue());
        assertEquals(38, cell5.getValue());
    }
}
