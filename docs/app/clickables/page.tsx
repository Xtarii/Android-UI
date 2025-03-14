import { Typography } from "@mui/material"
import Link from "next/link"
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
        <Link href={"./clickables/buttons"}>Buttons</Link>
    </div>)
}
