import { Box, List, ListItem, ListItemButton, Typography } from "@mui/material"
import Link from "next/link"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Android UI - Base Functionality</Typography>


        <Box>
            <List>
                <ListItem>
                    <ListItemButton href="./base/layout">Root Layout</ListItemButton>
                </ListItem>

                {/* Router and Routes */}
                <ListItem>
                    <ListItemButton href="./base/router#provider">RouterProvider</ListItemButton>
                </ListItem>
                <ListItem>
                    <ListItemButton href="./base/router#router">Router</ListItemButton>
                </ListItem>
                <ListItem>
                    <ListItemButton href="./base/router#routes">Routes</ListItemButton>
                </ListItem>

                {/* Themes and style */}
                <ListItem>
                    <ListItemButton href="./base/themes">Themes</ListItemButton>
                </ListItem>
            </List>
        </Box>
    </div>)
}
