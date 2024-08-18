import { useState } from 'react';
import './css_example_dashboard.css';
const CSSExample_Dashboard = () => {
    const [isActive, setActive] = useState(false);
    const openMenu = () => {
        setActive(true);
        document.getElementById("dashboard_grid_container").style.marginLeft = "240px";
        document.getElementById("dashboard_header").style.marginLeft = "240px";

    }

    const closeMenu = () => {
        setActive(false);
        document.getElementById("dashboard_grid_container").style.marginLeft = "0px";
        document.getElementById("dashboard_header").style.marginLeft = "0px";

    }
    return <div  className='dashboard_grid_container'>
        <div className='dashboard_menu_icon'>
            <strong onClick={openMenu}> &#9776; </strong>
        </div>
        <header className='dashboard_header' id="dashboard_header">
            <div className='dashboard_header_search'>Search...</div>
            <div className='dashboard_header_avatar'>Logout</div>
        </header>
        <aside className={isActive ? 'dashboard_aside active' : 'dashboard_aside'} id='aside'>
            <div className='dashboard_aside_close_icon'>
                <span onClick={closeMenu}>&times;</span>
            </div>
            <ul className='dashboard_aside_list'>
                <li className='dashboard_aside_list_item'>Menu item 1</li>
                <li className='dashboard_aside_list_item'>Menu item 2</li>
                <li className='dashboard_aside_list_item'>Menu item 3</li>
                <li className='dashboard_aside_list_item'>Menu item 4</li>
                <li className='dashboard_aside_list_item'>Menu item 5</li>
                <li className='dashboard_aside_list_item'>Menu item 6</li>
            </ul>
        </aside>
        <main className='dashboard_main' id="dashboard_grid_container">
            <div className='dashboard_main_overview'>
                <div className='dashboard_main_overview_card'>
                    <div className='dashboard_main_overview_card_info'>
                        Overview
                    </div>
                    <div className='dashboard_main_overview_card_icon'>
                        Info
                    </div>
                </div>
                <div className='dashboard_main_overview_card'>
                    <div className='dashboard_main_overview_card_info'>
                        Overview
                    </div>
                    <div className='dashboard_main_overview_card_icon'>
                        Info
                    </div>
                </div>
                <div className='dashboard_main_overview_card'>
                    <div className='dashboard_main_overview_card_info'>
                        Overview
                    </div>
                    <div className='dashboard_main_overview_card_icon'>
                        Info
                    </div>
                </div>
            </div>
            <div className='dashboard_main_cards'>
                <div className='dashboard_main_card'>Card</div>
                <div className='dashboard_main_card'>Card</div>
                <div className='dashboard_main_card'>Card</div>
            </div>
        </main>
        <footer></footer>
    </div>
}


export default CSSExample_Dashboard;