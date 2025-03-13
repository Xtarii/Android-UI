"use client"
import { Box, createTheme, CssBaseline, Divider, Drawer, List, ListItem, ListItemButton, ListItemText, ThemeProvider } from "@mui/material"
import { ReactElement } from "react"
import { Button, Toolbar, Typography } from "@mui/material"

const drawerWidth = 240;

const darkTheme = createTheme({
  palette: {
    mode: 'dark',
  },
});

export default function Base({ children, }: Readonly<{ children: React.ReactNode; }>) : ReactElement {
    return(<ThemeProvider theme={darkTheme}>
        <CssBaseline />
          <Box sx={{ display: "flex" }}>
              <Drawer
                  sx={{
                      width: drawerWidth,
                      flexShrink: 0,
                      '& .MuiDrawer-paper': {
                          width: drawerWidth,
                          boxSizing: 'border-box',
                      },
                  }}
                  variant="permanent"
                  anchor="left"
              >
                <Toolbar>
                    <Button href="/" variant="text">
                        <Typography variant="h6" color="textPrimary" component="div" sx={{ margin: "auto" }}>
                            AUI
                        </Typography>
                    </Button>
                </Toolbar>
                <Divider />
                <List>{[{ name: "Base", route: "/base" }].map((value, index) => <ListItem key={index}>
                    <ListItemButton href={value.route}>
                        <ListItemText primary={value.name} />
                    </ListItemButton>
                </ListItem>)}</List>
              </Drawer>

              {/* Content */}
              <Box component="main" sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}>
                    {children}
              </Box>
          </Box>
    </ThemeProvider>)
}
