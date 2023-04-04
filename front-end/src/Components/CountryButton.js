// import { GetRandomCountryAPI } from "../APIFetch"
import "./CountryButton.css"


export default function CountryButton({countryName, getRandomCountry}) {

    return (
        <button
            id='action-btn'
            className='button'
            onClick={() => getRandomCountry()}
            >
            <p>Get Country: {countryName} </p>
        </button>
    )
}