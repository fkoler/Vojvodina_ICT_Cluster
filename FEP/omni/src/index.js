import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import HW from './HW';
import HTMLTekst from './HTMLTekst';
import CSSLayout from './css_example/layout/CSSLayout';
import Osnove from './js/Osnove';
import CSSText from './css_example/text/CSSText';
import {
    createBrowserRouter,
    NavLink,
    Outlet,
    RouterProvider,
} from 'react-router-dom';
import Usluzne from './js/Usluzne';
import BasicCSS from './css_example/introduction/BasicCSS';
import CSSExample from './css_example/layout/CSSExample';
import HTMLAssignment from './html_assignments/HTMLAssignment';
import Zadatak_J1 from './html_assignments/Zadatak_J1';
import Zadatak_J2 from './html_assignments/Zadatak_J2';
import Zadatak_J3 from './html_assignments/Zadatak_J3';
import HTMLOrganizacija from './HTMLOrganizacija';
import HTMLSlika from './HTMLSlika';
import HTMLForma from './HTMLForma';
import Funkcionalno from './js/Funkcionalno';
import Objektno from './js/Objektno';
import JSV from './js_assignments/JSV';
import JSV1 from './js_assignments/JSV1';
import JSV2 from './js_assignments/JSV2';
import JSV3 from './js_assignments/JSV3';
import JSV4 from './js_assignments/JSV4';
import JSV5 from './js_assignments/JSV5';
import JSV6 from './js_assignments/JSV6';
import JSV7 from './js_assignments/JSV7';
import JSV8 from './js_assignments/JSV8';
import JSV9 from './js_assignments/JSV9';
import JSV10 from './js_assignments/JSV10';
import Zadatak_J4 from './html_assignments/Zadatak_J4';
import Zadatak_J5 from './html_assignments/Zadatak_J5';
import Zadatak_J6 from './html_assignments/Zadatak_J6';
import HTMLTabela from './HTMLTabela';
import Zadatak_J7 from './html_assignments/Zadatak_J7';
import Zadatak_J8 from './html_assignments/Zadatak_J8';
import Zadatak_J9 from './html_assignments/Zadatak_J9';
import CSSExample_ListMainView from './css_example/layout/CSSExample_ListMainView';
import CSSExample_Dashboard from './css_example/layout/CSSExampla_Dashboard';
import JSXOsnove from './jsx_examples/Osnove';
import Stopwatch1 from './jsx_examples/Stopwatch1';
import HooksExample from './jsx_examples/Hooks';
import ConditionalExample from './jsx_examples/Conditional';
import EventsExample from './jsx_examples/Events';
import FetchExample from './jsx_examples/Fetch';
import ListsExample from './jsx_examples/Lists';
import Stopwatch2 from './jsx_examples/Stopwatch2';
import PrimerModula from './lib_examples/ModuleExample';
import PodElement from './lib_examples/PodElement';
import PodElement2 from './lib_examples/PodElement2';
import AutoLoad from './lib_examples/AutoLoad';
import Book from './lib_examples/Book';

import './NestedNav.css';
import AutoLoad2 from './lib_examples/AutoLoad2';
import BookError from './lib_examples/BookError';
import BookError2 from './lib_examples/BookError2';
import SearchExample from './jsx_examples/SearchExample';
import ImmerExample from './lib_examples/ImmerExample';
import Context from './lib_examples/Context';
import Reducer from './lib_examples/Reducer';
import Memo from './lib_examples/Memo';

