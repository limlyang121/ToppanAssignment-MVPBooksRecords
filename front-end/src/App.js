import './App.css';
import { useEffect, useState } from 'react';
import CountryButton from './Components/CountryButton';
import { findTop3BooksAPI } from './APIFetch';
import BooksData from './Components/BooksData';

function App() {
  const [countryData, setCountryData] = useState("AF");
  const [dataFound, setDataFound] = useState(0);
  const [bookData, setBookData] = useState([]);

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

  }, [])


  return (

    <div>
      <div className='header'>
        <CountryButton countryName={countryData} />

      </div>
      <div className='content'>
        <BooksData BooksData={bookData} />
      </div>
    </div>

  );
}

export default App;

