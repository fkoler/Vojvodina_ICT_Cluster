/*
Kreirati formu za prijavu kandidata za posao. Izgled forme je dat na slici
*/

// import slika from './../assets/images/zad5.PNG';

import './zadatak5_css.css';

const Zadatak_J5 = () => {
    return (
        <>
            {/* <img src={slika} alt='slika' /> */}
            <div className='form-container'>
                <form>
                    <fieldset>
                        <legend>
                            <span className='section-number'>1</span> Candidate
                            Info
                        </legend>

                        <label>
                            <input
                                placeholder='Your Name *'
                                type='text'
                                name='name'
                                required
                            />
                        </label>

                        <label>
                            <input
                                placeholder='Your Email *'
                                type='email'
                                name='email'
                                required
                            />
                        </label>

                        <label>
                            <textarea
                                placeholder='About yourself'
                                name='about'
                                rows='4'
                            ></textarea>
                        </label>

                        <label>
                            Interests:
                            <select name='interests'>
                                <option value='fishkeeping'>Fishkeeping</option>
                                <option value='coding'>Coding</option>
                                <option value='gaming'>Gaming</option>
                                <option value='esports'>E-Sports</option>
                            </select>
                        </label>
                    </fieldset>

                    <fieldset>
                        <legend>
                            <span className='section-number'>2</span> Additional
                            Info
                        </legend>

                        <label>
                            <textarea
                                placeholder='About Your School'
                                name='school'
                                rows='4'
                            ></textarea>
                        </label>
                    </fieldset>
                    <button type='submit'>Apply</button>
                </form>
            </div>
        </>
    );
};

export default Zadatak_J5;