/*
  Ovo je mesto gde se prave _rute_ u našoj aplikaciji. Ideja je sledeća:

  Ako želimo da imamo više delova u našoj aplikaciji: ekran za X, ekran za Y, ekran za Z, onda moramo da imamo više stranica. Postoji prvobitan mehanizam za ovo koji se sastoji od odvojenih stranica sa sadržajem koje se nalaze na web serveru. Problem sa ovim jeste da svaki prelazak na drugu stranicu zahteva novo obraćanje serveru i učitavanje svega od nule što čini da iskustvo manje liči na jednu aplikaciju a više gomilu umereno povezanih aplikacija. Danas se koristi metod koji _liči_ na ovaj pristup, ali umesto da u stvari postoji brdo stranica, korisnik je uvek na jednoj stranici gde mu React lukavo prikazuje čas jedne komponente, čas druge, dok preuzima kontrolu nad tim šta se nalazi u adresnom bar-u browser-a. Efekat je isti kao da imamo više stranica, ali prelaz između je gladak i aplikacija ne mora da se (sporo) učitava opet i vraća zapamćeno stanje iz cookie mehanizma, sa back-end-a i sličnih mesta. 

  Prvi korak je da se definišu rute. To se radi sa createBrowserRouter funkcijom koju učitamo iz react-router-dom paketa. Ona prima niz objekata, svako od kojih definiše rutu: to je putanja (ono što ide ispred adrese sajta: npr za www.example.com/a/b/c ruta bi bila a/b/c) pod imenom 'path' i ona komponenta koju treba da iscrtamo kada korisnik ode na tu putanju pod imenom 'element'. 
    {
      path: "/",
      element: <App />,
    }
  U ovom slučaju, želimo kada korisnik ode na koren sajta (putanja /) da se prikaže element App koga možemo naći definisanog u App.js (gde uskoro idemo da se upoznamo sa linkovima). Na dnu ove stranice mi onda primenimo ovaj ruter. 
*/

