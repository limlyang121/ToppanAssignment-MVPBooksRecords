import './App.css';
import { useCallback, useEffect, useState } from 'react';
import CountryButton from './Components/CountryButton';
import { GetRandomCountryAPI, findTop3BooksAPI } from './APIFetch';
import BooksData from './Components/BooksData';

function App() {
  const [countryData, setCountryData] = useState("SG");
  const [bookData, setBookData] = useState([]);

  const getRandomCountry = useCallback (async  () => {
    let response = await GetRandomCountryAPI ();
    setCountryData (response.country.country_code)
  },[setCountryData])


  useEffect(() => {
    const fetchTop3BooksGlobally = async (countryName) => {
      let response = await findTop3BooksAPI(countryName);

      if (response.message === "Invalid Parameter" || response.message === "No Results") {
        setBookData([]);
      } else {
        setBookData(response);
      }
    }

    fetchTop3BooksGlobally(countryData);

  }, [countryData, getRandomCountry])


  return (

    <div>
      <div className='header'>
        <CountryButton countryName={countryData} getRandomCountry={getRandomCountry} />

      </div>
      <div className='content'>
        <BooksData BooksData={bookData} />
      </div>
    </div>

  );
}

export default App;

