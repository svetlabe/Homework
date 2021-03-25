import BankAccount from './BankAccount';

export default function BankDirectory({title, accounts}:any){
    return (
        <div>
            <header>
                <h1>{title}</h1>
            </header>
            <div>
                {accounts.map((account:any, i:any) =>
                    <BankAccount key={i} {...account} />
                )}
            </div>
        </div>
    );
}