import React, { useState } from "react";
import { Tabs, Tab, Typography, Box } from "@material-ui/core";
import { PropTypes } from "prop-types";

function TabPanelLeft(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanelLeft"
      hidden={value !== index}
      id={`vertical-tabpanelLeft-${index}`}
      aria-labelledby={`vertical-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanelLeft.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `vertical-tab-${index}`,
    "aria-controls": `vertical-tabpanelLeft-${index}`,
  };
}

export function VerticalTabs() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Box
      sx={{
        flexGrow: 1,
        bgcolor: "background.paper",
        display: "flex",
        height: 224,
      }}
    >
      <Tabs
        orientation="vertical"
        variant="scrollable"
        value={value}
        onChange={handleChange}
        aria-label="Vertical tabs example"
        sx={{ borderRight: 1, borderColor: "divider" }}
      >
        <Tab label="Item One" {...a11yProps(0)} />
        <Tab label="Item Two" {...a11yProps(1)} />
        <Tab label="Item Three" {...a11yProps(2)} />
        <Tab label="Item Four" {...a11yProps(3)} />
        <Tab label="Item Five" {...a11yProps(4)} />
        <Tab label="Item Six" {...a11yProps(5)} />
        <Tab label="Item Seven" {...a11yProps(6)} />
      </Tabs>
      {/* <TabPanelLeft value={value} index={0}>
        Item One
      </TabPanelLeft>
      <TabPanelLeft value={value} index={1}>
        Item Two
      </TabPanelLeft>
      <TabPanelLeft value={value} index={2}>
        Item Three
      </TabPanelLeft>
      <TabPanelLeft value={value} index={3}>
        Item Four
      </TabPanelLeft>
      <TabPanelLeft value={value} index={4}>
        Item Five
      </TabPanelLeft>
      <TabPanelLeft value={value} index={5}>
        Item Six
      </TabPanelLeft>
      <TabPanelLeft value={value} index={6}>
        Item Seven
      </TabPanelLeft> */}
    </Box>
  );
}
