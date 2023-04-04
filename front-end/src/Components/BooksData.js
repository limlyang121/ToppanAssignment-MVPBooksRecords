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
            {BooksData.length !== 0 ? (
                BooksData.map((book, idx) => {
                    return (
                        <React.Fragment key={`book-${idx}`}>
                            <div className="rectangle" id={`book-item-${idx + 1}`}   >
                                <div className="bookInfo">
                                    <h1>{`${idx + 1}  ${book.name}`} </h1>
                                    <button
                                        className="book-toggle"
                                        id="book-toggle"
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
                <div className="error-message" id="error-message">
                    <p> No Data Found</p>

                </div>

            )}
        </div>
    );
}