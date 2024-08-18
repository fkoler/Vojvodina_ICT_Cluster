import { Link } from "react-router-dom";

const HTMLAssignment = () => {
  return (
    <div>
      <h1>HTML i CSS Zadaci</h1>
      <p>Zadaci iz HTML-a i CSS-a</p>
      <ul>
        <li>
          <Link to="zad1">Zadatak 1</Link>
        </li>
        <li>
          <Link to="zad2">Zadatak 2</Link>
        </li>
        <li>
          <Link to="zad3">Zadatak 3</Link>
        </li>
        <li>
          <Link to="zad4">Zadatak 4</Link>
        </li>
        <li>
          <Link to="zad5">Zadatak 5</Link>
        </li>
        <li>
          <Link to="zad6">Zadatak 6</Link>
        </li>
        <li>
          <Link to="zad7">Zadatak 7</Link>
        </li>
        <li>
          <Link to="zad8">Zadatak 8</Link>
        </li>
        <li>
          <Link to="zad9">Zadatak 9</Link>
        </li>
      </ul>
    </div>
  );
};

export default HTMLAssignment;
