export async function findTop3BooksAPI(countryName) {
  let response = await fetch(`http://localhost:8080/getTop3ReadBooks?country_code=${countryName}`)
  return response.json()
}

export async function GetRandomCountryAPI() {
  let response = await fetch(`http://localhost:8080/getRandomCountry`)
  return response.json()
}
