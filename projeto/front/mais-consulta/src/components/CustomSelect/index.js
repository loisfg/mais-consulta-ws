import React from 'react';
import Select from "react-select";

const customStyles = {
    control: (styles) => {
        return {
            ...styles, 
           backgroundColor: 'white',
           borderColor: 'var(--green-standard)',
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

function CustomSelect({label, options, onKeyUp, disabled, ...rest}) {
return (
        <div>
            <label>{label}</label>
            <Select isDisabled={disabled} 
                    onKeyDown={onKeyUp} 
                    isMulti 
                    styles={customStyles} 
                    options={options} 
                    {...rest}/>
        </div>
    )
}
export default CustomSelect;