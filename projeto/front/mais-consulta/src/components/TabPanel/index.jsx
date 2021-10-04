import React from 'react';
import PropTypes from 'prop-types';
import { CustomBox, CustomTypography, CustomTab, CustomTabs} from './styles'

export function TabPanel({ children, value, handleChange, label }) {
  const a11yProps = index => ({
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  })
  return (
    <div
    role="tabpanel"
    id={`simple-tabpanel-${value}`}
    aria-labelledby={`simple-tab-${value}`}
    >
      {value && (
        <CustomBox sx={{ p: 0 }}>
          {children.map( (item) => <CustomTypography>{item}</CustomTypography> )}
        </CustomBox>
      )}
      <CustomTabs value={value} onChange={handleChange}>
        {children.map((item,index) => <CustomTab label={label} {...a11yProps(index)}/> )}
      </CustomTabs>
    </div>
  );
}

// TabPanel.propTypes = {
//     children: PropTypes.node,
//     index: PropTypes.number.isRequired,
//     value: PropTypes.number.isRequired,
// };