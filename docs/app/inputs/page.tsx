import { List, ListItem, ListItemButton, Typography } from "@mui/material";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h3">Inputs</Typography>

        {/* Content List */}
        <List>
            <ListItem>
                <ListItemButton href="./inputs/input">Input</ListItemButton>
            </ListItem>
        </List>
    </div>)
}
