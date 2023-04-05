package com.booksrecords.demo.MVPBookRecords.Util;

import com.booksrecords.demo.MVPBookRecords.ExceptionHandling.CountryNotFoundException;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

@Component
public class CountryDataUtils {
    private CountryData countryData;

    @Autowired
    public CountryDataUtils(CountryData countryData) {
        this.countryData = countryData;
    }

    private HashMap<String, CountryData> countryDataMap;

    @PostConstruct
    public  Map<String, CountryData> readCSV() throws IOException {
        countryDataMap = new HashMap<>();
        try {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "CountryList.csv");
            FileReader fileReader = new FileReader(file);

            com.opencsv.CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allMyData = csvReader.readAll();
            for (String[] data : allMyData){
                CountryData tempData = new CountryData();
                tempData.setCountryName(data[0]);
                tempData.setCountryCode(data[1]);
                tempData.setCountryNumber(Long.parseLong(data[2]));
                countryDataMap.put(data[1], tempData);
            }
        }catch (Exception e){
            System.err.println(e);
        }

        return countryDataMap;
    }

    public  long getCountryCode (String country){
        try{
            return countryDataMap.get(country).getCountryNumber();
        }catch(NullPointerException e){
            return 0;
        }
    }

    public CountryData getRandomCountry(){
        try{
            Random rd = new Random();
            List<String> countryKeyList = new ArrayList<>(countryDataMap.keySet());
            int randomIndex = rd.nextInt(countryKeyList.size());

            String randomCountry = countryKeyList.get(randomIndex);
            return countryDataMap.get(randomCountry);
        }catch (Exception e){
            return null;
        }

    }


}
