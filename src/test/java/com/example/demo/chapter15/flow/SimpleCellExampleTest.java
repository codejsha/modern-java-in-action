package com.example.demo.chapter15.flow;

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
class SimpleCellExampleTest {
    @Mock
    private SimpleCell cell1;
    @Mock
    private SimpleCell cell2;
    @Mock
    private SimpleCell cell3;

    @BeforeEach
    void setUp() {
        cell1 = spy(new SimpleCell("C1"));
        cell2 = spy(new SimpleCell("C2"));
        cell3 = spy(new SimpleCell("C3"));
    }

    @Test
    void test1() {
        cell1.subscribe(cell3);
        verify(cell1, times(1)).subscribe(cell3);

        cell1.onNext(10);
        verify(cell1, times(1)).onNext(10);
        verify(cell3, times(1)).onNext(10);
        assertEquals(10, cell1.getValue());
        assertEquals(10, cell3.getValue());

        cell2.onNext(20);
        verify(cell2, times(1)).onNext(20);
        assertEquals(20, cell2.getValue());
    }
}
