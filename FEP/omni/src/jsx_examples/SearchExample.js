import { useState, useEffect } from "react";

const SearchExample = () => {
    const [q, setQ] = useState("");
    const [books, setBooks] = useState([]);
    useEffect(() => {
        let ignore = false;
        const ff = async () => {
            if(q === ""){
                let r = await fetch('http://localhost:8080/api/v1/book');
                let rr = await r.json();
                setBooks(rr);
            }else{                
                let r = await fetch(`http://localhost:8080/api/v1/book/search/?title=${encodeURIComponent(q)}`);
                let rr = await r.json();
                setBooks(rr);                
            }
        }
        ff(); 
        return () => {
            ignore = true;
        }
    }, [q]);
    return <>
    <label>Search: <input type="text" value={q} onChange={(e) => {
        setQ(e.target.value);
    }}/></label>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
            </tr>
        </thead>
        <tbody>
            {books.map(v => <tr key={v.id}><td>{v.id}</td><td>{v.title}</td></tr>)}
        </tbody>
    </table></>;
}

export default SearchExample;