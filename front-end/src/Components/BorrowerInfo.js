import "./BorrowerInfo.css"


export default function BorrowerInfo({ borrowerInfo }) {
    return (
        borrowerInfo.map((borrower) => {
            return (
                <div className="customer" id="customer">
                    {borrower !== null ? (
                        <p>{borrower} </p>
                    ) :
                        (
                            <div className="borrowerNull" id="borrowerNull">
                                <p>Null</p>
                            </div>
                        )
                    }
                </div>
            )
        })
    )
}