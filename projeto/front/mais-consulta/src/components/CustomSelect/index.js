import React from 'react';
import Select from "react-select";

const customStyles = {
    control: (styles) => {
        return {
            ...styles, 
           backgroundColor: 'white',
           borderColor: 'var(--green-standard)'
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

function CustomSelect({label, options, onChange, ...rest}) {
return (
        <div>
            <label>{label}</label>
            <Select isMulti styles={customStyles} options={options} {...rest}/>
        </div>
    )
}
export default CustomSelect;