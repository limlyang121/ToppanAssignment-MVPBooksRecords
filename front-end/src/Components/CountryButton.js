// import { GetRandomCountryAPI } from "../APIFetch"
import "./CountryButton.css"


export default function CountryButton({countryCode, getRandomCountry}) {

    return (
        <button
            id='action-btn'
            className='button'
            data-testid='action-btn'
            onClick={() => getRandomCountry()}
            >
            <p>Get Country: {countryCode} </p>
        </button>
    )
}