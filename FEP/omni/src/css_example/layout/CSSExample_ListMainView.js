import "./css_example_listmainview.css";
const CSSExample_ListMainView = () => {
    
  return (
    <div className="container_list_main_view">
      <header className="container_list_main_view_header">
        <div className="header_search">
          <input type="text" placeholder="Search..." />
        </div>
        <div className="header_avatar">&#9786;</div>
      </header>
      <aside className="container_list_main_view_sidenav" id="sidenav">
        <ul className="container_list_main_view_sidenav_list">
          <li className="container_list_main_view_sidenav_list_item">Item 1</li>
          <li className="container_list_main_view_sidenav_list_item">Item 2</li>
          <li className="container_list_main_view_sidenav_list_item">Item 3</li>
          <li className="container_list_main_view_sidenav_list_item">Item 4</li>
        </ul>
      </aside>
      <main className="container_list_main_view_main">
        <div className="container_list_main_view_main_header">
          <div className="container_list_main_view_main_header_heading">
            Hello user
          </div>
          <div className="container_list_main_view_main_header_updates">
            Recent Items
          </div>
        </div>
        <div className="container_list_main_view_main_overview">
          <div class="overviewcard">
            <div class="overviewcard__icon">Overview</div>
            <div class="overviewcard__info">Card</div>
          </div>
          <div class="overviewcard">
            <div class="overviewcard__icon">Overview</div>
            <div class="overviewcard__info">Card</div>
          </div>
          <div class="overviewcard">
            <div class="overviewcard__icon">Overview</div>
            <div class="overviewcard__info">Card</div>
          </div>
          <div class="overviewcard">
            <div class="overviewcard__icon">Overview</div>
            <div class="overviewcard__info">Card</div>
          </div>
          {/* <div class="overviewcard">
            <div class="overviewcard__icon">Overview</div>
            <div class="overviewcard__info">Card</div>
          </div>
          <div class="overviewcard">
            <div class="overviewcard__icon">Overview</div>
            <div class="overviewcard__info">Card</div>
          </div> */}
        
        </div>
        <div className="container_list_main_view_main_cards">
            <div className="card">Card</div>
            <div className="card">Card</div>
            <div className="card">Card</div>
          </div>
      </main>
      <footer className="container_list_main_view_footer"></footer>
    </div>
  );
};

export default CSSExample_ListMainView;
