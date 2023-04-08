import React from "react"
import "./BorrowerInfo.css"

export default function BorrowerInfo({ borrowerInfo }) {
    return (
        borrowerInfo.map((borrower, idx) => {
            return (
                <React.Fragment key={idx} >
                    <div className="customer" id="customer" data-testid="customer"
                    >
                        {borrower !== null ? (
                            <p>{borrower} </p>
                        ) :
                            (
                                <div className="borrowerNull" id="borrowerNull">
                                    <p>NA</p>
                                </div>
                            )
                        }
                    </div>
                </React.Fragment>
            )
        })
    )
}