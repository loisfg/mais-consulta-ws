import React, { useEffect, useRef, useState } from 'react';
import api from '../../services/api';
import {remedios} from './remedios';

export default function AutoCompleteTest() {
    const [ display, setDisplay ] = useState(false);
    const [ options, setOptions ] = useState([]);
    const [ search, setSearch ] = useState('');
    const wrapperRef = useRef(null);

    useEffect(() => {
        const idPaciente = localStorage.getItem('id');
        // Promise.all(remedios).then(remediosArray => {
        //     return remediosArray.map(res => res.data.then(({ nome, id }) => {
        //         return remedios.push(nome, id);
        //     }))
        // })
        setOptions(remedios)
    }, [])
    useEffect(() => {
        window.addEventListener("mousedown", handleClickOutside);
        return () => {
          window.removeEventListener("mousedown", handleClickOutside);
        };
    });
    
    const handleClickOutside = event => {
    const { current: wrap } = wrapperRef;
    if (wrap && !wrap.contains(event.target)) {
        setDisplay(false);
    }
    };

    const setRemedio = remedio => {
        setSearch(remedio);
        setDisplay(false);
    }
  return (
      <div ref={wrapperRef} className='flex-container flex-column pos-rel'>
          <input id='auto' 
          type="text"
          onClick= {() => setDisplay(!display)}
          placeholder='type to search'
          value={search}
          onChange={event => setSearch(event.target.value)}
          />
          {
              display && (
                  <div className='autoComplete'>
                      {options.filter(({nome}) => nome.indexOf(search.toLowerCase()) > -1).map((value, index) => {
                          return (
                            <div onClick={() => setRemedio(value.nome)}  key={index}>
                                <span>{value.nome}</span>
                            </div>
                          )
                      })}
                  </div>
              )
          }
      </div>
  )
}