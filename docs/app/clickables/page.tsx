import { List, ListItem, ListItemButton, Typography } from "@mui/material"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h3">Clickable Components</Typography>
        <Typography>
            Clickable components are components such
            as <code>Buttons</code>, <code>cards</code>
            , <code>switches</code> and more.
        </Typography>

        {/* Content List */}
        <List>
            <ListItem>
                <ListItemButton href="./clickables/buttons">Buttons</ListItemButton>
            </ListItem>

            {/* Selection Components */}
            <ListItem>
                <ListItemButton href="./clickables/selection#selection">Selection Box</ListItemButton>
            </ListItem>
            <ListItem>
                <ListItemButton href="./clickables/selection#switch">Switches</ListItemButton>
            </ListItem>
            <ListItem>
                <ListItemButton href="./clickables/cards">Cards</ListItemButton>
            </ListItem>
        </List>
    </div>)
}
