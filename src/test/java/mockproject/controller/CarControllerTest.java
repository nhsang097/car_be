package mockproject.controller;

import mockproject.entity.Car;
import mockproject.service.CarsService;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    private CarsService carsService;

    @InjectMocks
    private CarController carController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    void addCar() throws Exception {
        Car car = new Car();
        car.setId(1L);
        car.setName("BMW");
        when(carsService.addCar(any(Car.class))).thenReturn(car);

        mockMvc.perform(MockMvcRequestBuilders.post("/addCar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"BMW\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("BMW"));

        verify(carsService, times(1)).addCar(any(Car.class));
    }


    @Test
    void deleteById() throws Exception {
        doNothing().when(carsService).deleteById(anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteById/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(carsService, times(1)).deleteById(anyLong());
    }

    @Test
    void findById() throws Exception {
        Car car = new Car();
        car.setName("BMW");
        when(carsService.findById(1L)).thenReturn(car);

        mockMvc.perform(MockMvcRequestBuilders.get("/findById/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("BMW"));
    }

    @Test
    void getAllCars() throws Exception {
        Car car1 = new Car();
        car1.setName("BMW");
        Car car2 = new Car();
        car2.setName("Mercedes");
        when(carsService.getAllCars()).thenReturn(Lists.newArrayList(car1, car2));

        mockMvc.perform(MockMvcRequestBuilders.get("/getAllCars")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("BMW"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Mercedes"));
    }

    @Test
    void deleteAllCars() throws Exception {
        doNothing().when(carsService).deleteAllCars();

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteAllCars"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(carsService, times(1)).deleteAllCars();
    }


}