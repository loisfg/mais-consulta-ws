import React, { useState } from "react";
import { Drawer, Divider, Toolbar, List, ListItemText, ListItem } from "@material-ui/core";

const drawerWidth = 240;

export const Menu = ({window}) =>{
       
    const drawer = (
        <div>
          <Toolbar />
          <Divider />
          <List>
            {['Home', 'Histórico', 'Agendamento', 'Mapas de unidades', 'Perfil', 'Sair'].map((text, index) => (
              <ListItem button key={text}>
                <div>
                  {index % 2 === 0 ? <div /> : <div />}
                </div>
                <ListItemText primary={text} />
              </ListItem>
            ))}
          </List>
        </div>
      );
      const container = window !== undefined ? () => window().document.body : undefined;

    return (
        <>
            <Drawer
          container={container}
          variant="temporary"
      
          ModalProps={{
            keepMounted: true, // Better open performance on mobile.
          }}
          sx={{
            display: { xs: 'block', sm: 'none' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
          }}
        >
          {drawer}
        </Drawer>
        <Drawer
          variant="permanent"
          sx={{
            display: { xs: 'none', sm: 'block' },
            '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
          }}
          open
        >
          {drawer}
        </Drawer>
        </>
    )
}
