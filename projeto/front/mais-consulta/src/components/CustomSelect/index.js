import React from 'react';
import Select from "react-select";

function CustomSelect({label, options, color='--light-blue', onKeyUp, ...rest}) {
    
    const customStyles = {
        control: (styles) => {
            return {
                ...styles, 
               backgroundColor: 'white',
               borderColor: `var(${color})`,
               height: '0.5rem'
            }
        },
        option: (styles, { data, isDisabled, isFocused, isSelected }) => {
            return {
                ...styles,
                backgroundColor: 'white',
                color: 'black',
                cursor: 'pointer',
          };
        },
    };
    
return (
        <div>
            <label>{label}</label>
            <Select onKeyDown={onKeyUp} isMulti styles={customStyles} options={options} {...rest}/>
        </div>
    )
}
export default CustomSelect;