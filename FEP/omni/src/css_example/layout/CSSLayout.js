/* CSS Layout (raspored) nam omogucava da pravimo interfejs aplikacije koji ima raspored koji nama odgovara. 
Postoji nekoliko opcija za kreiranje rasporeda i detaljno cemo proci neke od njih.
Za kreiranje rasporeda kljucna je osobina display zato sto ona kontrolise kako ce se elementi prikazati. Vrednosti ove osobine
mogu da budu: none, inline, block, inline-block, grid i flex
1. display = none -> sadrzaj se ne prikazuje na ekranu 
2. display = inline -> sadrzaj koji bude postavljen na ovu vrednost nece poceti na novom redu i zauzece preostalu/dostupnu sirinu ekranu. 
Samo zauzima prostor koji bi takav element normalno zauzeo.
3. display = block -> prikazuje element kao blok, slican je p tagu (p je tag za pasus), zauzima celu sirinu ekrana. Element obavezno pocinje na novoj liniji
4. display = inline-block -> slaganje kompleksnih blokova u redove kao tekst
5. display = grid -> podela prostora na mrezu celija, potrebno je definisati ponasanje za svaku celiku u mrezi tako sto
modifikujemo osobine svake celije
6. display = flex -> omogucava da definisete kako ce stavke u kontejneru da budu rasporedjene, a isto tako mozete definisati i stilove za svaku stavku pojedinacno
*/

// css stilove definisemo u drugom fajlu i obavezno moramo ovde da ga uvezemo
import "./css_layout.css";
import {Link} from 'react-router-dom'


const CSSLayout = () => {

  /* Funkcija koja nam sluzi za kreiranje jednostvanih rasporeda, kao sto su:
  none, inline, block i inline-block:
    - param: className - ime klase koju zelimo da postavimo na tag span u okviru div kontejnera
    
  Ovo nacin kako mozete dinamicki da menjate izgled nekog elementa tako sto mu menjate vrednost klase u zavisnosti od neki promena*/ 
  const setLayout = (className) => (
    <div>
      <span>
        Lorem Ipsum is simply dummy text of the printing and typesetting
        industry. Lorem Ipsum has been the industry's standard dummy text ever
        since the 1500s, when an unknown printer took a galley of type and
        scrambled it to make a type specimen book. 
        <span className={className}>
          {" "}
          It has survived not only
          five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged.{" "}
        </span>{" "}
        It was popularised in the 1960s with the release of Letraset sheets
        containing Lorem Ipsum passages, and more recently with desktop
        publishing software like Aldus PageMaker including versions of Lorem
        Ipsum. 
      </span>
    </div>
  );

/*
    Funkcija slicna onoj iznad samo sada za kreiranje grid rasporeda; 
    param:
      className => naziv klase u kojoj je definisan grid kontejner
      classNameCell => naziv klase pojedinacne celije u grid rasporedu
*/
  const setGridLayout = (className, classNameCell) => (
    <div className={className}>
      <span className={classNameCell + ' layout_grid_item_first'}>
        Lorem Ipsum is simply dummy text of the printing and typesetting
        industry. Lorem Ipsum has been the industry's standard dummy text ever
        since the 1500s, when an unknown printer took a galley of type and
        scrambled it to make a type specimen book. </span>
        <span className={classNameCell + ' layout_grid_item_second'}>
          {" "}
          It has survived not only
          five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged.{" "}
        </span>{" "}
        <span className={classNameCell + ' layout_grid_item_third'}>  It was popularised in the 1960s with the release of Letraset sheets
        containing Lorem Ipsum passages, and more recently with desktop
        publishing software like Aldus PageMaker including versions of Lorem
        Ipsum. 
      </span>
    </div>
  )

  /*
    Funkcija slicna onoj iznad samo sada za kreiranje flex rasporeda; 
    param:
      className => naziv klase u kojoj je definisan flex kontejner
      classNameCell => naziv klase pojedinacne stavke u flex kontejneru
*/
  const setFlexLayout = (className, classNameCell) => (
    <div className={className}>
      
      <span className={classNameCell}>
        Lorem Ipsum is simply dummy text of the printing and typesetting
        industry. </span>
        <span className={classNameCell}> Lorem Ipsum has been the industry's standard dummy text ever
        since the 1500s, when an unknown printer took a galley of type and
        scrambled it to make a type specimen book. </span>
        <span className={classNameCell}>
          {" "}
          It has survived not only
          five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged.{" "}
        </span>{" "}
        <span className={classNameCell}>  It was popularised in the 1960s with the release of Letraset sheets
        containing Lorem Ipsum passages, and more recently with desktop
        publishing software like Aldus PageMaker including versions of Lorem
        Ipsum. 
      </span>
    </div>
  )
  return (
    <div>
      <h1> Raspored </h1>
      <p><Link to="css_example">Primeri upotrebe rasporeda</Link></p>
      <p><Link to="css_list_view_example">Primeri upotrebe rasporeda (dashboard 1)</Link></p>
      <p><Link to="css_dashboard">Primeri upotrebe rasporeda (dashboard 2) </Link></p>
      <span>
        {" "}
        <i> Raspored ce biti prikazan na sledecem tekstu: {setLayout()} </i>{" "}
      </span>
      <hr />
      <h2> None raspored </h2>
      {setLayout("layout_none")}
      <hr />
      <h2> Inline raspored </h2>
      {setLayout("layout_inline")}
      <hr />
      <h2> Block raspored </h2>
      {setLayout("layout_block")}
      <hr/>
      <h2> Inline-block raspored </h2>
      {setLayout("layout_inline_block")}
      <hr/>
      <h2> Grid raspored</h2>
      {setGridLayout("layout_grid", "layout_grid_cell")}
      <hr/>
      <h2> Flex raspored </h2>
      <h3> Flex raspored - red</h3>
      {setFlexLayout("layout_flex_row", "layout_flex_item")}
      
      <h3> Flex raspored - kolona</h3>
      {setFlexLayout("layout_flex_column", "layout_flex_item")}
    </div>

  );
};

export default CSSLayout;
