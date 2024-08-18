import { useRouteError } from "react-router-dom";

const BookError = () => {
    const error = useRouteError(); //Ovo je hook koji nam da štagod da je bila greška: to može da bude exception ili bilo šta što je throw-ovano.
    return <div>
        <h1>Greška!</h1>
        <p>Nismo bili u stanju da preuzmemo traženu knjigu. Interna greška je:</p>
        <pre>
            {error.message}
        </pre>
    </div>
}

export default BookError;