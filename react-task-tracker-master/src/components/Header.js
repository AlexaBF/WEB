import PropTypes from 'prop-types'
import Button from './Button'

const Header = (props) => {
  return (
    <header className='header'>

        <h1 style = {headingStyle}>TASK TRACKER</h1>
        <h1>
            {props.title}
        </h1>
        
        <Button color='green' text = 'hello'/>
        

    </header>
  )
}

const headingStyle = {
    color: 'red',
    backgroundColor: 'black',
}

export default Header