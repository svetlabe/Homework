const bankAccountData = [
    {
        "bankAccountName": "Petter's Bank Account",
        "currentBalance": [
            { "currentbalance": 10000000 },

        ],
        "transactions": [
            { "name": "Purchase of car", "amount": -1500000},
            { "name": "Salary", "amount": 2000000},
        ]
    },
    {
        "bankAccountName": "Tom's Bank Account",
        "currentBalance": [
            { "currentbalance": 10000000 },

        ],
        "transactions": [
            { "name": "Tax returned", "amount": 200000},
            { "name": "Salary", "amount": 2000000},
        ]
    },
    {
        "bankAccountName": "Marina's Bank Account",
        "currentBalance": [
            { "currentbalance": 10000000 },

        ],
        "transactions": [
            { "name": "Purchase of car", "amount": -2500000},
            { "name": "Salary", "amount": 2000000},
        ]
    },
]

const ItemsList = ({ title, items, extractorFunc }) =>
    <React.Fragment>
        <h4>{title}</h4>
        <ul className="{title}">
            {items.map((item, i) => 
                <li key={i}>{extractorFunc(item)}</li>
            )}
        </ul>
    </React.Fragment>
    
const BankAccount = ({ bankAccountName, currentBalance, transactions }) =>
    <fieldset id={bankAccountName}>
        <legend>{bankAccountName}</legend>
        <ItemsList title="Current Balance" items={currentBalance} extractorFunc={balance => balance.currentbalance} />
        <ItemsList title="Transactions" items={transactions} extractorFunc={transaction => transaction.name + ': '+ transaction.amount} />
    </fieldset>

const BankDirectory = ({title, accounts}) =>
    <div>
        <header>
            <h1>{title}</h1>
        </header>
        <div>
            {accounts.map((account, i) =>
                <BankAccount key={i} {...account} />
            )}
        </div>
    </div>

ReactDOM.render(
    <BankDirectory accounts={bankAccountData} title="Super Dupper Bank" />,
    document.getElementById("app-root")
)
