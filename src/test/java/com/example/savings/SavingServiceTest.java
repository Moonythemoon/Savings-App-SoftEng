package com.example.savings;

import com.example.savings.model.Saving;
import com.example.savings.repository.SavingRepository;
import com.example.savings.service.SavingService;
import com.example.savings.service.SavingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SavingServiceTest {

    @Mock
    private SavingRepository savingRepository;

    @InjectMocks
    private SavingServiceImpl savingService;

    public SavingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByCustomerNumber() {
        Saving saving = new Saving();
        saving.setCustomerNumber(123);

        when(savingRepository.findByCustomerNumber(123)).thenReturn(saving);

        Saving found = savingService.findByCustomerNumber(123);

        assertEquals(123, found.getCustomerNumber());
    }

    @Test
    public void testSave() {
        Saving saving = new Saving();
        saving.setCustomerNumber(123);

        when(savingRepository.save(saving)).thenReturn(saving);

        Saving saved = savingService.save(saving);

        assertEquals(123, saved.getCustomerNumber());
        verify(savingRepository, times(1)).save(saving);
    }
}
