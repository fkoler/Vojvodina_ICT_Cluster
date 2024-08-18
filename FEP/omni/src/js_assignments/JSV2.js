/* 
    Zadatak 2
    Prošriti funkciju iz zadatka 1 tako da ne sortira samo brojeve u uzlaznom redosledu nego može da sortira bilo šta kroz komparatorsku funkciju koja vraća, za neko a i b, -1 kada a < b, 0 kada a == b, i 1 kada a > b. Takva funkcija za sortiranje dobija niz i funkciju. Testirati ovu funkciju tako što joj se da niz i funkcija koja sortira u silazećem redosledu. Inače, svaki niz ima funkciju .sort koja obavlja tačno ovaj posao koji ovde kodiramo, i prima kao parametar komparatorsku funkciju koja radi tačno kao ova koju opisujemo ovde. 
*/

const _ = require('lodash');

const customSort = (array, order = 'desc') => {
    return _.orderBy(array, [_.identity], [order]);
};

const testCustomSort = () => {
    const numbers = [2, 8, 5, 12, 7, -13, 9, 17, -20];
    const sortedNumbers = customSort(numbers);

    console.log('Originalni niz:', numbers);
    console.log('Sortirani brojevi u opadajućem redosledu:', sortedNumbers);
};

// testCustomSort();

const JSV2 = () => {
    return <div></div>;
};

export default JSV2;
