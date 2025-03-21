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
                    <Button href="https://xtarii.github.io/Android-UI" variant="text">
                        <Typography variant="h6" color="textPrimary" component="div" sx={{ margin: "auto" }}>
                            AUI
                        </Typography>
                    </Button>
                </Toolbar>
                <Divider />
                <List>{[
                    { name: "Base", route: "https://xtarii.github.io/Android-UI/base" },
                    { name: "Clickables", route: "https://xtarii.github.io/Android-UI/clickables" },
                    { name: "Components", route: "https://xtarii.github.io/Android-UI/components" },
                    { name: "Inputs", route: "https://xtarii.github.io/Android-UI/inputs" },
                ].map((value, index) => <ListItem key={index}>
                    <ListItemButton href={value.route}>
                        <ListItemText primary={value.name} />
                    </ListItemButton>
                </ListItem>)}</List>
              </Drawer>

              {/* Content */}
              <Box component="main" sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}>
                    <Box sx={{ margin: "auto", width: "80%" }}>{children}</Box>
              </Box>
          </Box>
    </ThemeProvider>)
}
