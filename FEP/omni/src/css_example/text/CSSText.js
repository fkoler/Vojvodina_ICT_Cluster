/* Formatiranje teksta uptrebom CSS-a

Sa tekstom mozemo da radimo sledece stvari:
1. bojimo odredjeni deo teksta
2. podebljamo odredjeni deo teksta
3. obojimo pozadinu nekog dela teksta
4. poravnate tekst
5. transformacije teksta
6. dekorisete tekst
*/

import './css_text.css'
const CSSText = () => {
    // funkcija koja u zavisnosti od parametara koje primi dekorise tekst, parametri su nazivi klasa
    const setTextCSS = (lorem_ipsum_class, p_class) => {
        const text = (<p className={p_class}>
            <span className={lorem_ipsum_class}>Lorem Ipsum</span>  is simply dummy text of the printing and typesetting industry.
            <span className={lorem_ipsum_class}>Lorem Ipsum </span> has been the industry's standard dummy text ever since the
            1500s, when an unknown printer took a galley of type and scrambled it to
            make a type specimen book. It has survived not only five centuries, but
            also the leap into electronic typesetting, remaining essentially
            unchanged. It was popularised in the 1960s with the release of Letraset
            sheets containing  <span className={lorem_ipsum_class}> Lorem Ipsum  </span> passages, and more recently with desktop
            publishing software like Aldus PageMaker including versions of <span className={lorem_ipsum_class}>Lorem
            Ipsum </span>.
        </p>);
        return text;
    }

    return <div> 
        <h1> Formatiranje teksta </h1>
        <hr/>
        <h2> Bojenje teksta </h2>
        {setTextCSS("lorem_ipsum_color")}
        <hr/>
        <h2> Bojenje pozadine  </h2>
        {setTextCSS("lorem_ipsum_background")}
        <hr/>
        <h2> Podvlacenje teksta </h2>
        {setTextCSS("lorem_ipsum_decoration")}
        <hr/>
        <h2> Poravnjavanje i transformacije teksta </h2>
        <div className='container_text'>
            <div className='container_item'> Centriran tekst {setTextCSS("lorem_ipsum_uppercase", "alignment_center")} </div>
            <div className='container_item'> Justify {setTextCSS("lorem_ipsum_lowercase", "alignment_justify")} </div>
            <div className='container_item'> Levo poravnanje {setTextCSS("lorem_ipsum_capitalize", "alignment_left")} </div>
            <div className='container_item'> Desno poravnanje {setTextCSS("", "alignment_right")} </div>
        </div>
        <hr/>
        <h2> Razmaci </h2>
        {/* uvucena prva linija teksta, razmak izmedju slova podesen na 3px, razmak izmedju reci 10px i  senka*/}
        {setTextCSS("", "text_indent")}
    </div>

};

export default  CSSText;