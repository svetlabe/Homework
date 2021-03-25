import ItemList from './ItemList';
    export default function BankAccount({bankAccountName, currentBalance, transactions}: any) {
        var c = transactions.isDeposit ? 'deposit' : 'transfer'
        return (
            <fieldset className="BankAccount" >
                <legend>{bankAccountName}</legend>
                Current Balance: {currentBalance}
                <div>
                    <h4>{"Transactions"}</h4>
                <ul>
                    {transactions.map((transaction: any, i: number) =>
                        <li style={{ color: transaction.isDeposit? '#007272': 'red' }}> {transaction.name} GBP {transaction.amount} </li>
                    )}
                </ul>
                </div>
            </fieldset>
        );

      //Alternative way to display transactions
        // <ItemsList title="Transactions" items={transactions} extractorFunc={transaction => transaction.name + ': '+ transaction.amount} />
}

