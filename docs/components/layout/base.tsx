"use client"
import { createTheme, CssBaseline, ThemeProvider } from "@mui/material"
import { ReactElement } from "react"

const darkTheme = createTheme({
  palette: {
    mode: 'dark',
  },
});

export default function Base({ children, }: Readonly<{ children: React.ReactNode; }>) : ReactElement {
    return(<ThemeProvider theme={darkTheme}>
        <CssBaseline />
            {children}
    </ThemeProvider>)
}
