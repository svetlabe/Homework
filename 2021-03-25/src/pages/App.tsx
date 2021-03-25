import React from 'react';
import logo from './logo.svg';
import './App.css';
import BankDirectory from './BankDirectory';


const bankAccountData = [
    {
        bankAccountName: "Petter's Bank Account",
        currentBalance:  10000000 ,
        transactions: [
            { name: "Purchase of car", amount: -1500000, isDeposit:false},
            { name: "Salary", amount: 2000000, isDeposit: true},
        ]
    },
    {
        bankAccountName: "Tom's Bank Account",
        currentBalance:  10000000 ,
        transactions: [
            { name: "Purchase of car", amount: -1000000, isDeposit:false},
            { name: "Salary", amount: 2000000, isDeposit: true},
            { name: "Tax returned", amount: 100000, isDeposit: true},
        ]
    },
    {
        bankAccountName: "Marina's Bank Account",
        currentBalance:  10000000,
        transactions: [
            { name: "Purchase of car", amount: -2500000, isDeposit:false},
            { name: "Salary", amount: 2000000, isDeposit: true},
        ]
    },
]


function App() {
  return (
    <React.Fragment>

        <BankDirectory accounts={bankAccountData} title="Super Duper Bank" />

    </React.Fragment>
  );
}

export default App;
