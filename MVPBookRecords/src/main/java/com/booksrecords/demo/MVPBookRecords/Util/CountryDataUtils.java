package com.booksrecords.demo.MVPBookRecords.Util;

import com.booksrecords.demo.MVPBookRecords.ExceptionHandling.CountryNotFoundException;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CountryDataUtils {
    private CountryData countryData;

    @Autowired
    public CountryDataUtils(CountryData countryData) {
        this.countryData = countryData;
    }

    private HashMap<String, CountryData> countryDataMap;
    private static final String filePath = "CountryList.csv";

    @PostConstruct
    public  Map<String, CountryData> readCSV() throws IOException {
        countryDataMap = new HashMap<>();
        try {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + filePath);
            FileReader fileReader = new FileReader(file);

            com.opencsv.CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allMyData = csvReader.readAll();
            for (String[] data : allMyData){
                CountryData tempData = new CountryData();
                tempData.setCountryName(data[0]);
                tempData.setCountryName(data[1]);
                tempData.setCountryCode(Long.parseLong(data[2]));
                countryDataMap.put(data[1], tempData);
            }
        }catch (Exception e){
            System.err.println(e);
        }

        return countryDataMap;
    }

    public  long getCountryCode (String country){
        try{
            return countryDataMap.get(country).getCountryCode();
        }catch(NullPointerException e){
            return 0;
        }
    }


}
