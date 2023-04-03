import "./CountryButton.css"

export default function CountryButton({countryName}) {

    return (
        <button
            id='action-btn'
            className='button'>
            <p>Get Country: {countryName} </p>
        </button>
    )
}