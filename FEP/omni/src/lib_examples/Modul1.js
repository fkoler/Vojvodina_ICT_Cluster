//Modul se ne razlikuje od bilo kog drugog js fajla koji ste pisali. U nekim okruženjima, ekstenzija mora da bude .mjs, ali nama ne treba ni to. Sve što treba da uradim da eksportujemo nešto jeste da ispred 'const' stavimo 'export' i to radi na funkcijama i konstantama. 

export const THE_ANSWER = 42;

export const f = () => {
    return "Module1->F";
}

export const g = () => {
    return "Module1->G";
}

const h = () => {
    return "Module1->H";
}
