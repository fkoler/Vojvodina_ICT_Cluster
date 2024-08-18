/* 
    React context omogucava da se lako deli stanje unutar aplikacije.
    Pomocu React context-a mozemo lako da saljemo podatke i da ih konzumiramo unutar cele
    aplikacije bez potrebe da ih prosledjujemo putem prop-ova <Komponenta prop={prop}/>

    Tipovi podataka za koje se najcesce upotrebljava context:
        * podaci u vezi teme (svetlo, tamno)
        * podaci u vezi korisnika (trenutno autentifikovani korisnik)
        * podaci u vezi lokacije (jezik)
    
    U React context se stavljaju podaci koji se nece cesto update-ovati.
    Nesto poput globalnih promenljivih.

    React Context resava problem props drilling-a, odnosno pojave da saljemo podatke
    putem prop-a kroz komponente kojima oni nisu potrebni.
    

    Za upotrebu React Context-a postoje 4 koraka:
        1. Kreirati context pomocu createContext metode
        2. Obaviti zeljene komponente pomocu datog context provider-a
        3. Upotrebom value prop-a postaviti bilo koju vrednost unutar context provider-a
        4. Upotrebom context consumer-a procitati datu vrednost u bilo kojoj komponenti 
*/

import React from "react";

//Primer prop drilling-a

const PropDrilling = () => {
    return <UserPropDrilling name={"Aleksandar"}/>
}

const UserPropDrilling = ({name}) => {
    return <NamePropDrilling name={name}/>
}

const NamePropDrilling = ({name}) => {
    return (
        <h1>{name}</h1>
    ) 
}

// Primer upotrebe React context-a

// Korak 1. 
export const UserContext = React.createContext();

const ContextPrimer1 = () => {
    {/* Korak 2. i 3.*/}
    return (
        <UserContext.Provider value={{name:"Petar"}}>
            <UserPrimer1/>
        </UserContext.Provider>
    )

}

const UserPrimer1 = () => {
    {/* Korak 4. izveden pojmocu useContext hook-a*/}
    const student = React.useContext(UserContext);
    return <h1>{student.name}</h1>;
}


//Kako se resava problem prop drilling-a pomocu React context-a

const ContextPrimer2 = () => {
    return (
        <UserContext.Provider value={{name:"Jovana"}}>
            <UserPrimer2/>
        </UserContext.Provider>
    )
}

const UserPrimer2 = () => {
    return <UserName/>
    
}

const UserName = () => {
    const student = React.useContext(UserContext);
    return <h1>{student.name}</h1>;
}

const Context = () => {
    
    return (
        <>
            <PropDrilling/>
            <ContextPrimer1/>
            <ContextPrimer2/>
        </>
        
    )

}

export default Context;

