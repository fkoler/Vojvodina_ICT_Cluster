import { useRouteError } from "react-router-dom";

const BookError2 = () => {
    const error = useRouteError();
    return <div>
        <h1>Greška!</h1>
        <p>Nismo bili u stanju da preuzmemo traženu knjigu</p>
        <p>
            {error.status === 404 ? "Tražena knjiga ne postoji" : "Interna greška sa oznakom: " + error.message}
        </p>
    </div>
}

export default BookError2;