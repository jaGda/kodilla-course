package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    static Temperatures temperaturesMock1 = mock(Temperatures.class);
    static Temperatures temperaturesMock2 = mock(Temperatures.class);

    static WeatherForecast weatherForecast1;
    static WeatherForecast weatherForecast2;

    private static final Map<String, Double> temperaturesMap1 = new HashMap<>() {{
        put("Poznan", 25.5);
        put("Krakow", 26.2);
        put("Wroclaw", 24.8);
        put("Warsaw", 25.2);
        put("Gdansk", 26.1);
    }};

    private static final Map<String, Double> temperaturesMap2 = new HashMap<>() {{
        put("Poznan", 25.0);
        put("Krakow", 5.0);
        put("Wroclaw", -1.5);
        put("Warsaw", 32.0);
        put("Gdansk", 12.00);
        put("Lodz", -5.00);
    }};

    @BeforeAll
    public static void beforeAllTests() {
        when(temperaturesMock1.getTemperatures()).thenReturn(temperaturesMap1);
        when(temperaturesMock2.getTemperatures()).thenReturn(temperaturesMap2);
        weatherForecast1 = new WeatherForecast(temperaturesMock1);
        weatherForecast2 = new WeatherForecast(temperaturesMock2);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given

        //When
        int quantityOfSensors1 = weatherForecast1.calculateForecast().size();
        int quantityOfSensors2 = weatherForecast2.calculateForecast().size();

        //Then
        Assertions.assertAll(
                () -> Assertions.assertEquals(5, quantityOfSensors1),
                () -> Assertions.assertEquals(6, quantityOfSensors2)
        );
    }

    @Test
    void testCalculateAverageTemperature() {
        //Given

        //When
        double averageTemperature1 = weatherForecast1.calculateAverageTemperature();
        double averageTemperature2 = weatherForecast2.calculateAverageTemperature();

        //Then
        Assertions.assertAll(
                () -> Assertions.assertEquals(25.56, averageTemperature1),
                () -> Assertions.assertEquals(11.25, averageTemperature2)
        );
    }

    @Test
    void testCalculateMedianTemperature() {
        //Given

        //When
        double medianTemperature1 = weatherForecast1.calculateMedianOfTemperature();
        double medianTemperature2 = weatherForecast2.calculateMedianOfTemperature();

        //Then
        Assertions.assertAll(
                () -> Assertions.assertEquals(25.5, medianTemperature1),
                () -> Assertions.assertEquals(8.5, medianTemperature2)
        );
    }
}
