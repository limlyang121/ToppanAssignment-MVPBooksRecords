import React from "react";
import { setupServer } from 'msw/node';
import { rest } from 'msw';

import { render, fireEvent, screen, waitFor } from "@testing-library/react";
import App from "./App";



const randomCountryHandler = (req, res, ctx) => {
  return res(
    ctx.json({
      country: {
        full_name: "Singapore",
        country_code: "AF"
      }
    })
  );
};

const top3BooksHandler = (req, res, ctx) => {
  return res(
    ctx.json([
      {
        author: "Sage john",
        name: "The adventure of Sage",
        borrower: [
          "Borrower 1",
          "Borrower 11",
          "Borrower 21"
        ]
      },
      {
        author: "SSR Card",
        name: "How to get lucky",
        borrower: [
          "Borrower 2",
          "Borrower 12",
          "Borrower 22"
        ]
      },
      {
        author: "Headphone Man",
        name: "How to get the best result of Earphone",
        borrower: [
          "Borrower 3",
          "Borrower 13",
          "Borrower 23"
        ]
      }
    ])
  );
};

const server = setupServer(
  rest.get('http://localhost:8080/getRandomCountry', randomCountryHandler),
  rest.get('http://localhost:8080/getTop3ReadBooks', top3BooksHandler)
);


beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

test("Display Data if data is exist", async () => {
  render(
    <div>
      <App />
    </div>
  );

  fireEvent.click(screen.getByTestId('action-btn'));


  // console.log(top3BooksHandler)
  await screen.findByTestId('book-item-1');
  expect(screen.getByTestId('book-item-1')).toHaveTextContent("1 The adventure of Sage arrow.svg by Sage john");
  expect(screen.getByTestId('book-item-2')).toHaveTextContent("2 How to get lucky arrow.svg by SSR Card");
  expect(screen.getByTestId('book-item-3')).toHaveTextContent("3 How to get the best result of Earphone arrow.svg by Headphone Man");

  //Click on First book arrow button
  fireEvent.click(screen.getAllByTestId('book-toggle')[0]);
  await screen.findAllByTestId('customer');
  expect(screen.getAllByTestId('customer')[0]).toHaveTextContent("Borrower 1");
  expect(screen.getAllByTestId('customer')[1]).toHaveTextContent("Borrower 11");
  expect(screen.getAllByTestId('customer')[2]).toHaveTextContent("Borrower 21");


  //Click on Second book arrow button
  fireEvent.click(screen.getAllByTestId('book-toggle')[1]);
  await screen.findAllByTestId('customer');
  expect(screen.getAllByTestId('customer')[0]).toHaveTextContent("Borrower 2");
  expect(screen.getAllByTestId('customer')[1]).toHaveTextContent("Borrower 12");
  expect(screen.getAllByTestId('customer')[2]).toHaveTextContent("Borrower 22");

  //Click on Third book arrow button
  fireEvent.click(screen.getAllByTestId('book-toggle')[2]);
  await screen.findAllByTestId('customer');
  expect(screen.getAllByTestId('customer')[0]).toHaveTextContent("Borrower 3");
  expect(screen.getAllByTestId('customer')[1]).toHaveTextContent("Borrower 13");
  expect(screen.getAllByTestId('customer')[2]).toHaveTextContent("Borrower 23");


  //Ensure the Book 1 and Book 2 follower is not exist anymore
  expect(screen.queryAllByText('Borrower 1')).toHaveLength(0);
  expect(screen.queryAllByText('Borrower 11')).toHaveLength(0);
  expect(screen.queryAllByText('Borrower 11')).toHaveLength(0);
  expect(screen.queryAllByText('Borrower 12')).toHaveLength(0);
  expect(screen.queryAllByText('Borrower 12')).toHaveLength(0);
  expect(screen.queryAllByText('Borrower 12')).toHaveLength(0);
});


test('if there is not data from back-end when get top3Books', async () => {
  server.listen()
  server.use(
    rest.get('http://localhost:8080/getTop3ReadBooks', (req, res, ctx) => {
      return res(ctx.json({
        message: "No Results"
      }));
    })
  );

  render(<App />);
  expect(screen.getByTestId('action-btn')).toHaveTextContent("Get Country: SG");
  expect(screen.getByTestId('error-message')).toHaveTextContent("No Data Found");

  fireEvent.click(screen.getByTestId('action-btn'));
  await screen.findByTestId('error-message');
  expect(screen.getByTestId('error-message')).toHaveTextContent("No Data Found");
  server.close()
});

test('Top books get but there is no value for That country', async () => {
  server.listen()
  server.use(
    rest.get("http://localhost:8080/getTop3ReadBooks"), (res, ctx) => {
      return res(
        ctx.json([
          {
            author: "Sage john",
            name: "The adventure of Sage",
            borrower: [
              "null",
              "null",
              "null"
            ]
          },
          {
            author: "SSR Card",
            name: "How to get lucky",
            borrower: [
              "Borrower 2",
              "null",
              "null"
            ]
          },
          {
            author: "Headphone Man",
            name: "How to get the best result of Earphone",
            borrower: [
              "Borrower 3",
              "Borrower 13",
              "Borrower 23"
            ]
          }
        ])
      );
    },
    rest.get('http://localhost:8080/getRandomCountry', (req, res, ctx) => {
      return res(ctx.json({
        country: {
          full_name: "Singapore",
          country_code: "SG"
        }
      }));
    }
    ));



  render(<App />)
  fireEvent.click(screen.getByTestId('action-btn'));
  await screen.findByTestId('book-item-1');
  expect(screen.getByTestId('book-item-1')).toHaveTextContent("1 The adventure of Sage arrow.svg by Sage john");
  expect(screen.getByTestId('book-item-2')).toHaveTextContent("2 How to get lucky arrow.svg by SSR Card");
  expect(screen.getByTestId('book-item-3')).toHaveTextContent("3 How to get the best result of Earphone arrow.svg by Headphone Man");

  //Click on First book arrow button
  fireEvent.click(screen.getAllByTestId('book-toggle')[0]);
  await screen.findAllByTestId('customer');
  expect(screen.getAllByTestId('customer')[0]).toHaveTextContent("NA");
  expect(screen.getAllByTestId('customer')[1]).toHaveTextContent("NA");
  expect(screen.getAllByTestId('customer')[2]).toHaveTextContent("NA");


  //Click on Second book arrow button
  fireEvent.click(screen.getAllByTestId('book-toggle')[1]);
  await screen.findAllByTestId('customer');
  expect(screen.getAllByTestId('customer')[0]).toHaveTextContent("Borrower 2");
  expect(screen.getAllByTestId('customer')[1]).toHaveTextContent("NA");
  expect(screen.getAllByTestId('customer')[2]).toHaveTextContent("NA");

  //Click on Third book arrow button
  fireEvent.click(screen.getAllByTestId('book-toggle')[2]);
  await screen.findAllByTestId('customer');
  expect(screen.getAllByTestId('customer')[0]).toHaveTextContent("Borrower 3");
  expect(screen.getAllByTestId('customer')[1]).toHaveTextContent("Borrower 13");
  expect(screen.getAllByTestId('customer')[2]).toHaveTextContent("Borrower 23");

  server.close()

});
