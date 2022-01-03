package a3.makarenko;

import a3.makarenko.EmployeeModel.EmployeeList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class JSONWorkerTest {

    @Mock
    private ObjectMapper objectMapper;

    private ObjectMapper stdMapper = JSONWorker.mapper;


    @BeforeEach
    public void setup(){
        JSONWorker.mapper = objectMapper;
    }

    @AfterEach
    public void stdReturn(){
        JSONWorker.mapper = stdMapper;
    }

    @Test
    void read() {
        EmployeeList employeeList = RandomGenerator.getRandomEmployeeList(1, 2);
        try{
        when(objectMapper.readValue(any(File.class), eq(EmployeeList.class))).thenReturn(employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(JSONWorker.read("randomFile").getEmployeeList().size() > 0);
        try{
        verify(objectMapper, times(1)).readValue(any(File.class), eq(EmployeeList.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void write() {
        EmployeeList employeeList = RandomGenerator.getRandomEmployeeList(1, 2);
        ArgumentCaptor<EmployeeList> valueCapture = ArgumentCaptor.forClass(EmployeeList.class);
        try{
            doNothing().when(objectMapper).writeValue(any(File.class), valueCapture.capture());
            JSONWorker.write("randomFile", employeeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(employeeList, valueCapture.getValue());
    }
}