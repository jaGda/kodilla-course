package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        return temperatures.getTemperatures().values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public double calculateMedianOfTemperature() {
        double[] doubles = temperatures.getTemperatures().values().stream()
                .mapToDouble(Double::doubleValue)
                .sorted()
                .toArray();
        int midOfArr = doubles.length / 2;
        double medianWhenEvenArrLength = doubles[midOfArr];
        double medianWhenOddArrLength = (doubles[midOfArr] + doubles[midOfArr - 1]) / 2;

        return doubles.length % 2 != 0 ? medianWhenEvenArrLength : medianWhenOddArrLength;
    }
}
