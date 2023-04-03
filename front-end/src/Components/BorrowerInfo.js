import "./BorrowerInfo.css"


export default function BorrowerInfo({ borrowerInfo }) {
    return (
        borrowerInfo.map((borrower) => {
            return (
                <div className="customer" id="customer">
                    <p>{borrower} </p>
                </div>
            )
        })
    )
}