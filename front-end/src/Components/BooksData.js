import React, { useState } from "react";
import "./BooksData.css";
import BorrowerInfo from "./BorrowerInfo";
import { ReactComponent as Arrow } from "../Assest/arrow.svg";


export default function BooksData({ BooksData }) {
    const [showBorrower, setShowBorrower] = useState([0, 0, 0]);

    const changeDisplayBorrower = (idx) => {
        let updated = [0, 0, 0];
        if (showBorrower[idx] === 0)
            updated[idx] = 1;

        setShowBorrower(updated);

    }

    return (
        <div className="container" id="container">
            {/* Just add extra stability incase of different error message */}
            {Array.isArray(BooksData) && BooksData.length !== 0 ? (
                BooksData.map((book, idx) => {
                    return (
                        <React.Fragment key={`book-${idx}`}>
                            <div className="book-item" id={`book-item-${idx + 1}`}  data-testid={`book-item-${idx + 1}`} >
                                <div className="bookInfo">
                                    <p className="bookInfoLeft"   > {`${idx + 1}`}</p>
                                    <p className="bookInfoCenter" > {book.name} </p>

                                    {/* <h1>{`${idx + 1}  Book Name ${idx+1}`} </h1> */}
                                    <button
                                        className="book-toggle"
                                        id="book-toggle"
                                        data-testid="book-toggle"
                                        style={{ justifyContent: "flex-end" }}
                                        onClick={() => changeDisplayBorrower(idx)}

                                    >
                                        <Arrow />
                                    </button>
                                </div>

                                <div className="authorInfo" >
                                    <p> {`by ${book.author}`} </p>
                                </div>

                            </div>
                            <div className="borrowerInfo">
                                {showBorrower[idx] === 1 ? (
                                    <BorrowerInfo borrowerInfo={book.borrower} />
                                ) : (
                                    null
                                )}
                            </div>


                        </React.Fragment>

                    )
                })
            ) : (
                <div className="error-message" id="error-message" data-testid="error-message">
                    <p> No Data Found</p>

                </div>

            )}

        </div>
    );
}