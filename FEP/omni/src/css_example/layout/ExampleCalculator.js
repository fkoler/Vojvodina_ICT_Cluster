// ovaj primer ce demonstrirati upotrebu flex kontejnera 
import './css_example_calculator.css';
const ExampleCalculator = () => {
    return <div className="container_cal">
        <div className="wrapper">
            <div className="col">
                <div className="expression">
                    
                </div>
            </div>
            <div className="col">
                <div className="result"></div>
            </div>
            <div class="col">
                <button className='button'>1</button>
                <button className='button'>2</button>
                <button className='button'>3</button>
                <button className='button'>-</button>
            </div>
            <div class="col">
                <button className='button'>4</button>
                <button className='button'>5</button>
                <button className='button'>6</button>
                <button className='button'>+</button>
            </div>
                <div class="col">
                <button className='button'>7</button>
                <button className='button'>8</button>
                <button className='button'>9</button>
                <button className='button'>*</button>
            </div>
            <div class="col">
                <button className='button'>CLR</button>
                <button className='button'>0</button>
                <button className='button'>=</button>
                <button className='button'>/</button>
            </div>
        </div>

    </div>
}

export default ExampleCalculator;