
export default function ItemList({title, items, extractorFunc}:any){

    return (
        <div>
            <h4>{title}</h4>
            <ul className="{title}">
                {items.map((item:any, i:any) =>
                    <li key={i}>{extractorFunc(item)}</li>
                )}
            </ul>
        </div>
    );
}