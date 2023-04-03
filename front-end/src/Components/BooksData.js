import React from "react";
import "./BooksData.css";
import BorrowerInfo from "./BorrowerInfo";

export default function BooksData({ BooksData }) {
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
                                        id="book-toggle" >
                                        A
                                    </button>
                                </div>

                                <div className="authorInfo" >
                                    <p> {`by ${book.author}`} </p>
                                </div>

                            </div>
                            <div className="borrowerInfo">
                                <BorrowerInfo borrowerInfo={book.borrower} />
                            </div>

                        </React.Fragment>
                    )
                })
            ) : (
                <p>The book list is empty.</p>

            )}
        </div>
    );
}