import React, { useState } from "react";
import { RightSide, LeftSide, Page, DivLogo, CustomTabs, CustomTab, CustomBox, CustomTypography } from "./styles"
import { FormLogin, SignUp } from '../../../components'
import Logo from '../../../assets/logo.svg';
import PropTypes from 'prop-types';

export const Initial = () => {
  function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
      <div
        role="tabpanel"
        hidden={value !== index}
        id={`simple-tabpanel-${index}`}
        aria-labelledby={`simple-tab-${index}`}
        {...other}
      >
        {value === index && (
          <CustomBox sx={{ p: 0 }}>
            <CustomTypography>{children}</CustomTypography>
          </CustomBox>
        )}
      </div>
    );
  }

  const [value, setValue] = useState(0)

  function a11yProps(index) {
    return {
      id: `simple-tab-${index}`,
      'aria-controls': `simple-tabpanel-${index}`,
    };
  }

  TabPanel.propTypes = {
    children: PropTypes.node,
    index: PropTypes.number.isRequired,
    value: PropTypes.number.isRequired,
  };

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Page>
      <LeftSide>
        <DivLogo>
          <img src={Logo} alt="Logo +Consulta" />
        </DivLogo>

        <CustomTabs
          value={value}
          onChange={handleChange}
        >
          <CustomTab label="Login" {...a11yProps(0)} />
          <CustomTab label="Cadastro" {...a11yProps(1)} />
        </CustomTabs>

        <TabPanel value={value} index={0}>
          <FormLogin />
        </TabPanel>

        <TabPanel value={value} index={1}>
          <SignUp setValue={setValue} />
        </TabPanel>
      </LeftSide>
      <RightSide />
    </Page>
  );
};

