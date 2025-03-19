import { List, ListItem, ListItemButton, Typography } from "@mui/material"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h3">Components</Typography>

        {/* Content List */}
        <List>
            <ListItem>
                <ListItemButton href="./components/typography">Typography</ListItemButton>
            </ListItem>

            {/* Indicators */}
            <ListItem>
                <ListItemButton href="./components/indicators#linearProgress">Linear Progress</ListItemButton>
            </ListItem>
        </List>
    </div>)
}
