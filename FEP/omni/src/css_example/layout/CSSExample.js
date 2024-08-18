/*
Primer upotrebe flex i grid rasporeda na realnim primerima
1. pomocu grid rasporeda izdelicemo ceo ekran i predstaviti glavne delove svake web aplikacije 
    - imacemo 4 reda: header, navigation menu, content i footer
    - glavni deo gde ce biti prikazan sadrzaj moze da bude izdeljen na vise kolona, kada su u pitanju desktop aplikacije obicno je podeljen na 3 kolone 
*/

import "./css_example.css";
import ExampleForm from './ExampleForm';
import ExampleCalculator from './ExampleCalculator';
import picture from './../../assets/images/lorem_ipsum.jpg';
import React, { useState} from 'react';
import ExampleTable from "./ExampleTable";

const CSSExample = () => {
  const [showForm, setShowForm] = useState('f');

  const clickFormButton = () => {
    setShowForm('f');
  }
  const clickCalButton = () => {
    setShowForm('c');
  }
  const clickTableButton = () => {
    setShowForm('t');
  }

  const main_layout = (
    <div className="container">
      <div className="header">
        <header>Example header</header>
      </div>
      <div className="navigation_menu">
          <input className="menu_item" type="button" value="Forma" onClick={clickFormButton} />
          <input className="menu_item" type="button" value="Kalkulator" onClick={clickCalButton}/>
          <input className="menu_item" type="button" value="Tabela" onClick={clickTableButton}/>
      </div>
      <div className="content_left">
        {" "}
        <p>
          Lorem Ipsum is simply dummy text of the printing and typesetting
          industry. Lorem Ipsum has been the industry's standard dummy text ever
          since the 1500s, when an unknown printer took a galley of type and
          scrambled it to make a type specimen book. It has survived not only
          five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged. It was popularised in the 1960s with
          the release of Letraset sheets containing Lorem Ipsum passages, and
          more recently with desktop publishing software like Aldus PageMaker
          including versions of Lorem Ipsum
        </p>{" "}
        <p>
          Contrary to popular belief, Lorem Ipsum is not simply random text. It
          has roots in a piece of classical Latin literature from 45 BC, making
          it over 2000 years old. Richard McClintock, a Latin professor at
          Hampden-Sydney College in Virginia, looked up one of the more obscure
          Latin words, consectetur, from a Lorem Ipsum passage, and going
          through the cites of the word in classical literature, discovered the
          undoubtable source. Lorem Ipsum comes from sections 1.10.32 and
          1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and
          Evil) by Cicero, written in 45 BC. This book is a treatise on the
          theory of ethics, very popular during the Renaissance. The first line
          of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in
          section 1.10.32.
        </p>
      </div>
      <div className="content_main"> 
      {/* raspored se smenjuje u zavisnosti od toga sta se izabere da li forma ili kalkulator */}
          { showForm === 'f' ? <ExampleForm/> : (showForm === 'c' ? <ExampleCalculator/> : <ExampleTable/>) }
      </div>
      <div className="content_right"> <img  src={picture} alt="Example"/> </div>
      <div className="footer"> <footer> Example footer</footer> </div>
    </div>
  );
  return main_layout;
};

export default CSSExample;