const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
    },
    {
        path: '/hello_world',
        element: <HW />,
    },
    {
        path: '/html_text',
        element: <HTMLTekst />,
    },
    {
        path: '/css_basic',
        element: <BasicCSS />,
    },
    {
        path: '/css_text',
        element: <CSSText />,
    },
    {
        path: '/css_layout',
        element: <CSSLayout />,
    },
    {
        path: '/js_osnove',
        element: <Osnove />,
    },
    {
        path: '/js_usluzne',
        element: <Usluzne />,
    },
    {
        path: '/html_organisation',
        element: <HTMLOrganizacija />,
    },
    {
        path: '/html_image',
        element: <HTMLSlika />,
    },
    {
        path: '/html_form',
        element: <HTMLForma />,
    },
    {
        path: '/html_table',
        element: <HTMLTabela />,
    },
    {
        path: '/css_layout/css_example',
        element: <CSSExample />,
    },
    {
        path: '/css_layout/css_list_view_example',
        element: <CSSExample_ListMainView />,
    },
    {
        path: '/css_layout/css_dashboard',
        element: <CSSExample_Dashboard />,
    },
    {
        path: '/html_assignment',
        element: <HTMLAssignment />,
    },
    {
        path: '/html_assignment/zad1',
        element: <Zadatak_J1 />,
    },
    {
        path: '/html_assignment/zad2',
        element: <Zadatak_J2 />,
    },
    {
        path: '/html_assignment/zad3',
        element: <Zadatak_J3 />,
    },
    {
        path: '/html_assignment/zad4',
        element: <Zadatak_J4 />,
    },
    {
        path: '/html_assignment/zad5',
        element: <Zadatak_J5 />,
    },
    {
        path: '/html_assignment/zad6',
        element: <Zadatak_J6 />,
    },
    {
        path: '/html_assignment/zad7',
        element: <Zadatak_J7 />,
    },
    {
        path: '/html_assignment/zad8',
        element: <Zadatak_J8 />,
    },
    {
        path: '/html_assignment/zad9',
        element: <Zadatak_J9 />,
    },
    {
        path: '/js_funkcionalno',
        element: <Funkcionalno />,
    },
    {
        path: '/js_objektno',
        element: <Objektno />,
    },
    {
        path: '/js_assignments',
        element: <JSV />,
    },
    {
        path: '/js_assignments/z1',
        element: <JSV1 />,
    },
    {
        path: '/js_assignments/z2',
        element: <JSV2 />,
    },
    {
        path: '/js_assignments/z3',
        element: <JSV3 />,
    },
    {
        path: '/js_assignments/z4',
        element: <JSV4 />,
    },
    {
        path: '/js_assignments/z5',
        element: <JSV5 />,
    },
    {
        path: '/js_assignments/z6',
        element: <JSV6 />,
    },
    {
        path: '/js_assignments/z7',
        element: <JSV7 />,
    },
    {
        path: '/js_assignments/z8',
        element: <JSV8 />,
    },
    {
        path: '/js_assignments/z9',
        element: <JSV9 />,
    },
    {
        path: '/js_assignments/z10',
        element: <JSV10 />,
    },
    {
        path: 'jsx/osnove',
        element: <JSXOsnove />,
    },
    {
        path: 'jsx/stopwatch1',
        element: <Stopwatch1 />,
    },
    {
        path: 'jsx/hooks',
        element: <HooksExample />,
    },
    {
        path: 'jsx/conditional',
        element: <ConditionalExample />,
    },
    {
        path: 'jsx/events',
        element: <EventsExample />,
    },
    {
        path: 'jsx/lists',
        element: <ListsExample />,
    },
    {
        path: 'jsx/fetch',
        element: <FetchExample />,
    },
    {
        path: 'jsx/stopwatch2',
        element: <Stopwatch2 />,
    },
    {
        path: 'jsx/pretraga',
        element: <SearchExample />,
    },
    {
        path: 'lib/moduli',
        element: <PrimerModula />,
    },
    /*
    Možemo da napravimo mnogo udobnije rute od ovih: ovde svaki element je sasvim poseban. To je baš ono što smo i hteli da uradimo, zato što smo pravili nezavisne primere, ali većinu vremena imamo deo interfejsa koji se ne menja, i deo koji se menja. Za to služe ugnježdene rute. 
  */
    {
        path: 'lib/routes',
        //Element se sada sastoji od dva dela: stalnog dela koji se ne menja: to je naslov i meni opcija na koje možemo da kliknemo i dela koji se menja koga označava poseban tip "Outlet" Šta će se naći u outlet-u određuje u koji deo putanje ispod lib/routes mi odemo.
        element: (
            <>
                <h1>Ovaj naslov je uvek isti</h1>
                <div>
                    <ul className='navlist'>
                        <li>
                            <NavLink to='pod_element' className='navitem'>
                                Pod element
                            </NavLink>
                            {/*NavLink je kao link (ide na neku adresu, ali adresu koji definiše naš ruter) ali za razliku od linka, NavLink je osetljiv na to gde se nalazimo u programu. Ako je link na koji vodi NavLink trenutna adresa na kojoj se nalazimo, NavLink će, osim klase koju mi specificiramo da ima i klasu 'active.' To nam omogućava da označimo šta je od linkova 'selektovano.'*/}
                        </li>
                        <li>
                            <NavLink to='pod_element2' className='navitem'>
                                Pod element 2
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to='automatic_loading' className='navitem'>
                                Automatsko učitavanje
                            </NavLink>
                        </li>
                        <li>
                            <NavLink
                                to='automatic_loading2'
                                className='navitem'
                            >
                                Poluautomatsko učitavanje
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to='book/8' className='navitem'>
                                Knjiga 8
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to='book/11' className='navitem'>
                                Knjiga 11
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to='book/14' className='navitem'>
                                Knjiga 14
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to='book/15' className='navitem'>
                                Knjiga koja ne postoji
                            </NavLink>
                        </li>
                        <li>
                            <NavLink to='book2/15' className='navitem'>
                                Knjiga koja ne postoji - bolje greške
                            </NavLink>
                        </li>
                    </ul>
                </div>
                <Outlet></Outlet>
            </>
        ),
        // Naravno, ugnježdene rute su beskorisne ako u njima nema pod-ruta koje će pružait sadržaj Outlet elementa. one se nalaze u Children atributu, kao niz najobičnijih ruta. Naravno možemo ugnjezditi ovične putanja-i-element rute (vodite računa da su sve putanje u odnosu na putanju rute u kojoj smo ugnježdeni pa tako pod_element u stvari znači lib/routes/pod_element), ali možemo i da ugnjezdimo element sa svojim pod-elementima, ako želimo, il ida koristimo druge osobine koje ruter pruža potpuno slobodno. Nema ograničenja.
        children: [
            {
                path: 'pod_element',
                element: <PodElement />,
            },
            {
                path: 'pod_element2',
                element: <PodElement2 />,
            },
            //Među stvarima koje možemo da koristimo (ima ih još: ali o tome kasnije) je i *učitavanje*. Budući da je veoma često učitati nešto sa back-end-a pre nego priklažemo nešto na ekranu, ruter nam nudi instant mehanizam za to koji je mnogo, mnogo lakši za upotrebu neko klasični 'useEffect' iako naranvo radi nešto slično iza kulisa. Trik je da u okviru elementa rute pružimo i vrednost za 'loader' atribut. Loader prima asinhronu funkciju koja treba da vrati Response: tačno ono što će da vrati i običan fetch. Proces await-ovanja i pozivanja .json() i sve to, to radi sam ruter umesto nas. Naravno, fetch ne mora da bude prost, možemo da prosledimo štagod da je to što želimo ovde u zaglavlja, menjamo tip i slično. Ključna stvar jeste da će ovo da pre učitavanja preuzme vrednost koju zatražimo u pruži je funkciji kroz hook. Ako nismo namestili loader, ovo će pokušati da nabavi podatke iz najbliže rute.
            {
                path: 'automatic_loading',
                element: <AutoLoad />,
                loader: async () => {
                    return fetch('http://localhost:8080/api/v1/book');
                },
            },
            {
                path: 'automatic_loading2',
                element: <AutoLoad2 />,
            },
            /*
        Možemo imati delove koji su parametrizovani, baš kao i u Spring back-end-u. Ovde se označavaju sa jednom dvotačkom ispred imena i dostupni su u loader-u kroz parametar 'params.' Budući da ovim tražimo neki podatak koji možda jeste a možda nije tu, može lako da se desi da imamo grešku. To možemo da popravimo koristeći 'elemente greške' koji se prikazuju umesto naše komponente u slučaju grešaka. 
      */
            {
                path: 'book/:id',
                element: <Book />,
                errorElement: <BookError />,
                loader: async ({ params }) => {
                    return fetch(
                        `http://localhost:8080/api/v1/book/${params.id}`
                    );
                },
            },
            /*
        Nekada imamo greške koje očekujemo da mogu da se dese: recimo možda ne možemo da preuzmemo knjigu zbog neke bizarne greške za koju ne znamo unapred. Onda će ta greška, štagod da je, da bude bačena i mi možemo da je presretnemo i prikažemo. Ali ponekad jednostavno nema knjige sa specifičim ID-om. Bilo bi lepo da to možemo da kažemo direktno. Tehnika je da umesto da pustimo da se ceo posao await-ovanja odradi automatski, da ga odradimo mi i da, ako detektujemo problem da bacimo kao grešku nešto što nam odgovara i što možemo da identifikujemo u našem errorElement-u. 
      */
            {
                path: 'book2/:id',
                element: <Book />,
                errorElement: <BookError2 />,
                loader: async ({ params }) => {
                    const r = await fetch(
                        `http://localhost:8080/api/v1/book/${params.id}`
                    );
                    if (r.status === 404) {
                        throw new Response('Resurs nije nađen', {
                            status: 404,
                        });
                    }
                    const rr = await r;
                    return rr;
                },
            },
        ],
    },
    {
        path: 'lib/immer',
        element: <ImmerExample />,
    },
    {
        path: 'lib/context',
        element: <Context />,
    },
    {
        path: 'lib/reducer',
        element: <Reducer />,
    },
    {
        path: 'lib/memo',
        element: <Memo />,
    },
]);

//Način na koji React radi jeste što postoji index.html. Sav HTML koji smo kucali do sada je bio JSX, odnosno dijalekt HTML-a koji je namenjen za React i za mešanje sa JS-om. Ovo je pravi, originalni HTML u kome se nameste neki meta-podaci i doda jedan jedini div sa id-om root. Taj div je prazan i samo služi kao mesto gde možemo ubaciti naš React. To radimo ovde
const root = ReactDOM.createRoot(document.getElementById('root')); //Prvo stvorimo root element (početak sajta) od tog diva sa ovim kodom, a onda:
root.render(
    // <React.StrictMode>
    <RouterProvider router={router} />
    // </React.StrictMode>
); //Koristimo root.render da nešto iscrtamo u njemu. Šta iscrtavamo? Pa može bilo koji JSX: za nas to je RouterProvider (isto iz react-router-dom paketa) kome kažemo da koristi ruter koji smo gore napravili. RouterProvider onda radi sav posao za nas. StrictMode nam samo čini kod čistijim zato što nam ne dozvoljava neke stvari.
