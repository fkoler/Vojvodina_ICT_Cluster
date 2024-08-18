import { useLoaderData } from "react-router-dom";

const Book = () => {
    const book = useLoaderData();
    return <div>
        Id: {book.id} <br/>
        Isbn: {book.isbn} <br/>
        Title: {book.title} <br/>
        Authors: <ul>{book.authors.map(v => <li>{v}</li>)}</ul>
        Genre: {book.genre} <br/>
        Year: {book.year} <br/>
        Rating: {book.rating.toFixed(2)} <br/>
    </div>
}

export default Book;