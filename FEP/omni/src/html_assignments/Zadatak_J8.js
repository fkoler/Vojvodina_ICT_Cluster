// Prikazati stihove naredne pesme:
/*
My Bonnie lies over the ocean
My Bonnie lies over the sea
My Bonnie lies over the ocean
Oh, bring back my Bonnie to me.
*/

// Iznad stihova napisati naslov pesme: "Poem" i odvojiti horizontalnom linijom od stihova

import React from 'react';
import './Zadatak_J8.css';

const Zadatak_J8 = () => {
    return (
        <div className='poem-container'>
            <h1>Poem</h1>
            <hr />
            <p>
                My Bonnie lies over the ocean
                <br />
                My Bonnie lies over the sea
                <br />
                My Bonnie lies over the ocean
                <br />
                Oh, bring back my Bonnie to me.
            </p>
        </div>
    );
};

export default Zadatak_J8;
